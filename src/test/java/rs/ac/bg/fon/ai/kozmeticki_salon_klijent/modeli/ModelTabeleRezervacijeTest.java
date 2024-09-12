/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.kozmeticki_salon_klijent.modeli;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.Klijent;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.Rezervacija;

/**
 * Klasa koja predstavlja test za model tabele za prikaz podataka o rezervacijama.
 * 
 * @author Nikolina Baros
 */
public class ModelTabeleRezervacijeTest extends TestCase {
    private ModelTabeleRezervacije modelTabeleRezervacije;
    private List<Rezervacija> rezervacije;
    private Klijent klijent;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
    
    
    public ModelTabeleRezervacijeTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
       klijent = new Klijent(1, "Nikola", "Nikolic", "065123456", sdf.parse("10.02.1990."));
        
        rezervacije = new ArrayList<>();
        rezervacije.add(new Rezervacija(1, sdf.parse("05.09.2025."), 3000, true, klijent));
        rezervacije.add(new Rezervacija(2, sdf.parse("06.09.2025."), 5000, false, klijent));
        
        modelTabeleRezervacije = new ModelTabeleRezervacije(rezervacije);
    }
    
    @Override
    protected void tearDown() throws Exception {
        rezervacije=null;
        klijent=null;
        modelTabeleRezervacije=null;
    }

    
    @Test
    public void testGetRowCount() {
        assertEquals(2, modelTabeleRezervacije.getRowCount());
    }

    @Test
    public void testGetColumnCount() {
        assertEquals(6, modelTabeleRezervacije.getColumnCount());
    }

    @Test
    public void testGetValueAt() throws Exception {
        assertEquals(1, modelTabeleRezervacije.getValueAt(0, 0));
        assertEquals("05.09.2025.", modelTabeleRezervacije.getValueAt(0, 1));
        assertEquals(3000, modelTabeleRezervacije.getValueAt(0, 2));
        assertEquals("da", modelTabeleRezervacije.getValueAt(0, 3));
        assertEquals("Nikola Nikolic", modelTabeleRezervacije.getValueAt(0, 4));
        assertEquals("10.02.1990.", modelTabeleRezervacije.getValueAt(0, 5));

        assertEquals(2, modelTabeleRezervacije.getValueAt(1, 0));
        assertEquals("06.09.2025.", modelTabeleRezervacije.getValueAt(1, 1));
        assertEquals(5000, modelTabeleRezervacije.getValueAt(1, 2));
        assertEquals("ne", modelTabeleRezervacije.getValueAt(1, 3));
        assertEquals("Nikola Nikolic", modelTabeleRezervacije.getValueAt(1, 4));
        assertEquals("10.02.1990.", modelTabeleRezervacije.getValueAt(1, 5));
    }

    @Test
    public void testSetLista() {
        List<Rezervacija> novaLista = new ArrayList<>();
        novaLista.add(new Rezervacija(3, new Date(), 4000, true, klijent));
        modelTabeleRezervacije.setLista(novaLista);
        assertEquals(1, modelTabeleRezervacije.getRowCount());
        assertEquals(3, modelTabeleRezervacije.getValueAt(0, 0));
    }
    
}
