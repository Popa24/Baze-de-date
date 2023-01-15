package com.example.bazededate.dataaccesobject;

import com.example.bazededate.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query("select p from Autor p ")
    List<Autor>getAllAutori ();
    @Query("select DISTINCT id_aut1.id_aut ,id_aut2.id_aut " +
            "FROM Autor id_aut1  JOIN Autor id_aut2 ON (id_aut1.id_carte=id_aut2.id_carte) "+
            "WHERE id_aut1.id_aut<id_aut2.id_aut ")
    List<Object[]>getAllPerechi();

}
