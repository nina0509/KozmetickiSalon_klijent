/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.kozmeticki_salon_klijent.modeli;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.Usluga;
import javax.swing.table.AbstractTableModel;

/**
 * Klasa koja predstavlja model tabele za prikaz podataka o uslugama sa
 * kolonama: ID, Naziv, Trajanje, Cena i Tip Usluge . Nasleđuje
 * AbstractTableModel i koristi se za prikaz liste stavki rezervacije u
 * tabelarnom obliku.
 *
 * @author Nikolina Baros
 */
public class ModelTabeleUsluga extends AbstractTableModel {

    /**
     * Lista usluga koja se prikazuje u tabeli.
     */
    List<Usluga> lista;
    /**
     * Nazivi kolona u tabeli.
     */
    String[] kolone = {"ID", "Naziv", "Trajanje", "Cena", "Tip usluge"};

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
     * Konstruktor klase ModelTabeleUsluga koji postavlja listu usluga za
     * prikaz.
     *
     * @param lista Lista usluga koja će biti prikazana u tabeli.
     */

    public ModelTabeleUsluga(List<Usluga> lista) {

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

        Usluga u = lista.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return u.getUslugaId();
            case 1:
                return u.getNaziv();
            case 2:
                return u.getTrajanje() + "min";
            case 3:
                return u.getCena();
            case 4:
                return u.getTip().getNaziv();

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
     * Vraća trenutnu listu usluga.
     *
     * @return Lista usluga.
     */
    public List<Usluga> getLista() {
        return lista;
    }

    /**
     * Postavlja novu listu usluga u model tabele.
     *
     * @param lista Nova lista usluga.
     */
    public void setLista(List<Usluga> lista) {
        this.lista = lista;
    }

}
