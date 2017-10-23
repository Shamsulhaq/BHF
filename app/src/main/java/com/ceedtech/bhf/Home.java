package com.ceedtech.bhf;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public WebView webViewWV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        webViewWV = (WebView) findViewById(R.id.webviewfilde);
        WebSettings webSettings = webViewWV.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webViewWV.setHorizontalScrollBarEnabled(false);
        webViewWV.loadUrl("http://www.bdhockey.org");
        setTitle("BHF/HOME");

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

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
        getMenuInflater().inflate(R.menu.home, menu);
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
            finish();
            System.exit(0);

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            webViewWV.loadUrl("http://www.bdhockey.org");
            setTitle("BHF/HOME");
        } else if (id == R.id.nav_photo) {
           // http://www.bdhockey.org/galleryPhoto
            webViewWV.loadUrl("http://www.bdhockey.org/galleryPhoto");
            setTitle("BHF/PHOTO GALLERY");

        } else if (id == R.id.nav_video) {
            // http://www.bdhockey.org/galleryVideo
            webViewWV.loadUrl("http://www.bdhockey.org/galleryVideo");
            setTitle("BHF/VIDEO GALLERY");

        } else if (id == R.id.nav_about) {
            // http://www.bdhockey.org/aboutBhf
            webViewWV.loadUrl("http://www.bdhockey.org/aboutBhf");
            setTitle("BHF/ABOUT");

        } else if (id == R.id.nav_news) {
            webViewWV.loadUrl("http://www.bdhockey.org/matchReport");
            setTitle("BHF/NEWS");

        } else if (id == R.id.nav_location) {
            webViewWV.loadUrl("http://www.bdhockey.org/contactOfficial");
            setTitle("BHF/LOCATION");

        } else if (id == R.id.nav_bug_report) {
            setTitle("BHF/BUG REPORT");

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
