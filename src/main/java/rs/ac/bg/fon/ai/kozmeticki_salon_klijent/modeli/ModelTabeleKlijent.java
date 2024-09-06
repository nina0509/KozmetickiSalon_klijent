/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.kozmeticki_salon_klijent.modeli;


import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.Klijent;

/**
 * Klasa koja predstavlja model tabele za prikaz podataka o klijentima sa kolonama: ID, Ime, Prezime, Broj telefona, Datum rođenja .
 * Nasleđuje AbstractTableModel i koristi se za prikaz liste klijenata
 * u tabelarnom obliku.
 * 
 * @author Nikolina Baros
 */
public class ModelTabeleKlijent extends AbstractTableModel {

     /**
     * Lista klijenata koja se prikazuje u tabeli.
     */
    List<Klijent> lista;
    
     /**
     * Nazivi kolona u tabeli.
     */
    String[] kolone = {"ID", "Ime", "Prezime", "Broj telefona", "Datum rodjenja"};

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
     * Konstruktor klase ModelTabeleKlijent koji postavlja listu klijenata za prikaz.
     * 
     * @param lista Lista klijenata koja će biti prikazana u tabeli.
     */
    public ModelTabeleKlijent(List<Klijent> lista) {

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

        Klijent k = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return k.getKlijentId();
            case 1:
                return k.getIme();
            case 2:
                return k.getPrezime();
            case 3:
                return k.getBrTel();
            case 4:
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy.");
                return simpleDateFormat.format(k.getDatRodj());

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
     * Vraća trenutnu listu klijenata.
     * 
     * @return Lista klijenata.
     */
    public List<Klijent> getLista() {
        return lista;
    }

    /**
     * Postavlja novu listu klijenata u model tabele.
     * 
     * @param lista Nova lista klijenata.
     */
    public void setLista(List<Klijent> lista) {
        this.lista = lista;
    }


}
