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
    private Integer inicio, modo, dificultad, tamañoMapa, nuevoJuego, tamañoBarco, tamañoBarcoPC, volverMenu, vidaJugador, vidaComputadora, inputHabilidad, habilidadPC;
    private long tiempo;
        //Comprabaciones de que las opciones seleccionadas por el usuario sean válidas
    private Boolean opcion=false, opcion2=false, opcion3=false, opcion4=false, opcion5=false, opcion6=false, opcion7=false, opcion8=false, opcion9=false; 
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
        long start = System.currentTimeMillis();
                
        Mapa mapPC = new Mapa(tamañoMapa);
        Mapa mapUsuario = new Mapa(tamañoMapa);
        Barco barcosUsuario[] = new Barco [6];
        Barco barcosPC[] = new Barco [6];
        
        imprimirMapas (mapPC, mapUsuario);
                                        
        //Creación de barcos pc
        for (int i=0; i < barcosPC.length; i++) {
        
            habilidadPC = (int)(Math.random() * 4 + 0);
                        
            barcosPC[i] = new Barco(this.getTamañoBarcosPc()[i], vidaComputadora, habilidadPC, true);
               
        }
               
        //Creación de barcos usuario
        for (int i=0; i < barcosUsuario.length; i++) {
        
            do{
                System.out.println("Seleccione la habilidad para el barco de tamaño: " + this.getTamañoBarcosUsuario()[i] 
                    + "\n[0] Sin habilidad"
                    + "\n[1] Vida extra"
                    + "\n[2] Regenerar Vida"
                    + "\n[3] Última instancia"
                    + "\n[4] Levantar escudo");
            
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
            
           barcosUsuario[i] = new Barco(this.getTamañoBarcosUsuario()[i], vidaJugador, inputHabilidad, false);
           
        }
        
         mapUsuario.mapaImprimir();
        for(int i=0; i<barcosUsuario.length; i++){
            mapUsuario.ponerBarco(barcosUsuario[i]);
            mapUsuario.mapaImprimir();
            do {
                System.out.println("Deseas reiniciar tu mapa?"
                    + "\n[1] Si"
                    + "\n[2] No");
                reiniciar = input.nextInt();
                if (reiniciar != 1 && reiniciar != 2 ) {
                    System.out.println("Opción inválida, por favor introduzca una opción válida");
                    opcion9 = false;
                }
                else {
                    opcion9 = true;
                }
            }while (!opcion9);
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
            for (Barco habilidad : barcosPC) {
                habilidad.habilidad();
            }
            imprimirMapas (mapPC, mapUsuario);
            if(finalizoPartida(barcosPC)){
                tiempo = (System.currentTimeMillis()-start);
                aux=1;
            }
            else{
               mapUsuario.disparoPC();
               for (Barco habilidad : barcosUsuario) {
                habilidad.habilidad();
               }
               imprimirMapas (mapPC, mapUsuario);
               if(finalizoPartida(barcosUsuario)){
                   tiempo = (System.currentTimeMillis()-start);
                   aux=2;
               }
            }
                   
        } while (aux==0);
                
        double min = (tiempo*0.000017);
        double sec = ((min-(int)min)*60);
        double mil = ((sec-(int)sec)*1000);
        if(aux==1){
            System.out.println("\n*** Felicidades ha ganado! *** \n Resultados: ");
        }
        else {
            System.out.println("\n--- Perdiste T.T --- \n Resultados: ");
        }
        
        System.out.println("\nEl tiempo de partida fue de: "+(int)min+":"+(int)sec+":"+(int)(mil));
        System.out.println("\nDisparos totales: Jugador = "+(int)mapPC.getDisparosTotal()+" PC = "+(int)mapUsuario.getDisparosTotal());
        System.out.println("\nDisparos acertados: Jugador = "+(int)mapPC.getDisparosAcertados()+" PC = "+(int)mapUsuario.getDisparosAcertados());
        System.out.println("\nDisparos fallidos: Jugador = "+(int)(mapPC.getDisparosTotal()-mapPC.getDisparosAcertados())+" PC = "+(int)(mapUsuario.getDisparosTotal()-mapUsuario.getDisparosAcertados()));
        System.out.println("\nPorcentaje de disparos acertados: Jugador = "+(mapPC.getDisparosAcertados()*100/mapPC.getDisparosTotal())+" PC = "+(mapUsuario.getDisparosAcertados()*100/mapUsuario.getDisparosTotal()));
        mapPC.setDisparosAcertados(0);
        mapPC.setDisparosAcertados(0);
        mapUsuario.setDisparosAcertados(0);
        mapUsuario.setDisparosTotal(0);
                    
//            double sec = ((min%1)*60);
//            double mil = (int)((sec%1)*1000);
                    
    }
    
    //Función para verificar cuando termina la partida 
    public boolean finalizoPartida(Barco [] barcos) {
        
        int total = 0;
        for (Barco barco : barcos) {
            total += barco.actualizarVidaTotal();
        }
        return total == 0;        
    }
    
    /*public void restaurarVidas(int vidas, Barco[] barcos){
        
        int parte, respuesta = 0;
        System.out.println("Puede aumentar un total de "+vidas+" puntos de vidas a las partes de sus barcos");
        System.out.println("Diga cual varco queire recuperar: \nTamaño 2 (1) \nTamaño 3 (2) \nTamaño 3 (3) \nTamaño 4 (4) \nTamaño 5 (5) \nTamaño "+barcos[5].barco.length+" (6)");
            
            switch(input.nextInt()){
                
                case 1 : do{
                    
                         System.out.println("Estas son las vidas actuales del Barco : ");
                         System.out.println("Parte 1: "+barcos[0].barco[0].getVidas());
                         System.out.println("Parte 2: "+barcos[0].barco[1].getVidas());
                         System.out.println("Diga el numero de la parte que desea aumentarle una vida: ");
                         parte = input.nextInt();
                         
                         if(parte == barcos[0].vida_partes)
                             System.out.println("Esta parte ya tiene las vidas al máximo, elija otra.");
                         else{
                         do {
                             barcos[0].barco[parte].setVidas(barcos[0].barco[parte].getVidas()+1);
                             vidas--;
                             if(vidas!=0 || parte == barcos[0].vida_partes){
                             System.out.println("Ya no puede segir sumando vidas");
                             respuesta=1;
                             } else {
                             System.out.println("¿Desea aumentarle otra ves una vida? \n Si (0)   No (1)");
                             respuesta = input.nextInt();
                             } 
                         } while(respuesta==0);}
                         
                         if(vidas!=0){
                             System.out.println("Ya no puede segir sumando vidas");
                             respuesta = 1;
                         } else {
                         System.out.println("¿Desea escoger otra parte? \nSi (0)   No (1)");
                            respuesta = input.nextInt();
                         }
                            }while(respuesta==0 && vidas!=0);
            
            }
    
    }*/
    
    //Función para mostrar ambos mapas
    public void imprimirMapas(Mapa pc, Mapa usuario) {
        
        System.out.println("Mapa de la PC");
        pc.mapaImprimir();
        System.out.println("-----------------------------------");
        System.out.println("Mapa del Jugador");
        usuario.mapaImprimir();
    
    }
    
    //Instrucciones
    public void comoJugar(){
    
        do{
            System.out.println("[----Cómo jugar----]"
                + "\n\nO : La parte del barco tiene la vida completa"
                + "\n• : La parte del barco esta dañada"
                + "\no : La parte del barco le queda una vida"
                + "\n+ : El la parte del barco está destruido"
                + "\n~ : Casilla llena de agua"
                + "\nX : Disparo fallido ");
            
            System.out.println("\n***Habilidades***"
                    + "\n[1] Vida extra: el barco tendrá una vida extra en cada una de sus partes"
                    + "\n[2] Regenerar vida: el barco regenera una vida a alguna pieza si puede, esta habilidad se activa cada 3 turnos"
                    + "\n[3] Última instancia: el barco regenera la vida por completo al llegar a una (1) vida en total, solo se activa una vez por partida"
                    + "\n[4] Levanter escudos: el barco sera invencible durante el turno, no podrás dispararle a sus piezas");
            
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
