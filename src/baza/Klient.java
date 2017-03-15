/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

/**
 * Klasa obiektów przyjmujących wartości takie jak pojedyńczy rekord w tabeli klienci 
 * @author Michał Rembisz
 */
public class Klient {
    private String id_k;
    private String imie;
    private String nazwisko;
    private String tel_k;
    private String id_a;

    /**
     * Konstruktor dla obiektów klasy Klient
     * @param id_k zmienna typu String
     * @param imie zmienna typu String
     * @param nazwisko zmienna typu String
     * @param tel_k zmienna typu String
     * @param id_a  zmienna typu String
     */
    public Klient(String id_k, String imie, String nazwisko, String tel_k, String id_a) {
        this.id_k = id_k;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.tel_k = tel_k;
        this.id_a = id_a;
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
     * Metoda zwracająca zmienną imie na zewnątrz klasy
     * @return zwraca zmienną imie
     */
    public String getImie() {
        return imie;
    }

    /**
     * Metoda ustawiająca wartość zmiennej imie 
     * @param imie zmienna służąca do ustawienia wartosći zmiennej imie z tej klasy
     */
    public void setImie(String imie) {
        this.imie = imie;
    }

    /**
     * Metoda zwracająca zmienną nazwisko na zewnątrz klasy
     * @return zwraca zmienną nazwisko
     */
    public String getNazwisko() {
        return nazwisko;
    }

    /**
     * Metoda ustawiająca wartość zmiennej nazwisko 
     * @param nazwisko zmienna służąca do ustawienia wartosći zmiennej nazwisko z tej klasy
     */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    /**
     * Metoda zwracająca zmienną tel_k na zewnątrz klasy
     * @return zwraca zmienną tel_k
     */
    public String getTel_k() {
        return tel_k;
    }

    /**
     * Metoda ustawiająca wartość zmiennej tel_k 
     * @param tel_k zmienna służąca do ustawienia wartosći zmiennej tel_k z tej klasy
     */
    public void setTel_k(String tel_k) {
        this.tel_k = tel_k;
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
     * Metoda zwracająca zmienną typu String przygotowaną w celu wypisania na ekran wartości dla pojedyńczego obiektu klasy Klient
     * @return zwraca zmienną typu String zawierającą wartości zmiennych dla obiektu tej klasy
     */
    @Override
     public String toString() {
        return "["+id_k+"] - "+imie+" "+nazwisko+" - "+tel_k+" - "+id_a;
    }
    
}
