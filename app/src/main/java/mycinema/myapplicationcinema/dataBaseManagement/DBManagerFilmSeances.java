package mycinema.myapplicationcinema.dataBaseManagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import mycinema.myapplicationcinema.objectFromJSON.FilmSeances;

/**
 * Created by jean on 01/03/16.
 */

public class DBManagerFilmSeances extends SQLiteOpenHelper {

    private static final Integer DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "FilmSeancesDB";
    private static final String TABLE_FILMSEANCES = "filmseances";

    private static final String KEY_ID = "id";
    private static final String KEY_TITRE = "titre";
    private static final String KEY_TITRE_ORI = "titre_ori";
    private static final String KEY_AFFICHE = "affiche";
    private static final String KEY_WEB = "web";
    private static final String KEY_DUREE = "duree";
    private static final String KEY_DISTRIBUTEUR = "distributeur";
    private static final String KEY_PARTICIPANTS = "participants";
    private static final String KEY_REALISATEUR = "realisateur";
    private static final String KEY_SYNOPSIS = "synopsis";
    private static final String KEY_ANNEE = "annee";
    private static final String KEY_DATE_SORTIE = "date_sortie";
    private static final String KEY_INFO = "info";
    private static final String KEY_IS_VISIBLE = "is_visible";
    private static final String KEY_IS_VENTE = "is_vente";
    private static final String KEY_GENREID = "genreid";
    private static final String KEY_CATEGORIEID = "categorieid";
    private static final String KEY_GENRE = "genre";
    private static final String KEY_CATEGORIE = "categorie";
    private static final String KEY_RELEASENUMBER = "ReleaseNumber";
    private static final String KEY_PAYS = "pays";
    private static final String KEY_SHARE_URL = "share_url";
    private static final String KEY_MEDIAS = "medias";
    private static final String KEY_VIDEOS = "videos";
    private static final String KEY_IS_AVP = "is_avp";
    private static final String KEY_IS_ALAUNE = "is_alaune";
    private static final String KEY_IS_LASTWEEK = "is_lastWeek";


    public DBManagerFilmSeances(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase dataBase) {
        String CREATE_FILMSEANCES_TABLE = "CREATE TABLE " + TABLE_FILMSEANCES + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_TITRE + " TEXT," + KEY_TITRE_ORI + " TEXT," + KEY_AFFICHE + " TEXT," + KEY_WEB + " TEXT," + KEY_DUREE + " TEXT,"
                + KEY_DISTRIBUTEUR + " TEXT," + KEY_PARTICIPANTS + " TEXT," + KEY_REALISATEUR + " TEXT," + KEY_SYNOPSIS + " TEXT," + KEY_ANNEE + " TEXT," + KEY_DATE_SORTIE + " TEXT,"
                + KEY_INFO + " TEXT," + KEY_IS_VISIBLE + " TEXT," + KEY_IS_VENTE + " TEXT," + KEY_GENREID + " TEXT," + KEY_CATEGORIEID + " TEXT" + KEY_GENRE + " TEXT,"  + KEY_CATEGORIE + " TEXT,"
                + KEY_RELEASENUMBER + " TEXT," + KEY_PAYS + " TEXT," + KEY_SHARE_URL + " TEXT," + KEY_MEDIAS + " TEXT," + KEY_VIDEOS + " TEXT" + KEY_IS_AVP + " TEXT" + KEY_IS_ALAUNE + " TEXT" + KEY_IS_LASTWEEK + " TEXT" + ")";
        dataBase.execSQL(CREATE_FILMSEANCES_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase dataBase, int oldVersion, int newVersion) {
        dataBase.execSQL("DROP TABLE IF EXISTS " + TABLE_FILMSEANCES);
        onCreate(dataBase);
    }

    public void addFilmSeances(FilmSeances filmSeances) {
        SQLiteDatabase dataBase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, filmSeances.getId());
        values.put(KEY_TITRE, filmSeances.getTitre());
        values.put(KEY_TITRE_ORI, filmSeances.getTitre_ori());
        values.put(KEY_AFFICHE, filmSeances.getAffiche());
        values.put(KEY_WEB, filmSeances.getWeb());
        values.put(KEY_DUREE, filmSeances.getDuree());
        values.put(KEY_DISTRIBUTEUR, filmSeances.getDistributeur());
        values.put(KEY_PARTICIPANTS, filmSeances.getParticipants());
        values.put(KEY_REALISATEUR, filmSeances.getRealisateur());
        values.put(KEY_SYNOPSIS, filmSeances.getSynopsis());
        values.put(KEY_ANNEE, filmSeances.getAnnee());
        values.put(KEY_DATE_SORTIE, filmSeances.getDate_sortie());
        values.put(KEY_INFO, filmSeances.getInfo()); //Reprendre là !!!!!
        values.put(KEY_IS_VENTE, filmSeances.getIs_vente());
        values.put(KEY_GENREID, filmSeances.getGenreid());
        values.put(KEY_GENRE, filmSeances.getGenre());
        values.put(KEY_CATEGORIE, filmSeances.getTitre());
        values.put(KEY_RELEASENUMBER, filmSeances.getTitre());
        values.put(KEY_PAYS, filmSeances.getTitre());
        values.put(KEY_SHARE_URL, filmSeances.getTitre());
        values.put(KEY_MEDIAS, filmSeances.getTitre());
        values.put(KEY_VIDEOS, filmSeances.getTitre());
        dataBase.insert(TABLE_FILMSEANCES, null, values);
        dataBase.close();
    }

