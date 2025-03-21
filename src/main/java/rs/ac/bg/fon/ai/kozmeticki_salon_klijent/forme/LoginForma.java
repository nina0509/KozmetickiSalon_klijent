/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rs.ac.bg.fon.ai.kozmeticki_salon_klijent.forme;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 * Klasa koja predstavlja JFrame koji pruža korisnički interfejs za prijavu menadzera na sistem.
 *
 * @author Nikolina Baros
 */
@SuppressWarnings("unused") 
public class LoginForma extends javax.swing.JFrame {

     /**
     * Kreira novu formu LoginForma. Konstruktor inicijalizuje
     * komponente korisničkog interfejsa.
     *
     */
    public LoginForma() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButtonUlogujSe = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Prijava na sistem");
        setLocation(new java.awt.Point(150, 500));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel1.setText("Korisnicko ime:");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setText("Lozinka:");

        jTextFieldUsername.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextFieldUsername.setText("nina");

        jPasswordField1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPasswordField1.setText("nina");

        jButtonUlogujSe.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButtonUlogujSe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login.png"))); // NOI18N
        jButtonUlogujSe.setText("Uloguj se");
        jButtonUlogujSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUlogujSeActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salon.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jButtonUlogujSe))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jButtonUlogujSe, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metoda koja se poziva kada korisnik pritisne dugme za prijavu.
    
     * @param evt Događaj koji izaziva poziv metode.
     */
    private void jButtonUlogujSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUlogujSeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonUlogujSeActionPerformed

    
     /**
     * Vraća dugme za prijavu na sistem.
     *
     * @return JButton za prijavu na sistem.
     */
   public JButton getjButtonUlogujSe() {
        return jButtonUlogujSe;
    }

    /**
     * Postavlja dugme za prijavu na sistem.
     *
     * @param jButtonUlogujSe Novo dugme za prijavu na sistem.
     */
    public void setjButtonUlogujSe(JButton jButtonUlogujSe) {
        this.jButtonUlogujSe = jButtonUlogujSe;
    }

     /**
     * Vraća JPasswordField za unos lozinke menadzera.
     *
     * @return JPasswordField za unos lozinke menadzera.
     */
    public JPasswordField getjPasswordField1() {
        return jPasswordField1;
    }

     /**
     * Postavlja JPasswordField za unos lozinke menadzera.
     *
     * @param jPasswordField1 Novi JPasswordField za unos lozinke menadzera.
     */
    public void setjPasswordField1(JPasswordField jPasswordField1) {
        this.jPasswordField1 = jPasswordField1;
    }

     /**
     * Vraća tekstualno polje za unos korisnickog imena menadzera.
     *
     * @return JTextField za unos korisnickog imena menadzera.
     */
    public JTextField getjTextFieldUsername() {
        return jTextFieldUsername;
    }

    
    /**
     * Postavlja tekstualno polje za unos korisnickog imena menadzera.
     *
     * @param jTextFieldUsername Nov tekstualno polje za unos korisnickog imena menadzera
     */
    public void setjTextFieldUsername(JTextField jTextFieldUsername) {
        this.jTextFieldUsername = jTextFieldUsername;
    }
    
    /**
     * Dodaje ActionListener za dugme za prijavu menadzera.
     *
     * @param actionListener ActionListener koji će biti dodat dugmetu.
     */
 public void loginAddActionListener(ActionListener actionListener) {

        jButtonUlogujSe.addActionListener(actionListener);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonUlogujSe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables
}
