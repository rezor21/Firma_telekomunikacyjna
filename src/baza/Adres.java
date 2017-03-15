/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

/**
 * Klasa obiektów przyjmujących wartości takie jak pojedyńczy rekord w tabeli adresy 
 * @author Michał Rembisz
 */
public class Adres {
    private String id_a;
    private String miejscowosc;
    private String ulica;
    private String nr_domu;
    private String kod;
    private String poczta;

    /**
     * Konstruktor dla obiektów klasy Adres
     * @param id_a zmienna typu String
     * @param miejscowosc zmienna typu String
     * @param ulica zmienna typu String
     * @param nr_domu zmienna typu String
     * @param kod zmienna typu String
     * @param poczta zmienna typu String
     */
    public Adres(String id_a, String miejscowosc, String ulica, String nr_domu, String kod, String poczta) {
        this.id_a = id_a;
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.nr_domu = nr_domu;
        this.kod = kod;
        this.poczta = poczta;
    }

    /**
     * Metoda zwracająca zmienną id_a na zewnątrz klasy
     * @return zwraca zmienną id_a
     */
    public String getId_a() {
        return id_a;
    }

    /**
     * Metoda ustawiająca wartość zmiennej id_a 
     * @param id_a zmienna służąca do ustawienia wartosći zmiennej id_a z tej klasy
     */
    public void setId_a(String id_a) {
        this.id_a = id_a;
    }

    /**
     * Metoda zwracająca zmienną miejscowosc na zewnątrz klasy
     * @return zwraca zmienną miejscowosc
     */
    public String getMiejscowosc() {
        return miejscowosc;
    }

     /**
     * Metoda ustawiająca wartość zmiennej miejscowosc 
     * @param miejscowosc zmienna służąca do ustawienia wartosći zmiennej miejscowosc z tej klasy
     */
    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    /**
     * Metoda zwracająca zmienną ulica na zewnątrz klasy
     * @return zwraca zmienną ulica
     */
    public String getUlica() {
        return ulica;
    }

     /**
     * Metoda ustawiająca wartość zmiennej ulica 
     * @param ulica zmienna służąca do ustawienia wartosći zmiennej ulica z tej klasy
     */
    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    /**
     * Metoda zwracająca zmienną nr_domu na zewnątrz klasy
     * @return zwraca zmienną nr_domu
     */
    public String getNr_domu() {
        return nr_domu;
    }
    
    /**
     * Metoda ustawiająca wartość zmiennej nr_domu 
     * @param nr_domu zmienna służąca do ustawienia wartosći zmiennej nr_domu z tej klasy
     */
    public void setNr_domu(String nr_domu) {
        this.nr_domu = nr_domu;
    }

    /**
     * Metoda zwracająca zmienną kod na zewnątrz klasy
     * @return zwraca zmienną kod
     */
    public String getKod() {
        return kod;
    }

    /**
     * Metoda ustawiająca wartość zmiennej kod 
     * @param kod zmienna służąca do ustawienia wartosći zmiennej kod z tej klasy
     */
    public void setKod(String kod) {
        this.kod = kod;
    }

    /**
     * Metoda zwracająca zmienną poczta na zewnątrz klasy
     * @return zwraca zmienną poczta
     */
    public String getPoczta() {
        return poczta;
    }

    /**
     * Metoda ustawiająca wartość zmiennej poczta 
     * @param poczta zmienna służąca do ustawienia wartosći zmiennej poczta z tej klasy
     */
    public void setPoczta(String poczta) {
        this.poczta = poczta;
    }
    
    /**
     * Metoda zwracająca zmienną typu String przygotowaną w celu wypisania na ekran wartości dla pojedyńczego obiektu klasy Adres
     * @return zwraca zmienną typu String zawierającą wartości zmiennych dla obiektu tej klasy
     */
    @Override
     public String toString() {
        return "["+id_a+"] - "+miejscowosc+" - "+ulica+" - "+nr_domu+" - "+kod+" - "+poczta;
    }
    
    
}
