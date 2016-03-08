package mycinema.myapplicationcinema.objectFromJSON;

import org.json.JSONArray;

/**
 * Created by jean on 09/03/16.
 */
public class Soon {
    private Integer id = 0;
    private String titre = null;
    private String affiche = null;

    public Soon()
    {
    }

    public Soon(Integer id, String titre, String affiche)
    {
        this.id = id;
        this.titre = titre;
        this.affiche = affiche;
    }

    // ACCESSEUR
    public Integer getId() {
        return id;
    }
    public String getTitre() {
        return titre;
    }
    public String getAffiche() {
        return affiche;
    }

    // MUTATEUR
    public void setId(Integer id) {
        this.id = id;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }
}
