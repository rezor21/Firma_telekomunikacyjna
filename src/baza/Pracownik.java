package baza;
 
/**
 * Klasa obiektów przyjmujących wartości takie jak pojedyńczy rekord w tabeli pracownicy 
 * @author Michał Rembisz
 */
public class Pracownik {
    private String id_p;
    private String imie;
    private String nazwisko;
    private String rejon;
    private String zmiana;
    private String tel_p;
    private String id_a;
 
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
     * Metoda zwracająca zmienną rejon na zewnątrz klasy
     * @return zwraca zmienną rejon
     */
    public String getRejon() {
        return rejon;
    }

    /**
     * Metoda ustawiająca wartość zmiennej rejon 
     * @param rejon zmienna służąca do ustawienia wartosći zmiennej rejon z tej klasy
     */
    public void setRejon(String rejon) {
        this.rejon = rejon;
    }

    /**
     * Metoda zwracająca zmienną zmiana na zewnątrz klasy
     * @return zwraca zmienną zmiana
     */
    public String getZmiana() {
        return zmiana;
    }

    /**
     * Metoda ustawiająca wartość zmiennej zmiana 
     * @param zmiana zmienna służąca do ustawienia wartosći zmiennej zmiana z tej klasy
     */
    public void setZmiana(String zmiana) {
        this.zmiana = zmiana;
    }

    /**
     * Metoda zwracająca zmienną tel_p na zewnątrz klasy
     * @return zwraca zmienną tel_p
     */
    public String getTel_p() {
        return tel_p;
    }

    /**
     * Metoda ustawiająca wartość zmiennej tel_p 
     * @param tel_p zmienna służąca do ustawienia wartosći zmiennej tel_p z tej klasy
     */
    public void setTel_p(String tel_p) {
        this.tel_p = tel_p;
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
     * Konstruktor dla obiektów klasy Klient
     * @param id_p zmienna typu String
     * @param imie zmienna typu String
     * @param nazwisko zmienna typu String
     * @param rejon zmienna typu String
     * @param zmiana zmienna typu String
     * @param tel_p zmienna typu String
     * @param id_a zmienna typu String
     */
    public Pracownik(String id_p, String imie, String nazwisko, String rejon, String zmiana, String tel_p, String id_a) {
        this.id_p = id_p;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rejon = rejon;
        this.zmiana = zmiana;
        this.tel_p = tel_p;
        this.id_a = id_a;
    }
 
    /**
     * Metoda zwracająca zmienną typu String przygotowaną w celu wypisania na ekran wartości dla pojedyńczego obiektu klasy Pracownik
     * @return zwraca zmienną typu String zawierającą wartości zmiennych dla obiektu tej klasy
     */
    @Override
    public String toString() {
        return "["+id_p+"] - "+imie+" "+nazwisko+" - "+rejon+" - "+zmiana+" - "+tel_p+" - "+id_a;
    }
}