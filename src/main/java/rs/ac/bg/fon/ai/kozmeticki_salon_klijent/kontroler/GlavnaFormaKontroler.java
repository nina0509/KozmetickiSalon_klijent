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
 * Klasa koja predstavlja kontroler za upravljanje glavnom formom korisničkog interfejsa aplikacije.
 * 
 * @author Nikolina Baros
 */
public class GlavnaFormaKontroler {

    /**
     * Glavna forma kojom kontroler upravlja.
     */
    private final GlavnaForma gf;
/**
     * Konstruktor kontrolera koji postavlja formu na prosledjenu vrednost.
     * Takodje, poziva metodu koja dodaje sve potrebne actionListener-e na komponente forme.
     * @param gf Glavna forma.
     */
    public GlavnaFormaKontroler(GlavnaForma gf) {
        this.gf = gf;
        addActionListeners();
    }

    /**
     * Postavlja actionListener na dugme za odjavu klijenta.
    * 
    */
    private void addActionListeners() {

      
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

     /**
     * Otvara glavnu formu i podesava ulogovanog menadzera.
     * 
     **/
    public void otvoriFormu() {

        Menadzer m = GlavniKontroler.getInstance().getUlogovani();
        gf.setVisible(true);
        gf.getjLabelUlogovani().setText(m.getIme() + " " + m.getPrezime());

    }
}
