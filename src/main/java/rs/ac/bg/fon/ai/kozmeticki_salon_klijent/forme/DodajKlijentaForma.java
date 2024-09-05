/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rs.ac.bg.fon.ai.kozmeticki_salon_klijent.forme;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Klasa koja predstavlja JFrame koji pruža korisnički interfejs za dodavanje
 * novog klijenta, brisanje klijenta ili azuriranje postojeceg klijenta.
 *
 * @author Nikolina Baros
 */
public class DodajKlijentaForma extends javax.swing.JFrame {

    /**
     * Kreira novu formu DodajKlijentaForma. Konstruktor inicijalizuje
     * komponente korisničkog interfejsa i podešava ponašanje prozora prilikom
     * zatvaranja.
     *
     */
    public DodajKlijentaForma() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonDodajKlijenta = new javax.swing.JButton();
        jButtonAzuriraj = new javax.swing.JButton();
        jButtonObrisi = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelid = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldIme = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPrezime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldBrTel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldDatum = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 150));

        jButtonDodajKlijenta.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButtonDodajKlijenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        jButtonDodajKlijenta.setText("Dodaj");

        jButtonAzuriraj.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButtonAzuriraj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/update.png"))); // NOI18N
        jButtonAzuriraj.setText("Azuriraj");

        jButtonObrisi.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButtonObrisi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        jButtonObrisi.setText("Obrisi");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Podaci o klijentu", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 0, 12))); // NOI18N

        jLabelid.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabelid.setText("Id:");

        jTextFieldId.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setText("Ime:");

        jTextFieldIme.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextFieldIme.setText("Marija");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setText("Prezime: ");

        jTextFieldPrezime.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextFieldPrezime.setText("Jovanovic");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setText("Broj telefona:");

        jTextFieldBrTel.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextFieldBrTel.setText("+381607182934");
        jTextFieldBrTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBrTelActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel4.setText("Datum rodjenja (dd.mm.yyyy):");

        jTextFieldDatum.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextFieldDatum.setText("12.02.2001");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)
                        .addComponent(jTextFieldDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelid, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(127, 127, 127)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldIme, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldPrezime, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldBrTel)
                            .addComponent(jTextFieldId))))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldBrTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jButtonAzuriraj, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jButtonDodajKlijenta, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDodajKlijenta, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonObrisi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAzuriraj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldBrTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBrTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBrTelActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAzuriraj;
    private javax.swing.JButton jButtonDodajKlijenta;
    private javax.swing.JButton jButtonObrisi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelid;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldBrTel;
    private javax.swing.JTextField jTextFieldDatum;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldIme;
    private javax.swing.JTextField jTextFieldPrezime;
    // End of variables declaration//GEN-END:variables

    /**
     * Dodaje ActionListener za dugme "Dodaj".
     *
     * @param actionListener ActionListener koji će biti dodat dugmetu.
     */
    public void dodajAddActionListener(ActionListener actionListener) {

        jButtonDodajKlijenta.addActionListener(actionListener);
    }

    /**
     * Dodaje ActionListener za dugme "Obriši".
     *
     * @param actionListener ActionListener koji će biti dodat dugmetu.
     */
    public void obrisiAddActionListener(ActionListener actionListener) {

        jButtonObrisi.addActionListener(actionListener);
    }

    /**
     * Dodaje ActionListener za dugme "Ažuriraj".
     *
     * @param actionListener ActionListener koji će biti dodat dugmetu.
     */
    public void azurirajAddActionListener(ActionListener actionListener) {

        jButtonAzuriraj.addActionListener(actionListener);
    }

    /**
     * Vraća tekstualno polje za unos broja telefona.
     *
     * @return JTextField za unos broja telefona.
     */
    public JTextField getjTextFieldBrTel() {
        return jTextFieldBrTel;
    }

    /**
     * Postavlja tekstualno polje za unos broja telefona.
     *
     * @param jTextFieldBrTel Novo tekstualno polje za broj telefona.
     */
    public void setjTextFieldBrTel(JTextField jTextFieldBrTel) {
        this.jTextFieldBrTel = jTextFieldBrTel;
    }

    /**
     * Vraća tekstualno polje za unos datuma rodjenja.
     *
     * @return JTextField za unos datuma rodjenja.
     */
    public JTextField getjTextFieldDatum() {
        return jTextFieldDatum;
    }

    /**
     * Postavlja tekstualno polje za unos datuma rodjenja.
     *
     * @param jTextFieldDatum Novo tekstualno polje za datum rodjenja.
     */
    public void setjTextFieldDatum(JTextField jTextFieldDatum) {
        this.jTextFieldDatum = jTextFieldDatum;
    }

    /**
     * Vraća tekstualno polje za unos imena.
     *
     * @return JTextField za unos imena.
     */
    public JTextField getjTextFieldIme() {
        return jTextFieldIme;
    }

    /**
     * Postavlja tekstualno polje za unos imena.
     *
     * @param jTextFieldIme Novo tekstualno polje za ime.
     */
    public void setjTextFieldIme(JTextField jTextFieldIme) {
        this.jTextFieldIme = jTextFieldIme;
    }

    /**
     * Vraća tekstualno polje za unos prezimena.
     *
     * @return JTextField za unos prezimena
     */
    public JTextField getjTextFieldPrezime() {
        return jTextFieldPrezime;
    }

    /**
     * Postavlja tekstualno polje za unos prezimena.
     *
     * @param jTextFieldPrezime Novo tekstualno polje za prezime.
     */
    public void setjTextFieldPrezime(JTextField jTextFieldPrezime) {
        this.jTextFieldPrezime = jTextFieldPrezime;
    }

    /**
     * Vraća dugme "Ažuriraj".
     *
     * @return JButton za ažuriranje klijenta.
     */
    public JButton getjButtonAzuriraj() {
        return jButtonAzuriraj;
    }

    /**
     * Postavlja dugme "Ažuriraj".
     *
     * @param jButtonAzuriraj Novo dugme za ažuriranje.
     */
    public void setjButtonAzuriraj(JButton jButtonAzuriraj) {
        this.jButtonAzuriraj = jButtonAzuriraj;
    }

    /**
     * Vraća dugme "Dodaj klijenta".
     *
     * @return JButton za dodavanje klijenta.
     */
    public JButton getjButtonDodajKlijenta() {
        return jButtonDodajKlijenta;
    }

    /**
     * Postavlja dugme "Dodaj klijenta".
     *
     * @param jButtonDodajKlijenta Novo dugme za dodavanje klijenta.
     */
    public void setjButtonDodajKlijenta(JButton jButtonDodajKlijenta) {
        this.jButtonDodajKlijenta = jButtonDodajKlijenta;
    }

    /**
     * Vraća labelu koja prikazuje oznaku za polje ID klijenta.
     *
     * @return JLabel za prikaz oznake za polje ID-a klijenta.
     */
    public JLabel getjLabelid() {
        return jLabelid;
    }

    /**
     * Postavlja labelu koja prikazuje oznaku za ID klijenta.
     *
     * @param jLabelid Nova labela koja prikazuje oznaku za ID klijenta.
     */
    public void setjLabelid(JLabel jLabelid) {
        this.jLabelid = jLabelid;
    }

    /**
     * Vraća tekstualno polje za unos ID-a klijenta.
     *
     * @return JTextField za unos ID-a klijenta.
     */
    public JTextField getjTextFieldId() {
        return jTextFieldId;
    }

    /**
     * Postavlja tekstualno polje za unos ID-a klijenta.
     *
     * @param jTextFieldId Novo tekstualno polje za ID klijenta.
     */
    public void setjTextFieldId(JTextField jTextFieldId) {
        this.jTextFieldId = jTextFieldId;
    }

    /**
     * Vraća dugme "Obriši".
     *
     * @return JButton za brisanje klijenta.
     */
    public JButton getjButtonObrisi() {
        return jButtonObrisi;
    }

    /**
     * Postavlja dugme "Obriši".
     *
     * @param jButtonObrisi novo dugme za brisanje klijenta
     */
    public void setjButtonObrisi(JButton jButtonObrisi) {
        this.jButtonObrisi = jButtonObrisi;
    }

}
