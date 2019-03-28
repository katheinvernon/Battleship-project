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
public class Mapa {
    
    private final Scanner sn = new Scanner(System.in);
    private Partes_Barco mapa[][]; //El mapa del jugador
    private int tamaño, numBarcos = 0;
    private int indices[]; //Los indices y margenes se guardaran por separado
    private char margen[][];
    private int direcciones[][] = new int[6][3];
        
    public Mapa(int tamaño){ // Este es el constructor de la clase mapa y se encargara de crear un mapa de las dimensiones (tamaño+3)x(tamaño+) que indique el usuario
              
        this.mapa = new Partes_Barco[tamaño][tamaño];
        this.indices = new int[tamaño];
        this.margen = new char[2][(tamaño)+2];
        
        //Se crea los margenes 
        margen[0][0] = '┌';
        margen[1][0] = '└';
        margen[0][(tamaño+2)-1] = '┐';
        margen[1][(tamaño+2)-1] = '┘';
        
        
        for (int i = 1; i < (tamaño+2)-1; i++) {
            margen[0][i] = ' ';
        }
        
        for (int i = 1; i < (tamaño+2)-1; i++) {
            margen[1][i] = ' ';
        }
        
        // Aqui esta asignando los indices de las columnas y las filas.
        for (int i = 0; i < indices.length; i++) {
           
                indices[i] = i+1;
        }
        
        // Aqui esta asignando los caracteres que identifican los espacios con agua
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                mapa[i][j] = new Partes_Barco();
            }
        }
    
    }
    public void mapaImprimir(){ //Imprime el mapa que se guarda en la instancia creada
        
        /*Impreme fila por fila a el vector mapa que le llega, el unico impedimento que tiene el metodo es 
          que las zonas de agua no las imprimera centradas si se usan caracteres muy grandes*/  
        
        System.out.print("      ");
        for (int indice : this.indices) { //Indices superiores
                System.out.print(indice+"   ");           
        }
        System.out.print("\n    ");
        for (int i = 0; i < (mapa.length+2); i++) { //Margen superior 
                if(i==mapa.length && mapa.length==7)
                    System.out.print("           ");
                if(i==mapa.length && mapa.length==8)
                    System.out.print("             ");
                if(i==mapa.length && mapa.length==9)
                    System.out.print("               ");
                
                System.out.print(margen[0][i]+" ");
        }
        System.out.println(" ");
        
        for (int i = 0; i < mapa.length; i++) { //Inices laterales junto con el mapa
            for (int j = 0; j < mapa.length; j++) {
                
               if(j==0)
                    System.out.print(indices[i]+"     ");
               
                System.out.print(mapa[i][j].getIdentificador()+"   ");
                
                if(j==(mapa.length-1))
                    System.out.println("");
            } 
        }
        System.out.print("    ");
        for (int i = 0; i < (mapa.length+2); i++) {//Margen inferior 
            if(i==mapa.length && mapa.length==7)
                    System.out.print("           ");
            if(i==mapa.length && mapa.length==8)
                    System.out.print("             ");
            if(i==mapa.length && mapa.length==9)
                    System.out.print("               ");

                System.out.print(margen[1][i]+" ");
        }
        System.out.println("");
    }
    
    public void ponerBarco(Barco barco){
        int tamañoB = barco.tamaño;
        int Aux = 1;
        boolean valido;
        
        while(Aux!=0){
            int y = 0;
            int x = 0;
            Aux = 1;
            valido = false;
            
            while( !valido ){
                System.out.println("\nBarco de tamaño: " + barco.tamaño);
                System.out.println("\nIndique desde donde desea colocar su barco, comenzando primero por el indice de la fila: ");
                x = sn.nextInt();
                System.out.println("Ahora indique el indice de la columna: ");
                y = sn.nextInt();
                if(x > mapa.length || y > mapa.length || x < 1 || y < 1)
                        System.out.println("Error, las coordenadas de los indices no son válidas, proceda a elegirlas de nuevo.");
                else
                    valido = true;
                }
                System.out.println("Elija hacia cual dirección desea poner el barco: \n1.Hacia la derecha \n2.Hacia la izquierda \n3.Hacia arriba \n4.Hacia abajo");
                int respuesta = sn.nextInt();
                
                switch(respuesta) {
                    
                    case 1: boolean valido1 = this.colocarDerecha(x, y, tamañoB);
                            if(valido1){
                                for (int i = 0; i < barco.tamaño; i++) {
                                 mapa[x-1][(y-1)+i] = barco.barco[i];
                                 Aux = 0;
                                }
                            } else {
                                System.out.println("Error, no puede colocar el barco en esa dirección, verifique que no lo esta colocando fuera de los límites o encima de otro barco. \nProceda a elegir la posición de nuevo.");
                            }
                            break;
                            
                    case 2: boolean valido2 = this.colocarIzquierda(x, y, tamañoB);
                            if(valido2){
                                for (int i = 0; i < barco.tamaño; i++) {
                                 mapa[x-1][(y-1)-i] = barco.barco[i];
                                 Aux = 0;
                                }
                            } else {
                                System.out.println("Error, no puede colocar el barco en esa dirección, verifique que no lo esta colocando fuera de los límites o encima de otro barco. \nProceda a elegir la posición de nuevo.");
                            }
                            break;
                            
                    case 3: boolean valido3 = this.colocarArriba(x, y, tamañoB);
                            if(valido3){
                                for (int i = 0; i < barco.tamaño; i++) {
                                 mapa[(x-1)-i][y-1] = barco.barco[i];
                                 Aux = 0;
                                }
                            } else {
                                System.out.println("Error, no puede colocar el barco en esa dirección, verifique que no lo esta colocando fuera de los límites o encima de otro barco. \nProceda a elegir la posición de nuevo.");
                            }
                            break;
                            
                    case 4: boolean valido4 = this.colocarAbajo(x, y, tamañoB);
                            if(valido4){
                                for (int i = 0; i < barco.tamaño; i++) {
                                 mapa[(x-1)+i][y-1] = barco.barco[i];
                                 Aux = 0;
                                }
                            } else {
                                System.out.println("Error, no puede colocar el barco en esa dirección, verifique que no lo esta colocando fuera de los límites o encima de otro barco. \nProceda a elegir la posición de nuevo.");
                            }
                            break;                            
            }
        }
    }
    
    public void verificarBarcos(Barco barcos[]){
        
        boolean listo = false, poner = false, colocado = false, terminar = false;
        int posicion = 0, x = 0, y =0, contador = 0, contPosicion = 0, a = numBarcos;
        
        if(numBarcos>barcos.length-1){
            terminar = true;
        } else {
            do{
            x = (int)(Math.random()*(mapa.length-1)+1);
            y = (int)(Math.random()*(mapa.length-1)+1);
            posicion = (int)(Math.random()*2);
            contador++;
                //System.out.println(x+" "+y+" "+posicion+" "+a+" "+contador);
                do{  
                    switch(posicion){
                        
                        case 0 : if(this.colocarDerecha(x, y, barcos[numBarcos].tamaño, true)){
                                    listo = true;
                                    colocado = true;
                                    poner = true;
                                    direcciones[numBarcos][0] = posicion;
                                    direcciones[numBarcos][1] = x;
                                    direcciones[numBarcos][2] = y;
                                    numBarcos++;
                                    } else {
                                     posicion = 1;
                                     contPosicion++;
                                     if(contPosicion>1)
                                         colocado = true;
                                    }
                                break;
                        case 1 : if(this.colocarAbajo(x, y, barcos[numBarcos].tamaño, true)){
                                    listo = true;
                                    colocado = true;
                                    poner = true;
                                    numBarcos++;
                                    } else {
                                     posicion = 0;
                                     contPosicion++;
                                     if(contPosicion>1)
                                         colocado = true;
                                    }
                                 break;   
                    }
            } while(!colocado);
                if(contador==30){
                    
                    if(numBarcos == 1){
                        this.vaciarMapa();
                        this.ponerBarcosPred(barcos, mapa.length);
                        terminar = true;
                    }
                    numBarcos--;
                    switch(direcciones[numBarcos][0]){
            
                case 0: for (int i = 0; i < barcos[numBarcos].tamaño; i++) {
                                 mapa[direcciones[numBarcos][1]-1][(direcciones[numBarcos][2]-1)+i] = new Partes_Barco();
                                }
                        break;
                case 1: for (int i = 0; i < barcos[numBarcos].tamaño; i++) {
                                 mapa[(direcciones[numBarcos][1]-1)+i][direcciones[numBarcos][2]-1] = new Partes_Barco();
                                }   
                        break;
            }
                    listo = true;
                }           
            } while(!listo);
        }
        
        if(poner){
            switch(posicion){
            
                case 0: for (int i = 0; i < barcos[a].tamaño; i++) {
                                 mapa[x-1][(y-1)+i] = barcos[a].barco[i];
                                }
                        break;
                case 1: for (int i = 0; i < barcos[a].tamaño; i++) {
                                 mapa[(x-1)+i][y-1] = barcos[a].barco[i];
                                }   
                        break;
            }
        }
        
        if(!terminar){
            this.verificarBarcos(barcos);
        }
    }
    
    public void ponerBarcosPred(Barco barcos[], int tamaño){
    
        //Barco de tamaño 2
        for (int i = 0; i < barcos[0].tamaño; i++) {
                mapa[2-1][(3-1)+i] = barcos[0].barco[i];
        }
    }
    
    public void vaciarMapa(){
        
        for (Partes_Barco[] mapa1 : mapa) {
            for (int j = 0; j < mapa.length; j++) {
                mapa1[j] = new Partes_Barco();
            }
        }
    
    }
    
    public void disparoRecibir(){ //Disparo para el jugador
        
        boolean valido = false, valido2 = false, valido3 = false;
        int fila = 0, columna = 0;
        
        while(!valido3){
        while(!valido){
        System.out.println("Elija el indice de la fila en la que va a disparar: ");
        fila = sn.nextInt();
        if(fila<1 || fila>mapa.length)
                System.out.println("Dato incorrecto, ingrese un numero de fila valido");
        valido = true;
        }
        while(!valido2){
        System.out.println("Ahora elija el indice de la columna en la que va a disparar: ");
        columna = sn.nextInt();
        if(columna<1 || columna>mapa.length)
                System.out.println("Dato incorrecto, ingrese un numero de columna valido");
        valido2 = true;
        }
        
        fila = fila-1;
        columna = columna-1;
        
        if(mapa[fila][columna].getIdentificador()=='X' || mapa[fila][columna].getIdentificador()=='+')
                System.out.println("En esta casilla no tiene que dispara más, por favor, elija otra");
        valido3 = true;
        }

        switch (mapa[fila][columna].getIdentificador()) {
 
            case '~':
                if(mapa[fila][columna].isPC()){
                 switch(mapa[fila][columna].getVidas()) {
                    
                    case 1: mapa[fila][columna].setIdentificador('+');
                    break;
                    
                    case 2: mapa[fila][columna].setIdentificador('•');
                    break;
                    
                    case 3: mapa[fila][columna].setIdentificador('•');
                    break;
                }   mapa[fila][columna].setVidas(mapa[fila][columna].getVidas()-1);}
                else
                    mapa[fila][columna].setIdentificador('X');
                break;
            case 'O':
                switch(mapa[fila][columna].getVidas()) {
                    
                    case 1: mapa[fila][columna].setIdentificador('+');
                    break;
                    
                    case 2: mapa[fila][columna].setIdentificador('•');
                    break;
                    
                    case 3: mapa[fila][columna].setIdentificador('•');
                    break;
                }   mapa[fila][columna].setVidas(mapa[fila][columna].getVidas()-1);
                break;
            case '•':
                switch(mapa[fila][columna].getVidas()) {
                    
                    case 1: mapa[fila][columna].setIdentificador('+');
                    break;
                    
                    case 2: mapa[fila][columna].setIdentificador('o');
                    break;
                }   mapa[fila][columna].setVidas(mapa[fila][columna].getVidas()-1);
                break;
            case 'o':
                mapa[fila][columna].setIdentificador('+');
                mapa[fila][columna].setVidas(mapa[fila][columna].getVidas()-1);
                break;
            default:
                break;
        }
    
    }
    
    public void disparoPC(){ //Dsiparo para la maquina
        
        boolean valido = false;
        int fila = 0, columna = 0;
        
        do{
        
        fila = (int)(Math.random()*(mapa.length));
        columna = (int)(Math.random()*(mapa.length));
        
        if(mapa[fila][columna].getIdentificador()!='X' && mapa[fila][columna].getIdentificador()!='+')
            valido = true;
    
        } while(!valido);
        
        switch (mapa[fila][columna].getIdentificador()) {
 
            case '~':
                mapa[fila][columna].setIdentificador('X');
                break;
            case 'O':
                switch(mapa[fila][columna].getVidas()) {
                    
                    case 1: mapa[fila][columna].setIdentificador('+');
                    break;
                    
                    case 2: mapa[fila][columna].setIdentificador('•');
                    break;
                    
                    case 3: mapa[fila][columna].setIdentificador('•');
                    break;
                }   mapa[fila][columna].setVidas(mapa[fila][columna].getVidas()-1);
                break;
            case '•':
                switch(mapa[fila][columna].getVidas()) {
                    
                    case 1: mapa[fila][columna].setIdentificador('+');
                    break;
                    
                    case 2: mapa[fila][columna].setIdentificador('o');
                    break;
                }   mapa[fila][columna].setVidas(mapa[fila][columna].getVidas()-1);
                break;
            case 'o':
                mapa[fila][columna].setIdentificador('+');
                mapa[fila][columna].setVidas(mapa[fila][columna].getVidas()-1);
                break;
            default:
                break;
        }
    
    }
    
    public boolean colocarIzquierda(int x, int y, int tamaño){
        
        for (int i = 0; i < tamaño; i++) {
            if((y-1)-i<0 || mapa[x-1][(y-1)-i].getIdentificador()=='O'){
            return false;
            }
      }
        return true;
    }
    
    public boolean colocarDerecha(int x, int y, int tamaño){
        
        for (int i = 0; i < tamaño; i++) {
            if((y-1)+i>mapa.length-1 || mapa[x-1][(y-1)+i].getIdentificador()=='O'){
            return false;
            }
        }
        return true;
    }
    
    public boolean colocarDerecha(int x, int y, int tamaño, boolean pc){
        
        for (int i = 0; i < tamaño; i++) {
            if((y-1)+i>mapa.length-1 || mapa[x-1][(y-1)+i].isPC()){
            return false;
            }
        }
        return true;
    }
    
    public boolean colocarAbajo(int x, int y, int tamaño){
        
        for (int i = 0; i < tamaño; i++) {
            if((x-1)+i>mapa.length-1 || mapa[(x-1)+i][y-1].getIdentificador()=='O'){
            return false;
            }
        }
        return true;
    }
    
    public boolean colocarAbajo(int x, int y, int tamaño, boolean pc){
        
        for (int i = 0; i < tamaño; i++) {
            if((x-1)+i>mapa.length-1 || mapa[(x-1)+i][y-1].isPC()){
            return false;
            }
        }
        return true;
    }
            
    public boolean colocarArriba(int x, int y, int tamaño){
        
        for (int i = 0; i < tamaño; i++) {
            if((x-1)-i<0 || mapa[(x-1)-i][y-1].getIdentificador()=='O'){
            return false;
            }
        }
        return true;
    }

    public Partes_Barco[][] getMapa() {
        return mapa;
    }

    public void setMapa(Partes_Barco[][] mapa) {
        this.mapa = mapa;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public int[] getIndices() {
        return indices;
    }

    public void setIndices(int[] indices) {
        this.indices = indices;
    }

    public char[][] getMargen() {
        return margen;
    }

    public void setMargen(char[][] margen) {
        this.margen = margen;
    }

    public int getNumBarcos() {
        return numBarcos;
    }

    public void setNumBarcos(int numBarcos) {
        this.numBarcos = numBarcos;
    }
    
   
}
