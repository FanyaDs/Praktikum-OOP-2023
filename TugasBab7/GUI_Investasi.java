/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package TugasBab7;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author - LENOVO -
 */
public class GUI_Investasi extends javax.swing.JFrame {

    /**
     * Creates new form GUI_Investasi
     */
    public GUI_Investasi() {
        initComponents();
        
        DefaultTableModel dataModel = (DefaultTableModel) Tabel_Investasi.getModel();
        
        int rowCount = dataModel.getRowCount();
        while (rowCount > 0) {
            dataModel.removeRow(rowCount -1);
            rowCount = dataModel.getRowCount();            
        }
        
        Investasi ivs = new Investasi();
        txt_Keuntungan.setText(Double.toString(ivs.getKeuntungan()));
        txt_Keuntungan.setEnabled(false);
    }
    
    public void clear () {
        txt_InvestasiAwal.setText(""); 
        txt_bulan.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_proses = new javax.swing.JButton();
        cmb_rencana = new javax.swing.JComboBox<>();
        txt_bulan = new javax.swing.JTextField();
        txt_InvestasiAwal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_Keuntungan = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabel_Investasi = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("INVESTASI");

        jLabel2.setText("Rencana Investasi");

        jLabel3.setText("Bulan");

        jLabel5.setText("Investasi");

        btn_proses.setBackground(new java.awt.Color(204, 255, 255));
        btn_proses.setText("PROSES");
        btn_proses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prosesActionPerformed(evt);
            }
        });

        cmb_rencana.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendidikan", "Travelling", "Properti", "Dll" }));
        cmb_rencana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_rencanaActionPerformed(evt);
            }
        });

        txt_bulan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bulanActionPerformed(evt);
            }
        });

        txt_InvestasiAwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_InvestasiAwalActionPerformed(evt);
            }
        });

        jLabel4.setText("Keuntungan");

        txt_Keuntungan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_KeuntunganActionPerformed(evt);
            }
        });

        Tabel_Investasi.setBackground(new java.awt.Color(204, 255, 255));
        Tabel_Investasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "RENCANA INVESTASI", "BULAN", "INVESTASI BULAN INI", "TOTAL KEUNTUNGAN"
            }
        ));
        jScrollPane2.setViewportView(Tabel_Investasi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_proses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(cmb_rencana, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(txt_bulan))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(68, 68, 68)
                                .addComponent(txt_InvestasiAwal))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(txt_Keuntungan)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmb_rencana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_bulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_InvestasiAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_Keuntungan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_proses)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_proses.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_prosesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prosesActionPerformed
        // TODO add your handling code here:
        
         // Menampilkan pesan dialog bahwa data telah ditambahkan ke tabel
        JOptionPane.showMessageDialog(null, "Data Sukses Ditambahkan");
        // Mengambil model data dari tabel
        DefaultTableModel dataModel = (DefaultTableModel) 
        Tabel_Investasi.getModel();
        // Inisialisasi sebuah ArrayList bernama 'list'
        List list = new ArrayList<>();
        // Mengatur tabel untuk membuat kolom dari model secara otomatis
        Tabel_Investasi.setAutoCreateColumnsFromModel(true);
        
        Investasi ivs = new Investasi();
            ivs.setdataBulan(txt_bulan.getText());
            ivs.setInvestasiAwal(Double.parseDouble(txt_InvestasiAwal.getText())); 
            ivs.setKeuntungan(Double.parseDouble(txt_Keuntungan.getText()));
            String R = cmb_rencana.getSelectedItem().toString();
            
            list.add(R);
            list.add(ivs.getcetakBulan());
            list.add(ivs.getInvestasiAwal());
            list.add(ivs.dataTotalInvestasi());   
            
            dataModel.addRow(list.toArray());
        // Memanggil fungsi 'clear' untuk membersihkan nilai dari komponen keculai Tenggat Bayar
        clear();
            
    }//GEN-LAST:event_btn_prosesActionPerformed

    private void txt_bulanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bulanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bulanActionPerformed

    private void txt_InvestasiAwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_InvestasiAwalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_InvestasiAwalActionPerformed

    private void cmb_rencanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_rencanaActionPerformed
        // TODO add your handling code here:           
           
    }//GEN-LAST:event_cmb_rencanaActionPerformed

    private void txt_KeuntunganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_KeuntunganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_KeuntunganActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(GUI_Investasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Investasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Investasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Investasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Investasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabel_Investasi;
    private javax.swing.JButton btn_proses;
    private javax.swing.JComboBox<String> cmb_rencana;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txt_InvestasiAwal;
    private javax.swing.JTextField txt_Keuntungan;
    private javax.swing.JTextField txt_bulan;
    // End of variables declaration//GEN-END:variables
}
