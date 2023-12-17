/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasBab10;

/**
 *
 * @author - LENOVO -
 */
public class Pembayaran extends Abstract_Sisa implements InterfacePembayaran{ 
    
    //ATRIBUT
    private double bayar;
    
    //SETTER
    public void setBayar (double Bayar) {
        this.bayar = Bayar;
    }
    
    //GETTER
    public double getBayar () {
        return bayar;
    }        
    
    //KONSTRUKTOR
    public Pembayaran () {
        this.getcetakSaldo();
    }    
    
    @Override
    double dataHitungPembayaran () {
        return getcetakSaldo() - bayar;        
    }
    
    //OVERIDDING
    @Override
    public double getcetakSaldo() {
        return super.getcetakSaldo();
    } 
}
