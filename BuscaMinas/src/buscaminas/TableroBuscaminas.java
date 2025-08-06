package buscaminas;

import java.util.LinkedList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danir
 */
public class TableroBuscaminas {
    private Casilla[][] casilla;
    
    int numFilas;
    int numColumnas;
    int numMinas;
  
    

    public TableroBuscaminas(int numFilas, int numColumnas, int numMinas) {
            this.numFilas = numFilas;
    this.numColumnas=numColumnas;
    this.numMinas=numMinas;
    inicializarCasillas();
    System.out.println("Número de minas esperadas: " + numMinas);
    }

    
    public void inicializarCasillas(){
        casilla = new Casilla[this.numFilas][this.numColumnas];
        for (int i = 0; i < casilla.length; i++) {
            for (int j = 0; j < casilla[i].length; j++) {
                casilla[i][j] = new Casilla(i,j);
            }
        }
        generarMinas();
    }
    private void generarMinas(){
        int minasGeneradas=0;
        while(minasGeneradas!=numMinas){
            int posTmFila=(int)(Math.random()*casilla.length);
            int posTmpColumna=(int)(Math.random()*casilla[0].length);
            if (!casilla[posTmFila][posTmpColumna].isMina()){
                casilla[posTmFila][posTmpColumna].setMina(true);
                minasGeneradas++;
            }
        }
        actualizarNMinas();
        
    }
    private void imprimirTablero(){
        for (int i = 0; i < casilla.length; i++) {
            for (int j = 0; j < casilla[i].length; j++) {
                System.out.print(casilla[i][j].isMina()?"1":"0");
            }
          
           System.out.println("");
        }
        
    }
      private void imprimirPistas(){
        for (int i = 0; i < casilla.length; i++) {
            for (int j = 0; j < casilla[i].length; j++) {
                System.out.print(casilla[i][j].getNumMinasAlrededor());
            }
          
           System.out.println("");
        }
        
    }
    // acutualiza el numero de minas que hay al rededor
    private void actualizarNMinas(){
          for (int i = 0; i < casilla.length; i++) {
            for (int j = 0; j < casilla[i].length; j++) {
                if (casilla[i][j].isMina()){
                    List<Casilla> casillasAlrededor = obtenerCasillasAlrededor(i, j);
                    casillasAlrededor.forEach((c)->c.IncrementarNumeroMinasAlrededor());
                }
            }
          
  
        }
    }
    //vemos la generacion de los numeros
     private List<Casilla> obtenerCasillasAlrededor(int posFila, int posColumna){
         List<Casilla> listaCasillas = new LinkedList<>();
         for (int i = 0; i < 8; i++) {
             int tmpPosFila=posFila;
             int tmpPosColumna=posColumna;
             switch(i){
                 case 0->{
                     //Arriba
                     tmpPosFila--;
                 }
                 case 1->{
                     //Arriba derecha
                        tmpPosFila--;
                        tmpPosColumna++;
                 }
                 case 2->{
                     //derecha
                       tmpPosColumna++;
                 }
                 case 3->{
                     //Derecha Abajo
                      tmpPosColumna++;
                      tmpPosFila++;
                 }
                 case 4->{
                     //Abajo
                     tmpPosFila++;
                 }
                 case 5->{
                     //Abajo Izquierda
                        tmpPosFila++;
                        tmpPosColumna--;
                 }
                 case 6->{
                     //Izquierda
                             tmpPosColumna--;
                 }
                 case 7->{
                     //Izquierda Arriba
                      tmpPosFila--;
                      tmpPosColumna--;
                 }
             }
             if(tmpPosFila>=0 && tmpPosFila<this.casilla.length && tmpPosColumna>=0 && tmpPosColumna<this.casilla[0].length){
                 listaCasillas.add(this.casilla[tmpPosFila][tmpPosColumna]);
             }
             
         }
         return listaCasillas;
     }
    public static void main(String[] args) {
        // TODO code application logic here
        buscaminas.TableroBuscaminas tablero = new buscaminas.TableroBuscaminas(5, 5, 5);
        tablero.imprimirTablero();
        System.out.println("--------------");
        tablero.imprimirPistas();
    }
  
    }
