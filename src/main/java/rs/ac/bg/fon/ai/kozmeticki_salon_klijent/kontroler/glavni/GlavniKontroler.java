/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.kozmeticki_salon_klijent.kontroler.glavni;

import rs.ac.bg.fon.ai.kozmeticki_salon_klijent.forme.DodajKlijentaForma;
import java.util.HashMap;
import java.util.Map;
import rs.ac.bg.fon.ai.kozmeticki_salon_klijent.forme.*;
import rs.ac.bg.fon.ai.kozmeticki_salon_klijent.kontroler.*;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.*;

/**
 * Klasa koja predstavlja glavnog kontrolera aplikacije i upravlja svim formama
 * unutar klijentske aplikacije kozmetičkog salona kroz njihove kontrolere.
 *
 * Implementira Singleton šablon kako bi postojala samo jedna instanca klase
 * tokom izvršavanja programa.
 *
 * @author Nikolina Baros
 */
public class GlavniKontroler {

    /**
     * Instanca klase GlavniKontroler, koristi se za implementaciju Singleton
     * šablona.
     */
    private static GlavniKontroler instance;
    /**
     * Kontroler za formu za prijavu.
     */
    private LoginKontroler loginKontroler;
    /**
     * Kontroler za glavnu formu aplikacije.
     */
    private GlavnaFormaKontroler glavnaFormaKontroler;
    /**
     * Kontroler za za formu za pregled klijenata.
     */
    private PregledKlijenataKontroler pregledKlijenataKontroler;
    /**
     * Kontroler za formu za dodavanje,izmenu i brisanje klijenta.
     */
    private DodajKlijentaKontroler dodajKlijentaKontroler;
    /**
     * Kontroler za formu za pregled usluga.
     */
    private PregledUslugaKontroler pregledUslugaKontroler;
    /**
     * Kontroler za formu za pregled rezervacija.
     */
    private PregledRezervacijaKontroler pregledRezervacijaKontroler;
    /**
     * Kontroler za formu za dodavanje i brisanje usluge.
     */
    private DodajUsluguKontroler dodajUsluguKontroler;
    /**
     * Kontroler za formu za dodavanje,izmenu i brisanje rezervacije.
     */
    private DodajRezervacijuKontroler dodajRezervacijuKontroler;
    /**
     * Kontroler za prikaz statistike rezervacija.
     */
    private StatistikaRezervacijaKontroler statistikaRezervacijaKontroler;
    /**
     * Objekat koji predstavlja trenutno ulogovanog menadžera.
     */
    private Menadzer ulogovani;
    /**
     * Mapa koja sadrži parametre koje koriste različite forme i kontroleri.
     * Ključ je string koji predstavlja naziv parametra, dok je vrednost objekat
     * koji se prosleđuje.
     */
    private Map<String, Object> parametri;

    /**
     * Privatni konstruktor za GlavniKontroler (implementira Singleton šablon).
     * Inicijalizuje mapu parametara.
     */
    private GlavniKontroler() {
        parametri = new HashMap<>();
    }

    /**
     * Vraća instancu GlavnogKontrolera. Ako instanca ne postoji, kreira je i
     * vraca.
     *
     * @return instanca GlavnogKontrolera
     */
    public static GlavniKontroler getInstance() {

        if (instance == null) {
            instance = new GlavniKontroler();
        }
        return instance;
    }

    /**
     * Otvara login formu i inicijalizuje LoginKontroler.
     */
    public void otvoriLoginFormu() {

        loginKontroler = new LoginKontroler(new LoginForma());
        loginKontroler.otvoriFormu();

    }

    /**
     * Otvara glavnu formu i inicijalizuje GlavnaFormaKontroler.
     */
    public void otvoriGlavnuFormu() {

        glavnaFormaKontroler = new GlavnaFormaKontroler(new GlavnaForma());
        glavnaFormaKontroler.otvoriFormu();

    }

    /**
     * Otvara formu za pregled klijenata i inicijalizuje
     * PregledKlijenataKontroler.
     */
    public void otvoriPregledKlijenataFormu() {

        pregledKlijenataKontroler = new PregledKlijenataKontroler(new PregledKlijenataForma());
        pregledKlijenataKontroler.otvoriFormu();

    }

    /**
     * Vraća trenutno ulogovanog menadžera.
     *
     * @return trenutno ulogovani Menadzer.
     */
    public Menadzer getUlogovani() {
        return ulogovani;
    }

    /**
     * Postavlja ulogovanog menadžera.
     *
     * @param ulogovani Novi menadzer koji je trenutno ulogovan.
     */
    public void setUlogovani(Menadzer ulogovani) {
        this.ulogovani = ulogovani;
    }

