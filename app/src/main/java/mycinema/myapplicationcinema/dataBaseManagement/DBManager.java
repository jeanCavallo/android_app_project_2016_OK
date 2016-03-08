
package mycinema.myapplicationcinema.dataBaseManagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import mycinema.myapplicationcinema.objectFromJSON.FilmSeances;
import mycinema.myapplicationcinema.objectFromJSON.Seances;
import mycinema.myapplicationcinema.objectFromJSON.Soon;

/**
 * Created by jean on 01/03/16.
 */

public class DBManager extends SQLiteOpenHelper {

    private static final Integer DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "FilmSeancesDB.db";
    private static final String TABLE_FILMSEANCES = "filmseances";
    private static final String TABLE_EVENTS = "events";
    private static final String TABLE_SEANCES = "seances";
    private static final String TABLE_SOON = "soon";

    // FOR TABLE_FILMSEANCES
    private static final String FILM_ID = "id";
    private static final String FILM_TITRE = "titre";
    private static final String FILM_TITRE_ORI = "titre_ori";
    private static final String FILM_AFFICHE = "affiche";
    private static final String FILM_WEB = "web";
    private static final String FILM_DUREE = "duree";
    private static final String FILM_DISTRIBUTEUR = "distributeur";
    private static final String FILM_PARTICIPANTS = "participants";
    private static final String FILM_REALISATEUR = "realisateur";
    private static final String FILM_SYNOPSIS = "synopsis";
    private static final String FILM_ANNEE = "annee";
    private static final String FILM_DATE_SORTIE = "date_sortie";
    private static final String FILM_INFO = "info";
    private static final String FILM_IS_VISIBLE = "is_visible";
    private static final String FILM_IS_VENTE = "is_vente";
    private static final String FILM_GENREID = "genreid";
    private static final String FILM_CATEGORIEID = "categorieid";
    private static final String FILM_GENRE = "genre";
    private static final String FILM_CATEGORIE = "categorie";
    private static final String FILM_RELEASENUMBER = "ReleaseNumber";
    private static final String FILM_PAYS = "pays";
    private static final String FILM_SHARE_URL = "share_url";
    private static final String FILM_MEDIAS = "medias";
    private static final String FILM_VIDEOS = "videos";
    private static final String FILM_IS_AVP = "is_avp";
    private static final String FILM_IS_ALAUNE = "is_alaune";
    private static final String FILM_IS_LASTWEEK = "is_lastWeek";
    // add is_Next_1 and is_Next_2

    // FOR TABLE_EVENTS
    private static final String EVENT_TYPE = "type"; // TODO: Find how to extract it properly
    private static final String EVENT_ID = "id";
    private static final String EVENT_TITRE = "titre";
    private static final String EVENT_SOUS_TITRE = "sous_titre";
    private static final String EVENT_AFFICHE = "affiche";
    private static final String EVENT_DESCRIPTION = "description";
    private static final String EVENT_VAD_CONDITION = "vad_condition";
    private static final String EVENT_PARTENAIRE = "partenaire";
    private static final String EVENT_DATE_DEB = "date_deb";
    private static final String EVENT_DATE_FIN = "date_fin";
    private static final String EVENT_HEURE = "heure";
    private static final String EVENT_CONTACT = "contact";
    private static final String EVENT_WEB_LABEL = "web_label";
    private static final String EVENT_EVENEMENTTYPEID = "evenementtypeid";
    private static final String EVENT_FILMS = "films";

    // FOR TABLE_SEANCES
    private static final String SEANCE_ID = "id";
    private static final String SEANCE_ACTUAL_DATE = "actual_date";
    private static final String SEANCE_SHOW_TIME = "show_time";
    private static final String SEANCE_IS_TROISD = "is_troisd";
    private static final String SEANCE_IS_MALENTENDANT = "is_malentendant";
    private static final String SEANCE_IS_HANDICAPE = "is_handicape";
    private static final String SEANCE_NATIONALITY = "nationality";
    private static final String SEANCE_CINEMAID = "cinemaid";
    private static final String SEANCE_FILMID = "filmid";
    private static final String SEANCE_TITRE = "titre";
    private static final String SEANCE_CATEGORIEID = "categorieid";
    private static final String SEANCE_PERFORMANCEID = "performanceid";
    private static final String SEANCE_CINEMA_SALLE = "cinema_salle";

