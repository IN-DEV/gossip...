package com.example.loic.gissippool.Provider;

/**
 * Created by LOIC on 09/07/2015.
 */
public class Profil {

    public int Id;

    public String speudo;

    public String passwd;

    public String email;


    public Profil(){

        this.Id=0; this.speudo=""; this.passwd=""; this.email="";
    }

    public Profil(int Id, String speudo, String passwd ,String email){

        this.Id=Id; this.speudo=speudo; this.passwd=passwd; this.email=email;
    }

    public int getId(){ return this.Id; }

    public void setId(int Id){ this.Id=Id; }

    public String getSpeudo(){ return  this.speudo; }

    public void setSpeudo(String speu){ this.speudo=speu; }

    public String getPasswd(){ return this.passwd; }

    public void setPasswd(String pass){ this.passwd=pass; }

    public String getEmail(){ return this.email; }

    public void setEmail(String email){ this.email=email; }

}

