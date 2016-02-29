package mycinema.myapplicationcinema;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jean on 29/02/16.
 */
public class ParseJSON {
    public static String[] films;

    public static final String JSON_ARRAY = "result";
    public static final String KEY_FILM = "titre";

    private JSONArray users = null;

    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

    protected void parseJSON(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            films = new String[users.length()];

            for(int i=0;i<users.length();i++){
                JSONObject jsonObjectImported = users.getJSONObject(i);
                films[i] = jsonObjectImported.getString(KEY_FILM);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}