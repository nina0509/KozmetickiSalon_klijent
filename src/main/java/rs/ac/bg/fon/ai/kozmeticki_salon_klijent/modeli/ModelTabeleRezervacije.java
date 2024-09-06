/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.kozmeticki_salon_klijent.modeli;


import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.Rezervacija;

/**
 * Klasa koja predstavlja model tabele za prikaz podataka o rezervacijama sa kolonama: ID, datum, ukupna cena, pojavio se, ime klijenta, datum rodjenja klijenta .
 * Nasleđuje AbstractTableModel i koristi se za prikaz liste rezervacija
 * u tabelarnom obliku.
 * 
 * @author Nikolina Baros
 */
public class ModelTabeleRezervacije extends AbstractTableModel {
/**
     * Lista rezervacija koja se prikazuje u tabeli.
     */
    List<Rezervacija> lista;
    /**
     * Nazivi kolona u tabeli.
     */
    String[] kolone = {"ID", "datum", "ukupna cena", "pojavio se", "ime klijenta", "datum rodjenja klijenta"};
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
     * Konstruktor klase ModelTabeleRezervacije koji postavlja listu rezervacija za prikaz u tabeli.
     * 
     * @param lista Lista rezervacija koja će biti prikazana u tabeli.
     */
    public ModelTabeleRezervacije(List<Rezervacija> lista) {

        this.lista = lista;
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

        Rezervacija r = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return r.getRezervacijaId();
            case 1:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy.");
                return simpleDateFormat.format(r.getDatum());
            case 3:
                if (r.isPojavljivanje()) {
                    return "da";
                } else {
                    return "ne";
                }
            case 2:
                return r.getUkupnaCena();
            case 4:
                return r.getKlijent().getIme() + " " + r.getKlijent().getPrezime();
            case 5:
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd.MM.yyyy.");
                return simpleDateFormat1.format(r.getKlijent().getDatRodj());

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
     * Vraća trenutnu listu rezervacija.
     * 
     * @return Lista rezervacija.
     */
    public List<Rezervacija> getLista() {
        return lista;
    }
/**
     * Postavlja novu listu rezervacija u model tabele.
     * 
     * @param lista Nova lista rezervacija.
     */
    public void setLista(List<Rezervacija> lista) {
        this.lista = lista;
    }

   

}
