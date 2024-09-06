/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.kozmeticki_salon_klijent.komunikacija;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.config.Operacija;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.*;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.transfer.*;

/**
 * Klasa koja služi za komunikaciju sa serverom putem soketa. Omogućava slanje
 * zahteva i prijem odgovora sa servera. Implementira Singleton šablon kako bi
 * postojala samo jedna instanca klase tokom izvršavanja programa.
 *
 * @author Nikolina Baros
 */
public class Komunikacija {

    /**
     * Soket preko kojeg se vrši komunikacija sa serverom.
     */
    private Socket soket;
    /**
     * Posiljalac zadužen za slanje zahteva serveru.
     */
    private Posiljalac posiljalac;
    /**
     * Primalac zadužen za prijem odgovora sa servera.
     */
    private Primalac primalac;
    /**
     * Staticka instanca klase Komunikacija (Singleton).
     */
    private static Komunikacija instance;

    /**
     * Privatni konstruktor koji onemogućava kreiranje više instanci klase.
     */
    private Komunikacija() {

    }

    /**
     * Metoda koja vraća jedinu instancu klase Komunikacija (Singleton).
     *
     * @return instanca klase Komunikacija.
     */
    public static Komunikacija getInstance() {
        if (instance == null) {
            instance = new Komunikacija();
        }
        return instance;

    }

    /**
     * Metoda koja omogucava povezivanje sa serverom na zadatoj adresi i portu.
     * Kreira objekat Posiljalac i Primalac za slanje i primanje poruka.
     *
     */
    public void konekcija() {

        try {
            soket = new Socket("localhost", 9000);
            posiljalac = new Posiljalac(soket);
            primalac = new Primalac(soket);
        } catch (IOException ex) {

            System.out.println("SERVER NIJE POVEZAN!");

        }

    }

    /**
     * Salje zahtev serveru za prijavu menadžera na sistem i prihvata odgovor od
     * servera.
     *
     * @param username Korisničko ime menadžera.
     * @param password Lozinka menadžera.
     * @return Menadžer koji se prijavio na sistem ili null ako prijava nije
     * uspela.
     */
    public Menadzer login(String username, String password) {

        Menadzer m = new Menadzer();
        m.setUsername(username);
        m.setPassword(password);

        Zahtev zahtev = new Zahtev(Operacija.LOGIN, m);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();

        return (Menadzer) odgovor.getOdgovor();

    }

