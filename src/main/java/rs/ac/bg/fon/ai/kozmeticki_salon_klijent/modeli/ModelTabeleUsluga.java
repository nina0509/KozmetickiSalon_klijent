/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.kozmeticki_salon_klijent.modeli;


import java.util.List;;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.Usluga;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ninic
 */
public class ModelTabeleUsluga extends AbstractTableModel {

    List<Usluga> lista;
    String[] kolone = {"ID", "Naziv", "Trajanje", "Cena", "Tip usluge"};

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    public ModelTabeleUsluga(List<Usluga> lista) {

        this.lista = lista;
    }

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

    @Override
    public String getColumnName(int column) {

        return kolone[column];
    }

    public List<Usluga> getLista() {
        return lista;
    }

    public void setLista(List<Usluga> lista) {
        this.lista = lista;
    }


}
