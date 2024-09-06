/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.kozmeticki_salon_klijent.modeli;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.Klijent;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.Popust;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.Usluga;

/**
 * Klasa koja predstavlja model tabele za prikaz podataka o popustima  sa kolonama: usluga, br. rezervacija i popust .
 * Nasleđuje AbstractTableModel i koristi se za prikaz liste popusta
 * u tabelarnom obliku.
 * 
 * @author Nikolina Baros
 */
public class ModelTabelePopust extends AbstractTableModel {

    /**
     * Lista popusta koja se prikazuje u tabeli.
     */
    List<Popust> lista;
    /**
     * Nazivi kolona u tabeli.
     */
    String[] kolone = {"usluga", "br. rezervacija", "popust (%)"};

     /**
     * Vraća broj redova u tabeli, tj. veličinu liste popusta.
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
     * Konstruktor klase ModelTabelePopust koji postavlja listu popusta za prikaz.
     * 
     * @param lista Lista popusta koja će biti prikazana u tabeli.
     */
    public ModelTabelePopust(List<Popust> lista) {

        List<Popust> nova=new ArrayList<>();
        for(Popust p: lista)
        {
        if(p.getBrojRezUsluge()!=0)nova.add(p);
        }
        this.lista = nova;
    }
    
      /**
     * Konstruktor bez parametara klase ModelTabelePopust inicijalizuje listu koja ne sadrzi nijedan objekat.
     * 
   */
    public ModelTabelePopust() {

       this.lista=new ArrayList<>();
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
        Popust p = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return p.getUsluga().getNaziv();
            case 1:
                return p.getBrojRezUsluge();
            case 2:
                return p.getPopust() + "%";

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
     * Vraća trenutnu listu popusta.
     * 
     * @return Lista popusta.
     */
    public List<Popust> getLista() {
        return lista;
    }

    /**
     * Postavlja novu listu popusta u model tabele izostavljajuci popuste sa brojem rezervacija usluge koji je jednak nuli.
     * 
     * @param lista Nova lista popusta.
     */
    public void setLista(List<Popust> lista) {
        
        List<Popust> nova=new ArrayList<>();
        for(Popust p: lista)
        {
        if(p.getBrojRezUsluge()!=0)nova.add(p);
        }
        this.lista = nova;
        
    }

    /**
     * Vraća popust odredjenog klijenta za odredjenu uslugu.
     * 
     * @param k Klijent za koga postoji popust.
     * @param u Usluga za koju postoji popust.

     * @return Popust klijenta za odredjenu uslugu.
     */
    public Popust vratiPopust(Klijent k, Usluga u) {

        for (Popust p : lista) {
            if (p.getKlijent().equals(k) && p.getUsluga().equals(u)) {
                return p;
            }
        }
        return null;

    }

}
