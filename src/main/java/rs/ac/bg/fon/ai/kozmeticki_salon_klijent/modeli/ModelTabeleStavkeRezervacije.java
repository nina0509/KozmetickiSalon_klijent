/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.kozmeticki_salon_klijent.modeli;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.StavkaRezervacije;

/**
 *
 * @author ninic
 */
public class ModelTabeleStavkeRezervacije extends AbstractTableModel {

    List<StavkaRezervacije> lista;
    String[] kolone = {"RB", "vreme pocetka", "vreme zavrsetka", "cena", "usluga"};

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    public ModelTabeleStavkeRezervacije(List<StavkaRezervacije> lista) {

        this.lista = lista;
    }

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

    @Override
    public String getColumnName(int column) {

        return kolone[column];
    }

    public List<StavkaRezervacije> getLista() {
        return lista;
    }

    public void setLista(List<StavkaRezervacije> lista) {
        this.lista = lista;
    }

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

    public void izbrisiStavku(StavkaRezervacije sr) {

        lista.remove(sr);
        int i = 1;
        for (StavkaRezervacije s : lista) {
            s.setRBStavke(i);
            i++;
        }
        fireTableDataChanged();

    }

    public void resetuj() {

        lista.clear();
        fireTableDataChanged();

    }

}
