/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.kozmeticki_salon_klijent.main;

import rs.ac.bg.fon.ai.kozmeticki_salon_klijent.kontroler.glavni.GlavniKontroler;


/**
 * Glavna klasa aplikacije koja pokreće program i sadrzi main metodu.
 * 
 * @author Nikolina Baros
 */
public class Main {

    /**
     *
     * Metod koji se prvi izvršava pri pokretanju aplikacije. Poziva se 
     * Singleton instanca glavnog kontrolera aplikacije i otvara se
     * login forma, omogućavajući korisniku da se prijavi na sistem.
     * 
     * @param args Argumenti komandne linije (ne koriste se u ovoj aplikaciji).
     */
    public static void main(String[] args) {

        GlavniKontroler.getInstance().otvoriLoginFormu();
    }
}
