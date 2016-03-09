package mycinema.myapplicationcinema.activities;

import android.content.Intent;
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
import android.widget.ListView;

import java.util.List;

import mycinema.myapplicationcinema.Objects.SeanceAdapter;
import mycinema.myapplicationcinema.Objects.SoonAdapter;
import mycinema.myapplicationcinema.R;
import mycinema.myapplicationcinema.dataBaseManagement.DBManager;
import mycinema.myapplicationcinema.objectFromJSON.Seances;
import mycinema.myapplicationcinema.objectFromJSON.Soon;

public class SoonActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soon);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mListView = (ListView) findViewById(R.id.listView);

        DBManager soonDB = new DBManager(this);
        soonDB.getReadableDatabase();

        List<Soon> allSoon = soonDB.getAllSoon();

        SoonAdapter adapter = new SoonAdapter(SoonActivity.this, allSoon);
        mListView.setAdapter(adapter);
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
        getMenuInflater().inflate(R.menu.soon, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menu_alaffiche) {
            Intent intent = new Intent(SoonActivity.this,WelcomeActivity.class);
            startActivity(intent);
        } else if (id == R.id.menu_evenements) {
            Intent intent = new Intent(SoonActivity.this,EventsActivity.class);
            startActivity(intent);
        } else if (id == R.id.menu_prochainement) {
            Intent intent = new Intent(SoonActivity.this,SoonActivity.class);
            startActivity(intent);
        } else if (id == R.id.settings_preferences) {
            Intent intent = new Intent(SoonActivity.this,PreferencesActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
