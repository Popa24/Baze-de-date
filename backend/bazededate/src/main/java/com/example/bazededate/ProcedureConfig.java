package com.example.bazededate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProcedureConfig implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public ProcedureConfig(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.execute("CREATE OR REPLACE FUNCTION get_overdue(id INTEGER) " +
                "RETURNS TABLE (id_pers INTEGER, nume VARCHAR(255), telefon VARCHAR(255), adresa VARCHAR(255), data_nasterii DATE, overdue INTEGER) AS $$ " +
                "BEGIN " +
                "    RETURN QUERY SELECT p.id_pers, p.nume, p.telefon, p.adresa, p.data_nasterii, (current_date - i.datai) - i.nr_zile " +
                "    FROM Imprumut i " +
                "    JOIN Persoana p ON (p.id_pers = i.id_imp) " +
                "    WHERE i.datar IS NULL AND (current_date - i.datai) - i.nr_zile > 0 AND i.id_imp = id; " +
                "END; $$ LANGUAGE plpgsql; ");
    }
}