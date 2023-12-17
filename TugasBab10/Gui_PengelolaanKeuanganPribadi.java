/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TugasBab10;

//masukkan semua import di bawah
        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.util.logging.Level;
        import java.util.logging.Logger;
        import javax.crypto.interfaces.PBEKey;
        import javax.swing.JOptionPane;
        import javax.swing.table.DefaultTableModel;

/**
 *
 * @author - LENOVO -
 */
public class Gui_PengelolaanKeuanganPribadi extends javax.swing.JFrame {
    String Bulan, saldo,pemasukan,pengeluaran,tabungan;

    /**
     * Creates new form Gui_PengelolaanKeuanganPribadi
     */
    public Gui_PengelolaanKeuanganPribadi() {
        
        initComponents();
        tampil();        
        
    }
    
    public Connection conn;
    
    public void batal () {
        txtBulan.setText("");
        txtPemasukan.setText("");
        txtPengeluaran.setText("");
        txtTabungan.setText("");   
        txtSaldo.setText("");
    }
    
    public void itempilih() {
        txtBulan.setText(Bulan);
        txtPemasukan.setText(pemasukan);
        txtPengeluaran.setText(pengeluaran);
        txtTabungan.setText(tabungan);
        txtSaldo.setText(saldo);
    }
    
    //masukkan method koneksi()
    public void koneksi() throws SQLException {
        try {
            conn = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/prakoopbab10_2218068?user=root&password=");
            System.out.println("Terkoneksi");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Gui_PengelolaanKeuanganPribadi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(Gui_PengelolaanKeuanganPribadi.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception es) {
            Logger.getLogger(Gui_PengelolaanKeuanganPribadi.class.getName()).log(Level.SEVERE, null, es);
        }
    }
    
    public void tampil () {
        DefaultTableModel tabelhead = new DefaultTableModel();
        tabelhead.addColumn("Bulan");
        tabelhead.addColumn("Saldo Awal");
        tabelhead.addColumn("Pemasukan");
        tabelhead.addColumn("Pengeluaran");
        tabelhead.addColumn("Tabungan");
        try {
            koneksi();
            String sql = "SELECT * FROM tb_pengelolaankeuanganpribadi";
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery(sql);
            while (res.next()) {
                tabelhead.addRow(new Object[]{res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6)});
            }
            tabel_keuanganku.setModel(tabelhead);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "BELUM TERKONEKSI" );
        }
    }
    
    //masukkan method delete()
    public void delete() {
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                String sql = "DELETE FROM tb_pengelolaankeuanganpribadi WHERE bulan='" + txtBulan.getText() + "'";
                java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
                batal();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal di hapus");
            }
        }
        refresh();
    }
    
    //masukkan method cari()
    public void cari() {
        try {
            try ( Statement statement = conn.createStatement()) {
                String sql = "SELECT * FROM tb_pengelolaankeuanganpribadi WHERE `bulan`  LIKE '%" + btn_search.getText() + "%'";
                ResultSet rs = statement.executeQuery(sql); //menampilkan data dari sql query
                if (rs.next()) // .next() = scanner method
                {
                    txtBulan.setText(rs.getString(2));
                    txtPemasukan.setText(rs.getString(3));
                    txtPemasukan.setText(rs.getString(4));
                    txtPengeluaran.setText(rs.getString(5));
                    txtSaldo.setText(rs.getString(6));
                } else {
                    JOptionPane.showMessageDialog(null, "Data yang Anda cari tidak ada");
                }
            }
        } catch (Exception ex) {
            System.out.println("Error." + ex);
        }
    }
    
    //masukkan method update()
    public void update() {
        String Bulan = txtBulan.getText();
        Integer Pemasukan = Integer.parseInt(txtPemasukan.getText());
        Integer Pengeluaran = Integer.parseInt(txtPengeluaran.getText());
        Integer Tabungan = Integer.parseInt(txtTabungan.getText());
        Integer Saldo = Integer.parseInt(txtSaldo.getText());
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate("UPDATE tb_pengelolaankeuanganpribadi SET Bulan='" + Bulan + "',"
                    + "Saldo_Bawaan='" + Saldo + "'" + ",Pemasukan='" + Pemasukan + "',Pengeluaran='" + Pengeluaran + "',Tabungan='"
                    + Tabungan + "'" );
            statement.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Update Data Berhasil!");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        refresh();
    }
    
    //masukkan method refresh()
    public void refresh() {
        new Gui_PengelolaanKeuanganPribadi().setVisible(true);
        this.setVisible(false);
    }
    
    //masukkan method insert()
    public void insert() {        
               
        String bulan = txtBulan.getText();
        Integer Pemasukan = Integer.parseInt(txtPemasukan.getText());
        Integer pengeluaran = Integer.parseInt(txtPengeluaran.getText());
        Integer tabungan = Integer.parseInt(txtTabungan.getText());
        Integer Saldo = Integer.parseInt(txtSaldo.getText());
        try {
            koneksi();
            Statement statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO tb_pengelolaankeuanganpribadi (Bulan, Saldo_Bawaan, Pemasukan, Pengeluaran, Tabungan) "
                    + "VALUES('" + bulan + "','" + Saldo + "','" + Pemasukan + "','" + pengeluaran + "','" + tabungan + "')");
            statement.close();
            JOptionPane.showMessageDialog(null, "Berhasil Memasukan Data!" + "\n" + bulan);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!" + e);
        }
        refresh();
    }
    
    



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        txtPemasukan = new javax.swing.JTextField();
        txtPengeluaran = new javax.swing.JTextField();
        txtTabungan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBulan = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabel_keuanganku = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btn_search = new javax.swing.JButton();
        btn_bulan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnHapus1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("KEUANGANKU");

        jLabel2.setText("Saldo Awal");

        jLabel3.setText("Pemasukan");

        jLabel4.setText("Pengeluaran");

        jLabel7.setText("Tabungan");

        tabel_keuanganku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BULAN", "SALDO SAAT INI", "PEMASUKAN", "PENGELUARAN", "TABUNGAN"
            }
        ));
        tabel_keuanganku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_keuangankuMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabel_keuanganku);

        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("BATAL");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnClose.setText("CLOSE");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        btn_bulan.setText("Pembayaran");
        btn_bulan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bulanActionPerformed(evt);
            }
        });

        jLabel5.setText("Bulan");

        btnHapus1.setText("UPDATE");
        btnHapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapus1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(243, 243, 243))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTabungan)
                                    .addComponent(txtPemasukan)
                                    .addComponent(txtSaldo)
                                    .addComponent(txtBulan)
                                    .addComponent(txtPengeluaran)))
                            .addComponent(jScrollPane4))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_search))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_bulan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnHapus1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_search)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPemasukan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPengeluaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTabungan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnBatal)
                    .addComponent(btnClose)
                    .addComponent(btnHapus)
                    .addComponent(btnHapus1))
                .addGap(12, 12, 12)
                .addComponent(btn_bulan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        
        insert();
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        
        delete();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        
        batal();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        
        cari();
    }//GEN-LAST:event_btn_searchActionPerformed

    private void tabel_keuangankuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_keuangankuMouseClicked
        // TODO add your handling code here:
        
        int tabel = tabel_keuanganku.getSelectedRow();
        Bulan = tabel_keuanganku.getValueAt(tabel, 0).toString();
        saldo = tabel_keuanganku.getValueAt(tabel, 1).toString();
        pemasukan = tabel_keuanganku.getValueAt(tabel, 2).toString();
        pengeluaran = tabel_keuanganku.getValueAt(tabel, 3).toString();
        tabungan = tabel_keuanganku.getValueAt(tabel, 4).toString();
        itempilih();
    }//GEN-LAST:event_tabel_keuangankuMouseClicked

    private void btn_bulanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bulanActionPerformed
        // TODO add your handling code here:
        
        new GUI_Pembayaran().setVisible(true);
    }//GEN-LAST:event_btn_bulanActionPerformed

    private void btnHapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapus1ActionPerformed
        // TODO add your handling code here:
        
        update();
    }//GEN-LAST:event_btnHapus1ActionPerformed

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
            java.util.logging.Logger.getLogger(Gui_PengelolaanKeuanganPribadi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui_PengelolaanKeuanganPribadi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui_PengelolaanKeuanganPribadi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui_PengelolaanKeuanganPribadi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui_PengelolaanKeuanganPribadi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnHapus1;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btn_bulan;
    private javax.swing.JButton btn_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tabel_keuanganku;
    private javax.swing.JTextField txtBulan;
    private javax.swing.JTextField txtPemasukan;
    private javax.swing.JTextField txtPengeluaran;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtTabungan;
    // End of variables declaration//GEN-END:variables
}
