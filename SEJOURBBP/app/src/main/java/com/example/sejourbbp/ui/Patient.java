package com.example.sejourbbp.ui;

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


    }

