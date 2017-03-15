/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektpo;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *Klasa dla okna wyświetlanego gdy użytkownik chce zobaczyć zawartość bazy
 * @author Michał Rembisz
 */
public class WyswietlFrame extends javax.swing.JFrame {

    /**
     * Creates new form TabeleFrame
     */
    private javax.swing.JFrame thisFrame;
    private DefaultTableModel model;
    
    public WyswietlFrame() {
        initComponents();
    }
    /**
     * Metoda ta powoduje, że kod, który jest umieszczony w metodzie run zostanie wykonany na pewno przez wątek uruchomiony przez klasy Swing - konkretniej przez wątek służący do 
     * obsługi interfejsu graficznego. Powodem tego jest to iż kod biblioteki Swing nie jest wielowątkowy.
     * Ponieważ obsługą interfejsu zajmuje się już jeden konkretny wątek, to wszystko co zmienia ten interfejs musi być uruchomione z tego właśnie wątku. 
     * Przekazuje do invokeLater() klasę poruszaną przez ten sam wątek. To co przekazuje, to klasa anonimowa implementująca interfejs Runnable.
     */
    public void display(){
          java.awt.EventQueue.invokeLater(new Runnable() {
              /**
               * metoda tworząca nowy obiekt tej klasy i ukrywająca go
               */
            public void run() {
                thisFrame=new WyswietlFrame();
                thisFrame.setVisible(false);
               
                
            }
        });
    }
    
   
  /**
   * Metoda pobierająca wartości i dodająca je w wierszu do obiektu jTable2 z klasy WyswietlFrame
   * @param s1 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 0 kolumnie dla Pracownika
   * @param s2 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 1 kolumnie dla Pracownika
   * @param s3 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 2 kolumnie dla Pracownika
   * @param s4 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 3 kolumnie dla Pracownika
   * @param s5 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 4 kolumnie dla Pracownika
   * @param s6 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 5 kolumnie dla Pracownika
   * @param s7 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 6 kolumnie dla Pracownika
   */
    public void addNewRowsPracownicy(String s1,String s2,String s3,String s4 ,String s5,String s6, String s7){
      
       model=(DefaultTableModel)jTable2.getModel();
       model.addRow(new Object[]{s1,s2,s3,s4,s5,s6,s7});
       
           
    }
    /**
     * Metoda pobierająca wartości i dodająca je w wierszu do obiektu jTable4 z klasy WyswietlFrame
     * @param s1 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 0 kolumnie dla Adresu
     * @param s2 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 1 kolumnie dla Adresu
     * @param s3 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 2 kolumnie dla Adresu
     * @param s4 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 3 kolumnie dla Adresu
     * @param s5 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 4 kolumnie dla Adresu
     * @param s6 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 5 kolumnie dla Adresu 
     */
     public void addNewRowsAdresy(String s1,String s2,String s3,String s4 ,String s5,String s6){
      
       model=(DefaultTableModel)jTable4.getModel();
       model.addRow(new Object[]{s1,s2,s3,s4,s5,s6});
           
    }
     /**
      * Metoda pobierająca wartości i dodająca je w wierszu obiektu do jTable3 z klasy WyswietlFrame
      * @param s1 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 0 kolumnie dla Klienta
      * @param s2 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 1 kolumnie dla Klienta
      * @param s3 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 2 kolumnie dla Klienta
      * @param s4 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 3 kolumnie dla Klienta
      * @param s5 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 4 kolumnie dla Klienta 
      */
     public void addNewRowsKlienci(String s1,String s2,String s3,String s4 ,String s5){
      
       model=(DefaultTableModel)jTable3.getModel();
       model.addRow(new Object[]{s1,s2,s3,s4,s5});
           
    }
     /**
      * Metoda pobierająca wartości i dodająca je w wierszu do obiektu jTable5 z klasy WyswietlFrame
      * @param s1 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 0 kolumnie dla Zlecenia
      * @param s2 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 1 kolumnie dla Zlecenia
      * @param s3 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 2 kolumnie dla Zlecenia
      * @param s4 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 3 kolumnie dla Zlecenia
      * @param s5 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 4 kolumnie dla Zlecenia
      */
      public void addNewRowsZlecenia(String s1,String s2,String s3,String s4 ,String s5){
      
       model=(DefaultTableModel)jTable5.getModel();
       model.addRow(new Object[]{s1,s2,s3,s4,s5});
           
    }
      
