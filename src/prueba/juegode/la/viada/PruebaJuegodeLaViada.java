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
        //Instanciasmos un objeto de la clase Scanner
        Scanner teclado = new Scanner(System.in);

        //Mostramos un mensaje inicial con instrucciones
        gestorMovimientos.mensajeInicial();
        
        //PEDIMOS LA DIMENSION DEL TABLERO Y EL NUMERO DE CELULAS QUE TENDRA
        //NO CONTROLAMOS LOS DATOS QUE INTRODUZCA EL USUARIO
        System.out.println("Introduce las filas");
        int tableroX=teclado.nextInt();
        System.out.println("Introduce las columnas");
        int tableroY=teclado.nextInt();
        System.out.println("Introduce el numero de celulas aleatorias");
        int celulas=teclado.nextInt();
        
        //Creamos un Array Bidimensional de tipo String
        //La dimension del Array Bidimensional dependera de los valores introducidos por el Usuario
        String[][] tablero = new String [tableroX][tableroY];
        
        //CREAMOS UN TABLERO AUXILIAR CON LA MISMA DIMENSION QUE EL PRINCIPAL
        String tableroAux[][] = new String[tableroX][tableroY];
        
        //Rellenamos el tablero principal
        tablero=gestorMovimientos.rellenarTablero(tableroX, tableroY, tablero);
        
        //Rellenamos el tablero principal de celulas aleatorias
        tablero= gestorMovimientos.colocarCelulas(celulas, tableroX, tableroY, tablero);
        
        //Clonamos el tablero principal, y lo guardamos el el tablero auxiliar
        tableroAux=gestorMovimientos.rellenarTableroAuxoPrincipal(tableroX, tableroY, tableroAux, tablero);
        
        //Imprimimos el tablero principal con todos sus elementos
        gestorMovimientos.imprimirtablero(tableroX, tableroY, tablero);
        
        //COMENZAMOS EL JUEGO DE LA VIDA
        gestorMovimientos.comenzarJuego(tableroX, tableroY, tablero, tableroAux);
    }
    
}
