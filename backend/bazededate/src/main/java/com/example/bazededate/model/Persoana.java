package com.example.bazededate.model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Table
@Entity
public class Persoana {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_pers;
    private String nume;
    private long telefon;
    private String adresa;
    private LocalDate data_nasterii;
    private long intarziere;


    public Persoana(String nume, long telefon, String adresa, LocalDate data_nasterii) {
        this.nume = nume;
        this.telefon = telefon;
        this.adresa = adresa;
        this.data_nasterii = data_nasterii;
    }

    public Persoana() {

    }

    public long getId_pers() {
        return id_pers;
    }

    public String getNume() {
        return nume;
    }

    public long getTelefon() {
        return telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public LocalDate getData_nasterii() {
        return data_nasterii;
    }

    public Persoana(long id_pers, String nume, long telefon, String adresa, LocalDate data_nasterii) {
        this.id_pers = id_pers;
        this.nume = nume;
        this.telefon = telefon;
        this.adresa = adresa;
        this.data_nasterii = data_nasterii;
    }

    public long getIntarziere() {
        return intarziere;
    }

    public Persoana(long id_pers, String nume, long telefon, String adresa, LocalDate data_nasterii, long intarziere) {
        this.id_pers = id_pers;
        this.nume = nume;
        this.telefon = telefon;
        this.adresa = adresa;
        this.data_nasterii = data_nasterii;
        this.intarziere = intarziere;
    }
}
