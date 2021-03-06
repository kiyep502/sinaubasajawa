package com.example.kiyep404.basajawa;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class BasaJawa extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        Aran_Arane.OnFragmentInteractionListener,
        Arane_Godhong.OnFragmentInteractionListener,
        Arane_Wet.OnFragmentInteractionListener,
        Arane_Woh.OnFragmentInteractionListener,
        CangkrimanFragment.OnFragmentInteractionListener,
        Paribasan.OnFragmentInteractionListener,
        Parikan_Lan_Paribasan.OnFragmentInteractionListener,
        Sandangan.OnFragmentInteractionListener,
        AksaraJawa.OnFragmentInteractionListener,
Golekiarane.OnFragmentInteractionListener,
        AnakeKewan.OnFragmentInteractionListener,
        Angka.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basajawa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.basajawa, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;

        if (id == R.id.aksara_jawa) {
            // Handle the camera action
            fragment = new AksaraJawa();

        } else if (id == R.id.sandangan) {
            fragment = new Sandangan();


        } else if (id == R.id.aksara_angka) {
            fragment = new Angka();

        } else if (id == R.id.Cangkriman) {
            fragment = new CangkrimanFragment();

        } else if (id == R.id.parikan)
        {
            fragment=new Parikan_Lan_Paribasan();

        } else if (id == R.id.paribasan) {
            fragment = new Paribasan();


        } else if (id == R.id.nav_manage) {
            fragment=new Aran_Arane();

        } else if (id == R.id.arane_kembang) {
            fragment = new Aran_Arane();

        } else if (id == R.id.arake_kewan) {
            fragment = new AnakeKewan();

        } else if (id == R.id.arane_wohwohan) {
            fragment = new Arane_Woh();

        } else if (id == R.id.arane_wet) {
            fragment = new Arane_Wet();

        } else if (id == R.id.goleki) {
            fragment = new Golekiarane();

        } else if (id == R.id.arane_godhong) {
            fragment = new Arane_Godhong();




        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction ft = fragmentManager.beginTransaction();

        ft.replace(R.id.container, fragment);
        ft.addToBackStack(null);

        ft.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
