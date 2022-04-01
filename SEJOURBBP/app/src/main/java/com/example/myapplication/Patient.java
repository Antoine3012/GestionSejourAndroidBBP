package com.example.myapplication;

import java.util.Date;

public class Patient {
    private int id;
    private String nom;
    private String prenom;
    private Date datenaissance;

    public Patient (int pId, String pNom, String pPrenom, Date pDateNaissance){
        id=pId;
        nom=pNom;
        prenom=pPrenom;
        datenaissance=pDateNaissance;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDatenaissance() { return datenaissance; }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", nom='" + nom + '\'' + ", prenom='" + prenom + '\'' + ", Date de naissance='" + datenaissance + '\'' +
                '}';
    }

    public String getTitle(){
        String title = nom + " " + prenom;

        return title;
    }
}
