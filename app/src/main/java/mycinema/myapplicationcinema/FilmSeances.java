package mycinema.myapplicationcinema;

/**
 * Created by jean on 01/03/16.
 */
public class FilmSeances {
    private int id;
    private String titre;
    private String titre_ori;
    private String affiche;
    private String web;
    private int duree;
    private String distributeur;
    private String participants;
    private String realisateur;
    private String synopsis;
    private int annee;
    private String date_sortie;
    private String info;
    private String is_vente;
    private int genreid;
    private String genre;
    private String categorie;
    private int ReleaseNumber;
    private String pays;
    private String share_url;
    private String medias;

    public FilmSeances()
    {
    }
    public FilmSeances(int id,String titre,String titre_ori,String affiche,String web,int duree,String distributeur,String participants,String realisateur,String synopsis,int annee,
                       String date_sortie,String info,String is_vente,int genreid,String genre,String categorie,int ReleaseNumber,String pays,String share_url,String medias)
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
        this.is_vente=is_vente;
        this.genreid=genreid;
        this.genre=genre;
        this.categorie=categorie;
        this.ReleaseNumber=ReleaseNumber;
        this.pays=pays;
        this.share_url=share_url;
        this.medias=medias;
    }

    // ACCESSEUR
    public int getId() {
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
    public int getDuree() {
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
    public int getAnnee() {
        return annee;
    }
    public String getDate_sortie() {
        return date_sortie;
    }
    public String getInfo() {
        return info;
    }
    public int getGenreid() {
        return genreid;
    }
    public String getGenre() {
        return genre;
    }
    public String getCategorie() {
        return categorie;
    }
    public int getReleaseNumber() {
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

    // MUTATEUR
    public void setId(int id) {
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
    public void setDuree(int duree) {
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
    public void setAnnee(int annee) {
        this.annee = annee;
    }
    public void setDate_sortie(String date_sortie) {
        this.date_sortie = date_sortie;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public void setGenreid(int genreid) {
        this.genreid = genreid;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    public void setReleaseNumber(int ReleaseNumber) {
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
}
