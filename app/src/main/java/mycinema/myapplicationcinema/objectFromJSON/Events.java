package mycinema.myapplicationcinema.objectFromJSON;

import java.util.List;

/**
 * Created by jean on 06/03/16.
 */
public class Events {
    private String type; // TODO: Find how to extract it properly
    private Integer id;
    private String titre;
    private String sous_titre;
    private String affiche;
    private String description;
    private String vad_condition;
    private String partenaire;
    private String date_deb;
    private String date_fin;
    private String heure;
    private String contact;
    private String web_label;
    private Integer evenementtypeid;
    private List<FilmSeances> films;

    public Events()
    {
    }
    public Events(String type, Integer id,String titre,String sous_titre,String affiche,String description,String vad_condition,String partenaire,String date_deb,
                  String date_fin,String heure,String contact, String web_label, Integer evenementtypeid, List<FilmSeances> films)
    {
        this.id=id;
        this.titre=titre;
        this.sous_titre=sous_titre;
        this.affiche=affiche;
        this.description=description;
        this.vad_condition=vad_condition;
        this.partenaire=partenaire;
        this.date_deb=date_deb;
        this.date_fin=date_fin;
        this.heure=heure;
        this.contact=contact;
        this.web_label=web_label;
        this.evenementtypeid=evenementtypeid;
        this.films=films;
    }

    // ACCESSEUR
    public String getType() {
        return type;
    }
    public Integer getId() {
        return id;
    }
    public String getTitre() {
        return titre;
    }
    public String getSous_titre() {
        return sous_titre;
    }
    public String getAffiche() {
        return affiche;
    }
    public String getDescription() {
        return description;
    }
    public String getVad_condition() {
        return vad_condition;
    }
    public String getPartenaire() {
        return partenaire;
    }
    public String getDate_deb() {
        return date_deb;
    }
    public String getDate_fin() {
        return date_fin;
    }
    public String getHeure() {
        return heure;
    }
    public String getContact() {
        return contact;
    }
    public String getWeb_label() {
        return web_label;
    }
    public Integer getEvenementtypeid() {
        return evenementtypeid;
    }
    public List<FilmSeances> getFilms() {
        return films;
    }


    // MUTATEUR
    public void setType(String type) {
        this.type = type;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public void setSous_titre(String sous_titre) {
        this.sous_titre = sous_titre;
    }
    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setVad_condition(String vad_condition) {
        this.vad_condition = vad_condition;
    }
    public void setPartenaire(String partenaire) {
        this.partenaire = partenaire;
    }
    public void setDate_deb(String date_deb) {
        this.date_deb = date_deb;
    }
    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }
    public void setHeure(String heure) {
        this.heure = heure;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public void setWeb_label(String web_label) {
        this.web_label = web_label;
    }
    public void setEvenementtypeid(Integer evenementtypeid) {
        this.evenementtypeid = evenementtypeid;
    }
    public void setFilms(List<FilmSeances> films) {
        this.films = films;
    }

}
