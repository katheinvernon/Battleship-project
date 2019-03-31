/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship_proyecto;

import java.util.Scanner;

/**
 *
 * @author Katherine
 */
public class Partida {
    
    Scanner input = new Scanner (System.in);
    
    //Variables 
    Integer inicio, modo, dificultad, tamañoMapa, nuevoJuego, tamañoBarco, tamañoBarcoPC, volverMenu, vidaJugador, vidaComputadora, inputHabilidad, habilidadPC;
        //Comprabaciones de que las opciones seleccionadas por el usuario sean válidas
    Boolean opcion=false, opcion2=false, opcion3=false, opcion4=false, opcion5=false, opcion6=false, opcion7=false, opcion8=false; 
    int [] tamañoBarcosUsuario = {2,3,3,4,5,0};  
    int [] tamañoBarcosPc = {2,3,3,4,5,0};
    
    public Integer getVidaComputadora() {
        return vidaComputadora;
    }

    public void setVidaComputadora(Integer vidaComputadora) {
        this.vidaComputadora = vidaComputadora;
    }

    public Integer getVidaJugador() {
        return vidaJugador;
    }
    
    public void setVidaJugador(Integer vidaJugador) {
        this.vidaJugador = vidaJugador;
    }

    public Integer getTamañoBarco() {
        return tamañoBarco;
    }

    public void setTamañoBarco(Integer tamañoBarco) {
        this.tamañoBarco = tamañoBarco;
    }

    public Integer getTamañoBarcoPC() {
        return tamañoBarcoPC;
    }
    
    public void setTamañoBarcoPC(Integer tamañoBarcoPC) {
        this.tamañoBarcoPC = tamañoBarcoPC;
    }

    public Integer getTamañoMapa() {
        return tamañoMapa;
    }

    public void setTamañoMapa(Integer tamañoMapa) {
        this.tamañoMapa = tamañoMapa;
    }
    public int[] getTamañoBarcosPc() {
        return tamañoBarcosPc;
    }

    public void setTamañoBarcosPc(int[] tamañoBarcos) {
        this.tamañoBarcosPc = tamañoBarcosPc;
    }
    public int[] getTamañoBarcosUsuario() {
        return tamañoBarcosUsuario;
    }

    public void setTamañoBarcosUsuario(int[] tamañoBarcos) {
        this.tamañoBarcosUsuario = tamañoBarcosUsuario;
    }
        
