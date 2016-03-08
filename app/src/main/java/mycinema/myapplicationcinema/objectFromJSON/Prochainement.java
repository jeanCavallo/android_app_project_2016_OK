package mycinema.myapplicationcinema.objectFromJSON;

import org.json.JSONArray;

import java.util.List;

/**
 * Created by jean on 06/03/16.
 */
public class Prochainement {
    private String current;
    private String next;
    private JSONArray films;

    public Prochainement(String current, String next, JSONArray films)
    {
        this.current = current;
        this.next = next;
        this.films = films;
    }

    // ACCESSEUR
    public String getCurrent() {
        return current;
    }
    public String getNext() {
        return next;
    }
    public JSONArray getFilms() {
        return films;
    }

    // MUTATEUR
    public void setCurrent(String current) {
        this.current = current;
    }
    public void setNext(String next) {
        this.next = next;
    }
    public void setFilms(JSONArray films) {
        this.films = films;
    }

}
