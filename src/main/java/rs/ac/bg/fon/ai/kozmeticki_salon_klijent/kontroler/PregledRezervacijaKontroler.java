/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.kozmeticki_salon_klijent.kontroler;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.event.ListSelectionEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import rs.ac.bg.fon.ai.kozmeticki_salon_klijent.forme.PregledRezervacijaForma;
import rs.ac.bg.fon.ai.kozmeticki_salon_klijent.komunikacija.Komunikacija;
import rs.ac.bg.fon.ai.kozmeticki_salon_klijent.kontroler.glavni.GlavniKontroler;
import rs.ac.bg.fon.ai.kozmeticki_salon_klijent.modeli.ModelTabeleRezervacije;
import rs.ac.bg.fon.ai.kozmeticki_salon_klijent.modeli.ModelTabeleStavkeRezervacije;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.Klijent;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.Rezervacija;

/**
 * Klasa koja predstavlja kontroler za upravljanje formom za pregled rezervacija.
 * 
 * @author Nikolina Baros
 */
public class PregledRezervacijaKontroler {
     /**
     * Forma za pregled rezervacija.
     */
    private final PregledRezervacijaForma prf;

     /**
     * Konstruktor kontrolera koji postavlja formu na prosledjenu vrednost.
     * Takodje, poziva metodu koja dodaje sve potrebne actionListenere na komponente forme.
     * @param prf Forma za pregled rezervacija.
     */
    public PregledRezervacijaKontroler(PregledRezervacijaForma prf) {
        this.prf = prf;
        addActionListener();

    }

    
    /**
     * Ucitava listu svih rezervacija u tabelu na formi i otvara formu za prikaz rezervacija.
     * 
     */
    public void otvoriFormu() {

        ucitajPodatkeZaFormu();
        ModelTabeleStavkeRezervacije mtsr = new ModelTabeleStavkeRezervacije();
        prf.getjTableStavkeRez().setModel(mtsr);
        prf.setVisible(true);

    }

    /**
     * Ucitava listu svih rezervacija i upisuje je u tabelu za prikaz rezervacija na formi.
     * 
     */
    private void ucitajPodatkeZaFormu() {

        List<Rezervacija> rezervacije = Komunikacija.getInstance().nadjiRezervacije(null);
        ModelTabeleRezervacije mtr = new ModelTabeleRezervacije(rezervacije);
        prf.getjTableRezervacije().setModel(mtr);

        TableColumn col1 = prf.getjTableRezervacije().getColumnModel().getColumn(0);
        col1.setMaxWidth(50);
        TableColumn col2 = prf.getjTableRezervacije().getColumnModel().getColumn(2);
        col2.setMaxWidth(150);
        TableColumn col3 = prf.getjTableRezervacije().getColumnModel().getColumn(3);
        col3.setMaxWidth(100);
        TableColumn col4 = prf.getjTableRezervacije().getColumnModel().getColumn(1);
        col4.setMaxWidth(150);
        
        

    }

    /**
     * Postavlja actionListener-e za dugmad za pretragu rezervacija, dodavanje rezervacije i prikaz detalja o rezervaciji.
    * 
    */
    private void addActionListener() {

        //pretraga rezervacija
        prf.addButtonPretraziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                   
                    
                    String ime = prf.getjTextFieldIme().getText().trim();
                    SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy");
                    Date datum=null;
                    String datumS=prf.getjTextFieldDatum().getText().trim();
                    
                    
                    if(!datumS.isBlank())
                    {
                    datum= date.parse(prf.getjTextFieldDatum().getText().trim());
                    }
                            
                    Rezervacija pret=new Rezervacija();
                    pret.setKlijent(new Klijent());
                   if(ime!=null && !ime.isBlank() && ime.length()>2) pret.getKlijent().setIme(ime);
                   if(datum!=null) pret.setDatum(datum);
                    
                    List<Rezervacija> pretraga=Komunikacija.getInstance().nadjiRezervacije(pret);
                    ModelTabeleRezervacije mtr = (ModelTabeleRezervacije) prf.getjTableRezervacije().getModel();
                    mtr.setLista(pretraga);
                    mtr.fireTableDataChanged();
                    
                    
                    if (mtr.getLista().isEmpty()) {
                        JOptionPane.showMessageDialog(prf, "Sistem ne moze da nadje rezervacije po zadatoj vrednosti", "Greska", JOptionPane.ERROR_MESSAGE);
                        ucitajPodatkeZaFormu();
                    } else {
                        JOptionPane.showMessageDialog(prf, "Sistem je nasao rezervacije po zadatoj vrednosti", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(prf, "Sistem ne moze da nadje rezervacije po zadatoj vrednosti", "Greska", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        //dugme dodaj novu rez
        prf.addButtonDodajActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GlavniKontroler.getInstance().otvoriDodajRezervacijuFormu();

            }

        });

        //dugme prikazi rezervaciju
        prf.addButtonPrikaziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int red = prf.getjTableRezervacije().getSelectedRow();
                if (red == -1) {
                    JOptionPane.showMessageDialog(prf, "Sistem ne moze da ucita rezervaciju", "Greska", JOptionPane.ERROR_MESSAGE);

                } else {

                    ModelTabeleRezervacije mtk = (ModelTabeleRezervacije) prf.getjTableRezervacije().getModel();
                    Rezervacija r = mtk.getLista().get(red);
                    
                    
                    Rezervacija r1=Komunikacija.getInstance().ucitajRezervaciju(r); 
                    GlavniKontroler.getInstance().setParam("Rezervacija", r1);
                    GlavniKontroler.getInstance().otvoriAzurirajRezervacijuFormu();

                }

            }

        });

        //ucitavanje stavki na promene selekcije reda
        prf.addRezervacijeActionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selRed = prf.getjTableRezervacije().getSelectedRow();
                    if (selRed != -1) {

                        ModelTabeleRezervacije mtr = (ModelTabeleRezervacije) prf.getjTableRezervacije().getModel();
                        Rezervacija r = mtr.getLista().get(selRed);

                        ModelTabeleStavkeRezervacije mtsr = (ModelTabeleStavkeRezervacije) prf.getjTableStavkeRez().getModel();
                        mtsr.setLista(r.getStavke());
                        mtsr.fireTableDataChanged();

                    }

                }

            }
        });

    }

    /**
     * Osvezava prikaz rezervacija u tabeli pozivajuci metodu koja ucitava listu svih rezervacija.
    * 
    */
    public void osveziTabeluRezervacija() {
        ucitajPodatkeZaFormu();
    }

}
