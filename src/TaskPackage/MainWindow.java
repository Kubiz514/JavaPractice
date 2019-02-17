package TaskPackage;

import java.awt.Color;
import java.awt.Component;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 * @author Jakub Płoch
 */
public class MainWindow extends javax.swing.JFrame {

    String[] StatesStrings = {"Nie rozpoczęty","W trakcie","Bardzo ważny","Zakończony"};
    String[] DefaultTableValues = {"Wpisz tytuł","Wpisz opis","wybierz...", ""};
    
    public MainWindow() {
        super("Lista zadań");
        initComponents();
        MainTable.getTableHeader().setReorderingAllowed(false);
        MainTable.setShowGrid(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DeleteDialog = new javax.swing.JDialog();
        CanceDeletelButton = new javax.swing.JButton();
        ConfirmDeleteButton = new javax.swing.JButton();
        QuestionLabel = new javax.swing.JLabel();
        ClearDialog = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        CancelClearButton = new javax.swing.JButton();
        ConfirmClearButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MainTable = new javax.swing.JTable(){
            public Component prepareRenderer(
                TableCellRenderer renderer, int row, int column){
                Component c = super.prepareRenderer(renderer, row, column);
                {
                    c.setBackground(getBackground());
                    int modelRow = convertRowIndexToModel(row);
                    String type = (String)getModel().getValueAt(modelRow, 2);
                    switch(type){
                        case "Zakończony":
                        c.setBackground(new Color(71,203,111));
                        break;
                        case "W trakcie":
                        c.setBackground(new Color(72,136,184));
                        break;
                        case "Bardzo ważny":
                        c.setBackground(new Color(255,184,89));
                        break;
                        case "Nie rozpoczęty":
                        c.setBackground(new Color(255,232,228));
                        break;
                        case "wybierz...":
                        c.setBackground(Color.WHITE);
                        break;
                        default:
                        c.setBackground(Color.WHITE);
                        break;
                    }
                }

                return c;
            }

        };
        TopPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        OpenButon = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        AddButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();

        DeleteDialog.setAlwaysOnTop(true);
        DeleteDialog.setLocation(new java.awt.Point(0, 0));
        DeleteDialog.setMinimumSize(new java.awt.Dimension(220, 100));
        DeleteDialog.setResizable(false);

        CanceDeletelButton.setText("Nie");
        CanceDeletelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CanceDeletelButtonActionPerformed(evt);
            }
        });

        ConfirmDeleteButton.setText("Tak");
        ConfirmDeleteButton.setMaximumSize(new java.awt.Dimension(220, 100));
        ConfirmDeleteButton.setMinimumSize(new java.awt.Dimension(220, 100));
        ConfirmDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmDeleteButtonActionPerformed(evt);
            }
        });

        QuestionLabel.setText("Czy na pewno chcesz usunąć zadnie? ");

        javax.swing.GroupLayout DeleteDialogLayout = new javax.swing.GroupLayout(DeleteDialog.getContentPane());
        DeleteDialog.getContentPane().setLayout(DeleteDialogLayout);
        DeleteDialogLayout.setHorizontalGroup(
            DeleteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteDialogLayout.createSequentialGroup()
                .addGroup(DeleteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DeleteDialogLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(CanceDeletelButton)
                        .addGap(40, 40, 40)
                        .addComponent(ConfirmDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DeleteDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(QuestionLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DeleteDialogLayout.setVerticalGroup(
            DeleteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeleteDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(QuestionLabel)
                .addGap(18, 18, 18)
                .addGroup(DeleteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CanceDeletelButton)
                    .addComponent(ConfirmDeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ClearDialog.setLocation(new java.awt.Point(0, 0));
        ClearDialog.setResizable(false);

        jLabel2.setText("Usunąć WSZYSTKIE zadania?");
        jLabel2.setMaximumSize(new java.awt.Dimension(220, 100));
        jLabel2.setMinimumSize(new java.awt.Dimension(220, 100));

        CancelClearButton.setText("Nie");
        CancelClearButton.setMaximumSize(new java.awt.Dimension(220, 100));
        CancelClearButton.setMinimumSize(new java.awt.Dimension(220, 100));
        CancelClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelClearButtonActionPerformed(evt);
            }
        });

        ConfirmClearButton.setText("Tak");
        ConfirmClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmClearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ClearDialogLayout = new javax.swing.GroupLayout(ClearDialog.getContentPane());
        ClearDialog.getContentPane().setLayout(ClearDialogLayout);
        ClearDialogLayout.setHorizontalGroup(
            ClearDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClearDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CancelClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ConfirmClearButton)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ClearDialogLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        ClearDialogLayout.setVerticalGroup(
            ClearDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClearDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ClearDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConfirmClearButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        MainTable.setAutoCreateRowSorter(true);
        MainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tytuł", "opis", "status", "data dodania"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MainTable.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        MainTable.setGridColor(new java.awt.Color(0, 51, 255));
        MainTable.setRowHeight(30);
        MainTable.setSelectionBackground(new java.awt.Color(255, 0, 0));
        MainTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        MainTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(MainTable);
        if (MainTable.getColumnModel().getColumnCount() > 0) {
            MainTable.getColumnModel().getColumn(0).setResizable(false);
            MainTable.getColumnModel().getColumn(0).setPreferredWidth(40);
            MainTable.getColumnModel().getColumn(1).setResizable(false);
            MainTable.getColumnModel().getColumn(1).setPreferredWidth(150);
            MainTable.getColumnModel().getColumn(2).setResizable(false);
            MainTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setText("Jakub Płoch 1a");

        OpenButon.setText("Otwórz");
        OpenButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenButonActionPerformed(evt);
            }
        });

        SaveButton.setText("Zapisz");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
        TopPanel.setLayout(TopPanelLayout);
        TopPanelLayout.setHorizontalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
                .addComponent(OpenButon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SaveButton)
                .addContainerGap())
        );
        TopPanelLayout.setVerticalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OpenButon)
                    .addComponent(SaveButton))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        AddButton.setText("Dodaj");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Usuń zazaczone zadanie");
        DeleteButton.setToolTipText("");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        ClearButton.setText("WYczyść tabelę");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ClearButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton)
                    .addComponent(DeleteButton)
                    .addComponent(ClearButton)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        AddRow(DefaultTableValues, true);
    }//GEN-LAST:event_AddButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        ShowDeleteDialog();   
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void CanceDeletelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CanceDeletelButtonActionPerformed
        HideConfirmDeleteDialog();
    }//GEN-LAST:event_CanceDeletelButtonActionPerformed

    private void ConfirmDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmDeleteButtonActionPerformed
        DeleteRow();
        HideConfirmDeleteDialog();
    }//GEN-LAST:event_ConfirmDeleteButtonActionPerformed

    private void OpenButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenButonActionPerformed
        OpenFile();
    }//GEN-LAST:event_OpenButonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        SaveToFile();
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        ShowClearDialog();
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void CancelClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelClearButtonActionPerformed
        HideConfirmClearDialog();
    }//GEN-LAST:event_CancelClearButtonActionPerformed

    private void ConfirmClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmClearButtonActionPerformed
        ClearTable();
        HideConfirmClearDialog();
    }//GEN-LAST:event_ConfirmClearButtonActionPerformed
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    
    private void AddRow(String[] data, boolean isNew){
        //Dodaje nowy rząd do tabeli
        DefaultTableModel tableModel = (DefaultTableModel)MainTable.getModel();
        //Dodaje datę utworzenia zadnia do danych jeśli rząd nie jet wczytywany
        if (isNew){
            data[MainTable.getColumn("data dodania").getModelIndex()] = getTime();
        }
        tableModel.addRow(data);
        
        //Tworzy comboBox w każdym nowym rzędzie
        JComboBox StatusComboBox = new JComboBox();
        StatusComboBox.setModel(new DefaultComboBoxModel(StatesStrings));
        MainTable.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(StatusComboBox));
    }
    
    private String getTime(){
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy");
        String formattedDate = dateFormat.format(currentDate);
        return formattedDate;
    }
    
    private void ClearTable(){
        DefaultTableModel tableModel = (DefaultTableModel)MainTable.getModel();
        tableModel.setRowCount(0);
    }
    
    private void ShowDeleteDialog(){
        if (!MainTable.getSelectionModel().isSelectionEmpty()) {
            DeleteDialog.setVisible(true);
        }
    }
    
    private void ShowClearDialog(){
        ClearDialog.setSize(220, 100);
        ClearDialog.setVisible(true);
    }
    
    private void HideConfirmDeleteDialog(){
        DeleteDialog.setVisible(false);
    }
    
    private void HideConfirmClearDialog(){
        ClearDialog.setVisible(false);
    }
    
    private void DeleteRow(){
        try{
            DefaultTableModel model = (DefaultTableModel)MainTable.getModel();
            int SelectedRowNumber = MainTable.getSelectedRow();
            model.removeRow(SelectedRowNumber);
        }catch(Exception ex){
            System.out.println(ex.fillInStackTrace());
        }
    }
    
    private void OpenFile(){
        final JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Wybierz plik tekstowy");
        chooser.setAcceptAllFileFilterUsed(false);
	FileNameExtensionFilter filter = new FileNameExtensionFilter("pliki txt oraz csv","csv","txt");
        chooser.addChoosableFileFilter(filter);
        int returnValue = chooser.showOpenDialog(MainWindow.this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File inputFile = chooser.getSelectedFile();
            try{
                ClearTable();
                Scanner scanner = new Scanner(inputFile);
                while (scanner.hasNext()) {
                    String line = scanner.next();
                    //Dane muszą zawierać znak '_' zamiast znaku spacji, inaczej scanner je pominie
                    line = line.replace('_', ' ');
                    String[] values = line.split(",");
                    AddRow(values, false);
                }
                scanner.close();
            } catch (FileNotFoundException e){
            System.out.println("Cannot open file!");
        }
        } 
    }
    
    private void SaveToFile(){
        final JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Wybierz plik tekstowy");
        chooser.setAcceptAllFileFilterUsed(false);
	FileNameExtensionFilter filter = new FileNameExtensionFilter("pliki txt oraz csv","csv","txt");
        chooser.addChoosableFileFilter(filter);
        int returnValue = chooser.showOpenDialog(MainWindow.this);
     
        if (returnValue == JFileChooser.APPROVE_OPTION) {
        File outputFile = chooser.getSelectedFile();
        try {
            FileWriter fWriter = new FileWriter(outputFile.getAbsoluteFile());
            BufferedWriter bWriter = new BufferedWriter(fWriter);
            for (int i = 0; i < MainTable.getRowCount(); i++) {
                for (int j = 0; j < MainTable.getColumnCount(); j++) {   
                    String cellValue = MainTable.getModel().getValueAt(i, j).toString();
                    cellValue = cellValue.replace(" ", "_");
                    bWriter.write(cellValue+",");
                }
                bWriter.write("\n");
            }
            bWriter.close();
            fWriter.close();
            JOptionPane.showMessageDialog(this, "Zapisano.");
        } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }  
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton CanceDeletelButton;
    private javax.swing.JButton CancelClearButton;
    private javax.swing.JButton ClearButton;
    private javax.swing.JDialog ClearDialog;
    private javax.swing.JButton ConfirmClearButton;
    private javax.swing.JButton ConfirmDeleteButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JDialog DeleteDialog;
    private javax.swing.JTable MainTable;
    private javax.swing.JButton OpenButon;
    private javax.swing.JLabel QuestionLabel;
    private javax.swing.JButton SaveButton;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

