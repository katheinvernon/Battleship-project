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
public class Partes_Barco {
    
    private char identificador; //Guardara el caracter que se imprimira en pantalla al dar el mapa
    private int vidas; // Vida entera : O, Segunda media : •, Vida baja : o, Destruido : + 
    private boolean PC; // Identifica si es una parte para los barcos de la computadora

    public Partes_Barco() { //Este constructor creara las partes de barco que enrealidad seran agua, se inicializara siempre.
        this.identificador = '~';
    }
    
    public Partes_Barco(boolean pc, int vidas) { //Este constructor crea las partes de un barco para la computadora, las cuales comenzaran con el caracter de "Vida entera" 
        this.PC = pc;
        this.vidas = vidas;
        if(pc)
            this.identificador = '~';
        else
            this.identificador = 'O';
    }

    public char getIdentificador() {
        return identificador;
    }

    public int getVidas() {
        return vidas;
    }

    public boolean isPC() {
        return PC;
    }

    public void setIdentificador(char identificador) {
        this.identificador = identificador;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public void setPC(boolean PC) {
        this.PC = PC;
    }
    
}
