/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektpo;
import java.util.List;
import baza.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
/**
 *Klasa testowa
 * @author Michał Rembisz
 */
public class Projektpo {
private static Connection conn;
    /**
     * Główna metoda klasy Projektpo
     * @param args the command line arguments
     * @throws FileNotFoundException wyjątek mówiący o nie znalezieniu pliku z danymi
     * @throws XMLStreamException  wyjątek błędu odczytu pliku XML
     */
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        Obsbazy b = new Obsbazy();
      b.insertAdres("Kolbuszowa", "jakas", "102b", "36-100", "Kolbuszowa");
       b.insertAdres("rzeszów", "jakas", "1023b", "36-110", "rzeszów");
        b.insertPracownik("Karol", "Maciaszek", "Kolbuszowa", "Druga", "781222111", "1");
        b.insertPracownik("Piotr", "Wojtecki", "Rzeszów", "Pierwsza", "898666333", "2");
        b.insertPracownik("Jan", "Nowak", "Rzeszów", "Druga", "222111333","1");
        b.insertPracownik("Piotr", "Kowalski", "Rzeszów", "Pierwsza", "555321123", "1");
        b.insertKlient("Piotr", "Janowski", "555321123", "1");
        b.insertZlecenie("Naprawa", "2", "1", "1");
        
         //Obsbazy.wykonajZapytanie("DELETE FROM pracownicy WHERE id_p=1");
       
        List<Pracownik> pracownicy = b.selectPracownicy();
        
       
        
   /*    b.clearall();
 System.out.println("Lista pracowników: ");
        for(Pracownik p: pracownicy)
            System.out.println(p);
          
        
        
        
       File xmlFile = new File("./src/projektpo/dane.xml");
       Parser.parsowanieXML(xmlFile,true,true);
       
      
      System.out.println("Lista pars: ");
            for(Pracownik q: Parser.zparsp)
            System.out.println(q);
            for(Klient q: Parser.zparsk)
            System.out.println(q);
          */ 
           pracownicy = b.selectPracownicy();
           System.out.println("Lista pracowników: ");
        for(Pracownik p: pracownicy)
            System.out.println(p);
        
        List<Adres> adresy = b.selectAdresy();
        System.out.println("Lista adresów: ");
        for(Adres a: adresy)
            System.out.println(a);
         
        List<Klient> klienci = b.selectKlienci();
        System.out.println("Lista klientów: ");
        for(Klient k: klienci)
            System.out.println(k); 
         
        List<Zlecenie> zlecenia = b.selectZlecenia();
        System.out.println("Lista zleceń: ");
        for(Zlecenie k: zlecenia)
            System.out.println(k);
        
        pracownicy.clear();
        adresy.clear();
        zlecenia.clear();
        klienci.clear();
        
        b.closeConnection();
        
    }
    
    
    
}
