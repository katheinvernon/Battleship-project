/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship_proyecto;

import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Partida {
    
    Scanner input = new Scanner (System.in);
    
    //Variables 
    Integer inicio, modo, dificultad, tamaño, nuevoJuego, tamañoBarco, tamañoBarcoPC;
        //Comprabaciones de que las opciones seleccionadas por el usuario sean válidas
    Boolean opcion=false, opcion2=false, opcion3=false, opcion4=false, opcion5=false, opcion6=false; 
            
    public void menuPrincipal () {
    
        do {
            System.out.println("[----- BATTLESHIP -----]");
        
            System.out.println("Deseas:"
                    + "\n[1] Empezar una nuevo juego"
                    + "\n[2] Salir");
           
            inicio = input.nextInt();

            if (inicio == 1) {

                opcion = true;
                
            }
            else if (inicio == 2){
            
                opcion = true;
                
            }
            else {

                System.out.println("Opción inválida, por favor selecciona una opción VÁLIDA");
                opcion = false;
                
            }
           
        }while (!opcion);
    
        if (inicio == 1) {

            nuevaPartida ();
                
        }
        else if (inicio == 2){
            
           System.out.println("****Gracias por jugar****");
                
        }
        
    }
    
    //Función para crear una nueva partida 
    public void nuevaPartida (){
            
        configuracionPartida ();
            
        empezarPartida ();
            
    }
    
    //Función donde el usuario coloca toda la configuración de su partida 
    public void configuracionPartida () {
                                                        
            modoJuego();

            nivelDificultad();

            tamañoMapa();
            
            sextoBarco (); 
            
            nuevoJuego();
                                     
    }
    
    //Función para la selección del modo de juego 
    public void modoJuego() {
        
        do {
            
            System.out.println("Selecciona un modo de juego"
                + "\n[1] Batalla"
                + "\n[2] Campaña");
        
            modo = input.nextInt();

            if (modo == 1) {

                opcion2 = true;
                
            }
            else if (modo == 2){
            
                opcion2 = true;
                
            }
            else {

                System.out.println("Opción inválida, por favor selecciona una opción VÁLIDA");
                opcion2 = false;
                
            }
            
        }while (!opcion2);
    
    }
    
    //Función para la selección del nivel de dificultad del juego
    public void nivelDificultad(){
    
        do {
            
            System.out.println("Selecciona el nivel de dificultad en el que deseas jugar"
                + "\n[1] Muy fácil"
                + "\n[2] Fácil"
                + "\n[3] Normal"
                + "\n[4] Difícil"
                + "\n[5] Muy difícil");
        
            dificultad = input.nextInt();

            if (dificultad == 1) {

                opcion3 = true;
                
            }
            else if (dificultad == 2){
            
                opcion3 = true;
                
            }
            else if (dificultad == 3){
            
                opcion3 = true;
                
            }
            else if (dificultad == 4){
            
                opcion3 = true;
                
            }
            else if (dificultad == 5){
            
                opcion3 = true;
                
            }
            else {

                System.out.println("Opción inválida, por favor selecciona una opción VÁLIDA");
                opcion3 = false;
                
            }
            
        }while (!opcion3);
    
    }
    
    //Función para la selección del tamaño del mapa en el que se desea jugar
    public void tamañoMapa() {
    
        do {
            
            System.out.println("Selecciona el tamaño del mapa en el que deseas jugar"
                + "\n[1] Pequeño 7*7"
                + "\n[2] Mediano 8*8"
                + "\n[3] Grande 9*9");
        
            tamaño = input.nextInt();

            if (tamaño == 1) {

                opcion4 = true;
                
            }
            else if (tamaño == 2){
            
                opcion4 = true;
                
            }
            else if (tamaño == 3){
            
                opcion4 = true;
                
            }
            else {

                System.out.println("Opción inválida, por favor selecciona una opción VÁLIDA");
                opcion4 = false;
                
            }
            
        }while (!opcion4);
                        
    }
    
    //Función para la selección del tamaño del sexto barco tanto del usuario como de la computadora
    public void sextoBarco (){
        
        do { 
            System.out.println("Elige el tamaño de tu sexto barco [entre 2 y 7]");
                
            tamañoBarco = input.nextInt();

            if (tamañoBarco != 2 && tamañoBarco != 3 && tamañoBarco != 4 && tamañoBarco != 5 && 
                    tamañoBarco != 5 && tamañoBarco != 6 && tamañoBarco != 7) {

                System.out.println("El tamaño ingresado es inválido, por favor ingrese un tamaño válido");
                
                opcion5 = false;
                
            }
            else {
            
                opcion5 = true;
            }
            
        } while (!opcion5);
                                        
        tamañoBarcoPC = (int)(Math.random() * (7-tamañoBarco) + tamañoBarco);
                        
    }
    
    //Funcion para verificar si el usuario desea jugar de nuevo la misma partida(con la misma configuración inicial)
    // o volver al menú principal
    public void nuevoJuego () {
    
        do {
            
            System.out.println("Deseas:"
                + "\n[1] Volver a empezar la partida"
                + "\n[2] Menú principal");
        
            nuevoJuego = input.nextInt();

            if (nuevoJuego !=1 && nuevoJuego !=2){
                
                System.out.println("Opción inválida, por favor selecciona una opción VÁLIDA");
                
                opcion6 = false;
                
            }
            
            else {
            
                opcion6 = true;
            }
            
        }while(!opcion6);
        
        if (nuevoJuego == 1){
            
            empezarPartida();
        }
        else {
        
            menuPrincipal();
        }
                
    }
    
    public void empezarPartida (){
    
    
    }
    
}