    /**
     * Salje zahtev serveru za ucitavanje podataka o prosledjenom klijentu i
     * vraca ucitanog klijenta na osnovu odgovora sa servera.
     *
     * @param k Klijent cije podatke server ucitava.
     * @return Učitani klijent.
     * @throws Exception Ako dođe do greške prilikom učitavanja.
     */
    public Klijent ucitajKlijenta(Klijent k) throws Exception {

        Klijent novi;
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_KLIJENTA, k);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        System.out.println("KOMUNIKACIJA" + odgovor.getOdgovor());
        novi = (Klijent) odgovor.getOdgovor();
        return novi;
    }

    /**
     * Salje zahtev serveru za pronalazak klijenata na osnovu zadatih
     * kriterijuma i vraca listu klijenata na osnovu odgovora servera.
     *
     * @param k Klijent sa podacima o kriterijumu pretrage klijenata.
     * @return Lista klijenata koji odgovaraju kriterijumu pretrage.
     */
    public List<Klijent> nadjiKlijente(Klijent k) {

        List<Klijent> klijenti = new ArrayList<>();

        Zahtev zahtev = new Zahtev(Operacija.NADJI_KLIJENTE, k);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        klijenti = (List<Klijent>) odgovor.getOdgovor();

        return klijenti;
    }

    /**
     * Salje serveru zahtev za brisanje klijenta iz sistema i prima odgovor od
     * servera.
     *
     * @param k Klijent koji se briše iz sistema.
     * @throws Exception Ako dođe do greške prilikom brisanja klijenta.
     */
    public void izbrisiKlijenta(Klijent k) throws Exception {

        Zahtev zahtev = new Zahtev(Operacija.IZBRISI_KLIJENTA, k);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();

        if (odgovor.getOdgovor() != null) {
            throw new Exception("Greska");
        }

    }

    /**
     * Salje zahtev serveru da sacuva zadatog klijenta i vraca ucitanog klijenta
     * na osnovu odgovora servera.
     *
     * @param k Klijent koji se čuva.
     * @throws Exception ako dođe do greške prilikom čuvanja klijenta.
     */
    public void sacuvajKlijenta(Klijent k) throws Exception {

        Zahtev zahtev = new Zahtev(Operacija.ZAPAMTI_KLIJENTA, k);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        if (odgovor.getOdgovor() != null) {
            throw new Exception("Greska");
        }

    }

    /**
     * Salje zahtev serveru da pronadje usluge na osnovu zadatog kriterijuma i
     * vraca listu usluga na osnovu odgovora servera.
     *
     * @param u Usluga koja sadrzi podatke o kriterijumu pretrage usluga.
     * @return Lista usluga koje odgovaraju kriterijumu pretrage.
     */
    public List<Usluga> nadjiUsluge(Usluga u) {

        List<Usluga> usluge = new ArrayList<>();

        Zahtev zahtev = new Zahtev(Operacija.NADJI_USLUGE, u);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        usluge = (List<Usluga>) odgovor.getOdgovor();

        return usluge;
    }

    /**
     * Salje zahtev serveru da učitav određenu uslugu i vraca ucitanu uslugu na
     * osnovu odgovora servera.
     *
     * @param u Usluga koja se učitava.
     * @return Učitana usluga.
     * @throws Exception ako dođe do greške prilikom učitavanja usluge.
     */
    public Usluga ucitajUslugu(Usluga u) throws Exception {

        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_USLUGU, u);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        System.out.println("KOMUNIKACIJA" + odgovor.getOdgovor());

        return (Usluga) odgovor.getOdgovor();
    }

    /**
     * Salje zahtev serveru da izbriše uslugu iz sistema i prima odgovor od
     * servera.
     *
     * @param u Usluga koja se briše.
     * @throws Exception ako dođe do greške prilikom brisanja usluge.
     */
    public void izbrisiUsugu(Usluga u) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.IZBRISI_USLUGU, u);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();

        if (odgovor.getOdgovor() != null) {
            throw new Exception("Greska");
        }
    }

    /**
     * Salje zahtev serveru da vrati sve tipove usluga iz sistema i vraca listu
     * svih tipova usluga iz sistema na osnovu serverskog odgovora.
     *
     * @return Lista svih tipova usluga.
     */
    public List<TipUsluge> vratiSveTipoveUsluga() {
        List<TipUsluge> tipovi = new ArrayList<>();

        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_LISTU_TIPOVA_USLUGE, null);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        tipovi = (List<TipUsluge>) odgovor.getOdgovor();

        return tipovi;
    }

    /**
     * Salje zahtev serveru da sacuva uslugu u sistemu i prima odgovor od
     * servera.
     *
     * @param u Usluga koja se čuva.
     * @throws Exception ako dođe do greške prilikom čuvanja usluge.
     */
    public void sacuvajUslugu(Usluga u) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.ZAPAMTI_USLUGU, u);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        if (odgovor.getOdgovor() != null) {
            throw new Exception("Greska");
        }
    }

    /**
     * Salje serveru zahtev da pronadje rezervacije na osnovu zadatog
     * kriterijuma i vraca listu rezervacija na osnovu serverskog odgovora.
     *
     * @param r Kriterijum pretrage rezervacija.
     * @return Lista rezervacija koje odgovaraju kriterijumu pretrage.
     */
    public List<Rezervacija> nadjiRezervacije(Rezervacija r) {

        List<Rezervacija> rezervacije = new ArrayList<>();

        Zahtev zahtev = new Zahtev(Operacija.NADJI_REZERVACIJE, r);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        rezervacije = (List<Rezervacija>) odgovor.getOdgovor();

        return rezervacije;

    }

    /**
     * Salje zahtev serveru da vrati sve popuste iz sistema i vraca listu svih
     * popusta na osnovu odgovora servera.
     *
     * @param k Klijent za kojeg se vraćaju popusti.
     * @return Lista popusta za klijenta.
     */
    public List<Popust> vratiSvePopuste(Klijent k) {

        List<Popust> popusti = new ArrayList<>();

        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_LISTU_POPUSTA, k);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        popusti = (List<Popust>) odgovor.getOdgovor();

        return popusti;

    }

    /**
     * Salje zahtev serveru da sacuva novu rezervaciju u sistemu i prima odgovor
     * od servera.
     *
     * @param r Rezervacija koja se čuva.
     * @throws Exception ako dođe do greške prilikom čuvanja rezervacije.
     */
    public void sacuvajRezervaciju(Rezervacija r) throws Exception {

        Zahtev zahtev = new Zahtev(Operacija.ZAPAMTI_REZERVACIJU, r);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();

        if (odgovor.getOdgovor() != null) {
            throw new Exception("Greska");
        }

    }

    /**
     * Salje zahtev serveru da izbriše rezervaciju iz sistema i prima odgovor od
     * servera.
     *
     * @param r Rezervacija koja se briše.
     * @throws Exception ako dođe do greške prilikom brisanja rezervacije.
     */
    public void izbrisiRezervaciju(Rezervacija r) throws Exception {

        Zahtev zahtev = new Zahtev(Operacija.IZBRISI_REZERVACIJU, r);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();

        if (odgovor.getOdgovor() != null) {
            throw new Exception("Greska");
        }

    }

    /**
     * Salje zahtev serveru da vrati sve klijente iz sistema i vraca listu svih
     * klijenata na osnovu odgovora servera.
     *
     * @return Lista svih klijenata.
     */
    public List<Klijent> vratiSveKlijente() {

        List<Klijent> klijenti = new ArrayList<>();

        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_LISTU_KLIJENATA, null);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        klijenti = (List<Klijent>) odgovor.getOdgovor();

        return klijenti;

    }

    /**
     * Salje zahtev serveru da vrati sve usluge iz sistema i vraca listu svih
     * usluga na osnovu odgovora servera.
     *
     * @return Lista svih usluga.
     */
    public List<Usluga> vratiSveUsluge() {

        List<Usluga> usluge = new ArrayList<>();

        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_LISTU_USLUGA, null);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        usluge = (List<Usluga>) odgovor.getOdgovor();

        return usluge;

    }

    /**
     * Salje zahtev serveru da ucita podatke o rezervaciji iz sistema i vraca
     * ucitanu rezervaciju na osnovu odgovora servera.
     *
     * @param r Rezervacija koja se ucitava.
     * @return Ucitana rezervacija
     *
     */
    public Rezervacija ucitajRezervaciju(Rezervacija r) {

        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_REZERVACIJU, r);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();

        return (Rezervacija) odgovor.getOdgovor();

    }

    /**
     * Salje zahtev serveru izloguje menadzera.
     *
     * @param ulogovani Menadzer koji se odjavljuje.
     *
     */
    public void logout(Menadzer ulogovani) {

        Zahtev zahtev = new Zahtev(Operacija.LOGOUT, ulogovani);
        posiljalac.posalji(zahtev);

    }

    /**
     * Salje zahtev serveru da vrati sve statistike iz sistema i vraca listu
     * svih statistika na osnovu odgovora servera.
     *
     * @return Lista svih statistika.
     */
    public List<Statistika> vratiSveStatistike() {

        List<Statistika> stat = new ArrayList<>();

        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_SVE_STATISTIKE, null);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        stat = (List<Statistika>) odgovor.getOdgovor();

        return stat;

    }

    /**
     * Salje zahtev serveru da generise statistiku za tekucu godinu i prima
     * odgovor od servera.
     *
     * @throws Exception ako dodje do greske prilikom generisanja statistike.
     */
    public void generisiStatistiku() throws Exception {

        Zahtev zahtev = new Zahtev(Operacija.ZAPAMTI_STATISTIKE, null);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();

        if (odgovor.getOdgovor() != null) {
            throw new Exception(odgovor.getOdgovor().toString());
        }
    }

}
