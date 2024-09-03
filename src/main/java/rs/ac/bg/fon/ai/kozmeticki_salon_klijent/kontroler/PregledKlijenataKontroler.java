/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.kozmeticki_salon_klijent.kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ai.kozmeticki_salon_klijent.forme.PregledKlijenataForma;
import rs.ac.bg.fon.ai.kozmeticki_salon_klijent.komunikacija.Komunikacija;
import rs.ac.bg.fon.ai.kozmeticki_salon_klijent.kontroler.glavni.GlavniKontroler;
import rs.ac.bg.fon.ai.kozmeticki_salon_klijent.modeli.ModelTabeleKlijent;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.Klijent;


/**
 *
 * @author ninic
 */
public class PregledKlijenataKontroler {

    private final PregledKlijenataForma pkf;

    public PregledKlijenataKontroler(PregledKlijenataForma pkf) {
        this.pkf = pkf;
        addActionListener();

    }

    public void otvoriFormu() {
        ucitajPodatkeZaFormu();
        pkf.setVisible(true);

    }

    private void ucitajPodatkeZaFormu() {

       
        List<Klijent> klijenti = Komunikacija.getInstance().nadjiKlijente(null);
        ModelTabeleKlijent mtk = new ModelTabeleKlijent(klijenti);
        pkf.getjTableKlijenti().setModel(mtk);

    }

    private void addActionListener() {

        //Pretraga klijenata, nadjiKlijente
        pkf.addButtonPretraziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ime = pkf.getjTextFieldIme().getText().trim();
                String prezime = pkf.getjTextFieldPrezime().getText().trim();
                Klijent k=new Klijent();
                k.setIme(ime); 
                k.setPrezime(prezime);
                
                List<Klijent> pretraga=Komunikacija.getInstance().nadjiKlijente(k);
                ModelTabeleKlijent mtk = (ModelTabeleKlijent) pkf.getjTableKlijenti().getModel();
                mtk.setLista(pretraga);
                mtk.fireTableDataChanged();
                
                
                if (mtk.getLista().isEmpty()) {
                    JOptionPane.showMessageDialog(pkf, "Sistem ne moze da nadje klijente po zadatoj vrednosti", "Greska", JOptionPane.ERROR_MESSAGE);
                    ucitajPodatkeZaFormu();
                } else {
                    JOptionPane.showMessageDialog(pkf, "Sistem je nasao klijente po zadatoj vrednosti", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        //dodaj klijenta
        pkf.addButtonDodajKlijentaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GlavniKontroler.getInstance().otvoriDodajKlijentaFormu();

            }

        });

        
        //ucitajKlijenta
        pkf.addButtonPrikaziKlijentaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int red = pkf.getjTableKlijenti().getSelectedRow();
                if (red == -1) {
                    JOptionPane.showMessageDialog(pkf, "Sistem ne moze da ucita klijenta", "Greska", JOptionPane.ERROR_MESSAGE);

                } else {

                    try {
                        ModelTabeleKlijent mtk = (ModelTabeleKlijent) pkf.getjTableKlijenti().getModel();
                        Klijent k = mtk.getLista().get(red);
                        
                        Klijent k1=Komunikacija.getInstance().ucitajKlijenta(k);
                        GlavniKontroler.getInstance().setParam("Klijent", k1);
                       
                        GlavniKontroler.getInstance().otvoriIzmeniKlijentaFormu();
                        
                    } catch (Exception ex) {
                        Logger.getLogger(PregledKlijenataKontroler.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }

        });

    }

    public void osveziTabeluKlijenata() {

        ucitajPodatkeZaFormu();
    }

}
