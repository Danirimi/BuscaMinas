package buscaminas;

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
        
    }
    private void imprimirTablero(){
        for (int i = 0; i < casilla.length; i++) {
            for (int j = 0; j < casilla[i].length; j++) {
                System.out.print(casilla[i][j].isMina()?"1":"0");
            }
          
           System.out.println("");
        }

    }
  
    }
