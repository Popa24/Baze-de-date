package com.example.bazededate.model;

import jakarta.persistence.*;

@Table
@Entity
public class Carte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_carte;
    private String titlu;
    private long nr_pagini;

    private long nr_exemplare;

    private String gen;


    public Carte(String titlu, long nr_pagini, long nr_exemplare, String gen) {
        this.titlu=titlu;
        this.nr_pagini=nr_pagini;
        this.nr_exemplare=nr_exemplare;
        this.gen=gen;
    }

    public Carte() {

    }

    public long getId_carte() {
        return id_carte;
    }

    public String getTitlu() {
        return titlu;
    }

    public long getNr_exemplare() {
        return nr_exemplare;
    }

    public long getNr_pagini() {
        return nr_pagini;
    }

    public String getGen() {
        return gen;
    }

    public Carte(long id_carte, String titlu, long nr_pagini, long nr_exemplare, String gen) {
        this.id_carte=id_carte;
        this.titlu=titlu;
        this.nr_pagini=nr_pagini;
        this.nr_exemplare=nr_exemplare;
        this.gen=gen;
    }


}