      /**
       * Metoda aktualizująca dany wiersz z obiektu jTable2 z klasy WyswietlFrame
       * @param selectRow zmienna odpowiadająca za numer wiersza do aktualizacji
       * @param s1 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 0 kolumnie dla Pracownika
       * @param s2 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 1 kolumnie dla Pracownika
       * @param s3 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 2 kolumnie dla Pracownika
       * @param s4 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 3 kolumnie dla Pracownika
       * @param s5 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 4 kolumnie dla Pracownika
       * @param s6 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 5 kolumnie dla Pracownika
       * @param s7 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 6 kolumnie dla Pracownika
       */
    public void updateRowsPracownicy(int selectRow,String s1,String s2,String s3,String s4 ,String s5, String s6, String s7){
      
       model=(DefaultTableModel)jTable2.getModel();
       model.setValueAt(s1, selectRow, 0);
       model.setValueAt(s2, selectRow, 1);
       model.setValueAt(s3, selectRow, 2);
       model.setValueAt(s4, selectRow, 3);
       model.setValueAt(s5, selectRow, 4);
       model.setValueAt(s6, selectRow, 5);
       model.setValueAt(s7, selectRow, 6);
               
    }
    /**
     * Metoda aktualizująca dany wiersz z obiektu jTable4 z klasy WyswietlFrame
     * @param selectRow zmienna odpowiadająca za numer wiersza do aktualizacji
     * @param s1 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 0 kolumnie dla Adresu
     * @param s2 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 1 kolumnie dla Adresu
     * @param s3 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 2 kolumnie dla Adresu
     * @param s4 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 3 kolumnie dla Adresu
     * @param s5 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 4 kolumnie dla Adresu
     * @param s6 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 5 kolumnie dla Adresu
     */
     public void updateRowsAdresy(int selectRow,String s1,String s2,String s3,String s4 ,String s5,String s6){
      
       model=(DefaultTableModel)jTable4.getModel();
       model.setValueAt(s1, selectRow, 0);
       model.setValueAt(s2, selectRow, 1);
       model.setValueAt(s3, selectRow, 2);
       model.setValueAt(s4, selectRow, 3);
       model.setValueAt(s5, selectRow, 4);
       model.setValueAt(s6, selectRow, 5);
               
    }
     /**
      * Metoda aktualizująca dany wiersz z obiektu jTable3 z klasy WyswietlFrame
      * @param selectRow zmienna odpowiadająca za numer wiersza do aktualizacji
      * @param s1 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 0 kolumnie dla Klienta
      * @param s2 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 1 kolumnie dla Klienta
      * @param s3 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 2 kolumnie dla Klienta
      * @param s4 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 3 kolumnie dla Klienta
      * @param s5 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 4 kolumnie dla Klienta 
      */
     public void updateRowsKlienci(int selectRow,String s1,String s2,String s3,String s4 ,String s5){
      
       model=(DefaultTableModel)jTable3.getModel();
       model.setValueAt(s1, selectRow, 0);
       model.setValueAt(s2, selectRow, 1);
       model.setValueAt(s3, selectRow, 2);
       model.setValueAt(s4, selectRow, 3);
       model.setValueAt(s5, selectRow, 4);
               
    }
     /**
      * Metoda aktualizująca dany wiersz z obiektu jTable5 z klasy WyswietlFrame
      * @param selectRow zmienna odpowiadająca za numer wiersza do aktualizacji
      * @param s1 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 0 kolumnie dla Zlecenia
      * @param s2 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 1 kolumnie dla Zlecenia
      * @param s3 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 2 kolumnie dla Zlecenia
      * @param s4 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 3 kolumnie dla Zlecenia
      * @param s5 zmienna pobierająca wartość klasy String odpowiada za wartość wyświetlaną w 4 kolumnie dla Zlecenia
      */
      public void updateRowsZlecenia(int selectRow,String s1,String s2,String s3,String s4 ,String s5){
      
       model=(DefaultTableModel)jTable5.getModel();
       model.setValueAt(s1, selectRow, 0);
       model.setValueAt(s2, selectRow, 1);
       model.setValueAt(s3, selectRow, 2);
       model.setValueAt(s4, selectRow, 3);
       model.setValueAt(s5, selectRow, 4);
     
               
    }
      /**
       * Metoda usuwająca wiersz z obiektu jTable2 z klasy WyswietlFrame
       * @param row zmienna odpowiadająca za numer wiersza do usunięcia
       */
    public void removeRowPracownicy(int row){
        model=(DefaultTableModel)jTable2.getModel();
        model.removeRow(row);
        
    }
      /**
       * Metoda usuwająca wiersz z obiektu jTable4 z klasy WyswietlFrame
       * @param row zmienna odpowiadająca za numer wiersza do usunięcia
       */
    public void removeRowAdresy(int row){
        model=(DefaultTableModel)jTable4.getModel();
        model.removeRow(row);
    }
      /**
       * Metoda usuwająca wiersz z obiektu jTable3 z klasy WyswietlFrame
       * @param row zmienna odpowiadająca za numer wiersza do usunięcia
       */
    public void removeRowKlienci(int row){
        model=(DefaultTableModel)jTable3.getModel();
        model.removeRow(row);
        
    }
      /**
       * Metoda usuwająca wiersz z obiektu jTable5 z klasy WyswietlFrame
       * @param row zmienna odpowiadająca za numer wiersza do usunięcia
       */
    public void removeRowZlecenia(int row){
        model=(DefaultTableModel)jTable5.getModel();
        model.removeRow(row);
    }
    /**
     * Metoda metoda pobierająca numer wiersza dla danego obiektu jTable2 z klasy WyswietlFrame
     * @param key zmienna odpowiadająca za podanie klucza do znalezienia rekordu
     * @return zwraca wartość typu int odpowiadającą za numer wiersza dla danefo obiektu
     */
     public int getRowPracownicy(String key){
         
          model=(DefaultTableModel)jTable2.getModel();
          for(int i=0;i<model.getRowCount();i++){
              if(model.getValueAt(i, 0).equals(key)){
                  return i;
              }
          }
          return 0;
     }
     /**
     * Metoda metoda pobierająca numer wiersza dla danego obiektu jTable4 z klasy WyswietlFrame
     * @param key zmienna odpowiadająca za podanie klucza do znalezienia rekordu
     * @return zwraca wartość typu int odpowiadającą za numer wiersza dla danefo obiektu
     */
      public int getRowAdresy(String key){
         
          model=(DefaultTableModel)jTable4.getModel();
          for(int i=0;i<model.getRowCount();i++){
              if(model.getValueAt(i, 0).equals(key)){
                  return i;
              }
          }
          return 0;
     }
      /**
     * Metoda metoda pobierająca numer wiersza dla danego obiektu jTable3 z klasy WyswietlFrame
     * @param key zmienna odpowiadająca za podanie klucza do znalezienia rekordu
     * @return zwraca wartość typu int odpowiadającą za numer wiersza dla danefo obiektu
     */
      public int getRowKlienci(String key){
         
          model=(DefaultTableModel)jTable3.getModel();
          for(int i=0;i<model.getRowCount();i++){
              if(model.getValueAt(i, 0).equals(key)){
                  return i;
              }
          }
          return 0;
     }
      /**
     * Metoda metoda pobierająca numer wiersza dla danego obiektu jTable5 z klasy WyswietlFrame
     * @param key zmienna odpowiadająca za podanie klucza do znalezienia rekordu
     * @return zwraca wartość typu int odpowiadającą za numer wiersza dla danefo obiektu
     */
       public int getRowZlecenia(String key){
         
          model=(DefaultTableModel)jTable5.getModel();
          for(int i=0;i<model.getRowCount();i++){
              if(model.getValueAt(i, 0).equals(key)){
                  return i;
              }
          }
          return 0;
     }
        