    // TABLE FOR SOON
    private static final String SOON_ID = "id";
    private static final String SOON_TITRE = "titre";
    private static final String SOON_AFFICHE = "affiche";

    public DBManager(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase dataBase) {
        String CREATE_FILMSEANCES_TABLE = "CREATE TABLE "
                + TABLE_FILMSEANCES
                + "("
                + FILM_ID + " INTEGER PRIMARY KEY, "
                + FILM_TITRE + " TEXT, "
                + FILM_TITRE_ORI + " TEXT, "
                + FILM_AFFICHE + " TEXT, "
                + FILM_WEB + " TEXT, "
                + FILM_DUREE + " TEXT, "
                + FILM_DISTRIBUTEUR + " TEXT, "
                + FILM_PARTICIPANTS + " TEXT, "
                + FILM_REALISATEUR + " TEXT, "
                + FILM_SYNOPSIS + " TEXT, "
                + FILM_ANNEE + " TEXT, "
                + FILM_DATE_SORTIE + " TEXT, "
                + FILM_INFO + " TEXT, "
                + FILM_IS_VISIBLE + " BOOLEAN, "
                + FILM_IS_VENTE + " BOOLEAN, "
                + FILM_GENREID + " INTEGER, "
                + FILM_CATEGORIEID + " INTEGER, "
                + FILM_GENRE + " TEXT, "
                + FILM_CATEGORIE + " TEXT, "
                + FILM_RELEASENUMBER + " INTEGER, "
                + FILM_PAYS + " TEXT, "
                + FILM_SHARE_URL + " TEXT, "
                + FILM_MEDIAS + " TEXT, "
                + FILM_VIDEOS + " TEXT, "
                + FILM_IS_AVP + " BOOLEAN, "
                + FILM_IS_ALAUNE + " BOOLEAN, "
                + FILM_IS_LASTWEEK + " BOOLEAN "
                + ")";

        String CREATE_EVENTS_TABLE = "CREATE TABLE "
                + TABLE_EVENTS
                + "("
                + EVENT_ID + " INTEGER PRIMARY KEY, "
                + EVENT_TITRE + " TEXT, "
                + EVENT_SOUS_TITRE + " TEXT, "
                + EVENT_AFFICHE + " TEXT, "
                + EVENT_DESCRIPTION + " TEXT, "
                + EVENT_VAD_CONDITION + " TEXT, "
                + EVENT_PARTENAIRE + " TEXT, "
                + EVENT_DATE_DEB + " TEXT, "
                + EVENT_DATE_FIN + " TEXT, "
                + EVENT_HEURE + " TEXT, "
                + EVENT_CONTACT + " TEXT, "
                + EVENT_WEB_LABEL + " TEXT, "
                + EVENT_EVENEMENTTYPEID + " INTEGER, "
                + EVENT_FILMS + " TEXT "
                + ")";

        String CREATE_SEANCES_TABLE = "CREATE TABLE "
                + TABLE_SEANCES
                + "("
                + SEANCE_ID + " INTEGER PRIMARY KEY, "
                + SEANCE_ACTUAL_DATE + " TEXT, "
                + SEANCE_SHOW_TIME + " TEXT, "
                + SEANCE_IS_TROISD + " BOOLEAN, "
                + SEANCE_IS_MALENTENDANT + " BOOLEAN, "
                + SEANCE_IS_HANDICAPE + " BOOLEAN, "
                + SEANCE_NATIONALITY + " TEXT, "
                + SEANCE_CINEMAID + " INTEGER, "
                + SEANCE_FILMID + " INTEGER, "
                + SEANCE_TITRE + " TEXT, "
                + SEANCE_CATEGORIEID + " INTEGER, "
                + SEANCE_PERFORMANCEID + " INTEGER, "
                + SEANCE_CINEMA_SALLE + " TEXT "
                + ")";

        String CREATE_SOON_TABLE = "CREATE TABLE "
                + TABLE_SOON
                + "("
                + SOON_ID + " INTEGER PRIMARY KEY, "
                + SOON_TITRE + " TEXT, "
                + SOON_AFFICHE + " TEXT "
                + ")";

        dataBase.execSQL(CREATE_FILMSEANCES_TABLE);
        dataBase.execSQL(CREATE_EVENTS_TABLE);
        dataBase.execSQL(CREATE_SEANCES_TABLE);
        dataBase.execSQL(CREATE_SOON_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase dataBase, int oldVersion, int newVersion) {
        dataBase.execSQL("DROP TABLE IF EXISTS " + TABLE_FILMSEANCES);
        dataBase.execSQL("DROP TABLE IF EXISTS " + TABLE_SEANCES);
        dataBase.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENTS);
        dataBase.execSQL("DROP TABLE IF EXISTS " + TABLE_SOON);
        onCreate(dataBase);
    }

