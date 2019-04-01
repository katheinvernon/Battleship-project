/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship_proyecto;

/**
 *
 * @author Katherine
 */
public class BarcoHabilidad1 extends Barco {
    
    public BarcoHabilidad1 (int tamaño, int vida_partes, boolean pc) {
        super(tamaño, vida_partes+1, pc);
        
    }
    
}
