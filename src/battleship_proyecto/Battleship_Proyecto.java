/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship_proyecto;

/**
 *
 * @author Daniel
 */
public class Battleship_Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Mapa map = new Mapa();
        
        map.mapaImprimir();
        
        Barco barco1 = new Barco(7, 2, true);
        Barco barco2 = new Barco(7, 2, true);
        Barco barco3 = new Barco(7, 2, true);
        Barco barco4 = new Barco(7, 2, true);
        Barco barco5 = new Barco(7, 2, true);
        Barco barco6 = new Barco(7, 2, true);
        
        Barco barcos[] = { barco1, barco2, barco3, barco4, barco5, barco6};
        
        map.verificarBarcos(barcos);
        map.mapaImprimir();
        
        for (int i = 0; i < 30; i++) {
            map.disparoPC();
        }
        
        
  }
}