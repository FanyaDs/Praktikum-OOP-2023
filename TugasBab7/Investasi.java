/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasBab7;

/**
 *
 * @author - LENOVO -
 */
public class Investasi extends Pengelolaan_Keuangan_Pribadi{       
    
    //ATRIBUT
    private String rencanaInvestasi; 
    private double investasiAwal; 
    private double keuntungan;    
    private double totalInvestasi;  
    
    //KONSTRUKTOR
    public Investasi () {
        this.keuntungan = 7;
    }
    
    //SETTER
    public void setRencanaInvestasi (String RencanaInvestasi) {
        this.rencanaInvestasi = RencanaInvestasi;
    }
    
    public void setInvestasiAwal (double InvestasiAwal) {
        this.investasiAwal = InvestasiAwal;
    }
    
    public void setKeuntungan (double Keuntungan) {
        this.keuntungan = Keuntungan;
    }
    
    public void setTotalInvestasi (double TotalInvestasi) {
        this.totalInvestasi = TotalInvestasi;
    }
    
    //GETTER
    public String getRencanaInvestasi () {
        return rencanaInvestasi;
    }    
    
    public double getInvestasiAwal () {
        return investasiAwal;
    } 
    
    public double getKeuntungan () {
        return keuntungan;
    }
    
    public double getTotalInvestasi () {
        return totalInvestasi;
    }
    
    public double dataTotalInvestasi () {
        return investasiAwal + (investasiAwal * (keuntungan / 100));
    }
    
    //OVERIDDING
    @Override
    public double getcetakSaldo() {
        return super.getcetakSaldo() + totalInvestasi;
    }    
    
   
}


   
