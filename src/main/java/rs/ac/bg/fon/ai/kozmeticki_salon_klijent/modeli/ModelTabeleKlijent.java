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
 *
 * @author ninic
 */
public class ModelTabeleKlijent extends AbstractTableModel {

    List<Klijent> lista;
    String[] kolone = {"ID", "Ime", "Prezime", "Broj telefona", "Datum rodjenja"};

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    public ModelTabeleKlijent(List<Klijent> lista) {

        this.lista = lista;
    }

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

    @Override
    public String getColumnName(int column) {

        return kolone[column];
    }

    public List<Klijent> getLista() {
        return lista;
    }

    public void setLista(List<Klijent> lista) {
        this.lista = lista;
    }


}
