package mycinema.myapplicationcinema.objectFromJSON;

import java.util.List;

/**
 * Created by jean on 06/03/16.
 */
public class Seances {

    private Integer id = 0;
    private String actual_date = null;
    private String show_time = null;
    private Boolean is_troisd = false;
    private Boolean is_malentendant = false;
    private Boolean is_handicape = false;
    private String nationality = null;
    private int cinemaid = 0;
    private int filmid = 0;
    private String titre = null;
    private int categorieid = 0;
    private int performanceid = 0;
    private String cinema_salle = null;

    public Seances()
    {
    }
    public Seances(Integer id, String actual_date,String show_time,Boolean is_troisd, Boolean is_malentendant, Boolean is_handicape, String nationality, Integer cinemaid,
                   Integer filmid, String titre, Integer categorieid, Integer performanceid, String cinema_salle)
    {
        this.id=id;
        this.actual_date=actual_date;
        this.show_time=show_time;
        this.is_troisd=is_troisd;
        this.is_malentendant=is_malentendant;
        this.is_handicape=is_handicape;
        this.nationality=nationality;
        this.cinemaid=cinemaid;
        this.filmid=filmid;
        this.titre=titre;
        this.categorieid=categorieid;
        this.performanceid=performanceid;
        this.cinema_salle=cinema_salle;
    }

    // ACCESSEUR
    public Integer getId() {
        return id;
    }
    public String getActual_date() {
        return actual_date;
    }
    public String getShow_time() {
        return show_time;
    }
    public Boolean getIs_troisd() {
        return is_troisd;
    }
    public Boolean getIs_malentendant() {
        return is_malentendant;
    }
    public Boolean getIs_handicape() {
        return is_handicape;
    }
    public String getNationality() {
        return nationality;
    }
    public int getCinemaid() {
        return cinemaid;
    }
    public int getFilmid() {
        return filmid;
    }
    public String getTitre() {
        return titre;
    }
    public int getCategorieid() {
        return categorieid;
    }
    public int getPerformanceid() {
        return performanceid;
    }
    public String getCinema_salle() {
        return cinema_salle;
    }


    // MUTATEUR
    public void setId(Integer id) {
        this.id = id;
    }
    public void setActual_date(String actual_date) {
        this.actual_date = actual_date;
    }
    public void setShow_time(String show_time) {
        this.show_time = show_time;
    }
    public void setIs_troisd(Boolean is_troisd) {
        this.is_troisd = is_troisd;
    }
    public void setIs_malentendant(Boolean is_malentendant) {
        this.is_malentendant = is_malentendant;
    }
    public void setIs_handicape(Boolean is_handicape) {
        this.is_handicape = is_handicape;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public void setCinemaid(int cinemaid) {
        this.cinemaid = cinemaid;
    }
    public void setFilmid(int filmid) {
        this.filmid = filmid;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public void setCategorieid(int categorieid) {
        this.categorieid = categorieid;
    }
    public void setPerformanceid(int performanceid) {
        this.performanceid = performanceid;
    }
    public void setCinema_salle(String cinema_salle) {
        this.cinema_salle = cinema_salle;
    }
}
