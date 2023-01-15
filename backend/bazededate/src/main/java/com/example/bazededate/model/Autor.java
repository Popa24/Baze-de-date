package com.example.bazededate.model;

import jakarta.persistence.*;

@Table
@Entity
@IdClass(AutorId.class)
public class Autor {
   @Id
    private long id_carte;
   @Id
    private long id_aut;

    public Autor(long id_aut){

        this.id_aut=id_aut;
    }
    public Autor(long id_carte, long id_aut) {
        this.id_carte = id_carte;
        this.id_aut = id_aut;
    }


    public Autor() {

    }

    public long getId_carte() {
        return id_carte;
    }

    public long getId_aut() {
        return id_aut;
    }
}
