package com.example.zadaniedomowe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Pracownik {
    
    @Id
    @GeneratedValue
    private Long id;
    private String imie;
    private String nazwisko;
    @Column(nullable = false)
    private String pesel;
    private LocalDate dataZatrudnienia;
    private BigDecimal wynagrodzenie;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public BigDecimal getWynagrodzenie() {
        return wynagrodzenie;
    }
    public void setWynagrodzenie(BigDecimal wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }
    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    public String getPesel() {
        return pesel;
    }
    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
    public LocalDate getDataZatrudnienia() {
        return dataZatrudnienia;
    }
    public void setDataZatrudnienia(LocalDate dataZatrudnienia) {
        this.dataZatrudnienia = dataZatrudnienia;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", Numer Pesel='" + pesel + '\'' +
                ", data zatrudnienia=" + dataZatrudnienia +
                ", wynagrodzenie=" + wynagrodzenie + " zł brutto" + '}';
    }
}
