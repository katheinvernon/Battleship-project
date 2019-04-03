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
    
    protected int tamaño, vida_Total, vida_partes, numH, contador4 = 0, contador2 = 0;
    protected boolean pc, full, invencible;
    protected Partes_Barco[] barco; //El barco estara hecho por un arreglo de Partes_Barco

    public Barco(int tamaño, int vida_partes, int numH, boolean pc) { //Barcos para la maquina
        this.pc = pc;
        this.tamaño = tamaño;
        this.numH = numH;
        if(numH==1)
            this.vida_partes = vida_partes++;
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
    
   public void habilidad(){
       
       if(numH!=0 || numH!=1)
       switch(numH){
           
           case 2 : if(contador2 == 0 && this.vida_Total!=(vida_partes*tamaño)){
                    System.out.println("Se ha activado la habilidad \"Regenarar vida\" ");
                    for (Partes_Barco recorrer : barco) {
                        contador2++;
                    if(recorrer.getVidas()!= vida_partes){
                    recorrer.setVidas(recorrer.getVidas()+1);
                    
                    switch(recorrer.getIdentificador()){
                        
                        case '+' : recorrer.setIdentificador('o');
                                   break;
                                   
                        case 'o' : if(vida_partes!=recorrer.getVidas()){
                                    recorrer.setIdentificador('•');
                                    } else {
                                    recorrer.setIdentificador('O');
                                    }
                                    break;
                        case '•' : if(recorrer.getVidas()==vida_partes)
                                    recorrer.setIdentificador('O');
                                    else
                                     recorrer.setIdentificador('•');
                                    break;
                    }
                    }
                    break;
                    }
                    }
                    if(contador2 > 1)
                        contador2++;
        
                    if(contador2==4)
                        contador2 = 0;
                    break;
                    
           case 3 : if(vida_Total==1 && !full){
                    System.out.println("Se ha activado la habilidad la habilidad \"Ultima Instancia\"");
                    for (Partes_Barco recorrer : barco) {
                
                    recorrer.setVidas(vida_partes);
                    recorrer.setIdentificador('O');
                    }    
                    full = true;
                    } break;
                    
           case 4 : if(contador4 == 0 && this.vida_Total!=(vida_partes*tamaño)){
                    contador4++;
                    System.out.println("Se ha activado la habilidad \"Levantar escudos\" ");
                    for (Partes_Barco recorrer : barco) {
                        
                        recorrer.setInvencible(true);
                    
                    }
                    } else if(contador4==1){
                    
                        for (Partes_Barco recorrer : barco) {
                
                            recorrer.setInvencible(false);
                    }
                    }
                    if(contador4 > 1)
                        contador4++;
        
                    if(contador4==3)
                        contador4 = 0;
                    break;
           
        }
   
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
