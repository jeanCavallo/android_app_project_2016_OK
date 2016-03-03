package mycinema.myapplicationcinema;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by jean on 01/03/16.
 */

public class DBManagerFilmSeances extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
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
    private static final String KEY_IS_VENTE = "is_vente";
    private static final String KEY_GENREID = "genreid";
    private static final String KEY_GENRE = "genre";
    private static final String KEY_CATEGORIE = "categorie";
    private static final String KEY_RELEASENUMBER = "ReleaseNumber";
    private static final String KEY_PAYS = "pays";
    private static final String KEY_SHARE_URL = "share_url";
    private static final String KEY_MEDIAS = "medias";
    private static final String KEY_VIDEOS = "videos";

    public DBManagerFilmSeances(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase dataBase) {
        String CREATE_FILMSEANCES_TABLE = "CREATE TABLE " + TABLE_FILMSEANCES + "("
                + KEY_ID + " INT" + KEY_TITRE + " TEXT," + KEY_TITRE_ORI + " TEXT," + KEY_AFFICHE + " TEXT," + KEY_WEB + " TEXT," + KEY_DUREE + " TEXT,"
                + KEY_DISTRIBUTEUR + " TEXT," + KEY_PARTICIPANTS + " TEXT," + KEY_REALISATEUR + " TEXT," + KEY_SYNOPSIS + " TEXT," + KEY_ANNEE + " TEXT," + KEY_DATE_SORTIE + " TEXT,"
                + KEY_TITRE_ORI + " TEXT," + KEY_INFO + " TEXT," + KEY_IS_VENTE + " TEXT," + KEY_GENREID + " TEXT," + KEY_GENRE + " TEXT,"  + KEY_CATEGORIE + " TEXT,"
                + KEY_RELEASENUMBER + " TEXT," + KEY_PAYS + " TEXT," + KEY_SHARE_URL + " TEXT," + KEY_MEDIAS + " TEXT," + KEY_VIDEOS + " TEXT" + ")";
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
        // TODO Ajouter tous les attributs/champs
        dataBase.insert(TABLE_FILMSEANCES, null, values);
        dataBase.close();
    }
    // TODO Add create table for other data
}
