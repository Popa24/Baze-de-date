package com.example.bazededate.dataaccesobject;

import com.example.bazededate.model.Persoana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersoanaRepository extends JpaRepository<Persoana, Long> {
    @Query("select p from Persoana p ")
    List<Persoana>getAllPersoane ();
    @Query("select  p " +
            "FROM Carte c JOIN Imprumut i ON (c.id_carte=i.id_carte) JOIN Persoana p ON (p.id_pers=i.id_imp) " +
            "WHERE c.gen='Copii' AND (CURRENT_DATE -i.datai)+1<14")
    List<Persoana>getAllCopii();
    @Query("SELECT p.id_pers,p.nume,p.telefon,p.adresa,p.data_nasterii,(current_date -i.datai)-i.nr_zile " +
            "FROM  Imprumut i JOIN Persoana p ON (p.id_pers=i.id_imp) " +
            "WHERE i.datar is null AND (current_date -i.datai)-i.nr_zile>0 ")
    List<Object[]>getAllNerestituite1();
    @Query("SELECT p, c " +
            "FROM Carte c JOIN Imprumut i ON (c.id_carte=i.id_carte)  JOIN Persoana p ON (p.id_pers=i.id_imp) " +
            "WHERE c.nr_exemplare>=ALL (SELECT c.nr_exemplare " +
            "FROM Carte c " +
            ") ")
    List<Object[]>getAllNrExemplare();
    @Procedure(name="get_overdue")
    List<Object[]> get_overdue();
}
