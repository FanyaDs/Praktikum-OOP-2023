/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasBab10;


/**
 *
 * @author - LENOVO -
 */
public class Pengelolaan_Keuangan_Pribadi {
    //ATRIBUT
    private String bulan,tahun, jumlahHari; 
    private double saldo; 
    private int pemasukan;
    private int pengeluaran;
    private int tabungan ;
    
    //KONSTRUKTOR
    public Pengelolaan_Keuangan_Pribadi () {
        this.saldo = 7000000 + pemasukan;
    }
    
    //METHOD & SETTER
    public void setdataBulan(String bulan){
        this.bulan = bulan;
    }
    public void setdataSaldo(double saldo){
        this.saldo = saldo + pemasukan;
    }
    public void setdataPemasukan(int pemasukan){
        this.pemasukan = pemasukan;
    }
    public void setdataPengeluaran(int pengeluaran){
        this.pengeluaran = pengeluaran;
    }
    public void setdataTabungan(int tabungan){
        this.tabungan = tabungan;
    }   
    
    //OVERLOADING 
    // Metode overload dua parameter (bulan dan tahun)
    public void setDataBulan(String bulan, String tahun) {
        this.bulan = bulan;
        this.tahun = tahun; 
    }

    // Metode overload tiga parameter (bulan, tahun, dan jumlahHari)
    public void setDataBulan(String bulan, String tahun, String jumlahHari) {
        this.bulan = bulan;
        this.tahun = tahun;
        this.jumlahHari = jumlahHari; 
    }

        
    //GETTER        
    public String getcetakBulan(){
        return bulan;
    }  
    
    public double getcetakSaldo(){
        return saldo + pemasukan;
    }
    public int getcetakPemasukan(){
        return pemasukan;
    }
    public int getcetakPengeluaran(){
        return pengeluaran;
    }
    public int getcetakTabungan(){
        return tabungan;
    }      
    
    
    // Getter dan setter tambahan untuk "tahun" dan "jumlahHari" jika belum didefinisikan
    public String getTahun() {
        return tahun;
    }

    public String getJumlahHari() {
        return jumlahHari;
    }

    public void setJumlahHari(String jumlahHari) {
        this.jumlahHari = jumlahHari;
    }    

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }   
    
}
