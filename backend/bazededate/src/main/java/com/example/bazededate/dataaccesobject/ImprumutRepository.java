package com.example.bazededate.dataaccesobject;

import com.example.bazededate.model.Imprumut;
import com.example.bazededate.model.Persoana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImprumutRepository extends JpaRepository<Imprumut, Long> {
    @Query("select p from Imprumut p ")
    List<Imprumut>getAllImprumuturi ();
    @Query("select i " +
            "FROM Imprumut i " +
            "WHERE (CURRENT_DATE -i.datai)-i.nr_zile>14 AND i.datar IS NULL " +
            "ORDER BY i.datai ASC, i.nr_zile DESC ")
    List<Imprumut>getAllNerestituite();

}
