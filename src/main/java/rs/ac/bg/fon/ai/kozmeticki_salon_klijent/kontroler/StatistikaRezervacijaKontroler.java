/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.kozmeticki_salon_klijent.kontroler;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import rs.ac.bg.fon.ai.kozmeticki_salon_klijent.forme.StatistikaRezervacijaForma;
import rs.ac.bg.fon.ai.kozmeticki_salon_klijent.komunikacija.Komunikacija;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.Statistika;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.StavkaStatistike;
import rs.ac.bg.fon.ai.kozmeticki_salon_zajednicki.domen.Usluga;

/**
 *
 * @author ninic
 */
public class StatistikaRezervacijaKontroler {
  
    private final StatistikaRezervacijaForma srf;

    public StatistikaRezervacijaKontroler(StatistikaRezervacijaForma srf) {
        this.srf = srf;
        
    }
    
     public void otvoriFormu() {
        
         List<Statistika> statistike = Komunikacija.getInstance().vratiSveStatistike();
         generisiGrafikRezervacijaPoGodinama(statistike);
        ucitajPodatkeZaComboBox();
         addActionListener();
        srf.setVisible(true);

    }

    private void ucitajPodatkeZaComboBox() {

         List<Usluga> usluge = Komunikacija.getInstance().vratiSveUsluge();
        for (Usluga u : usluge) {
            
            srf.getjComboBoxUsluga().addItem(u);
        }

    }
    
    
    private void addActionListener() {

        //statistika po usluzi
        srf.addButtonPoUsluziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                   
                    Usluga u=(Usluga) srf.getjComboBoxUsluga().getSelectedItem();
                   List<Statistika> statistike = Komunikacija.getInstance().vratiSveStatistike();
                    generisiGrafikRezervacijaPoGodinamaZaUslugu(statistike,u);
                    JOptionPane.showMessageDialog(srf, "Sistem je ucitao statistiku", "Uspeh", JOptionPane.INFORMATION_MESSAGE);

                    
                } catch (Exception ex) {
                    
                  JOptionPane.showMessageDialog(srf, "Sistem ne moze da ucita statistiku", "Greska", JOptionPane.ERROR_MESSAGE);

                }

            }

           
        });
        
        
         srf.addButtonUkupnaStatistikaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                
                    List<Statistika> statistike = Komunikacija.getInstance().vratiSveStatistike();
                    generisiGrafikRezervacijaPoGodinama(statistike);
                   JOptionPane.showMessageDialog(srf, "Sistem je ucitao statistiku", "Uspeh", JOptionPane.INFORMATION_MESSAGE);

               

            }
        });
         
          srf.addButtonSacuvajStatistikuActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                
                try {
                   Komunikacija.getInstance().generisiStatistiku();
                    List<Statistika> statistike = Komunikacija.getInstance().vratiSveStatistike();
                    generisiGrafikRezervacijaPoGodinama(statistike);
                   JOptionPane.showMessageDialog(srf, "Sistem je ucitao statistiku", "Uspeh", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception ex) {
                  JOptionPane.showMessageDialog(srf, "Sistem ne moze da ucita statistiku", "Greska", JOptionPane.ERROR_MESSAGE);
                }
                    
               

            }
        });
        

    }

  
    
     private void generisiGrafikRezervacijaPoGodinama(List<Statistika> statistike) {
        
        
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
      
        for(Statistika s:statistike)
        {
        
        dataset.addValue(s.getUkupnoRezervacija(), "Broj rezervacija", s.getGodina()+"");
        
        }
       
      JFreeChart barChart=ChartFactory.createBarChart(
              "Ukupno rezervacija po godinama", 
              "Godina", 
              "Broj rezervacija", 
              dataset,
              PlotOrientation.VERTICAL,
              true,
              true,
              false);

        
        
        ChartPanel chartPanelInstance = new ChartPanel(barChart);
        chartPanelInstance.setPreferredSize(new java.awt.Dimension(250, 250));
        
        
        srf.getjPanelStatistika().setLayout(new BorderLayout());
        srf.getjPanelStatistika().removeAll();// Postavite layout na BorderLayout
        srf.getjPanelStatistika().add(chartPanelInstance); // Dodajte ChartPanel na vaš JPanel
        srf.getjPanelStatistika().validate(); 
         
         }
     
     
      private void generisiGrafikRezervacijaPoGodinamaZaUslugu(List<Statistika> statistike, Usluga u) {

       DefaultCategoryDataset dataset=new DefaultCategoryDataset();
      
        for(Statistika s:statistike)
        {
           
         for(StavkaStatistike ss:s.getStavke())
         {
         if(ss.getUsluga().equals(u))dataset.addValue(ss.getBrojRezUsluge(), "Broj rezervacija usluge", s.getGodina()+"");
         }
        
        }
       
              JFreeChart barChart=ChartFactory.createBarChart(
              "Ukupno rezervacija po godinama za uslugu: "+u.getNaziv(), 
              "Godina", 
              "Broj rezervacija", 
              dataset,
              PlotOrientation.VERTICAL,
              true,
              true,
              false);

        
        
        ChartPanel chartPanelInstance = new ChartPanel(barChart);
        chartPanelInstance.setPreferredSize(new java.awt.Dimension(250, 250));
        
        
        srf.getjPanelStatistika().setLayout(new BorderLayout());
        srf.getjPanelStatistika().removeAll();// Postavite layout na BorderLayout
         srf.getjPanelStatistika().add(chartPanelInstance); // Dodajte ChartPanel na vaš JPanel
         srf.getjPanelStatistika().validate(); 
          
      
      }
    
    
}
