package com.example.loic.gissippool.Provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by LOIC on 09/07/2015.
 */
public class Requete {

    private static final int VERSION_BDD = 1;

    private static final String NOM_BDD = "gossip.db";

    private static final String PROFIL = "profil";

    private static final String ID = "Id";

    private static final int N_ID = 0;

    private static final String SPEUDO = "speudo";

    private static final int N_SPEUDO = 1;

    private static final String PASSWD = "pass";

    private static final int N_PASSWD = 3;
    private static final String EMAIL = "email";

    private static final int N_EMAIL = 3;

    private SQLiteDatabase bdd;

    private DataBase ma_bdd;

    public Requete(Context context) {

        // on crée la bdd et ses tables
        ma_bdd = new DataBase(context, NOM_BDD, null, VERSION_BDD);
    }
    public Requete(){}


    public void open() {

        // ouverture de la BDD en écriture
        bdd = ma_bdd.getWritableDatabase();
    }

    public void close() {

        // on ferme l'accès à la BDD
        bdd.close();
    }


    public SQLiteDatabase getBdd() {

        return bdd;
    }


    // methode pour inserer un nouvel element

    public long insertART(Profil p) {

        // création d'un content values

        ContentValues values = new ContentValues();

        values.put(SPEUDO, p.getSpeudo());

        values.put(PASSWD, p.getPasswd());

        values.put(EMAIL, p.getEmail());

        return bdd.insert(PROFIL, null, values);

    }

    // methode pour modifier un element

    public long updateART(Profil p, int id) {

        // création d'un content values

        ContentValues values = new ContentValues();

        values.put(SPEUDO, p.getSpeudo());

        values.put(PASSWD, p.getPasswd());
        values.put(EMAIL, p.getEmail());

        return bdd.update(PROFIL, values, ID + "=" + id, null);

    }

    // methode pour supprimer un element

    public int RemoveART(int id) {

        return bdd.delete(PROFIL, ID + "=" + id, null);
    }


    // methode pour rechercher un element a partir de son id

    public Profil getArticle(int id) {

        Cursor c = bdd.query(PROFIL, new String[]{ID, SPEUDO, PASSWD,EMAIL}, ID + "=" + id, null, null, null, null,null);

        return cursorArt(c);

    }

    // methode pour rechercher un element a partir de son titre

    public Profil getProfil(String speudo) {

        Cursor c = bdd.query(PROFIL, new String[]{ID, SPEUDO, PASSWD, EMAIL}, SPEUDO + "=" + speudo, null, null, null, null);

        return cursorArt(c);

    }

    // methode qui permet de parcourir les resultats d'une requete et de les retourner

    public Profil cursorArt(Cursor c) {

        if (c.getCount() == 0) {

            return null;

        } else {
            c.moveToFirst();

           Profil a =new Profil();

            a.setId(c.getInt(N_ID));

            a.setSpeudo(c.getString(N_SPEUDO));

            a.setPasswd(c.getString(N_PASSWD));
            a.setEmail(c.getString(N_EMAIL));

            c.close();

            return a;

        }

    }


    // methode qui permet de parcourir les resultats d'une requete et de les retourner dans une liste (ici on utilise la liste car c plus d'un element que l'on retourne )

    public ArrayList<Profil> getAllART() {

        Cursor c = bdd.query(PROFIL, new String[]{ID, SPEUDO, PASSWD, EMAIL}, null, null, null, null, null);

        return cursorArtAll(c);
    }

    public ArrayList<Profil> cursorArtAll(Cursor c) {

        ArrayList<Profil> list = new ArrayList<Profil>();

        if (c.getCount() == 0) {

            return null;

        } else {

            // déplaçons le curseur sur le premier enregistrement

            c.moveToFirst();

            // tant que le curseur pourra se déplacer sur les autres éléments, remplir la liste

            while (c.isAfterLast() == false) {

                Profil a =new Profil();

                a.setId(c.getInt(N_ID));

                a.setSpeudo(c.getString(N_SPEUDO));

                a.setPasswd(c.getString(N_PASSWD));
                a.setEmail(c.getString(N_EMAIL));

                list.add(a);

                c.moveToNext();

            }

            c.close();

            return list;

        }

    }


}
