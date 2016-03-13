package mycinema.myapplicationcinema.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import mycinema.myapplicationcinema.dataBaseManagement.DBManager;
import mycinema.myapplicationcinema.objectFromJSON.FilmSeances;
import mycinema.myapplicationcinema.objectFromJSON.Prochainement;
import mycinema.myapplicationcinema.objectFromJSON.Seances;
import mycinema.myapplicationcinema.objectFromJSON.Soon;

public class StartingActivity extends AppCompatActivity {

    public static final String JSON_URL_EVENTS = "http://centrale.corellis.eu/events.json";
    public static final String JSON_URL_FILMSEANCES = "http://centrale.corellis.eu/filmseances.json";
    public static final String JSON_URL_PROCHAINEMENTS = "http://centrale.corellis.eu/prochainement.json";
    public static final String JSON_URL_SEANCES = "http://centrale.corellis.eu/seances.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        ProgressDialog pDialog;

        pDialog = new ProgressDialog(StartingActivity.this);
        pDialog.setMessage("Please wait for the loading..");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        if(!isOnline()){
            Intent intent = new Intent(StartingActivity.this,MainActivity.class);
            startActivity(intent);
            Context context = getApplicationContext();
            CharSequence text = "Internet is disable, you do not have the updated news !";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }else{
            this.deleteDatabase("FilmSeancesDB.db");
            Thread timerThread = new Thread(){
            public void run(){
                try{
                    sendRequest();
                } finally {
                }
            }
        };
        timerThread.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
    
    // TO SEND ALL THE REQUESTS
    private void sendRequest(){

        final Integer[] count = {0};

        /*StringRequest stringRequestEvents = new StringRequest(JSON_URL_EVENTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //parseJSON(response); // TODO do the same as parseJSONFilmSeances
                        Log.d("testImportation", response);
                        Toast.makeText(StartingActivity.this, "JSON EVENTS imported !!", Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(StartingActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });*/

        final StringRequest stringRequestFilmSeances = new StringRequest(JSON_URL_FILMSEANCES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        parseJSONFilmSeances(response);
                        count[0] = count[0] +1;
                        if(count[0]==3){
                            Intent intent = new Intent(StartingActivity.this,MainActivity.class);
                            startActivity(intent);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(StartingActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        final StringRequest stringRequestProchainements = new StringRequest(JSON_URL_PROCHAINEMENTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        parseJSONProchainement(response);
                        count[0] = count[0] +1;
                        if(count[0]==3){
                            Intent intent = new Intent(StartingActivity.this,MainActivity.class);
                            startActivity(intent);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(StartingActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        final StringRequest stringRequestSeances = new StringRequest(JSON_URL_SEANCES,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        parseJSONSeances(response);
                        count[0] = count[0] +1;
                        if(count[0]==3){
                            Intent intent = new Intent(StartingActivity.this,MainActivity.class);
                            startActivity(intent);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(StartingActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        //requestQueue.add(stringRequestEvents);
        Thread timerThread = new Thread(){
            public void run(){
                try{
                    requestQueue.add(stringRequestFilmSeances);
                    requestQueue.add(stringRequestProchainements);
                    requestQueue.add(stringRequestSeances);
                }finally {
            }
        }
        };
        timerThread.start();

    }
    
    

    // METHODS TO PARSE JSONS FROM DOWNLOADS
    protected void parseJSONFilmSeances(String json){
        JSONArray jsonArray = null;
        JSONObject jsonObject = null;
        try {
            jsonArray = new JSONArray(json);
            DBManager dbManagerFilmSeances = new DBManager(getApplicationContext());
            for (Integer subscript=0; subscript<jsonArray.length(); subscript++){
                jsonObject = jsonArray.getJSONObject(subscript);

                String checkMedias;
                if (jsonObject.has("medias")) {
                    checkMedias = jsonObject.getString("medias");
                }else{checkMedias = null;}

                String checkVideos;
                if (jsonObject.has("videos")) {
                    checkVideos = jsonObject.getString("videos");
                }else{checkVideos = null;}



                FilmSeances filmSeancesToAdd = new FilmSeances(jsonObject.getInt("id"), jsonObject.getString("titre"), jsonObject.getString("titre_ori"), jsonObject.getString("affiche"), jsonObject.getString("web"),
                        jsonObject.getString("duree"), jsonObject.getString("distributeur"), jsonObject.getString("participants"), jsonObject.getString("realisateur"), jsonObject.getString("synopsis"),
                        jsonObject.getString("annee"), jsonObject.getString("date_sortie"), jsonObject.getString("info"), jsonObject.getBoolean("is_visible"), jsonObject.getBoolean("is_vente"),
                        jsonObject.getInt("genreid"), jsonObject.getInt("categorieid"), jsonObject.getString("genre"), jsonObject.getString("categorie"), jsonObject.getInt("ReleaseNumber"), jsonObject.getString("pays"),
                        jsonObject.getString("share_url"), checkMedias, checkVideos, jsonObject.getBoolean("is_avp"), jsonObject.getBoolean("is_alaune"), jsonObject.getBoolean("is_lastWeek"));
                dbManagerFilmSeances.addFilmSeances(filmSeancesToAdd);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected void parseJSONSeances(String json){
        JSONArray jsonArray = null;
        JSONObject jsonObject = null;
        try {
            jsonArray = new JSONArray(json);
            DBManager dbManagerSeances = new DBManager(getApplicationContext());
            for (Integer subscript2=0; subscript2<jsonArray.length(); subscript2++){
                jsonObject = jsonArray.getJSONObject(subscript2);
                Seances seanceToAdd = new Seances(jsonObject.getInt("id"),jsonObject.getString("actual_date"),jsonObject.getString("show_time"),jsonObject.getBoolean("is_troisd"),
                        jsonObject.getBoolean("is_malentendant"),jsonObject.getBoolean("is_handicape"),jsonObject.getString("nationality"),jsonObject.getInt("cinemaid"),
                        jsonObject.getInt("filmid"),jsonObject.getString("titre"),jsonObject.getInt("categorieid"),jsonObject.getInt("performanceid"),jsonObject.getString("cinema_salle"));
                dbManagerSeances.addSeances(seanceToAdd);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected void parseJSONProchainement(String json){
        JSONObject jsonObject = null;
        JSONObject jsonObject2 = null;
        try {
            jsonObject = new JSONObject(json);
            DBManager dbManagerSeances = new DBManager(getApplicationContext());
            Prochainement prochainementUpdated = new Prochainement(jsonObject.getString("current"), jsonObject.getString("next"), jsonObject.getJSONArray("films"));

            JSONArray jsonArrayProchainementFilms = prochainementUpdated.getFilms();

            for (Integer subscript=0; subscript<jsonArrayProchainementFilms.length(); subscript++){
                jsonObject2 = jsonArrayProchainementFilms.getJSONObject(subscript);
                Soon soonToAdd = new Soon(jsonObject2.getInt("id"),jsonObject2.getString("titre"),jsonObject2.getString("affiche"));
                dbManagerSeances.addSoon(soonToAdd);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected void parseJSONEvents(String json){ // TODO
        JSONArray jsonArray = null;
        JSONObject jsonObject = null;
        try {
            jsonArray = new JSONArray(json);
            DBManager dbManagerFilmSeances = new DBManager(getApplicationContext());
            for (Integer subscript=0; subscript<jsonArray.length(); subscript++){
                jsonObject = jsonArray.getJSONObject(subscript);
                FilmSeances filmSeancesToAdd = new FilmSeances(jsonObject.getInt("id"),jsonObject.getString("titre"),jsonObject.getString("titre_ori"),jsonObject.getString("affiche"),jsonObject.getString("web"),
                        jsonObject.getString("duree"),jsonObject.getString("distributeur"),jsonObject.getString("participants"),jsonObject.getString("realisateur"),jsonObject.getString("synopsis"),
                        jsonObject.getString("annee"),jsonObject.getString("date_sortie"),jsonObject.getString("info"),jsonObject.getBoolean("is_visible"),jsonObject.getBoolean("is_vente"),
                        jsonObject.getInt("genreid"), jsonObject.getInt("categorieid"), jsonObject.getString("genre"),jsonObject.getString("categorie"), jsonObject.getInt("ReleaseNumber"),jsonObject.getString("pays"),
                        jsonObject.getString("share_url"),jsonObject.getString("medias"), jsonObject.getString("videos"), jsonObject.getBoolean("is_avp"), jsonObject.getBoolean("is_alaune"), jsonObject.getBoolean("is_lastWeek"));
                dbManagerFilmSeances.addFilmSeances(filmSeancesToAdd);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // METHOD TO TEST IF THERE IS A CONNECTION TO INTERNET AVAILABLE
    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }




}
