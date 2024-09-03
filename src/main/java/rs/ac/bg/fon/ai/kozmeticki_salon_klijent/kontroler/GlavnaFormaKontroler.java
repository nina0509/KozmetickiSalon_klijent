/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.kozmeticki_salon_klijent.kontroler;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ai.kozmeticki_salon_klijent.forme.GlavnaForma;
import rs.ac.bg.fon.ai.kozmeticki_salon_klijent.komunikacija.Komunikacija;
import rs.ac.bg.fon.ai.kozmeticki_salon_klijent.kontroler.glavni.GlavniKontroler;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.Menadzer;

/**
 *
 * @author ninic
 */
public class GlavnaFormaKontroler {

    private final GlavnaForma gf;

    public GlavnaFormaKontroler(GlavnaForma gf) {
        this.gf = gf;
        addActionListeners();
    }

    private void addActionListeners() {

        //Obrisi klijenta
        gf.logoutAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                   Komunikacija.getInstance().logout(GlavniKontroler.getInstance().getUlogovani());
                    gf.dispose();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(gf, "Sistem ne moze da odjavi klijenta", "Greska", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

    }

    public void otvoriFormu() {

        Menadzer m = GlavniKontroler.getInstance().getUlogovani();
        gf.setVisible(true);
        gf.getjLabelUlogovani().setText(m.getIme() + " " + m.getPrezime());

    }
}
