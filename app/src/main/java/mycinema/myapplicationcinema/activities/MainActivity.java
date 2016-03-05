package mycinema.myapplicationcinema.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import mycinema.myapplicationcinema.R;
import mycinema.myapplicationcinema.dataBaseManagement.DBManagerFilmSeances;
import mycinema.myapplicationcinema.objectFromJSON.FilmSeances;

public class MainActivity extends AppCompatActivity  {

    public static final String JSON_URL_EVENTS = "http://centrale.corellis.eu/events.json";
    public static final String JSON_URL_FILMSEANCES = "http://centrale.corellis.eu/filmseances.json";
    public static final String JSON_URL_PROCHAINEMENTS = "http://centrale.corellis.eu/prochainement.json";
    public static final String JSON_URL_SEANCES = "http://centrale.corellis.eu/seances.json";

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Thread t1 = new Thread() {
            @Override
            public void run() {
                sendRequest();
            }
        };
        t1.start();
        new Thread() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent goToNextActivity = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(goToNextActivity);
            }
        };
    }

    private void sendRequest(){

        /*StringRequest stringRequestEvents = new StringRequest(JSON_URL_EVENTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //parseJSON(response); // TODO do the same as parseJSONFilmSeances
                        Log.d("testImportation", response);
                        Toast.makeText(MainActivity.this, "JSON EVENTS imported !!", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });*/

        StringRequest stringRequestFilmSeances = new StringRequest(JSON_URL_FILMSEANCES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        parseJSONFilmSeances(response);
                        Toast.makeText(MainActivity.this, "JSON FILMS SEANCES imported !!", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        /*StringRequest stringRequestProchainements = new StringRequest(JSON_URL_PROCHAINEMENTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //parseJSON(response); // TODO do the same as parseJSONFilmSeances
                        Toast.makeText(MainActivity.this, "JSON PROCHAINEMENT imported !!", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });*/

        /*StringRequest stringRequestSeances = new StringRequest(JSON_URL_SEANCES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //parseJSON(response); // TODO do the same as parseJSONFilmSeances
                        Toast.makeText(MainActivity.this, "JSON SEANCES imported !!", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });*/

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //requestQueue.add(stringRequestEvents);
        requestQueue.add(stringRequestFilmSeances);
        //requestQueue.add(stringRequestProchainements);
        //requestQueue.add(stringRequestSeances);
    }

    protected void parseJSONFilmSeances(String json){
        JSONArray jsonArray = null;
        JSONObject jsonObject = null;
        try {
            jsonArray = new JSONArray(json);
            DBManagerFilmSeances dbManagerFilmSeances = new DBManagerFilmSeances(getApplicationContext());
            for (Integer subscript=0; subscript<jsonArray.length(); subscript++){
                jsonObject = jsonArray.getJSONObject(subscript);
                FilmSeances filmSeancesToAdd = new FilmSeances(jsonObject.getInt("id"),jsonObject.getString("titre"),jsonObject.getString("titre_ori"),jsonObject.getString("affiche"),jsonObject.getString("web"),
                        jsonObject.getString("duree"),jsonObject.getString("distributeur"),jsonObject.getString("participants"),jsonObject.getString("realisateur"),jsonObject.getString("synopsis"),
                        jsonObject.getString("annee"),jsonObject.getString("date_sortie"),jsonObject.getString("info"),jsonObject.getBoolean("is_visible"),jsonObject.getBoolean("is_vente"),
                        jsonObject.getInt("genreid"),jsonObject.getString("genre"),jsonObject.getString("categorie"),jsonObject.getInt("ReleaseNumber"),jsonObject.getString("pays"),
                        jsonObject.getString("share_url"),jsonObject.getString("medias"), jsonObject.getString("videos"));
                dbManagerFilmSeances.addFilmSeances(filmSeancesToAdd);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
