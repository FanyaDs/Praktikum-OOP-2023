/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasBab7;

/**
 *
 * @author - LENOVO -
 */
public class PolimorfismeInvestasi extends Investasi{
    
    // Konstruktor
    public PolimorfismeInvestasi() {
        super();
    }

    // Override method dataTotalInvestasi dari class Investasi
    @Override
    public double dataTotalInvestasi() {
        // Implementasi baru sesuai kebutuhan polimorfisme
        return super.dataTotalInvestasi() + 500; // Contoh: Menambahkan nilai konstan 500
    }

    // Override method getcetakSaldo dari class Pengelolaan_Keuangan_Pribadi
    @Override
    public double getcetakSaldo() {
        // Implementasi baru sesuai kebutuhan polimorfisme
        return super.getcetakSaldo() + 200; // Contoh: Menambahkan nilai konstan 200
    }    
}
