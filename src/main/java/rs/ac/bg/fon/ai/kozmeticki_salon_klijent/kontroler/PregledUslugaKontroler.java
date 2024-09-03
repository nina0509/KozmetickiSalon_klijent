/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.kozmeticki_salon_klijent.kontroler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ai.kozmeticki_salon_klijent.forme.PregledUslugaForma;
import rs.ac.bg.fon.ai.kozmeticki_salon_klijent.komunikacija.Komunikacija;
import rs.ac.bg.fon.ai.kozmeticki_salon_klijent.kontroler.glavni.GlavniKontroler;
import rs.ac.bg.fon.ai.kozmeticki_salon_klijent.modeli.ModelTabeleUsluga;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.TipUsluge;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.Usluga;


/**
 *
 * @author ninic
 */
public class PregledUslugaKontroler {

    private final PregledUslugaForma puf;

    public PregledUslugaKontroler(PregledUslugaForma puf) {
        this.puf = puf;
        addActionListener();

    }

    public void otvoriFormu() {
        ucitajPodatkeZaFormu();
        ucitajPodatkeZaComboBox();
        puf.setVisible(true);

    }

    private void ucitajPodatkeZaFormu() {

        List<Usluga> usluge = Komunikacija.getInstance().nadjiUsluge(null);
        ModelTabeleUsluga mtk = new ModelTabeleUsluga(usluge);
        puf.getjTableUsluge().setModel(mtk);

    }

    public void osveziTabeluUsluga() {

        ucitajPodatkeZaFormu();
    }

    private void addActionListener() {

        
        //pretraga usluga
        puf.addButtonPretraziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String naziv = puf.getjTextFieldNaziv().getText().trim();
                TipUsluge tip = (TipUsluge) puf.getjComboBoxTipovi().getSelectedItem();

                Usluga u=new Usluga();
                u.setNaziv(naziv);
                u.setTip(tip);
                List<Usluga> pretraga=Komunikacija.getInstance().nadjiUsluge(u);
                ModelTabeleUsluga mtu = (ModelTabeleUsluga) puf.getjTableUsluge().getModel();
                mtu.setLista(pretraga);
                mtu.fireTableDataChanged();
                
               
                if (mtu.getLista().isEmpty()) {
                    JOptionPane.showMessageDialog(puf, "Sistem ne moze da nadje usluge po zadatoj vrednosti", "Greska", JOptionPane.ERROR_MESSAGE);
                    ucitajPodatkeZaFormu();
                } else {
                    JOptionPane.showMessageDialog(puf, "Sistem je nasao usluge po zadatoj vrednosti", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        puf.addButtonDodajUsluguActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GlavniKontroler.getInstance().otvoriDodajUsluguFormu();

            }

        });

        
        //prikaz usluge ucitajUslugu
        puf.addButtonPrikazUslugeActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int red = puf.getjTableUsluge().getSelectedRow();
                if (red == -1) {
                    JOptionPane.showMessageDialog(puf, "Sistem ne moze da ucita uslugu", "Greska", JOptionPane.ERROR_MESSAGE);

                } else {

                    try {
                        ModelTabeleUsluga mtu = (ModelTabeleUsluga) puf.getjTableUsluge().getModel();
                        Usluga u = mtu.getLista().get(red);
                        
                        Usluga u1=Komunikacija.getInstance().ucitajUslugu(u);
                          System.out.println(u1);
                        GlavniKontroler.getInstance().setParam("Usluga", u1);
                      
                        
                        GlavniKontroler.getInstance().otvoriIzbrisiUsluguFormu();
                    } catch (Exception ex) {
                    JOptionPane.showMessageDialog(puf, "Sistem ne moze da ucita uslugu", "Greska", JOptionPane.ERROR_MESSAGE);
                    }

                }

            }

        });

    }

    private void ucitajPodatkeZaComboBox() {
        List<TipUsluge> tipovi = Komunikacija.getInstance().vratiSveTipoveUsluga();
        puf.getjComboBoxTipovi().addItem(null);
        for (TipUsluge t : tipovi) {
            puf.getjComboBoxTipovi().addItem(t);
        }
    }

}
