package com.example.zadaniedomowe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class PracownikController {

    @Autowired
    @PersistenceUnit
    EntityManagerFactory entityManagerFactory;

    @GetMapping("/")
    public String list(Model model){

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Pracownik> query = entityManager.createQuery("select p from Pracownik p", Pracownik.class);
        List<Pracownik> lista_wynikow = query.getResultList();

        model.addAttribute("pracownicy", lista_wynikow);
        model.addAttribute("pageInformacje", "Lista pracowników:");
        return "index";
    }

    @GetMapping("/dodaj")
    public String dodaj(Model model) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        model.addAttribute("pracownik", new Pracownik());
        return "nowy";
    }

    @PostMapping("/dodaj")
    public String dodaj2(Pracownik pracownik)  {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(pracownik);
        entityManager.getTransaction().commit();

        return "success";
        

    }


    @GetMapping("/info/{id}")
    public String info(@PathVariable Long id, Model model) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Pracownik pracownik = entityManager.find(Pracownik.class, id);

        model.addAttribute("pracownik", pracownik);
        model.addAttribute("p", pracownik);
        return "informacje";
    }

    @GetMapping("/edycja/{id}")
    public String edycja(@PathVariable Long id, Model model) {


        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Pracownik pracownik = entityManager.find(Pracownik.class, id);

        model.addAttribute("pracownik", pracownik);

        return "edycja";
    }


    @PostMapping("/edycja/{id}")
    public String edycjadalsza(Pracownik pracownik, @PathVariable Long id)  {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Pracownik pracownikzedytowany = entityManager.find(Pracownik.class, id);
        pracownikzedytowany.setImie(pracownik.getImie());
        pracownikzedytowany.setNazwisko(pracownik.getNazwisko());

        entityManager.getTransaction().begin();
        entityManager.persist(pracownikzedytowany);
        entityManager.getTransaction().commit();

        return "redirect:/edycja/" + pracownik.getId();

    }
}
