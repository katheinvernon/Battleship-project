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
    Integer inicio, modo, dificultad, tamaño, nuevoJuego, tamañoBarco, tamañoBarcoPC, volverMenu, vidaJugador, vidaComputadora;
        //Comprabaciones de que las opciones seleccionadas por el usuario sean válidas
    Boolean opcion=false, opcion2=false, opcion3=false, opcion4=false, opcion5=false, opcion6=false, opcion7=false; 
            
    public void menuPrincipal () {
    
        do {
            System.out.println("[----- BATTLESHIP -----]");
        
            System.out.println("Deseas:"
                    + "\n[1] Empezar una nuevo juego"
                    + "\n[2] Ver las instrucciones"
                    + "\n[3] Salir");
           
            inicio = input.nextInt();

            if (inicio == 1 || inicio == 2 || inicio == 3) {

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
            
           comoJugar();
                
        }
        else{
        
            System.out.println("****Gracias por jugar****");
        }
        
    }
    
    //Función para crear una nueva partida 
    public void nuevaPartida (){
            
        configuracionPartida ();
                   
    }
    
    //Función donde el usuario coloca toda la configuración de su partida 
    public void configuracionPartida () {
                                                        
            modoJuego();

            nivelDificultad();

            tamañoMapa();
            
            sextoBarco ();
            
            empezarPartida(tamaño);
            
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

            if (dificultad == 1 || dificultad == 2 || dificultad == 3 || dificultad == 4 || dificultad == 5) {

                opcion3 = true;
                
            }
            else {

                System.out.println("Opción inválida, por favor selecciona una opción VÁLIDA");
                opcion3 = false;
                
            }
            
        }while (!opcion3);
        
        if (dificultad == 1) {

            vidaJugador = 3;
            vidaComputadora = 1;
                
        }
        else if (dificultad == 2){
            
            vidaJugador = 2;
            vidaComputadora = 1;
                
        }
        else if (dificultad == 3){
            
            vidaJugador = 1;
            vidaComputadora = 1;
                
        }
        else if (dificultad == 4){
            
            vidaJugador = 1;
            vidaComputadora = 2;
                
        }
        else {
            
            vidaJugador = 1;
            vidaComputadora = 3;
                
        }
    
    }
    
    //Función para la selección del tamaño del mapa en el que se desea jugar
    public void tamañoMapa() {
    
        do {
            
            System.out.println("Selecciona el tamaño del mapa en el que deseas jugar"
                + "\n[7] Pequeño 7*7"
                + "\n[8] Mediano 8*8"
                + "\n[9] Grande 9*9");
        
            tamaño = input.nextInt();

            if (tamaño == 7 || tamaño == 8 || tamaño == 9) {

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
            
            empezarPartida(tamaño);
        }
        else {
        
            menuPrincipal();
        }
                
    }
    
    public void empezarPartida (int tamañoMapa){
    
        Mapa map = new Mapa(tamañoMapa);
                
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
    
    public void comoJugar(){
    
        do{
            System.out.println("[----Cómo jugar----]"
                + "\n\nO : El barco tiene la vida completa"
                + "\n• : El barco tiene la vida media"
                + "\no : El barco tiene la vida baja"
                + "\n+ : El barco está destruido"
                + "\n~ : Casilla llena de agua"
                + "\nX : Disparo fallido ");
            
            System.out.println("\n***Habilidades***"
                    + "\n");
            
            System.out.println("\n····Niveles de dificultad····"
                    + "\nNivel             Vidas jugador             Vidas computador "
                    + "\nMuy fácil              3                           1"
                    + "\nFácil                  2                           1"
                    + "\nNormal                 1                           1"
                    + "\nDifícil                1                           2"
                    + "\nMuy difícil            1                           3");
        
            System.out.println("\nPresione 0 [cero] para volver al menú");

            volverMenu = input.nextInt();
            
            if(volverMenu == 0){
            
                opcion7=true;
            }
            else{
            
                opcion7=false;
            }
            
        }while (!opcion7);
        
        menuPrincipal();
    }
    
}
