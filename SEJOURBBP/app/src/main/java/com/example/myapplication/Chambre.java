package com.example.myapplication;

public class Chambre {
    private int id;
    private Service leService;

    public Chambre(int id, Service leService) {
        this.id = id;
        this.leService = leService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Service getLeService() {
        return leService;
    }

    public void setLeService(Service leService) {
        this.leService = leService;
    }

    @Override
    public String toString() {
        return "Chambre{" +
                "id=" + id +
                ", leService=" + leService +
                '}';
    }
}
