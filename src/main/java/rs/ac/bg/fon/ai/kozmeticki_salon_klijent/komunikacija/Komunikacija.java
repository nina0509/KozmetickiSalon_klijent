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
 *
 * @author ninic
 */
public class Komunikacija {

    private Socket soket;
    private Posiljalac posiljalac;
    private Primalac primalac;

    private static Komunikacija instance;

    private Komunikacija() {

    }

    public static Komunikacija getInstance() {
        if (instance == null) {
            instance = new Komunikacija();
        }
        return instance;

    }

    public void konekcija() {

        try {
            soket = new Socket("localhost", 9000);
            posiljalac = new Posiljalac(soket);
            primalac = new Primalac(soket);
        } catch (IOException ex) {

            System.out.println("SERVER NIJE POVEZAN!");

        }

    }

    public Menadzer login(String username, String password) {

        Menadzer m = new Menadzer();
        m.setUsername(username);
        m.setPassword(password);

        Zahtev zahtev = new Zahtev(Operacija.LOGIN, m);
        posiljalac.posalji(zahtev);
        
        Odgovor odgovor = (Odgovor) primalac.primi();
        
        if(odgovor.getOdgovor() instanceof Menadzer)m = (Menadzer) odgovor.getOdgovor();
        else m=new Menadzer(-1, "", "", "", "");
     
        return m;

    }

    public Klijent ucitajKlijenta(Klijent k) throws Exception {
        
        Klijent novi;
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_KLIJENTA, k);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        System.out.println("KOMUNIKACIJA"+odgovor.getOdgovor());
        novi=(Klijent)odgovor.getOdgovor();
         return novi;
    }
    
    public List<Klijent> nadjiKlijente(Klijent k) {

        List<Klijent> klijenti = new ArrayList<>();

        Zahtev zahtev = new Zahtev(Operacija.NADJI_KLIJENTE, k);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        klijenti = (List<Klijent>) odgovor.getOdgovor();

        return klijenti;
    }

    public void izbrisiKlijenta(Klijent k) throws Exception {

        Zahtev zahtev = new Zahtev(Operacija.IZBRISI_KLIJENTA, k);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();

        if (odgovor.getOdgovor() != null) {
            throw new Exception("Greska");
        }

    }

    public void sacuvajKlijenta(Klijent k) throws Exception {

        Zahtev zahtev = new Zahtev(Operacija.ZAPAMTI_KLIJENTA, k);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        if (odgovor.getOdgovor() != null) {
            throw new Exception("Greska");
        }

    }

    public List<Usluga> nadjiUsluge(Usluga u) {

        List<Usluga> usluge = new ArrayList<>();

        Zahtev zahtev = new Zahtev(Operacija.NADJI_USLUGE, u);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        usluge = (List<Usluga>) odgovor.getOdgovor();

        return usluge;
    }
    
    
    public Usluga ucitajUslugu(Usluga u) throws Exception {
        
        
        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_USLUGU, u);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        System.out.println("KOMUNIKACIJA"+odgovor.getOdgovor());
       
         return  (Usluga)odgovor.getOdgovor();
    }

    public void izbrisiUsugu(Usluga u) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.IZBRISI_USLUGU, u);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();

        if (odgovor.getOdgovor() != null) {
            throw new Exception("Greska");
        }
    }

    public List<TipUsluge> vratiSveTipoveUsluga() {
        List<TipUsluge> tipovi = new ArrayList<>();

        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_LISTU_TIPOVA_USLUGE, null);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        tipovi = (List<TipUsluge>) odgovor.getOdgovor();

        return tipovi;
    }

    public void sacuvajUslugu(Usluga u) throws Exception {
        Zahtev zahtev = new Zahtev(Operacija.ZAPAMTI_USLUGU, u);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        if (odgovor.getOdgovor() != null) {
            throw new Exception("Greska");
        }
    }

    

    public List<Rezervacija> nadjiRezervacije(Rezervacija r) {

        List<Rezervacija> rezervacije = new ArrayList<>();

        Zahtev zahtev = new Zahtev(Operacija.NADJI_REZERVACIJE, r);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        rezervacije = (List<Rezervacija>) odgovor.getOdgovor();

        return rezervacije;

    }

    public List<Popust> vratiSvePopuste(Klijent k) {

        List<Popust> popusti = new ArrayList<>();

        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_LISTU_POPUSTA, k);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        popusti = (List<Popust>) odgovor.getOdgovor();

        return popusti;

    }

    public void sacuvajRezervaciju(Rezervacija r) throws Exception {

        Zahtev zahtev = new Zahtev(Operacija.ZAPAMTI_REZERVACIJU, r);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();

        if (odgovor.getOdgovor() != null) {
            throw new Exception("Greska");
        }

    }

    public void izbrisiRezervaciju(Rezervacija r) throws Exception {

        Zahtev zahtev = new Zahtev(Operacija.IZBRISI_REZERVACIJU, r);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();

        if (odgovor.getOdgovor() != null) {
            throw new Exception("Greska");
        }

    }

    public List<Klijent> vratiSveKlijente() {

        List<Klijent> klijenti = new ArrayList<>();

        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_LISTU_KLIJENATA, null);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        klijenti = (List<Klijent>) odgovor.getOdgovor();

        return klijenti;


    }
    
      public List<Usluga> vratiSveUsluge() {

        List<Usluga> usluge = new ArrayList<>();

        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_LISTU_USLUGA, null);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        usluge = (List<Usluga>) odgovor.getOdgovor();

        return usluge;


    }

    public Rezervacija ucitajRezervaciju(Rezervacija r) {


        

        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_REZERVACIJU, r);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        

        return (Rezervacija)odgovor.getOdgovor();

    }

    public void logout(Menadzer ulogovani) {

        Zahtev zahtev = new Zahtev(Operacija.LOGOUT, ulogovani);
        posiljalac.posalji(zahtev);


    }

    public List<Statistika> vratiSveStatistike() {

        List<Statistika> stat = new ArrayList<>();

        Zahtev zahtev = new Zahtev(Operacija.UCITAJ_SVE_STATISTIKE, null);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
        stat = (List<Statistika>) odgovor.getOdgovor();

        return stat;

    }

    public void generisiStatistiku() throws Exception {

        Zahtev zahtev = new Zahtev(Operacija.ZAPAMTI_STATISTIKE, null);
        posiljalac.posalji(zahtev);

        Odgovor odgovor = (Odgovor) primalac.primi();
   
      if (odgovor.getOdgovor() != null) {
            throw new Exception(odgovor.getOdgovor().toString());
        }  
    }

   

   

}
