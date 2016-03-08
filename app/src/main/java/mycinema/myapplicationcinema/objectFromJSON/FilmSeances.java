package mycinema.myapplicationcinema.objectFromJSON;

/**
 * Created by jean on 01/03/16.
 */
public class FilmSeances {
    private Integer id = 0;
    private String titre = null;
    private String titre_ori = null;
    private String affiche = null;
    private String web = null;
    private String duree = null;
    private String distributeur = null;
    private String participants = null;
    private String realisateur = null;
    private String synopsis = null;
    private String annee = null;
    private String date_sortie = null;
    private String info = null;
    private boolean is_visible = false;
    private boolean is_vente = false;
    private Integer genreid = 0;
    private Integer categorieid = 0;
    private String genre = null;
    private String categorie = null;
    private Integer ReleaseNumber = 0;
    private String pays = null;
    private String share_url = null;
    private String medias = null;
    private String videos = null;
    private Boolean is_avp = false;
    private Boolean is_alaune = false;
    private Boolean is_lastWeek = false;

    public FilmSeances()
    {
    }
    public FilmSeances(Integer id,String titre,String titre_ori,String affiche,String web,String duree,String distributeur,String participants,String realisateur,String synopsis,String annee,
                       String date_sortie,String info,boolean is_visible, boolean is_vente,Integer genreid,Integer categorieid, String genre,String categorie,Integer ReleaseNumber,String pays,String share_url,
                       String medias, String videos, boolean is_avp, boolean is_alaune, boolean is_lastWeek)
    {
        this.id=id;
        this.titre=titre;
        this.titre_ori=titre_ori;
        this.affiche=affiche;
        this.web=web;
        this.duree=duree;
        this.distributeur=distributeur;
        this.participants=participants;
        this.realisateur=realisateur;
        this.synopsis=synopsis;
        this.annee=annee;
        this.date_sortie=date_sortie;
        this.info=info;
        this.is_visible=is_visible;
        this.is_vente=is_vente;
        this.genreid=genreid;
        this.categorieid=categorieid;
        this.genre=genre;
        this.categorie=categorie;
        this.ReleaseNumber=ReleaseNumber;
        this.pays=pays;
        this.share_url=share_url;
        this.medias=medias;
        this.videos=videos;
        this.is_avp=is_avp;
        this.is_alaune=is_alaune;
        this.is_lastWeek=is_lastWeek;
    }

    // ACCESSEUR
    public Integer getId() {
        return id;
    }
    public String getTitre() {
        return titre;
    }
    public String getTitre_ori() {
        return titre_ori;
    }
    public String getAffiche() {
        return affiche;
    }
    public String getWeb() {
        return web;
    }
    public String getDuree() {
        return duree;
    }
    public String getDistributeur() {
        return distributeur;
    }
    public String getParticipants() {
        return participants;
    }
    public String getRealisateur() {
        return realisateur;
    }
    public String getSynopsis() {
        return synopsis;
    }
    public String getAnnee() {
        return annee;
    }
    public String getDate_sortie() {
        return date_sortie;
    }
    public String getInfo() {
        return info;
    }
    public boolean getIs_visible() {
        return is_visible;
    }
    public boolean getIs_vente() {
        return is_vente;
    }
    public Integer getGenreid() {
        return genreid;
    }
    public Integer getCategorieid() {
        return categorieid;
    }
    public String getGenre() {
        return genre;
    }
    public String getCategorie() {
        return categorie;
    }
    public Integer getReleaseNumber() {
        return ReleaseNumber;
    }
    public String getPays() {
        return pays;
    }
    public String getShare_url() {
        return share_url;
    }
    public String getMedias() {
        return medias;
    }
    public String getVideos() {
        return videos;
    }
    public Boolean getIs_avp() {
        return is_avp;
    }
    public Boolean getIs_alaune() {
        return is_alaune;
    }
    public Boolean getIs_lastWeek() {
        return is_lastWeek;
    }

    // MUTATEUR
    public void setId(Integer id) {
        this.id = id;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public void setTitre_ori(String titre_ori) {
        this.titre_ori = titre_ori;
    }
    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }
    public void setWeb(String web) {
        this.web = web;
    }
    public void setDuree(String duree) {
        this.duree = duree;
    }
    public void setDistributeur(String distributeur) {
        this.distributeur = distributeur;
    }
    public void setParticipants(String participants) {
        this.participants = participants;
    }
    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    public void setAnnee(String annee) {
        this.annee = annee;
    }
    public void setDate_sortie(String date_sortie) {
        this.date_sortie = date_sortie;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public void setIs_visible(boolean is_visible) {
        this.is_visible = is_visible;
    }
    public void setIs_vente(boolean is_vente) {
        this.is_vente = is_vente;
    }
    public void setGenreid(Integer genreid) {
        this.genreid = genreid;
    }
    public void setCategorieid(Integer categorieid) {
        this.categorieid = categorieid;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    public void setReleaseNumber(Integer ReleaseNumber) {
        this.ReleaseNumber = ReleaseNumber;
    }
    public void setPays(String pays) {
        this.pays = pays;
    }
    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }
    public void setMedias(String medias) {
        this.medias = medias;
    }
    public void setVideos(String videos) {
        this.videos = videos;
    }
    public void setIs_avp(Boolean is_avp) {
        this.is_avp = is_avp;
    }
    public void setIs_alaune(Boolean is_alaune) {
        this.is_alaune = is_alaune;
    }
    public void setIs_lastWeek(Boolean is_lastWeek) {
        this.is_lastWeek = is_lastWeek;
    }

}
