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

/**
 * Klasa koja predstavlja test za model tabele za prikaz podataka o klijentima.
 * 
 * @author Nikolina Baros
 */

public class ModelTabeleKlijentTest extends TestCase {
    private ModelTabeleKlijent modelTabeleKlijent;
    private List<Klijent> klijenti;
    public ModelTabeleKlijentTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
       klijenti = new ArrayList<>();
        klijenti.add(new Klijent(1, "Nikola", "Nikolic", "065123456", new Date()));
        klijenti.add(new Klijent(2, "Marko", "Markovic", "064987654", new Date()));
        modelTabeleKlijent = new ModelTabeleKlijent(klijenti);
    }
    
    @Override
    protected void tearDown() throws Exception {
      modelTabeleKlijent=null;
      klijenti=null;
    }

  @Test
    public void testGetRowCount() {
        assertEquals(2, modelTabeleKlijent.getRowCount());
    }

    @Test
    public void testGetColumnCount() {
        assertEquals(5, modelTabeleKlijent.getColumnCount());
    }

    @Test
    public void testGetValueAt() {
        assertEquals(1, modelTabeleKlijent.getValueAt(0, 0));
        
        assertEquals("Nikola", modelTabeleKlijent.getValueAt(0, 1));
        
        assertEquals("Nikolic", modelTabeleKlijent.getValueAt(0, 2));
        
        assertEquals("065123456", modelTabeleKlijent.getValueAt(0, 3));

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
        String expectedDate = sdf.format(klijenti.get(0).getDatRodj());
        assertEquals(expectedDate, modelTabeleKlijent.getValueAt(0, 4));
    }
    
    @Test
    public void testGetColumnName() {
        assertEquals("ID", modelTabeleKlijent.getColumnName(0));
        assertEquals("Ime", modelTabeleKlijent.getColumnName(1));
        assertEquals("Prezime", modelTabeleKlijent.getColumnName(2));
        assertEquals("Broj telefona", modelTabeleKlijent.getColumnName(3));
        assertEquals("Datum rodjenja", modelTabeleKlijent.getColumnName(4));
    }

}
