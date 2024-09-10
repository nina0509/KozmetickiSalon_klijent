/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.kozmeticki_salon_klijent.modeli;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import rs.ac.bg.fon.ai.kozmeticki_salon_klijent.forme.TipForme;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.StavkaRezervacije;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.TipUsluge;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.Usluga;

/**
 * Klasa koja predstavlja test za model tabele za prikaz podataka o stavkama rezervacije.
 * 
 * @author Nikolina Baros
 */
public class ModelTabeleStavkeRezervacijeTest extends TestCase {
    private ModelTabeleStavkeRezervacije modelTabeleStavkeRezervacije;
    private List<StavkaRezervacije> stavke;
    private Usluga usluga1;
    private Usluga usluga2;
    public ModelTabeleStavkeRezervacijeTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        
        usluga1 = new Usluga(1, "Manikir", 100,1000,new TipUsluge(1,"Manikir"));
        usluga2 = new Usluga(2, "Pedikir", 150,1500,new TipUsluge(2,"Pedikir"));

        stavke = new ArrayList<>();
        stavke.add(new StavkaRezervacije(1, null,LocalTime.of(10, 0), LocalTime.of(11, 0), 1000, usluga1));
        stavke.add(new StavkaRezervacije(2,null, LocalTime.of(11, 0), LocalTime.of(12, 0), 1500, usluga2));

        modelTabeleStavkeRezervacije = new ModelTabeleStavkeRezervacije(stavke);
    }
    
    @Override
    protected void tearDown() throws Exception {
       modelTabeleStavkeRezervacije=null;
       stavke=null;
       usluga1=null;
       usluga2=null;
    }

    
    @Test
    public void testGetRowCount() {
        assertEquals(2, modelTabeleStavkeRezervacije.getRowCount());
    }

    @Test
    public void testGetColumnCount() {
        assertEquals(5, modelTabeleStavkeRezervacije.getColumnCount());
    }

    @Test
    public void testGetValueAt() {
        assertEquals(1, modelTabeleStavkeRezervacije.getValueAt(0, 0));
        assertEquals(LocalTime.of(10, 0), modelTabeleStavkeRezervacije.getValueAt(0, 1));
        assertEquals(LocalTime.of(11, 0), modelTabeleStavkeRezervacije.getValueAt(0, 2));
        assertEquals(1000, modelTabeleStavkeRezervacije.getValueAt(0, 3));
        assertEquals("Manikir", modelTabeleStavkeRezervacije.getValueAt(0, 4));

        assertEquals(2, modelTabeleStavkeRezervacije.getValueAt(1, 0));
        assertEquals(LocalTime.of(11, 0), modelTabeleStavkeRezervacije.getValueAt(1, 1));
        assertEquals(LocalTime.of(12, 0), modelTabeleStavkeRezervacije.getValueAt(1, 2));
        assertEquals(1500, modelTabeleStavkeRezervacije.getValueAt(1, 3));
        assertEquals("Pedikir", modelTabeleStavkeRezervacije.getValueAt(1, 4));
    }

    @Test
    public void testSetLista() {
        List<StavkaRezervacije> novaLista = new ArrayList<>();
        novaLista.add(new StavkaRezervacije(3,null, LocalTime.of(13, 0), LocalTime.of(14, 0), 2000, usluga1));
        modelTabeleStavkeRezervacije.setLista(novaLista);
        assertEquals(1, modelTabeleStavkeRezervacije.getRowCount());
        assertEquals(3, modelTabeleStavkeRezervacije.getValueAt(0, 0));
    }

    @Test
    public void testDodajStavku() throws Exception {
        StavkaRezervacije novaStavka = new StavkaRezervacije(3,null, LocalTime.of(12, 0), LocalTime.of(13, 0), 2000, usluga1);
        modelTabeleStavkeRezervacije.dodajStavku(novaStavka);
        assertEquals(3, modelTabeleStavkeRezervacije.getRowCount());
        assertEquals(3, modelTabeleStavkeRezervacije.getValueAt(2, 0));
    }

    @Test
    public void testDodajStavkuTerminPreklapanje() {
        StavkaRezervacije preklapajucaStavka = new StavkaRezervacije(3,null, LocalTime.of(10, 30), LocalTime.of(11, 30), 2000, usluga1);
        Exception exception = assertThrows(Exception.class, () -> {
            modelTabeleStavkeRezervacije.dodajStavku(preklapajucaStavka);
        });
        assertEquals("Sistem ne moze da doda stavku rezervacije. Termini usluga se preklapaju!", exception.getMessage());
    }

    @Test
    public void testIzbrisiStavku() {
        StavkaRezervacije stavkaZaBrisanje = stavke.get(0);
        modelTabeleStavkeRezervacije.izbrisiStavku(stavkaZaBrisanje);
        assertEquals(1, modelTabeleStavkeRezervacije.getRowCount());
        assertEquals(1, modelTabeleStavkeRezervacije.getValueAt(0, 0));
    }

    @Test
    public void testResetuj() {
        modelTabeleStavkeRezervacije.resetuj();
        assertEquals(0, modelTabeleStavkeRezervacije.getRowCount());
    }
}
