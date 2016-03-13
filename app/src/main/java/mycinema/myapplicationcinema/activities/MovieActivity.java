package mycinema.myapplicationcinema.activities;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

import mycinema.myapplicationcinema.R;
import mycinema.myapplicationcinema.dataBaseManagement.DBManager;
import mycinema.myapplicationcinema.loadImagesWithVolley.LoadImagesWithVolley;
import mycinema.myapplicationcinema.objectFromJSON.FilmSeances;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        Integer filmIdToPrint = getIntent().getIntExtra("filmIdToPrint",0);

        DBManager filmSeancesDB = new DBManager(this);
        filmSeancesDB.getReadableDatabase();
        FilmSeances filmToPrint = filmSeancesDB.getFilm(filmIdToPrint);



        ImageView affiche = (ImageView) findViewById(R.id.imageAffiche);
        TextView titre = (TextView) findViewById(R.id.textTitre);
        TextView description = (TextView) findViewById(R.id.textDescription);

        titre.setText(filmToPrint.getTitre());
        loadImageBitmap(affiche, filmToPrint.getAffiche());
        description.setText(filmToPrint.getSynopsis());

    }

    public void loadImageBitmap(final ImageView affiche, String urlToDownload) {

        ImageRequest request = new ImageRequest(urlToDownload,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        affiche.setImageBitmap(bitmap);
                    }
                }, 0, 0, null,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        affiche.setImageResource(R.drawable.polaroid);
                    }
                });
        LoadImagesWithVolley.getInstance(this).addToRequestQueue(request);

    }
}