    public void addFilmSeances(FilmSeances filmSeances) {
        SQLiteDatabase dataBase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FILM_ID, filmSeances.getId());
        values.put(FILM_TITRE, filmSeances.getTitre());
        values.put(FILM_TITRE_ORI, filmSeances.getTitre_ori());
        values.put(FILM_AFFICHE, filmSeances.getAffiche());
        values.put(FILM_WEB, filmSeances.getWeb());
        values.put(FILM_DUREE, filmSeances.getDuree());
        values.put(FILM_DISTRIBUTEUR, filmSeances.getDistributeur());
        values.put(FILM_PARTICIPANTS, filmSeances.getParticipants());
        values.put(FILM_REALISATEUR, filmSeances.getRealisateur());
        values.put(FILM_SYNOPSIS, filmSeances.getSynopsis());
        values.put(FILM_ANNEE, filmSeances.getAnnee());
        values.put(FILM_DATE_SORTIE, filmSeances.getDate_sortie());
        values.put(FILM_INFO, filmSeances.getInfo());
        values.put(FILM_IS_VISIBLE, filmSeances.getIs_visible());
        values.put(FILM_IS_VENTE, filmSeances.getIs_vente());
        values.put(FILM_GENREID, filmSeances.getGenreid());
        values.put(FILM_CATEGORIEID, filmSeances.getCategorieid());
        values.put(FILM_GENRE, filmSeances.getGenre());
        values.put(FILM_CATEGORIE, filmSeances.getCategorie());
        values.put(FILM_RELEASENUMBER, filmSeances.getReleaseNumber());
        values.put(FILM_PAYS, filmSeances.getPays());
        values.put(FILM_SHARE_URL, filmSeances.getShare_url());
        values.put(FILM_MEDIAS, filmSeances.getMedias());
        values.put(FILM_VIDEOS, filmSeances.getVideos());
        values.put(FILM_IS_AVP, filmSeances.getIs_avp());
        values.put(FILM_IS_ALAUNE, filmSeances.getIs_alaune());
        values.put(FILM_IS_LASTWEEK, filmSeances.getIs_lastWeek());
        dataBase.insert(TABLE_FILMSEANCES, null, values);
        dataBase.close();
    }

    public void addSeances(Seances seance) {
        SQLiteDatabase dataBase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SEANCE_ID, seance.getId());
        values.put(SEANCE_ACTUAL_DATE, seance.getActual_date());
        values.put(SEANCE_SHOW_TIME, seance.getShow_time());
        values.put(SEANCE_IS_TROISD, seance.getIs_troisd());
        values.put(SEANCE_IS_MALENTENDANT, seance.getIs_malentendant());
        values.put(SEANCE_IS_HANDICAPE, seance.getIs_handicape());
        values.put(SEANCE_NATIONALITY, seance.getNationality());
        values.put(SEANCE_CINEMAID, seance.getCinemaid());
        values.put(SEANCE_FILMID, seance.getFilmid());
        values.put(SEANCE_TITRE, seance.getTitre());
        values.put(SEANCE_CATEGORIEID, seance.getCategorieid());
        values.put(SEANCE_PERFORMANCEID, seance.getPerformanceid());
        values.put(SEANCE_CINEMA_SALLE, seance.getCinema_salle());
        dataBase.insert(TABLE_SEANCES, null, values);
        dataBase.close();
    }

    public void addSoon(Soon soon) {
        SQLiteDatabase dataBase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SOON_ID, soon.getId());
        values.put(SOON_TITRE, soon.getTitre());
        values.put(SOON_AFFICHE, soon.getAffiche());
        dataBase.insert(TABLE_SOON, null, values);
        dataBase.close();
    }

    public List<Soon> getAllSoon() {
        List<Soon> filmList = new ArrayList<Soon>();

        String selectQuery = "SELECT * FROM " + TABLE_SOON;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Soon filmSelected = new Soon();
                filmSelected.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(SOON_ID))));
                filmSelected.setTitre(cursor.getString(cursor.getColumnIndex(SOON_TITRE)));
                filmSelected.setAffiche(cursor.getString(cursor.getColumnIndex(SOON_AFFICHE)));

                filmList.add(filmSelected);
            } while (cursor.moveToNext());
        }
        return filmList;
    }

    public Soon getSoon(Integer idFilm) {
        Soon filmSelected = new Soon();
        String selectQuery = "SELECT * FROM " + TABLE_SOON + " WHERE id = " + idFilm + "";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();

        filmSelected.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(SOON_ID))));
        filmSelected.setTitre(cursor.getString(cursor.getColumnIndex(SOON_TITRE)));
        filmSelected.setAffiche(cursor.getString(cursor.getColumnIndex(SOON_AFFICHE)));

        return filmSelected;
    }

    public List<FilmSeances> getAllFilms() {
        List<FilmSeances> filmList = new ArrayList<FilmSeances>();

        String selectQuery = "SELECT * FROM " + TABLE_FILMSEANCES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                FilmSeances filmSelected = new FilmSeances();
                filmSelected.setId(Integer.parseInt(cursor.getString(0)));
                filmSelected.setTitre(cursor.getString(1));

                filmList.add(filmSelected);
            } while (cursor.moveToNext());
        }
        return filmList;
    }

    public FilmSeances getFilm(Integer idFilm) {
        FilmSeances filmList = new FilmSeances();
        String selectQuery = "SELECT * FROM " + TABLE_FILMSEANCES + " WHERE id = " + idFilm + "";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();

        filmList.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(FILM_ID))));
        filmList.setTitre(cursor.getString(cursor.getColumnIndex(FILM_TITRE)));
        filmList.setTitre_ori(cursor.getString(cursor.getColumnIndex(FILM_TITRE_ORI)));
        filmList.setWeb(cursor.getString(cursor.getColumnIndex(FILM_WEB)));
        filmList.setDuree(cursor.getString(cursor.getColumnIndex(FILM_DUREE)));
        filmList.setDistributeur(cursor.getString(cursor.getColumnIndex(FILM_DISTRIBUTEUR)));
        filmList.setParticipants(cursor.getString(cursor.getColumnIndex(FILM_PARTICIPANTS)));
        filmList.setRealisateur(cursor.getString(cursor.getColumnIndex(FILM_REALISATEUR)));
        filmList.setSynopsis(cursor.getString(cursor.getColumnIndex(FILM_SYNOPSIS)));
        filmList.setAnnee(cursor.getString(cursor.getColumnIndex(FILM_ANNEE)));
        filmList.setDate_sortie(cursor.getString(cursor.getColumnIndex(FILM_DATE_SORTIE)));
        filmList.setInfo(cursor.getString(cursor.getColumnIndex(FILM_INFO)));
        filmList.setIs_visible(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(FILM_IS_VISIBLE))));
        filmList.setIs_vente(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(FILM_IS_VENTE))));
        filmList.setGenreid(Integer.parseInt(cursor.getString(cursor.getColumnIndex(FILM_GENREID))));
        filmList.setCategorieid(Integer.parseInt(cursor.getString(cursor.getColumnIndex(FILM_CATEGORIEID))));
        filmList.setGenre(cursor.getString(cursor.getColumnIndex(FILM_GENRE)));
        filmList.setCategorie(cursor.getString(cursor.getColumnIndex(FILM_CATEGORIE)));
        filmList.setReleaseNumber(Integer.parseInt(cursor.getString(cursor.getColumnIndex(FILM_RELEASENUMBER))));
        filmList.setPays(cursor.getString(cursor.getColumnIndex(FILM_PAYS)));
        filmList.setShare_url(cursor.getString(cursor.getColumnIndex(FILM_SHARE_URL)));
        filmList.setMedias(cursor.getString(cursor.getColumnIndex(FILM_MEDIAS)));
        filmList.setVideos(cursor.getString(cursor.getColumnIndex(FILM_VIDEOS)));
        filmList.setIs_avp(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(FILM_IS_AVP))));
        filmList.setIs_alaune(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(FILM_IS_ALAUNE))));
        filmList.setIs_lastWeek(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(FILM_IS_LASTWEEK))));

        return filmList;
    }

    public List<Seances> getAllSeances() {
        List<Seances> seanceList = new ArrayList<Seances>();

        String selectQuery = "SELECT * FROM " + TABLE_SEANCES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Seances seanceSelected = new Seances();
                seanceSelected.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(SEANCE_ID))));
                seanceSelected.setActual_date(cursor.getString(cursor.getColumnIndex(SEANCE_ACTUAL_DATE)));
                seanceSelected.setShow_time(cursor.getString(cursor.getColumnIndex(SEANCE_SHOW_TIME)));
                seanceSelected.setIs_troisd(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(SEANCE_IS_TROISD))));
                seanceSelected.setIs_malentendant(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(SEANCE_IS_MALENTENDANT))));
                seanceSelected.setIs_handicape(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(SEANCE_IS_HANDICAPE))));
                seanceSelected.setNationality(cursor.getString(cursor.getColumnIndex(SEANCE_NATIONALITY)));
                seanceSelected.setCinemaid(Integer.parseInt(cursor.getString(cursor.getColumnIndex(SEANCE_CINEMAID))));
                seanceSelected.setFilmid(Integer.parseInt(cursor.getString(cursor.getColumnIndex(SEANCE_FILMID))));
                seanceSelected.setTitre(cursor.getString(cursor.getColumnIndex(SEANCE_TITRE)));
                seanceSelected.setCategorieid(Integer.parseInt(cursor.getString(cursor.getColumnIndex(SEANCE_CATEGORIEID))));
                seanceSelected.setPerformanceid(Integer.parseInt(cursor.getString(cursor.getColumnIndex(SEANCE_PERFORMANCEID))));
                seanceSelected.setCinema_salle(cursor.getString(cursor.getColumnIndex(SEANCE_CINEMA_SALLE)));

                seanceList.add(seanceSelected);
            } while (cursor.moveToNext());
        }
        return seanceList;
    }

    public Seances getSeance(Integer idSeance) {
        Seances seance = new Seances();
        String selectQuery = "SELECT * FROM " + TABLE_SEANCES + " WHERE id = " + idSeance + "";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();

        if( cursor != null && cursor.moveToFirst() ) {
            seance.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(SEANCE_ID))));
            seance.setActual_date(cursor.getString(cursor.getColumnIndex(SEANCE_ACTUAL_DATE)));
            seance.setShow_time(cursor.getString(cursor.getColumnIndex(SEANCE_SHOW_TIME)));
            seance.setIs_troisd(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(SEANCE_IS_TROISD))));
            seance.setIs_malentendant(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(SEANCE_IS_MALENTENDANT))));
            seance.setIs_handicape(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(SEANCE_IS_HANDICAPE))));
            seance.setNationality(cursor.getString(cursor.getColumnIndex(SEANCE_NATIONALITY)));
            seance.setCinemaid(Integer.parseInt(cursor.getString(cursor.getColumnIndex(SEANCE_CINEMAID))));
            seance.setFilmid(Integer.parseInt(cursor.getString(cursor.getColumnIndex(SEANCE_FILMID))));
            seance.setTitre(cursor.getString(cursor.getColumnIndex(SEANCE_TITRE)));
            seance.setCategorieid(Integer.parseInt(cursor.getString(cursor.getColumnIndex(SEANCE_CATEGORIEID))));
            seance.setPerformanceid(Integer.parseInt(cursor.getString(cursor.getColumnIndex(SEANCE_PERFORMANCEID))));
            seance.setCinema_salle(cursor.getString(cursor.getColumnIndex(SEANCE_CINEMA_SALLE)));
        }

        return seance;
    }

    // TODO Add create table for other data
}
