package com.example.myapplication;

import java.util.Date;

public class Sejour {
    private int id;
    private Date dateArrivee;
    private Chambre laChambre;
    private Patient lePatient;
    private boolean validationEntree;

    public Sejour(int id, Date dateArrivee, Chambre laChambre, Patient lePatient) {
        this.id = id;
        this.dateArrivee = dateArrivee;
        this.laChambre = laChambre;
        this.lePatient = lePatient;
        this.validationEntree = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public Chambre getLaChambre() {
        return laChambre;
    }

    public void setLaChambre(Chambre laChambre) {
        this.laChambre = laChambre;
    }

    public Patient getLePatient() {
        return lePatient;
    }

    public void setLePatient(Patient lePatient) {
        this.lePatient = lePatient;
    }

    public boolean isValidationEntree() {
        return validationEntree;
    }

    public void setValidationEntree(boolean validationEntree) {
        this.validationEntree = validationEntree;
    }

    @Override
    public String toString() {
        return "Sejour{" +
                "id=" + id +
                ", dateArrivee=" + dateArrivee +
                ", laChambre=" + laChambre +
                ", lePatient=" + lePatient +
                ", validationEntree=" + validationEntree +
                '}';
    }
}
