/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektpo;

import baza.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *Klasa zawierająca metody do parsowania danych z pliku XML
 * @author Michał Rembisz
 */
public class Parser {
    public static String zapytanie;
    public static List<Pracownik> zparsp = new ArrayList();
    public static List<Adres> zparsa = new ArrayList();
    public static List<Klient> zparsk = new ArrayList();
    public static List<Zlecenie> zparsz = new ArrayList();
    
    /**
     * Metoda służąca do pobierania danych z podanego pliku XML
     * @param filePath zmienna typu File zawierająca ścieżkę do pliku z danymi
     * @param dodajdolisty zmienna typu boolean informująca czy doać dane z pliku do listy
     * @param dodajdobazy zmienna typu boolean informująca czy doać dane z pliku do bazy
     * @throws FileNotFoundException wyjątek mówiący o nie znalezieniu pliku z danymi
     * @throws XMLStreamException  wyjątek błędu odczytu pliku XML
     */
    
    public static void parsowanieXML(File filePath, boolean dodajdolisty, boolean dodajdobazy) throws FileNotFoundException, XMLStreamException
    {
        // tworzenie parsera
        XMLInputFactory iFactory = XMLInputFactory.newInstance();
        InputStream xmlFile = new FileInputStream(filePath);
        XMLStreamReader parser = iFactory.createXMLStreamReader(xmlFile);
        

        // Arraylisty tagow i odpowiadajacych im wartosci
        ArrayList<String> tags = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        
        // dopoki masz nastepny element ...
        while (parser.hasNext()) 
        {
            // jesli jest to ... , wowczas ...
            switch (parser.next()) 
            {
// START ELEMENT //
                case XMLStreamConstants.START_ELEMENT:
    // tagi 'glowne' //
                   
                    
                    if (parser.getLocalName().equals("pracownicy")) {
                        tags.add("tabela");
                        values.add("pracownicy");
                    }
                    if (parser.getLocalName().equals("adresy")) {
                        tags.add("tabela");
                        values.add("adresy");
                    }
                    
                    if (parser.getLocalName().equals("klienci")) {
                        tags.add("tabela");
                        values.add("klienci");
                    }
                    
                    if (parser.getLocalName().equals("zlecenia")) {
                        tags.add("tabela");
                        values.add("zlecenia");
                    }
                    
                    
    // 'podtagi' //
                    
                    if (parser.getLocalName().equals("id_p")) {
                        tags.add("id_p");
                        values.add(parser.getElementText());
                    }
                    if (parser.getLocalName().equals("imie")) {
                        tags.add("imie");
                        values.add(parser.getElementText());
                    }
                    if (parser.getLocalName().equals("nazwisko")) {
                        tags.add("nazwisko");
                        values.add(parser.getElementText());
                    }
                    if (parser.getLocalName().equals("rejon")) {
                        tags.add("rejon");
                        values.add(parser.getElementText());
                    }
                    
                    if (parser.getLocalName().equals("zmiana")) {
                        tags.add("zmiana");
                        values.add(parser.getElementText());
                    }
                    
                    if (parser.getLocalName().equals("tel_p")) {
                        tags.add("tel_p");
                        values.add(parser.getElementText());
                    }
                    
                    if (parser.getLocalName().equals("id_a")) {
                        tags.add("id_a");
                        values.add(parser.getElementText());
                    }
                    if (parser.getLocalName().equals("miejscowosc")) {
                        tags.add("miejscowosc");
                        values.add(parser.getElementText());
                    }
                    if (parser.getLocalName().equals("ulica")) {
                        tags.add("ulica");
                        values.add(parser.getElementText());
                    }
                    if (parser.getLocalName().equals("nr_domu")) {
                        tags.add("nr_domu");
                        values.add(parser.getElementText());
                    }
                    
                    if (parser.getLocalName().equals("kod")) {
                        tags.add("kod");
                        values.add(parser.getElementText());
                    }
                    
                    if (parser.getLocalName().equals("poczta")) {
                        tags.add("poczta");
                        values.add(parser.getElementText());
                    }
                    
                    if (parser.getLocalName().equals("id_k")) {
                        tags.add("id_k");
                        values.add(parser.getElementText());
                    }
                    if (parser.getLocalName().equals("tel_k")) {
                        tags.add("tel_k");
                        values.add(parser.getElementText());
                    }
                    if (parser.getLocalName().equals("id_z")) {
                        tags.add("id_z");
                        values.add(parser.getElementText());
                    }
                    if (parser.getLocalName().equals("typ_zl")) {
                        tags.add("typ_zl");
                        values.add(parser.getElementText());
                    }
                    break;
// END ELEMENT //
                case XMLStreamConstants.END_ELEMENT:
                    
                    if (parser.getLocalName().equals("pracownicy") 
                            || parser.getLocalName().equals("adresy")
                            || parser.getLocalName().equals("klienci")
                            || parser.getLocalName().equals("zlecenia")
                            ) 
                    {
                        Obsbazy conn = new Obsbazy();
                        zapytanie = "INSERT INTO ";
                        if(values.get(0).equals("adresy") ){
                            if(dodajdolisty==true){
                                
                           baza.Adres adres = new baza.Adres(values.get(1), values.get(2), values.get(3), values.get(4), values.get(5), values.get(6));
                                 zparsa.add(adres);  
                            }
                                 
                        }
                        
                        if(values.get(0).equals("pracownicy") ){
                            
                         
                            if(dodajdolisty==true){
                                
                           baza.Pracownik prac = new baza.Pracownik(values.get(1), values.get(2), values.get(3), values.get(4), values.get(5), values.get(6), values.get(7));
                                 zparsp.add(prac);  
                            }
                                 
                        }
                        
                         
                         if(values.get(0).equals("klienci") ){
                            if(dodajdolisty==true){
                                
                           baza.Klient klient = new baza.Klient(values.get(1), values.get(2), values.get(3), values.get(4), values.get(5));
                                 zparsk.add(klient);  
                            }
                                 
                        }
                         if(values.get(0).equals("zlecenia") ){
                            if(dodajdolisty==true){
                                
                           baza.Zlecenie zlec = new baza.Zlecenie(values.get(1), values.get(2), values.get(3), values.get(4), values.get(5));
                                 zparsz.add(zlec);  
                            }
                                 
                        }
                        
                        
                        if(dodajdobazy==true)
                        {
                        
                        conn.insertListAdres(Parser.zparsa);
                        conn.insertListPracownik(Parser.zparsp);
                        
                        conn.insertListKlient(Parser.zparsk);
                        conn.insertListZlecenia(Parser.zparsz);
                        zparsp.clear();
                        zparsk.clear();
                        zparsz.clear();
                        zparsa.clear();
                        }
                        
                        
                        tags.clear();
                        values.clear();
                        System.out.println();
                       
                    }
                    break;
// END DOCUMENT //
                case XMLStreamConstants.END_DOCUMENT:
                    System.out.println("Koniec parsowania");
                    break;
                     
            }
            
        }
    }
}
