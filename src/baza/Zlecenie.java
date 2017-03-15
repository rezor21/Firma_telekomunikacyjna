/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

/**
 * Klasa obiektów przyjmujących wartości takie jak pojedyńczy rekord w tabeli pracownicy 
 * @author Michał Rembisz
 */
public class Zlecenie {
    private String id_z;
    private String typ_zl;
    private String id_a;
    private String id_p;
    private String id_k;

    /**
     * Konstruktor dla obiektów klasy Klient
     * @param id_z zmienna typu String
     * @param typ_zl zmienna typu String
     * @param id_a zmienna typu String
     * @param id_p zmienna typu String
     * @param id_k zmienna typu String
     */
    public Zlecenie(String id_z, String typ_zl, String id_a, String id_p, String id_k) {
        this.id_z = id_z;
        this.typ_zl = typ_zl;
        this.id_a = id_a;
        this.id_p = id_p;
        this.id_k = id_k;
    }

    /**
     * Metoda zwracająca zmienną id_z na zewnątrz klasy
     * @return zwraca zmienną id_z
     */
    public String getId_z() {
        return id_z;
    }

    /**
     * Metoda ustawiająca wartość zmiennej id_z 
     * @param id_z zmienna służąca do ustawienia wartosći zmiennej id_z z tej klasy
     */
    public void setId_z(String id_z) {
        this.id_z = id_z;
    }

    /**
     * Metoda zwracająca zmienną typ_zl na zewnątrz klasy
     * @return zwraca zmienną typ_zl
     */
    public String getTyp_zl() {
        return typ_zl;
    }

    /**
     * Metoda ustawiająca wartość zmiennej typ_zl 
     * @param typ_zl zmienna służąca do ustawienia wartosći zmiennej typ_zl z tej klasy
     */
    public void setTyp_zl(String typ_zl) {
        this.typ_zl = typ_zl;
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
     * Metoda zwracająca zmienną id_p na zewnątrz klasy
     * @return zwraca zmienną id_p
     */
    public String getId_p() {
        return id_p;
    }

    /**
     * Metoda ustawiająca wartość zmiennej id_p 
     * @param id_p zmienna służąca do ustawienia wartosći zmiennej id_p z tej klasy
     */
    public void setId_p(String id_p) {
        this.id_p = id_p;
    }

    /**
     * Metoda zwracająca zmienną id_k na zewnątrz klasy
     * @return zwraca zmienną id_k
     */
    public String getId_k() {
        return id_k;
    }

    /**
     * Metoda ustawiająca wartość zmiennej id_k 
     * @param id_k zmienna służąca do ustawienia wartosći zmiennej id_k z tej klasy
     */
    public void setId_k(String id_k) {
        this.id_k = id_k;
    }

    
   
    /**
     * Metoda zwracająca zmienną typu String przygotowaną w celu wypisania na ekran wartości dla pojedyńczego obiektu klasy Zlecenie
     * @return zwraca zmienną typu String zawierającą wartości zmiennych dla obiektu tej klasy
     */
    @Override
    public String toString() {
        return "["+id_z+"] - "+typ_zl+" - "+id_a+" - "+id_p+" - "+id_k;
    }
}
