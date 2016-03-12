package mycinema.myapplicationcinema.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import mycinema.myapplicationcinema.Objects.FilmSeancesAdapter;
import mycinema.myapplicationcinema.R;
import mycinema.myapplicationcinema.dataBaseManagement.DBManager;
import mycinema.myapplicationcinema.objectFromJSON.FilmSeances;

public class WelcomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        RecyclerView recyclerViewFilm = (RecyclerView) findViewById(R.id.listView);
        recyclerViewFilm.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewFilm.setLayoutManager(layoutManager);
        recyclerViewFilm.setItemAnimator(new DefaultItemAnimator());

        DBManager filmSeancesDB = new DBManager(this);
        filmSeancesDB.getReadableDatabase();

        List<FilmSeances> FilmSeances = filmSeancesDB.getAllFilms();

        FilmSeancesAdapter adapter = new FilmSeancesAdapter(WelcomeActivity.this,FilmSeances);
        recyclerViewFilm.setAdapter(adapter);

        for (FilmSeances shop : FilmSeances) {
            String log = "Id: " + shop.getId() + " ,URL: " + shop.getAffiche() + " ,Titre: " + shop.getTitre();
// Writing shops to log
            Log.d("Shop: : ", log);
        }

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
        getMenuInflater().inflate(R.menu.welcome, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menu_alaffiche) {
            Intent intent = new Intent(WelcomeActivity.this,WelcomeActivity.class);
            startActivity(intent);
            this.finish();
        } else if (id == R.id.menu_evenements) {
            Intent intent = new Intent(WelcomeActivity.this,EventsActivity.class);
            startActivity(intent);
            this.finish();
        } else if (id == R.id.menu_prochainement) {
            Intent intent = new Intent(WelcomeActivity.this,SoonActivity.class);
            startActivity(intent);
            this.finish();
        } else if (id == R.id.settings_preferences) {
            Intent intent = new Intent(WelcomeActivity.this,PreferencesActivity.class);
            startActivity(intent);
            this.finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
