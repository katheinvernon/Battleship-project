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
    private Integer inicio, modo, dificultad, tamañoMapa, nuevoJuego, tamañoBarco, tamañoBarcoPC, volverMenu, vidaJugador, vidaComputadora;
    private Long tiempo;
        //Comprabaciones de que las opciones seleccionadas por el usuario sean válidas
    Boolean opcion=false, opcion2=false, opcion3=false, opcion4=false, opcion5=false, opcion6=false, opcion7=false; 
    
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

    public Long getTiempo() {
        return tiempo;
    }

    public void setTiempo(Long tiempo) {
        this.tiempo = tiempo;
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
            
            empezarPartida(vidaJugador, vidaComputadora, tamañoMapa, tamañoBarco, tamañoBarcoPC);
        }
        else {
        
            menuPrincipal();
        }
                
    }
    
    public void empezarPartida (int vidaJugador, int vidaComputadora, int tamañoMapa, int tamañoBarco, int tamañoBarcoPC){
    
        //Variable
        int reiniciar;
        long start = System.currentTimeMillis();
                
        Mapa mapPC = new Mapa(tamañoMapa);
        Mapa mapUsuario = new Mapa(tamañoMapa);
        
        imprimirMapas (mapPC, mapUsuario);
                                        
        //Creación de barcos pc
        Barco barco1 = new Barco(2, vidaComputadora, true);
        Barco barco2 = new Barco(3, vidaComputadora, true);
        Barco barco3 = new Barco(3, vidaComputadora, true);
        Barco barco4 = new Barco(4, vidaComputadora, true);
        Barco barco5 = new Barco(5, vidaComputadora, true);
        Barco barco6 = new Barco(tamañoBarcoPC, vidaComputadora, true);
        
        Barco barcosPC[] = {barco1, barco2, barco3, barco4, barco5, barco6};
        
        //Creación de barcos usuario
        Barco barcoU1 = new Barco(2, vidaJugador, false);
        Barco barcoU2 = new Barco(3, vidaJugador, false);
        Barco barcoU3 = new Barco(3, vidaJugador, false);
        Barco barcoU4 = new Barco(4, vidaJugador, false);
        Barco barcoU5 = new Barco(5, vidaJugador, false);
        Barco barcoU6 = new Barco(tamañoBarco, vidaJugador, false);
        
        Barco barcosUsuario[] = {barcoU1, barcoU2, barcoU3, barcoU4, barcoU5, barcoU6};
        
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
                tiempo = (System.currentTimeMillis()-start);
                aux=1;
            }
            else{
               mapUsuario.disparoPC();
               imprimirMapas (mapPC, mapUsuario);
               if(finalizoPartida(barcosUsuario)){
                   tiempo = (System.currentTimeMillis()-start);
                   aux=2;
               }
            }
                   
        } while (aux==0);
        
        if(aux==1){
            double min = (tiempo*0.000017);
            double sec = ((min%1)*60);
            double mil = (int)((sec%1)*1000);
            System.out.println("*** Felicidades ha ganado! *** \n Estadisticas: ");
            System.out.println(" El tiempo de partida fue de : "+(int)min+": "+(int)sec+": "+(int)(mil/10));
            System.out.println("Disparos totales: Jugador = "+(int)mapPC.getDisparosTotal()+" PC = "+(int)mapUsuario.getDisparosTotal());
            System.out.println("Disparos acertados: Jugador = "+(int)mapPC.getDisparosAcertados()+" PC = "+(int)mapUsuario.getDisparosAcertados());
            System.out.println("Disparos fallidos: Jugador = "+(int)(mapPC.getDisparosTotal()-mapPC.getDisparosAcertados())+" PC = "+(int)(mapUsuario.getDisparosTotal()-mapUsuario.getDisparosAcertados()));
            System.out.println("Porcentaje de disparos acertados: Jugador = "+(mapPC.getDisparosAcertados()*100/mapPC.getDisparosTotal())+" PC = "+(mapUsuario.getDisparosAcertados()*100/mapUsuario.getDisparosTotal()));
            mapPC.setDisparosAcertados(0);
            mapPC.setDisparosAcertados(0);
            mapUsuario.setDisparosAcertados(0);
            mapUsuario.setDisparosTotal(0);
        }
        else {
            double min = (tiempo*0.000017);
            double sec = ((min%1)*60);
            double mil = (int)((sec%1)*1000);
            System.out.println("--- Perdiste T.T ---");
            System.out.println(" El tiempo de partida fue de : "+(int)min+": "+(int)sec+": "+(int)(mil/10));
            System.out.println("Disparos totales: Jugador = "+(int)mapPC.getDisparosTotal()+" PC = "+(int)mapUsuario.getDisparosTotal());
            System.out.println("Disparos acertados: Jugador = "+(int)mapPC.getDisparosAcertados()+" PC = "+(int)mapUsuario.getDisparosAcertados());
            System.out.println("Disparos fallidos: Jugador = "+(int)(mapPC.getDisparosTotal()-mapPC.getDisparosAcertados())+" PC = "+(int)(mapUsuario.getDisparosTotal()-mapUsuario.getDisparosAcertados()));
            System.out.println("Porcentaje de disparos acertados: Jugador = "+(mapPC.getDisparosAcertados()*100/mapPC.getDisparosTotal())+" PC = "+(mapUsuario.getDisparosAcertados()*100/mapUsuario.getDisparosTotal()));
            mapPC.setDisparosAcertados(0);
            mapPC.setDisparosAcertados(0);
            mapUsuario.setDisparosAcertados(0);
            mapUsuario.setDisparosTotal(0);
        }
    }
    
    public boolean finalizoPartida(Barco [] barcos) {
        
        int total = 0;
        for (Barco barco : barcos) {
            total += barco.actualizarVidaTotal();
        }
        return total == 0;        
    }    
    
    public void imprimirMapas(Mapa pc, Mapa usuario) {
        
        System.out.println("Mapa de la PC");
        pc.mapaImprimir();
        System.out.println("-----------------------------------");
        System.out.println("Mapa del Jugador");
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
