/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.kozmeticki_salon_klijent.modeli;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.StavkaRezervacije;

/**
 * Klasa koja predstavlja model tabele za prikaz podataka o stavkama rezervacije
 * sa kolonama: RB, vreme pocetka, vreme zavrsetka, cena i usluga . Nasleđuje
 * AbstractTableModel i koristi se za prikaz liste stavki rezervacije u
 * tabelarnom obliku.
 *
 * @author Nikolina Baros
 */
public class ModelTabeleStavkeRezervacije extends AbstractTableModel {

    /**
     * Lista stavki rezervacije koja se prikazuje u tabeli.
     */
    List<StavkaRezervacije> lista;

    /**
     * Nazivi kolona u tabeli.
     */
    String[] kolone = {"RB", "vreme pocetka", "vreme zavrsetka", "cena", "usluga"};

    /**
     * Vraća broj redova u tabeli, tj. veličinu liste klijenata.
     *
     * @return Broj redova u tabeli.
     */
    @Override
    public int getRowCount() {
        return lista.size();
    }

    /**
     * Vraća broj kolona u tabeli.
     *
     * @return Broj kolona.
     */
    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    /**
     * Konstruktor klase ModelTabeleStavkeRezervacije koji postavlja listu stavki rezervacija za prikaz.
     * 
     * @param lista Lista stavki rezervacija koja će biti prikazana u tabeli.
     */
    public ModelTabeleStavkeRezervacije(List<StavkaRezervacije> lista) {

        this.lista = lista;
    }

     /**
     * Konstruktor bez parametara klase ModelTabeleStavkeRezervacije koji inicijalizuje listu stavki rezervacija bez elemenata.
     * 
     */
    public ModelTabeleStavkeRezervacije() {

        this.lista = new ArrayList<>();
    }

     /**
     * Vraća vrednost iz tabele na osnovu indeksa reda i kolone.
     * 
     * @param rowIndex Indeks reda.
     * @param columnIndex Indeks kolone.
     * @return Vrednost u datom redu i koloni.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        StavkaRezervacije sr = lista.get(rowIndex);

        switch (columnIndex) {

            case 0:
                return sr.getRBStavke();
            case 1:
                return sr.getVremePocetka();
            case 2:
                return sr.getVremeZavrsetka();
            case 3:
                return sr.getCena();
            case 4:
                return sr.getUsluga().getNaziv();

            default:
                return null;

        }

    }

    /**
     * Vraća naziv kolone na osnovu njenog indeksa.
     * 
     * @param column Indeks kolone.
     * @return Naziv kolone.
     */
    @Override
    public String getColumnName(int column) {

        return kolone[column];
    }
/**
     * Vraća trenutnu listu stavki rezervacija.
     * 
     * @return Lista stavki rezervacija.
     */
    public List<StavkaRezervacije> getLista() {
        return lista;
    }

     /**
     * Postavlja novu listu stavki rezervacija u model tabele.
     * 
     * @param lista Nova lista stavki rezervacija.
     */
    public void setLista(List<StavkaRezervacije> lista) {
        this.lista = lista;
    }

      /**
     * Dodaje novu stavku u listu stavki rezervacija ukoliko vec u listi ne postoji stavka u istom terminu.
     * 
     * @param sr Nova stavka rezervacije za dodavanje u listu.
     * @throws Exception Ako se vec postoji stavka rezervacije u terminu u kom je i nova stavka rezervacije koja se dodaje u listu.
     */
    public void dodajStavku(StavkaRezervacije sr) throws Exception {

        for (StavkaRezervacije s : lista) {

            if (sr.getUsluga().equals(s.getUsluga()) && sr.getVremePocetka().isBefore(s.getVremeZavrsetka()) && sr.getVremeZavrsetka().isAfter(s.getVremePocetka())) {
                throw new Exception("Sistem ne moze da doda stavku rezervacije. Termini usluga se preklapaju!");

            }

        }
        sr.setRBStavke(lista.size() + 1);
        lista.add(sr);
        fireTableDataChanged();

    }

     /**
     * Brise stavku iz liste stavki rezervacija.
     * 
     * @param sr Stavka rezervacije za brisanje iz liste.
     */
    public void izbrisiStavku(StavkaRezervacije sr) {

        lista.remove(sr);
        int i = 1;
        for (StavkaRezervacije s : lista) {
            s.setRBStavke(i);
            i++;
        }
        fireTableDataChanged();

    }

     /**
     * Brise sve stavke rezervacije iz liste stavki rezervacija i azurira prikaz tabele.
  
     */
    public void resetuj() {

        lista.clear();
        fireTableDataChanged();

    }

}