       /**
        * Metoda czyszcząca wszystkie rekordy dla obiektu jTable2 z klasy WyswietlFrame
        */
       public void clearPracownicy(){
          model=(DefaultTableModel)jTable2.getModel();
          for(int i=0;i<model.getRowCount();i++){
             model.removeRow(i);
          }
          jTable2.removeAll();
       }
       /**
        * Metoda czyszcząca wszystkie rekordy dla obiektu jTable4 z klasy WyswietlFrame
        */
        public void clearAdresy(){
          model=(DefaultTableModel)jTable4.getModel();
          for(int i=0;i<model.getRowCount();i++){
             model.removeRow(i);
          }
       }
        /**
        * Metoda czyszcząca wszystkie rekordy dla obiektu jTable3 z klasy WyswietlFrame
        */
        public void clearKlienci(){
          model=(DefaultTableModel)jTable3.getModel();
          for(int i=0;i<model.getRowCount();i++){
             model.removeRow(i);
          }
       }
        /**
        * Metoda czyszcząca wszystkie rekordy dla obiektu jTable5 z klasy WyswietlFrame
        */
         public void clearZlecenia(){
          model=(DefaultTableModel)jTable5.getModel();
          for(int i=0;i<model.getRowCount();i++){
             model.removeRow(i);
          }
       }
   
    
  
        
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        wPrac = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(102, 102, 102));

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_p", "Imię", "Nazwisko", "Rejon", "Zmiana", "tel_p", "Adres"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        wPrac.setViewportView(jTable2);

        jTabbedPane1.addTab("Pracownicy", wPrac);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_a", "Miejscowość", "Ulica", "Nr domu/mieszkania", "Kod", "Poczta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jTabbedPane1.addTab("Adresy", jScrollPane4);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_k", "Imię", "Nazwisko", "Telefon", "Adres"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jTabbedPane1.addTab("Klienci", jScrollPane3);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_z", "typ zlecenia", "id_a", "id_p", "id_k"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable5);

        jTabbedPane1.addTab("Zlecenia", jScrollPane5);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(553, 553, 553)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 702, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 718, 539);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metoda obsługująca zdarzenie dla przycisku jButton1 - obiekt klasy WyswietlFrame
     * @param evt zmienna odpowiadająca za zdarzenie
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane wPrac;
    // End of variables declaration//GEN-END:variables
}
