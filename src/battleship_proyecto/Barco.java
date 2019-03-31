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
public class Barco {
    
    protected int tamaño, vida_Total, vida_partes;
    protected boolean pc;
    protected Partes_Barco[] barco; //El barco estara hecho por un arreglo de Partes_Barco

    public Barco(int tamaño, int vida_partes, boolean pc) { //Barcos para la maquina
        this.pc = pc;
        this.tamaño = tamaño;
        this.vida_Total = vida_partes*tamaño; //El barco siempre tendra una vida total igual a su tamaño por las vidas iniciales de sus partes
        this.barco = new Partes_Barco[tamaño];
        
        for (int i = 0; i < tamaño; i++) {
            
            barco[i] = new Partes_Barco(pc, vida_partes); //Se utiliza el segundo constructor de la clase Paartes_Barco
        }
    }
    
    protected int actualizarVidaTotal(){ //Devuelve y actualiza la vidad total de un barco 
        
        int nuevoTotal = 0;
        
        for( Partes_Barco barcoVidas : barco ){
                
           nuevoTotal += barcoVidas.getVidas();
        }
        
        this.setVida_Total(nuevoTotal);
        return nuevoTotal;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public int getVida_Total() {
       return vida_Total;
    }

    public void setVida_Total(int vida_Total) {
        this.vida_Total = vida_Total;
    }

    public int getVida_partes() {
        return vida_partes;
    }

    public void setVida_partes(int vida_partes) {
        this.vida_partes = vida_partes;
    }

    public Partes_Barco[] getBarco() {
        return barco;
    }

    public void setBarco(Partes_Barco[] barco) {
        this.barco = barco;
    }
    
}
