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
 *
 * @author ninic
 */
public class ModelTabelePopust extends AbstractTableModel {

    List<Popust> lista;
    String[] kolone = {"usluga", "br. rezervacija", "popust (%)"};

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    public ModelTabelePopust(List<Popust> lista) {

        List<Popust> nova=new ArrayList<>();
        for(Popust p: lista)
        {
        if(p.getBrojRezUsluge()!=0)nova.add(p);
        }
        this.lista = nova;
    }
    
    public ModelTabelePopust() {

       this.lista=new ArrayList<>();
    }


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

    @Override
    public String getColumnName(int column) {

        return kolone[column];
    }

    public List<Popust> getLista() {
        return lista;
    }

    public void setLista(List<Popust> lista) {
        
        List<Popust> nova=new ArrayList<>();
        for(Popust p: lista)
        {
        if(p.getBrojRezUsluge()!=0)nova.add(p);
        }
        this.lista = nova;
        
    }

    public Popust vratiPopust(Klijent k, Usluga u) {

        for (Popust p : lista) {
            if (p.getKlijent().equals(k) && p.getUsluga().equals(u)) {
                return p;
            }
        }
        return null;

    }

}
