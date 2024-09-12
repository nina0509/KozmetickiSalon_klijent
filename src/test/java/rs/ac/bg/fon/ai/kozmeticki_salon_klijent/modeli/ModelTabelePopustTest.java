/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.ac.bg.fon.ai.kozmeticki_salon_klijent.modeli;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.Klijent;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.Popust;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.TipUsluge;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.Usluga;

/**
 * Klasa koja predstavlja test za model tabele za prikaz podataka o popustima.
 *
 * @author Nikolina Baros
 */
public class ModelTabelePopustTest  {

    private ModelTabelePopust modelTabelePopust;
    private List<Popust> popusti;

    private Klijent klijent;
    private Usluga usluga1, usluga2;

    

    @BeforeEach
    public void setUp() throws Exception {
        klijent = new Klijent(1, "Nikola", "Nikolic", "065123456", new Date());
        TipUsluge tip = new TipUsluge(1, "tip1");
        usluga1 = new Usluga(1, "Masaža", 120, 1200, tip);
        usluga2 = new Usluga(2, "Manikir", 120, 1200, tip);

        popusti = new ArrayList<>();
        popusti.add(new Popust(klijent, usluga1, 5, 20));
        popusti.add(new Popust(klijent, usluga2, 0, 15));

        modelTabelePopust = new ModelTabelePopust(popusti);
    }

    @AfterEach
    public void tearDown() throws Exception {
        modelTabelePopust = null;
        List<Popust> popusti = null;
        klijent = null;
        usluga1 = null;
        usluga2 = null;
    }

    @Test
    public void testGetRowCount() {
        //ne prikazuje se popust sa 0rez
        assertEquals(1, modelTabelePopust.getRowCount());
    }

    @Test
    public void testGetColumnCount() {
        assertEquals(3, modelTabelePopust.getColumnCount());
    }

    @Test
    public void testGetValueAt() {
        assertEquals("Masaža", modelTabelePopust.getValueAt(0, 0));

        assertEquals(5, modelTabelePopust.getValueAt(0, 1));

        assertEquals("20%", modelTabelePopust.getValueAt(0, 2));
    }

    @Test
    public void testSetListaPopustBezRezervacija() {
        List<Popust> novaLista = new ArrayList<>();

        novaLista.add(new Popust(klijent, usluga2, 0, 15));

        modelTabelePopust.setLista(novaLista);

        assertEquals(0, modelTabelePopust.getRowCount());
    }

    @Test
    public void testVratiPopust() {
        Popust popust = modelTabelePopust.vratiPopust(klijent, usluga1);
        assertNotNull(popust);
        assertEquals(20, popust.getPopust());

        Popust popustNePostoji = modelTabelePopust.vratiPopust(klijent, usluga2);
        assertNull(popustNePostoji);
    }

}