    public FilmSeances getFilmSeances(Integer idToSelect) {
        SQLiteDatabase dataBase = this.getReadableDatabase();
        Cursor cursor = dataBase.query(TABLE_FILMSEANCES, new String[] {KEY_ID, KEY_TITRE, KEY_TITRE_ORI, KEY_AFFICHE, KEY_WEB, KEY_DUREE, KEY_DISTRIBUTEUR,
                KEY_PARTICIPANTS, KEY_REALISATEUR, KEY_SYNOPSIS, KEY_ANNEE, KEY_DATE_SORTIE, KEY_INFO, KEY_IS_VISIBLE, KEY_IS_VENTE, KEY_GENREID, KEY_GENRE,
                KEY_CATEGORIE, KEY_RELEASENUMBER, KEY_PAYS, KEY_SHARE_URL, KEY_MEDIAS, KEY_VIDEOS}, KEY_ID + " LIKE \"" + idToSelect +"\"", null, null, null, null);
        return cursorToFilmSeances(cursor);
    }

    private FilmSeances cursorToFilmSeances(Cursor cursor){
        if (cursor.getCount() == 0)
            return null;

        cursor.moveToFirst();
        FilmSeances filmSeances = new FilmSeances();

        filmSeances.setId(cursor.getInt(Integer.parseInt(KEY_ID)));
        filmSeances.setTitre(cursor.getString(Integer.parseInt(KEY_TITRE)));
        filmSeances.setTitre_ori(cursor.getString(Integer.parseInt(KEY_TITRE_ORI)));
        filmSeances.setAffiche(cursor.getString(Integer.parseInt(KEY_AFFICHE)));
        filmSeances.setWeb(cursor.getString(Integer.parseInt(KEY_WEB)));
        filmSeances.setDuree(cursor.getString(Integer.parseInt(KEY_DUREE)));
        filmSeances.setDistributeur(cursor.getString(Integer.parseInt(KEY_DISTRIBUTEUR)));
        filmSeances.setParticipants(cursor.getString(Integer.parseInt(KEY_PARTICIPANTS)));
        filmSeances.setRealisateur(cursor.getString(Integer.parseInt(KEY_REALISATEUR)));
        filmSeances.setSynopsis(cursor.getString(Integer.parseInt(KEY_SYNOPSIS)));
        filmSeances.setAnnee(cursor.getString(Integer.parseInt(KEY_ANNEE)));
        filmSeances.setDate_sortie(cursor.getString(Integer.parseInt(KEY_DATE_SORTIE)));
        filmSeances.setInfo(cursor.getString(Integer.parseInt(KEY_INFO)));
        filmSeances.setIs_visible(Boolean.parseBoolean(cursor.getString(Integer.parseInt(KEY_IS_VISIBLE))));
        filmSeances.setIs_vente(Boolean.parseBoolean(cursor.getString(Integer.parseInt(KEY_IS_VENTE))));
        filmSeances.setGenreid(cursor.getInt(Integer.parseInt(KEY_GENREID)));
        filmSeances.setGenre(cursor.getString(Integer.parseInt(KEY_GENRE)));
        filmSeances.setCategorie(cursor.getString(Integer.parseInt(KEY_CATEGORIE)));
        filmSeances.setReleaseNumber(cursor.getInt(Integer.parseInt(KEY_RELEASENUMBER)));
        filmSeances.setPays(cursor.getString(Integer.parseInt(KEY_PAYS)));
        filmSeances.setShare_url(cursor.getString(Integer.parseInt(KEY_SHARE_URL)));
        filmSeances.setMedias(cursor.getString(Integer.parseInt(KEY_MEDIAS)));
        filmSeances.setVideos(cursor.getString(Integer.parseInt(KEY_VIDEOS)));

        cursor.close();

        return filmSeances;
    }


    // TODO Add create table for other data
}
