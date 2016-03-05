package mycinema.myapplicationcinema.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import mycinema.myapplicationcinema.R;
import mycinema.myapplicationcinema.dataBaseManagement.DBManagerFilmSeances;
import mycinema.myapplicationcinema.objectFromJSON.FilmSeances;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DBManagerFilmSeances filmSeancesDB = new DBManagerFilmSeances(this);
        filmSeancesDB.getWritableDatabase();
        FilmSeances filmTest = filmSeancesDB.getFilmSeances(8587);
        //FilmSeances filmTest = new FilmSeances();
        //filmTest = null;
        if(filmTest != null){
            Toast.makeText(Main2Activity.this, filmTest.toString(), Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(Main2Activity.this, "Ce film n'existe pas !", Toast.LENGTH_LONG).show();
        }
    }
}
