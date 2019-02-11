/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.juegode.la.viada;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author andre
 */
public class PruebaJuegodeLaViada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Inicializamos un Scanner
        Scanner teclado = new Scanner(System.in);
        
        //Constante varibale de las celulas, ya que el numero de estos variara 
//        int cell = 5;
//        boolean moverse = true;
//        boolean[] estadoCell={true,true,true,true,true};1
        System.out.println("INTRODUCE LAS DIMENSCIONES DEL TABLERO");
        System.out.println("Introduce las filas");
        int tableroX=teclado.nextInt();
        System.out.println("Introduce las columnas");
        int tableroY=teclado.nextInt();
        //Tablero y Random
        String[][] tablero = new String [tableroX][tableroY];
        Random aleatorio = new Random ();
        
        //CREAMOS UN TABLERO SECUNDARIO
        String tableroAux[][] = new String[tableroX][tableroY];
        
        //Rellenar el tablero de asteriscos(*)
        for (int i = 0; i < tableroX; i++) {
            for (int j = 0; j < tableroY; j++) {
                tablero[i][j] = "*";
            }
        }
        
        //Declaramos una String para guardar las posiciones de las celulas
//        int[] posicionCellX = new int[10];
//        int[] posicionCellY = new int[10];
//        int desplazamientoX;
//        int desplazamientoY;
//        int nuevaPosCellX;
//        int nuevaPosCellY;
         
        //Colocamos las celulas aleatoriamente en el tablero
        int numX;
        int numY;
        //Colocamos celulas aleatorias en el tablero
        for (int i = 0; i < 10; i++) {
            do {                
                numX=aleatorio.nextInt(10);
                numY=aleatorio.nextInt(10);
            } while (!tablero[numX][numY].equals("*"));
            tablero[numX][numY]="C";
            //Guardamos las posiciones de las celulas
//            posicionCellX[i] = numX;
//            posicionCellY[i] =numY;
        }
        //Igualamos el tablero principal con el segundo tablero
        for (int i = 0; i < tableroX; i++) {
            for (int j = 0; j < tableroY; j++) {
                //De esta forma tendremos dos tableros iguales
                tableroAux[i][j] =tablero[i][j];
            }
        }
        
        //Imprimimos el tablero con todas las celulas
        for (int i = 0; i < tableroX; i++) {
            for (int j = 0; j < tableroY; j++) {
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println("");  
        }
        int contadorTurnos=0;
        int contador=0;
        do {            
            //RECORREMOS TODO EL TABLERO
            for (int i = 0; i < tableroX; i++) {
                for (int j = 0; j < tableroY; j++) {
                    //COMPROBAMOS SI ES UNA CELULA MUERTA O VIVA
                    if(tablero[i][j].equals("C")){
                        //RECORREMOS LOS ALREDEDORES DEL TABLERO
                        for (int k = -1; k < 2; k++) {
                            for (int l = -1; l < 2; l++) {
                                //COMPROBAMOS LOS LIMITES DEL TABLERO
                                if((i+k)<0 ||(i+k)>=tableroX || (j+l)<0 || (j+l)>=tableroY || (k==0&&l==0) ){
                                    
                                }else{
                                    if(tablero[(i+k)][(j+l)].equals("C")){
                                        contador++;
                                    }
                                    
                                }
                            }
                        }
                        //FIN DEL BUCLE DE ALREDEDOR
                        
                        //CAMBIAMOS EL VALOR DEPENDIENDO DEL CONTADOR
                        if(contador<2){//SI TIENE MENOS DE DOS CELULAS VECINAS ESTA MUERE POR SOLEDAD
                            tableroAux[i][j]="*";
                            
                        }else{
                            if(contador>3){//SI TIENE MAS DE TRES CELULAS VECINAS ESTA MUERE POR SOBREPOBLACION
                                tableroAux[i][j]="*";
                            }
                        }
                        //RESETEAMOS EL CONTADOR
                        contador=0;
                    }else{
                        for (int k = -1; k < 2; k++) {
                            for (int l = -1; l < 2; l++) {
                                //COMPROBAMOS LOS LIMITES DEL TABLERO
                                if((i+k)<0 ||(i+k)>=tableroX || (j+l)<0 || (j+l)>=tableroY || (k==0&&l==0) ){
                                    
                                }else{
                                    if(tablero[(i+k)][(j+l)].equals("C")){
                                        contador++;
                                    }
                                }
                            }
                        }
                        if(contador==3){
                            tableroAux[i][j]="C";
                        }
                        //RESETEAMOS EL CONTADOPR
                        contador=0;
                    }
                }
            }
            System.out.println("------------------------------------------------\n\n");
            
            //Imprimimos el tablero con todas las celulas
            for (int i = 0; i < tableroX; i++) {
                for (int j = 0; j < tableroY; j++) {
                    System.out.print(tableroAux[i][j]+" ");
                }
                System.out.println("");  
            }
            
            //AHORA COLOCAMOS EL TABLEROAUX A EL TABLERO PRINCIPAL
            for (int i = 0; i < tableroX; i++) {
                for (int j = 0; j < tableroY; j++) {
                    tablero[i][j] = tableroAux[i][j];//DE ESTA FORMA LOS TABLEROS SERAN IGUALES
                }
            }
            contadorTurnos++;
        } while (contadorTurnos<3);
    }
    
}