    /**
     * Otvara formu za dodavanje novog klijenta i inicijalizuje
     * DodajKlijentaKontroler.
     */
    public void otvoriDodajKlijentaFormu() {

        dodajKlijentaKontroler = new DodajKlijentaKontroler(new DodajKlijentaForma());
        dodajKlijentaKontroler.otvoriFormu(TipForme.DODAJ);

    }

    /**
     * Osvežava tabelu klijenata ako je kontroler za pregled klijenata
     * inicijalizovan.
     */
    public void osveziTabeluKlijenata() {

        if (pregledKlijenataKontroler != null) {
            pregledKlijenataKontroler.osveziTabeluKlijenata();
        }

    }

    /**
     * Otvara formu za dodavanje usluge i inicijalizuje DodajUsluguKontroler.
     */
    public void otvoriDodajUsluguFormu() {
        dodajUsluguKontroler = new DodajUsluguKontroler(new DodajUsluguForma());
        dodajUsluguKontroler.otvoriFormu(TipForme.DODAJ);

    }

    /**
     * Otvara formu za brisanje usluge i inicijalizuje DodajUsluguKontroler.
     */
    public void otvoriIzbrisiUsluguFormu() {
        dodajUsluguKontroler = new DodajUsluguKontroler(new DodajUsluguForma());
        dodajUsluguKontroler.otvoriFormu(TipForme.IZBRISI);

    }

    /**
     * Otvara formu za pregled usluga i inicijalizuje PregledUslugaKontroler.
     */
    public void otvoriPregledUslugaFormu() {
        pregledUslugaKontroler = new PregledUslugaKontroler(new PregledUslugaForma());
        pregledUslugaKontroler.otvoriFormu();
    }

    /**
     * Osvežava tabelu usluga ako je kontroler za pregled usluga aktivan.
     */
    public void osveziTabeluUsluga() {
        if (pregledUslugaKontroler != null) {
            pregledUslugaKontroler.osveziTabeluUsluga();
        }
    }

    /**
     * Postavlja parametar sa zadatim ključem i vrednošću.
     *
     * @param s Ključ parametra.
     * @param o Vrednost parametra.
     */
    public void setParam(String s, Object o) {
        parametri.put(s, o);
    }

    /**
     * Vraća vrednost parametra sa zadatim ključem.
     *
     * @param s Ključ parametra.
     * @return Vrednost parametra.
     */
    public Object getParam(String s) {
        return parametri.get(s);
    }

    /**
     * Otvara formu za izmenu klijenta i inicijalizuje DodajKlijentaKontroler.
     */
    public void otvoriIzmeniKlijentaFormu() {
        dodajKlijentaKontroler = new DodajKlijentaKontroler(new DodajKlijentaForma());
        dodajKlijentaKontroler.otvoriFormu(TipForme.IZMENI);

    }

    /**
     * Otvara formu za pregled rezervacija i inicijalizuje
     * PregledRezervacijaKontroler.
     */
    public void otvoriPregledRezervacijaFormu() {

        pregledRezervacijaKontroler = new PregledRezervacijaKontroler(new PregledRezervacijaForma());
        pregledRezervacijaKontroler.otvoriFormu();

    }

    /**
     * Otvara formu za dodavanje rezervacije i inicijalizuje
     * DodajRezervacijuKontroler.
     */
    public void otvoriDodajRezervacijuFormu() {

        dodajRezervacijuKontroler = new DodajRezervacijuKontroler(new DodajRezervacijuForma());
        dodajRezervacijuKontroler.otvoriFormu(TipForme.DODAJ);

    }

    /**
     * Otvara formu za ažuriranje rezervacije i inicijalizuje
     * DodajRezervacijuKontroler.
     */
    public void otvoriAzurirajRezervacijuFormu() {

        dodajRezervacijuKontroler = new DodajRezervacijuKontroler(new DodajRezervacijuForma());
        dodajRezervacijuKontroler.otvoriFormu(TipForme.IZMENI);

    }

    /**
     * Osvežava tabelu rezervacija ako je kontroler za pregled rezervacija
     * inicijalizovan.
     */
    public void osveziTabeluRezervacija() {
        if (pregledRezervacijaKontroler != null) {
            pregledRezervacijaKontroler.osveziTabeluRezervacija();
        }

    }

    /**
     * Odjavljuje trenutnog korisnika i ponovo mu prikazuje formu za prijavu.
     */
    public void logout() {

        this.ulogovani = null;
        loginKontroler.otvoriFormu();

    }

    /**
     * Otvara formu za prikaz statistike rezervacija i inicijalizuje
     * StatistikaRezervacijaKontroler.
     */
    public void otvoriStatistikaRezervacijaFormu() {

        statistikaRezervacijaKontroler = new StatistikaRezervacijaKontroler(new StatistikaRezervacijaForma());
        statistikaRezervacijaKontroler.otvoriFormu();

    }

}
