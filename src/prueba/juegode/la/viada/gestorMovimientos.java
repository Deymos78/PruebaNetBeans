/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.juegode.la.viada;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author andre
 */
public class gestorMovimientos {
    
    public static void mensajeInicial(){
        System.out.println("INTRODUCE LAS DIMENSCIONES DEL TABLERO Y EL NUMERO DE CELULAS");
    }
    
    public static String[][] rellenarTablero(int x, int y, String tablero[][]){
        //Rellenar el tablero de asteriscos(*)
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tablero[i][j] = "*";
            }
        }
        //Devolvemos el tablero Relleno de asteriscos
        return tablero;
    }
    
    public static String[][] colocarCelulas(int celulas,int x, int y, String tablero[][]){
        Random aleatorio = new Random ();
        //Colocamos las celulas aleatoriamente en el tablero
        int numX;
        int numY;
        //Colocamos celulas aleatorias en el tablero
        for (int i = 0; i < celulas; i++) {
            do {                
                numX=aleatorio.nextInt(x);
                numY=aleatorio.nextInt(y);
            } while (!tablero[numX][numY].equals("*"));
            tablero[numX][numY]="C";
        }
        return tablero;
    }

    public static String[][] rellenarTableroAuxoPrincipal(int x, int y, String tableroAux[][], String tablero[][]){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                //De esta forma tendremos dos tableros iguales
                tableroAux[i][j] =tablero[i][j];
            }
        }
        return tableroAux;
    }
    
    public static void imprimirtablero(int x, int y, String[][] tablero){
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println("");  
        }
    }
    
    public static int contarCelulasVecinas(int x, int y, String tablero[][], int i, int j){
        int contadorCelulasVecinas=0;
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {
                //COMPROBAMOS LOS LIMITES DEL TABLERO
                if((i+k)<0 ||(i+k)>=x || (j+l)<0 || (j+l)>=y || (k==0&&l==0) ){

                }else{
                    if(tablero[(i+k)][(j+l)].equals("C")){
                        contadorCelulasVecinas++;
                    }

                }
            }
        }
        //FIN DEL BUCLE DE ALREDEDOR
        return contadorCelulasVecinas;
    }
    
    public static String[][] updatetableroAux(int estado, int i, int j, String tableroAux[][], int celulasVecinas){
        //Dependiendo del estado la celula estara muerta o viva
        // estado==0 ---> MUERTA
        // estado==1 ---> VIVA
        if(estado==1){
            if(celulasVecinas<2){//SI TIENE MENOS DE DOS CELULAS VECINAS ESTA MUERE POR SOLEDAD
            tableroAux[i][j]="*";

            }else{
                if(celulasVecinas>3){//SI TIENE MAS DE TRES CELULAS VECINAS ESTA MUERE POR SOBREPOBLACION
                    tableroAux[i][j]="*";
                }
            }
        }else if(estado==0){
            if(celulasVecinas==3){
                tableroAux[i][j]="C";
            }
        }
        
        return tableroAux;
    }
    
    public static void comenzarJuego(int tableroX, int tableroY, String tablero[][], String tableroAux[][]){
        //Contador para los turnos, es decir, el numero de veces que se ejecutar el bucle
        //PUEDE SER INFINITO, PERO NO LO HACEMOS EN ESTE CASO
        int contadorTurnos=0;
        
        //Contador para contar el nuemro de Celulas Vecinas
        int contadorCelulasVecinas=0;
        
        do {            
            //RECORREMOS POSICION POR POSICION EL TABLERO PRINCIPAL
            for (int i = 0; i < tableroX; i++) {
                for (int j = 0; j < tableroY; j++) {
                    //COMPROBAMOS SI ES UNA CELULA VIVA O MUERTA
                    if(tablero[i][j].equals("C")){
                        //RECORREMOS LOS ALREDEDORES DE LA CELULA EN LA QUE NOS ENCONTREMOS
                        contadorCelulasVecinas=contarCelulasVecinas(tableroX, tableroY, tablero, i, j);
                        
                        //Modificamos la celula en funcion del contador de celulas vecinas, enviamos un 1 si la celula esta viva
                        // y un 0 si la celula esta muerta
                        tableroAux=updatetableroAux(1, i, j, tableroAux, contadorCelulasVecinas);
                        
                        //RESETEAMOS EL CONTADOR
                        contadorCelulasVecinas=0;
                    }else{
                        //Recorremos el alrededor de la celula en la que nos encontramos
                        contadorCelulasVecinas=contarCelulasVecinas(tableroX, tableroY, tablero, i, j);
                        
                        //Modificamos la celula en funcion del contador de celulas vecinas
                        //Enviamos un 0, ya que la celula esta muerta
                        tableroAux=updatetableroAux(0, i, j, tableroAux, contadorCelulasVecinas);
                        
                        //RESETEAMOS EL CONTADOPR
                        contadorCelulasVecinas=0;
                    }
                }
            }
            System.out.println("------------------------------------------------\n\n");
            
            //En ESTE CASO LE PASAMOS EL TABLERO AUXILIAR, YA QUE QUEREMOS QUE NOS IMPRIMA ESTE
            imprimirtablero(tableroX, tableroY, tableroAux);
            
            //Empleamos el metod anterior, pero en este caso queremos copiar tablero principal y pegarlo en el principal
            tablero=rellenarTableroAuxoPrincipal(tableroX, tableroY, tablero, tableroAux);
            
            //Esta variable nos permitira controlar el numero de repeticiones del bucle
            contadorTurnos++;
        } while (contadorTurnos<3);

    }
    
    
    
}
