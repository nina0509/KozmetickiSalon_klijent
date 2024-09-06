/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rs.ac.bg.fon.ai.kozmeticki_salon_klijent.forme;

import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.*;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Klasa koja predstavlja JFrame koji pruža korisnički interfejs za pregled
 * statistika o rezervacijama usluga.
 *
 * @author Nikolina Baros
 */
@SuppressWarnings("unused") 
public class StatistikaRezervacijaForma extends javax.swing.JFrame {

    /**
     * Kreira novu formu StatistikaRezervacijaForma. Konstruktor inicijalizuje
     * komponente korisničkog interfejsa i podešava ponašanje prozora prilikom
     * zatvaranja.
     *
     */
    public StatistikaRezervacijaForma() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelStatistika = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jComboBoxUsluga = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButtonPrikaziPoUsluzi = new javax.swing.JButton();
        jButtonSacuvajStatistiku = new javax.swing.JButton();
        jButtonUkupnaStatistika = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanelStatistikaLayout = new javax.swing.GroupLayout(jPanelStatistika);
        jPanelStatistika.setLayout(jPanelStatistikaLayout);
        jPanelStatistikaLayout.setHorizontalGroup(
            jPanelStatistikaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        jPanelStatistikaLayout.setVerticalGroup(
            jPanelStatistikaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Prikazi statistiku za uslugu", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setText("Usluga");

        jButtonPrikaziPoUsluzi.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButtonPrikaziPoUsluzi.setText("Prikazi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(jComboBoxUsluga, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonPrikaziPoUsluzi, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxUsluga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonPrikaziPoUsluzi)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jButtonSacuvajStatistiku.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButtonSacuvajStatistiku.setText("Generisi statistiku za tekucu godinu");

        jButtonUkupnaStatistika.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButtonUkupnaStatistika.setText("Prikazi statistiku za ukupan broj rezervacija");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonUkupnaStatistika, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSacuvajStatistiku, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jPanelStatistika, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelStatistika, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButtonUkupnaStatistika, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSacuvajStatistiku, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPrikaziPoUsluzi;
    private javax.swing.JButton jButtonSacuvajStatistiku;
    private javax.swing.JButton jButtonUkupnaStatistika;
    private javax.swing.JComboBox<Usluga> jComboBoxUsluga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelStatistika;
    // End of variables declaration//GEN-END:variables

    /**
     * Vraća dugme za cuvanje statistike za tekucu godinu.
     *
     * @return JButton dugme za cuvanje statistike za tekucu godinu.
     */
    public JButton getjButtonSacuvajStatistiku() {
        return jButtonSacuvajStatistiku;
    }

    /**
     * Postavlja dugme za cuvanje statistike za tekucu godinu.
     *
     * @param jButtonSacuvajStatistiku Novo dugme za cuvanje statistike za
     * tekucu godinu.
     */
    public void setjButtonSacuvajStatistiku(JButton jButtonSacuvajStatistiku) {
        this.jButtonSacuvajStatistiku = jButtonSacuvajStatistiku;
    }

    /**
     * Vraća JComboBox za izbor usluge.
     *
     * @return JComboBox za izbor usluge.
     */
    public JComboBox<Usluga> getjComboBoxUsluga() {
        return jComboBoxUsluga;
    }

    /**
     * Postavlja JComboBox za izbor usluge.
     *
     * @param jComboBoxUsluga Novi JComboBox za izbor usluge.
     */
    public void setjComboBoxUsluga(JComboBox<Usluga> jComboBoxUsluga) {
        this.jComboBoxUsluga = jComboBoxUsluga;
    }

    /**
     * Vraća JPanel za prikaz grafika statistike.
     *
     * @return JPanel za prikaz grafika statistike.
     */
    public JPanel getjPanelStatistika() {
        return jPanelStatistika;
    }

    /**
     * Postavlja jPanel za prikaz grafika statistike.
     *
     * @param jPanelStatistika Novi panel za prikaz grafika statistike.
     */
    public void setjPanelStatistika(JPanel jPanelStatistika) {
        this.jPanelStatistika = jPanelStatistika;
    }

    /**
     * Dodaje ActionListener na dugme za cuvanje statistike za tekucu godinu.
     *
     * @param actionListener ActionListener koji će biti dodat dugmetu.
     */
    public void addButtonSacuvajStatistikuActionListener(ActionListener actionListener) {
        jButtonSacuvajStatistiku.addActionListener(actionListener);
    }

    /**
     * Dodaje ActionListener na dugme za prikaz statistike za selektovanu
     * uslugu.
     *
     * @param actionListener ActionListener koji će biti dodat dugmetu.
     */
    public void addButtonPoUsluziActionListener(ActionListener actionListener) {
        jButtonPrikaziPoUsluzi.addActionListener(actionListener);
    }

    /**
     * Dodaje ActionListener na dugme za prikaz statistike svih usluga.
     *
     * @param actionListener ActionListener koji će biti dodat dugmetu.
     */
    public void addButtonUkupnaStatistikaActionListener(ActionListener actionListener) {
        jButtonUkupnaStatistika.addActionListener(actionListener);
    }

}
