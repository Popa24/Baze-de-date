package com.example.bazededate.model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Table
@Entity
@IdClass(ImprumutId.class)
public class Imprumut {

    @Id

    private long id_carte;
    @Id
    private long id_imp;
    private LocalDate datai;
    private LocalDate datar;
    private long nr_zile;


    public Imprumut() {
    }

    public Imprumut(long id_carte, long id_imp, LocalDate datai, LocalDate datar, long nr_zile) {
        this.id_carte = id_carte;
        this.id_imp = id_imp;
        this.datai = datai;
        this.datar = datar;
        this.nr_zile = nr_zile;
    }

    public long getId_carte() {
        return id_carte;
    }

    public long getId_imp() {
        return id_imp;
    }

    public LocalDate getDatai() {
        return datai;
    }

    public LocalDate getDatar() {
        return datar;
    }

    public long getNr_zile() {
        return nr_zile;
    }
}