    public void menuPrincipal () {
    
        do {
            System.out.println("[----- BATTLESHIP -----]");
        
            System.out.println("Deseas:"
                    + "\n[1] Empezar una nuevo juego"
                    + "\n[2] Leer las instrucciones"
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
            
        switch (inicio) {
            case 1:
                nuevaPartida ();
                break;
            case 2:
                comoJugar();
                break;
            default:
                System.out.println("****Gracias por jugar****");
                break;
        }
        
    }
    
    //Función para crear una nueva partida 
    public void nuevaPartida (){
                        
        switch (modoJuego()) {
        
            case 1:
              configuracionPartidaBatalla ();  
              break;
            default:
                System.out.println("---Próximamente---"); 
                nuevaPartida ();
                break;        
        }
        
        
    }
    
    //Función donde el usuario coloca toda la configuración de su partida 
    public void configuracionPartidaBatalla () {
                      
            nivelDificultad();

            asignarTamañoMapa();
            
            sextoBarco ();
            
            empezarPartida(vidaJugador, vidaComputadora, tamañoMapa, tamañoBarco, tamañoBarcoPC);
            
            nuevoJuego();
                                     
    }
    
    //Función para la selección del modo de juego 
    public int modoJuego() {
        
        do {
            
            System.out.println("Selecciona un modo de juego"
                + "\n[1] Batalla"
                + "\n[2] Campaña");
        
            modo = input.nextInt();

            switch (modo) {
                case 1:
                    opcion2 = true;
                    break;
                case 2:
                    opcion2 = true;
                    break;
                default:
                    System.out.println("Opción inválida, por favor selecciona una opción VÁLIDA");
                    opcion2 = false;
                    break;
            }
            
        }while (!opcion2);
        
        return modo;
    
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
               
        switch (dificultad) {
            case 1:
                vidaJugador = 3;
                vidaComputadora = 1;
                break;
            case 2:
                vidaJugador = 2;
                vidaComputadora = 1;
                break;
            case 3:
                vidaJugador = 1;
                vidaComputadora = 1;
                break;
            case 4:
                vidaJugador = 1;
                vidaComputadora = 2;
                break;
            default:
                vidaJugador = 1;
                vidaComputadora = 3;
                break;
        }
    
    }
    
    //Función para la selección del tamaño del mapa en el que se desea jugar
    public void asignarTamañoMapa() {
    
        do {
            
            System.out.println("Selecciona el tamaño del mapa en el que deseas jugar"
                + "\n[7] Pequeño 7*7"
                + "\n[8] Mediano 8*8"
                + "\n[9] Grande 9*9");
        
            tamañoMapa = input.nextInt();

            if (tamañoMapa == 7 || tamañoMapa == 8 || tamañoMapa == 9) {

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
        
        //Se coloca en vector de tamaños de los barcos el tamaño ingresado por el usuario
        this.setTamañoBarcoUsuarioPos(tamañoBarco, 5); 
                                        
        tamañoBarcoPC = (int)(Math.random() * (7-tamañoBarco) + tamañoBarco);
        
        this.setTamañoBarcoPcPos(tamañoBarcoPC, 5);
        
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
            
            empezarPartida(vidaJugador, vidaComputadora, tamañoMapa, tamañoBarco, tamañoBarcoPC);
        }
        else {
        
            menuPrincipal();
        }
                
    }
    
    public void empezarPartida (int vidaJugador, int vidaComputadora, int tamañoMapa, int tamañoBarco, int tamañoBarcoPC){
    
        //Variable
        int reiniciar;
        
        Mapa mapPC = new Mapa(tamañoMapa);
        Mapa mapUsuario = new Mapa(tamañoMapa);
        Barco barcosUsuario[] = new Barco [6];
        Barco barcosPC[] = new Barco [6];
        
        imprimirMapas (mapPC, mapUsuario);
                                        
        //Creación de barcos pc
        for (int i=0; i < barcosPC.length; i++) {
        
            habilidadPC = (int)(Math.random() * 4 + 0);
            
            switch (habilidadPC) {
                case 0:
                    barcosPC[i] = new BarcoSinHabilidad(this.getTamañoBarcosPc()[i], vidaComputadora, true);
                    break;
                case 1:
                    barcosPC[i] = new BarcoHabilidad1(this.getTamañoBarcosPc()[i], vidaComputadora, true);
                    break;
                case 2:
                    barcosPC[i] = new BarcoHabilidad2(this.getTamañoBarcosPc()[i], vidaComputadora, true);
                    break;
                case 3:
                    barcosPC[i] = new BarcoHabilidad3(this.getTamañoBarcosPc()[i], vidaComputadora, true);
                    break;
                default:
                    barcosPC[i] = new BarcoHabilidad4(this.getTamañoBarcosPc()[i], vidaComputadora, true);
                    break;
            }
                  
        }
               
        //Creación de barcos usuario
        for (int i=0; i < barcosUsuario.length; i++) {
        
            do{
                System.out.println("Seleccione la habilidad para el barco de tamaño: " + this.getTamañoBarcosUsuario()[i] 
                    + "\n[0] Sin habilidad"
                    + "\n[1] Vida extra"
                    + "\n[2]"
                    + "\n[3]"
                    + "\n[4]");
            
                inputHabilidad = input.nextInt();
                
                if (inputHabilidad != 0 && inputHabilidad != 1 && inputHabilidad != 2 && inputHabilidad != 3 && 
                    inputHabilidad != 4) {

                    System.out.println("La opción de la habilidad ingresada es inválida, por favor ingrese una opción válida");
                    opcion8 = false;
                }
                else {

                    opcion8 = true;
                }
            }while (!opcion8);
            
            switch (inputHabilidad) {
                case 0:
                    barcosUsuario[i] = new BarcoSinHabilidad(this.getTamañoBarcosUsuario()[i], vidaJugador, false);
                    break;
                case 1:
                    barcosUsuario[i] = new BarcoHabilidad1(this.getTamañoBarcosUsuario()[i], vidaJugador, false);
                    break;
                case 2:
                    barcosUsuario[i] = new BarcoHabilidad2(this.getTamañoBarcosUsuario()[i], vidaJugador, false);
                    break;
                case 3:
                    barcosUsuario[i] = new BarcoHabilidad3(this.getTamañoBarcosUsuario()[i], vidaJugador, false);
                    break;
                default:
                    barcosUsuario[i] = new BarcoHabilidad4(this.getTamañoBarcosUsuario()[i], vidaJugador, false);
                    break;
            }
                    
        }
                
        for(int i=0; i<barcosUsuario.length; i++){
            mapUsuario.ponerBarco(barcosUsuario[i]);
            mapUsuario.mapaImprimir();
            System.out.println("Deseas reiniciar tu mapa?"
                    + "\n[1] Si"
                    + "\n[2] No");
            reiniciar = input.nextInt();
            if (reiniciar == 1) {
                mapUsuario.vaciarMapa();
                System.out.println("\nSu mapa ha sido reiniciado \n");
                mapUsuario.mapaImprimir();
                i=-1;
            }
            else {}
        }
        
        mapPC.verificarBarcos(barcosPC);
        
        imprimirMapas (mapPC, mapUsuario);
        
        int aux=0;
        
        do{
            mapPC.disparoRecibir();
            imprimirMapas (mapPC, mapUsuario);
            if(finalizoPartida(barcosPC)){
                aux=1;
            }
            else{
               mapUsuario.disparoPC();
               imprimirMapas (mapPC, mapUsuario);
               if(finalizoPartida(barcosUsuario)){
                   aux=2;
               }
            }
                   
        } while (aux==0);
        
        if(aux==1){
        
            System.out.println("*** Felicidades ha ganado! ***");
        }
        else {
            System.out.println("--- Perdiste T.T ---");
        }
    }
    
    public boolean finalizoPartida(Barco [] barcos) {

        for(int i=0; i<barcos.length; i++){
            if(barcos[i].getVida_Total()>0){
                return false;
            }
        }
        return true;        
    }    
    
    public void imprimirMapas(Mapa pc, Mapa usuario) {
    
        pc.mapaImprimir();
        System.out.println("-----------------------------------");
        usuario.mapaImprimir();
    
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
                    + "\n[1] Vida extra: el barco tendrá una vida extra en cada una de sus partes"
                    + "\n[2]"
                    + "\n[3]"
                    + "\n[4]");
            
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
        
    public void setTamañoBarcoPcPos(int tamañoBarco, int pos) {
        this.tamañoBarcosPc [pos] = tamañoBarco;
    }
    
    public void setTamañoBarcoUsuarioPos(int tamañoBarco, int pos) {
        this.tamañoBarcosUsuario [pos] = tamañoBarco;
    }
}
