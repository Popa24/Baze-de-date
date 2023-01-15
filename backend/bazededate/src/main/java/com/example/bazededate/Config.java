package com.example.bazededate;

import com.example.bazededate.model.Autor;
import com.example.bazededate.model.Carte;
import com.example.bazededate.model.Imprumut;
import com.example.bazededate.model.Persoana;
import com.example.bazededate.serviciu.AutorServiciu;
import com.example.bazededate.serviciu.CarteServiciu;
import com.example.bazededate.serviciu.ImprumutServiciu;
import com.example.bazededate.serviciu.PersoanaServiciu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.lang.model.type.NullType;
import java.time.LocalDate;

@Configuration
public class Config {
    @Bean
    CommandLineRunner commandLineRunner(PersoanaServiciu p, CarteServiciu q, ImprumutServiciu r, AutorServiciu s){
        return args -> {
            Persoana a=new Persoana("Popa",726870977,"strada 1 decembrie 1918", LocalDate.of(2002,5,24));
            Persoana f = new Persoana("Popa Alexandru", 726870977, "CLUJ_NAPOCA", LocalDate.of(2002, 5, 24));
            Persoana b = new Persoana("Pop Alexandru", 726874577, "PETROSANI", LocalDate.of(2002, 6, 24));
            Persoana c = new Persoana("Popa Alex", 726854577, "CLUJ_NAPOCA", LocalDate.of(2002, 12, 24));
            Persoana d = new Persoana("Mircea Cărtărescu", 210134567, "", LocalDate.of(1956, 6, 1));
            Persoana e = new Persoana("Mihai Eminescu", 0, "", null);

            p.addPersoana(a);
            p.addPersoana(b);
            p.addPersoana(c);
            p.addPersoana(d);
            p.addPersoana(e);
            p.addPersoana(f);
            Carte aa = new Carte("Ion", 500, 150, "Tehnic");
            q.addCarte(aa);

            Carte bb = new Carte("Abatorul cinci", 700, 120, "Tehnic");
            q.addCarte(bb);

            Carte cc = new Carte("Abația", 900, 260, "Tehnic");
            q.addCarte(cc);

            Carte dd = new Carte("Cenusareasa", 100, 10, "Copii");
            q.addCarte(dd);

            Carte ee = new Carte("Rapunzel", 190, 300, "Copii");
            q.addCarte(ee);

            Carte ff = new Carte("Shogun", 100, 10, "Copii");
            q.addCarte(ff);

            Carte gg = new Carte("Capra fericita", 190, 300, "Copii");
            q.addCarte(gg);



            Imprumut imprumut3 = new Imprumut(1, 1, LocalDate.of(2022, 3, 10), LocalDate.of(2022, 6, 10), 5);
            r.addImprumut(imprumut3);

            Imprumut imprumut4 = new Imprumut(2, 1, LocalDate.of(2021, 12, 24), LocalDate.of(2022, 6, 10), 10);
            r.addImprumut(imprumut4);

            Imprumut imprumut5 = new Imprumut(3, 1, LocalDate.of(2022, 4, 5), LocalDate.of(2022, 4, 10), 14);
            r.addImprumut(imprumut5);

            Imprumut imprumut9=new Imprumut(4,1,LocalDate.of(2023,1,6),null,16);
            r.addImprumut(imprumut9);

            Imprumut imprumut1 = new Imprumut(4, 2, LocalDate.of(2022, 12, 8), LocalDate.of(2023, 6, 10), 5);
            r.addImprumut(imprumut1);


            Imprumut imprumut2 = new Imprumut(5, 3, LocalDate.of(2022, 12, 7), LocalDate.of(2023, 6, 10), 5);
            r.addImprumut(imprumut2);

            Imprumut imprumut10 = new Imprumut(5, 4, LocalDate.of(2023, 1, 6), LocalDate.of(2023, 6, 10), 5);
            r.addImprumut(imprumut10);

            Imprumut imprumut6=new Imprumut(6,2,LocalDate.of(2022,5,14),null,14);
            r.addImprumut(imprumut6);
            Imprumut imprumut7=new Imprumut(7,2,LocalDate.of(2021,5,14),null,15);
            r.addImprumut(imprumut7);
            Imprumut imprumut8=new Imprumut(8,2,LocalDate.of(2021,5,14),null,16);
            r.addImprumut(imprumut8);


            Autor aaa=new Autor(1,1);
            Autor bbb=new Autor(1,2);
            Autor ccc=new Autor(2,1);
            Autor ddd=new Autor(2,2);
            Autor eee=new Autor(2,3);

            s.addAutor(aaa);
            s.addAutor(bbb);
            s.addAutor(ccc);
            s.addAutor(ddd);
            s.addAutor(eee);

        };
    }
//
//
}
