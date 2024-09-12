/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.kozmeticki_salon_klijent.modeli;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.TipUsluge;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.Usluga;

/**
 * Klasa koja predstavlja test za model tabele za prikaz podataka o uslugama.
 * 
 * @author Nikolina Baros
 */
public class ModelTabeleUslugaTest {
     private ModelTabeleUsluga modelTabeleUsluga;
    private List<Usluga> usluge;
    private TipUsluge tip1;
    private TipUsluge tip2;

    @BeforeEach
    public void setUp() throws Exception {
         tip1 = new TipUsluge(1, "Masaža");
        tip2 = new TipUsluge(2, "Nega lica");

        usluge = new ArrayList<>();
        usluge.add(new Usluga(1, "Aromaterapija", 60, 3000, tip1));
        usluge.add(new Usluga(2, "Hidratacija kože", 45, 2500, tip2));

        modelTabeleUsluga = new ModelTabeleUsluga(usluge);
    }
    
    @AfterEach
    public void tearDown() throws Exception {
        modelTabeleUsluga=null;
        usluge=null;
        tip1=null;
        tip2=null;
    }

    @Test
    public void testGetRowCount() {
        assertEquals(2, modelTabeleUsluga.getRowCount());
    }

    @Test
    public void testGetColumnCount() {
        assertEquals(5, modelTabeleUsluga.getColumnCount());
    }

    @Test
    public void testGetValueAt() {
        assertEquals(1, modelTabeleUsluga.getValueAt(0, 0));
        assertEquals("Aromaterapija", modelTabeleUsluga.getValueAt(0, 1));
        assertEquals("60min", modelTabeleUsluga.getValueAt(0, 2));
        assertEquals(3000, modelTabeleUsluga.getValueAt(0, 3));
        assertEquals("Masaža", modelTabeleUsluga.getValueAt(0, 4));

        assertEquals(2, modelTabeleUsluga.getValueAt(1, 0));
        assertEquals("Hidratacija kože", modelTabeleUsluga.getValueAt(1, 1));
        assertEquals("45min", modelTabeleUsluga.getValueAt(1, 2));
        assertEquals(2500, modelTabeleUsluga.getValueAt(1, 3));
        assertEquals("Nega lica", modelTabeleUsluga.getValueAt(1, 4));
    }

    @Test
    public void testSetLista() {
        List<Usluga> novaLista = new ArrayList<>();
        novaLista.add(new Usluga(3, "Pedikir", 30, 1500, tip2));
        modelTabeleUsluga.setLista(novaLista);
        assertEquals(1, modelTabeleUsluga.getRowCount());
        assertEquals(3, modelTabeleUsluga.getValueAt(0, 0));
    }

    @Test
    public void testGetColumnName() {
        assertEquals("ID", modelTabeleUsluga.getColumnName(0));
        assertEquals("Naziv", modelTabeleUsluga.getColumnName(1));
        assertEquals("Trajanje", modelTabeleUsluga.getColumnName(2));
        assertEquals("Cena", modelTabeleUsluga.getColumnName(3));
        assertEquals("Tip usluge", modelTabeleUsluga.getColumnName(4));
    }
    
}
