package baza;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import org.sqlite.SQLiteConfig;
 
 /**
  * Klasa odpowiadająca za obsługę bazy danych
  * @author Michał Rembisz
  */
public class Obsbazy {
 
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:firmaIT.db";
 
    private Connection conn;
    private static Statement stat;
    
    public String rezultat = "";
 
    /**
     * Konstruktor klasy Obsbazy nawiązuje połączenie z bazą danych, wczytuje sterownik bazy i wywołuje metodę createTables
     */
    public Obsbazy () {
        try {
            Class.forName(Obsbazy.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }
 
        try {
            conn=null;
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            conn = DriverManager.getConnection(DB_URL,config.toProperties());
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }
 
        createTables();
    }
 
    /**
     * Metoda tworząca tabele i bazę jeśli nie istnieją
     * @return zwraca wartość logiczą oznaczającą czy tabele utworzono z powodzeniem lub czy wystąpił błąd
     */
    public boolean createTables()  {
        String createPracownicy = "CREATE TABLE IF NOT EXISTS pracownicy (id_p INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, imie varchar(255), nazwisko varchar(255), rejon varchar(255),zmiana varchar(255), tel_p INTEGER, id_a INTEGER REFERENCES adresy(id_a) ON DELETE CASCADE ON UPDATE CASCADE)";
        String createAdresy = "CREATE TABLE IF NOT EXISTS adresy (id_a INTEGER PRIMARY KEY AUTOINCREMENT, miejscowosc varchar(255), ulica varchar(255), nr_domu varchar(255),kod varchar(6), poczta varchar(255))";
        String createKlienci = "CREATE TABLE IF NOT EXISTS klienci (id_k INTEGER PRIMARY KEY AUTOINCREMENT, imie varchar(255), nazwisko varchar(255), tel_k INTEGER, id_a INTEGER REFERENCES adresy(id_a) ON DELETE CASCADE ON UPDATE CASCADE)";
        String createZlecenia = "CREATE TABLE IF NOT EXISTS zlecenia (id_z INTEGER PRIMARY KEY AUTOINCREMENT, typ_zl varchar(255), id_a INTEGER REFERENCES adresy(id_a) ON DELETE NO ACTION ON UPDATE CASCADE, id_p INTEGER REFERENCES pracownicy(id_p) ON DELETE NO ACTION ON UPDATE CASCADE, id_k INTEGER REFERENCES klienci(id_k) ON DELETE NO ACTION ON UPDATE CASCADE)";
        try {
            stat.execute(createPracownicy);
            stat.execute(createAdresy);
            stat.execute(createKlienci);
            stat.execute(createZlecenia);
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }
 
    /**
     * Metoda wstawiająca rekord do tabeli pracownicy na podstawie podanych danych
     * @param imie zmienna typu string
     * @param nazwisko zmienna typu string
     * @param rejon zmienna typu string
     * @param zmiana zmienna typu string
     * @param tel_p zmienna typu string
     * @param id_a zmienna typu string
     * @return zwraca wartość logiczną informującą czy udało się wstawić rekord
     */
    public boolean insertPracownik(String imie, String nazwisko, String rejon, String zmiana, String tel_p, String id_a) {
        try {
            int id_ad=Integer.parseInt(id_a);
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into pracownicy values (NULL, ?, ?, ?, ?, ?, ?);");
            prepStmt.setString(1, imie);
            prepStmt.setString(2, nazwisko);
            prepStmt.setString(3, rejon);
            prepStmt.setString(4, zmiana);
            prepStmt.setString(5, tel_p);
            prepStmt.setString(6, id_a);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu pracownika");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * Metoda wstawiająca rekord do tabeli klienci na podstawie podanych danych
     * @param imie zmienna typu string
     * @param nazwisko zmienna typu string
     * @param tel_k zmienna typu string
     * @param id_a zmienna typu string
     * @return zwraca wartość logiczną informującą czy udało się wstawić rekord
     */
    public boolean insertKlient(String imie, String nazwisko, String tel_k, String id_a) {
        try {
            int id_ad=Integer.parseInt(id_a);
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into klienci values (NULL, ?, ?, ?, ?);");
            prepStmt.setString(1, imie);
            prepStmt.setString(2, nazwisko);
            prepStmt.setString(3, tel_k);
            prepStmt.setInt(4, id_ad);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu klienta");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * Metoda wstawiająca rekord do tabeli zlecenia na podstawie podanych danych
     * @param typ_zl zmienna typu string
     * @param id_a zmienna typu string
     * @param id_p zmienna typu string
     * @param id_k zmienna typu string
     * @return zwraca wartość logiczną informującą czy udało się wstawić rekord
     */
    public boolean insertZlecenie(String typ_zl, String id_a, String id_p, String id_k) {
        try {
            int id_ad=Integer.parseInt(id_a);
            int id_pd=Integer.parseInt(id_p);
            int id_kd=Integer.parseInt(id_k);
            
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into zlecenia values (NULL, ?, ?, ?, ?);");
            prepStmt.setString(1, typ_zl);
            prepStmt.setInt(2, id_ad);
            prepStmt.setInt(3, id_pd);
            prepStmt.setInt(4, id_kd);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu zlecenia");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * Metoda wstawiająca rekord do tabeli adresy na podstawie podanych danych
     * @param miejscowosc zmienna typu string
     * @param ulica zmienna typu string
     * @param nr_domu zmienna typu string
     * @param kod zmienna typu string
     * @param poczta zmienna typu string
     * @return zwraca wartość logiczną informującą czy udało się wstawić rekord
     */
    public boolean insertAdres(String miejscowosc, String ulica, String nr_domu, String kod, String poczta) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into adresy values (NULL, ?, ?, ?, ?, ?);");
            prepStmt.setString(1, miejscowosc);
            prepStmt.setString(2, ulica);
            prepStmt.setString(3, nr_domu);
            prepStmt.setString(4, kod);
            prepStmt.setString(5, poczta);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu adresu");
            e.printStackTrace();
            return false;
        }
        return true;
    }
 
    
 
    /**
     * Metoda odczytująca tabelę pracownicy z bazy danych
     * @return zawraca listę zawierającą rekordy z bazy
     */
    public List<Pracownik> selectPracownicy() {
        List<Pracownik> pracownicy = new LinkedList<Pracownik>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM pracownicy");
            
            String imie, nazwisko, rejon, zmiana, tel_p, id_a, id_p;
            while(result.next()) {
                id_p = result.getString("id_p");
                imie = result.getString("imie");
                nazwisko = result.getString("nazwisko");
                rejon = result.getString("rejon");
                zmiana = result.getString("zmiana");
                tel_p = result.getString("tel_p");
                id_a = result.getString("id_a");
                pracownicy.add(new Pracownik(id_p, imie, nazwisko, rejon, zmiana, tel_p, id_a));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return pracownicy;
    }
    
    /**
     * Metoda odczytująca tabelę klienci z bazy danych
     * @return zawraca listę zawierającą rekordy z bazy
     */
    public List<Klient> selectKlienci() {
        List<Klient> klienci = new LinkedList<Klient>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM klienci");
            
            String imie, nazwisko, id_a, tel_k, id_k;
            while(result.next()) {
                id_k = result.getString("id_k");
                imie = result.getString("imie");
                nazwisko = result.getString("nazwisko");
                tel_k = result.getString("tel_k");
                id_a = result.getString("id_a");
                klienci.add(new Klient(id_k, imie, nazwisko, tel_k, id_a));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return klienci;
    }
    
    /**
     * Metoda odczytująca tabelę zlecenia z bazy danych
     * @return zawraca listę zawierającą rekordy z bazy
     */
    public List<Zlecenie> selectZlecenia() {
        List<Zlecenie> zlecenia = new LinkedList<Zlecenie>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM zlecenia");
            
            String typ_zl, id_p, id_a, id_k, id_z;
            while(result.next()) {
                id_z = result.getString("id_z");
                typ_zl = result.getString("typ_zl");
                id_a = result.getString("id_a");
                id_p = result.getString("id_p");
                id_k = result.getString("id_k");
                
                zlecenia.add(new Zlecenie(id_z, typ_zl, id_a, id_p, id_k));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return zlecenia;
    }
    
    /**
     * Metoda odczytująca tabelę adresy z bazy danych
     * @return zawraca listę zawierającą rekordy z bazy
     */
    public List<Adres> selectAdresy() {
        List<Adres> adresy = new LinkedList<Adres>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM adresy");
            
            String miejscowosc, ulica, nr_domu, kod, poczta, id_a;
            while(result.next()) {
                id_a = result.getString("id_a");
                miejscowosc = result.getString("miejscowosc");
                ulica = result.getString("ulica");
                nr_domu = result.getString("nr_domu");
                kod = result.getString("kod");
                poczta = result.getString("poczta");
                adresy.add(new Adres(id_a, miejscowosc, ulica, nr_domu, kod, poczta));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return adresy;
    }
 
 
    /**
     * Metoda zamykająca połączenie z bazą danych
     */
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }
    
    /**
     * Metoda wstawiająca listę rekordów do tabeli pracownicy na podstawie podanych danych
     * @param pracownicy lista rekordów do wstawienia
     */
    public void insertListPracownik(List<Pracownik> pracownicy){
        try {
            
          for(int i=-0;i<pracownicy.size();i++){
              insertPracownik(pracownicy.get(i).getImie(), pracownicy.get(i).getNazwisko(), pracownicy.get(i).getRejon(), pracownicy.get(i).getZmiana(), pracownicy.get(i).getTel_p(), pracownicy.get(i).getId_a());    
              
              pracownicy.clear();
          }          
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Pomyślnie utworzono rekordy");
    }
    
    /**
     * Metoda wstawiająca listę rekordów do tabeli adresy na podstawie podanych danych
     * @param adresy lista rekordów do wstawienia
     */
    public void insertListAdres(List<Adres> adresy){
        try {
            
          for(int i=-0;i<adresy.size();i++){
              insertAdres(adresy.get(i).getMiejscowosc(), adresy.get(i).getUlica(), adresy.get(i).getNr_domu(), adresy.get(i).getKod(), adresy.get(i).getPoczta());    
              
              adresy.clear();
          }          
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Pomyślnie utworzono rekordy");
    }
    
    /**
     * Metoda wstawiająca listę rekordów do tabeli klienci na podstawie podanych danych
     * @param klienci lista rekordów do wstawienia
     */
    public void insertListKlient(List<Klient> klienci){
        try {
            
          for(int i=-0;i<klienci.size();i++){
              insertKlient(klienci.get(i).getImie(), klienci.get(i).getNazwisko(), klienci.get(i).getTel_k(), klienci.get(i).getId_a());    
              
              klienci.clear();
          }          
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Pomyślnie utworzono rekordy");
    }
    
    /**
     * Metoda wstawiająca listę rekordów do tabeli zlecenia na podstawie podanych danych
     * @param zlecenia lista rekordów do wstawienia
     */
    public void insertListZlecenia(List<Zlecenie> zlecenia){
        try {
            
          for(int i=-0;i<zlecenia.size();i++){
              insertZlecenie(zlecenia.get(i).getTyp_zl(), zlecenia.get(i).getId_a(), zlecenia.get(i).getId_p(), zlecenia.get(i).getId_k());    
              zlecenia.clear();
          }          
        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Pomyślnie utworzono rekordy");
    }
    
    
    /**
     * Metoda czyszcząca bazę danych
     */
    public void clearall(){
       
        try{
        String sql = "DELETE from pracownicy;";
        stat.executeUpdate(sql);
        sql = "DELETE from adresy;";
        stat.executeUpdate(sql);
        sql = "DELETE from klienci;";
        stat.executeUpdate(sql);
        sql = "DELETE from zlecenia;";
        stat.executeUpdate(sql);

        } catch ( Exception e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        System.out.println("Wyczysczono baze");
    }
    
    /**
     * Metoda wykonująca dowolne zapytanie do bazy danych
     * @param zapytanie polecenie SQL do wykonania, powinno być zgodne ze składnią Sqlite
     */
    public void wykonajZapytanie(String zapytanie)
    {
        String polecenie = zapytanie;
        rezultat = "";
        
        
        StringTokenizer st = new StringTokenizer(polecenie, " ");
        String firstWord = st.nextToken().toUpperCase();
        if(firstWord.equals("SELECT")){
        
        // wykonywanie zapytan SELECT do bazy
        try {
            ResultSet resultSet = stat.executeQuery(polecenie);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int liczbaKol = rsmd.getColumnCount();
            while (resultSet.next())
            {
                String linia = new String();
                for (int i=1; i<=liczbaKol; i++)
                {
                    if (i>1) linia = linia + " ";
                        linia = linia + resultSet.getString(i);
                }
                rezultat += linia+"\n";
            }
            
            System.out.println(rezultat);
            
        } catch (SQLException ex) {
            System.out.println("! Wystapil blad podczas proby wykonania zapytania do bazy danych!!!");
        }
    }
        else if(firstWord.equals("INSERT") || firstWord.equals("DELETE") || firstWord.equals("UPDATE"))
        {
            // wykonywanie zapytan INSERT/DELETE/UPDATE do bazy
            try {
                int wynikUpdate = stat.executeUpdate(polecenie);
                if(wynikUpdate > 0)
                    System.out.println("Liczba zmodyfikowanych rekordow: " + wynikUpdate);
                else
                    System.out.println("Nie zmodyfikowano zadnego rekordu");
            } catch (SQLException ex) {
                System.out.println("! Wystąpił błąd podczas próby aktualizacji bazy danych!!!");
            }
        }
    }
}