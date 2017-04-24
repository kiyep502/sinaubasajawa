package com.example.kiyep404.basajawa;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import com.example.kiyep404.basajawa.DataKamus.DataKamus;


public class MainActivity extends Activity {
	private SQLiteDatabase db = null;
	private Cursor kamusCursor = null;
	private EditText txtJengearane;
	private EditText txtArane;
	private EditText txtJenisarane;
	private DataKamus datakamus = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_golekiarane);
		datakamus = new DataKamus(this);
		db = datakamus.getWritableDatabase();
		datakamus.createTable(db);
		datakamus.generateData(db);

		setContentView(R.layout.fragment_golekiarane);
        txtJengearane = (EditText) findViewById(R.id.txtJengearane);
        txtArane = (EditText) findViewById(R.id.txtArane);
        txtJenisarane = (EditText) findViewById(R.id.txtJenisarane);

	}

	public void getTerjemahan(View view) {
		String result = "";
		String result2 = "";

		String englishword = txtJengearane.getText().toString();
		kamusCursor = db.rawQuery("SELECT ID, JENENGARANE, ARANE,JENISARANE "
				+ "FROM kamus where INDONESIA='" + englishword
				+ "' ORDER BY JENENGARANE", null);

		if (kamusCursor.moveToFirst()) {
			result = kamusCursor.getString(2);
			for (; !kamusCursor.isAfterLast(); kamusCursor.moveToNext()) {
				result = kamusCursor.getString(2);
			}
		}

		if (kamusCursor.moveToFirst()) {
			result2 = kamusCursor.getString(3);
			for (; !kamusCursor.isAfterLast(); kamusCursor.moveToNext()) {
				result2 = kamusCursor.getString(3);
			}
		}

		if (result.equals("")) {
			result = "Maaf kata tidak ditemukan";
		}
		if (result2.equals("")) {
			result = "Maaf kata tidak ditemukan";
		}
		txtArane.setText(result);
		txtJenisarane.setText(result2);

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		kamusCursor.close();
		db.close();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.basajawa, menu);
		return true;
	}

}
