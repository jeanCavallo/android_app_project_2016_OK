package mycinema.myapplicationcinema;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

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

        sendRequest();
    }

    private void sendRequest(){

        StringRequest stringRequestEvents = new StringRequest(JSON_URL_EVENTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                        Toast.makeText(MainActivity.this, "JSON EVENTS imported !!", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        StringRequest stringRequestFilmSeances = new StringRequest(JSON_URL_FILMSEANCES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                        Toast.makeText(MainActivity.this, "JSON FILMS SEANCES imported !!", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        StringRequest stringRequestProchainements = new StringRequest(JSON_URL_PROCHAINEMENTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                        Toast.makeText(MainActivity.this, "JSON PROCHAINEMENT imported !!", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        StringRequest stringRequestSeances = new StringRequest(JSON_URL_SEANCES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                        Toast.makeText(MainActivity.this, "JSON SEANCES imported !!", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequestEvents);
        requestQueue.add(stringRequestFilmSeances);
        requestQueue.add(stringRequestProchainements);
        requestQueue.add(stringRequestSeances);
    }

    private void showJSON(String json){
        ParseJSON parseJSON = new ParseJSON(json);
        parseJSON.parseJSON();
    }

}
