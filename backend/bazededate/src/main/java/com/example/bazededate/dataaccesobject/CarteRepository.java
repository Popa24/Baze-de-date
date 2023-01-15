package com.example.bazededate.dataaccesobject;

import com.example.bazededate.model.Carte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarteRepository extends JpaRepository<Carte, Long> {
    @Query("select p from Carte p ")
    List<Carte>getAllCarti ();
    @Query("SELECT c " +
            "FROM Carte c " +
            "WHERE  c.gen='Tehnic' AND (c.nr_exemplare <300 AND c.nr_exemplare >100) " +
            "ORDER BY c.nr_exemplare DESC")
    List<Carte>getCarteExemplare();
    @Query("SELECT a " +
            "FROM Carte a " +
            "WHERE a.gen IN (SELECT b.gen " +
            "FROM Carte b " +
            "WHERE b.titlu='Shogun') ")
    List<Carte>getCarteShogun();
    @Query("SELECT  p.gen, MIN(p.nr_pagini)  , MAX(p.nr_pagini)  , AVG(p.nr_pagini) " +
            "FROM Carte p " +
            "GROUP BY p.gen")
    List<Object[]>getCarteMediu();




}
