/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4tema5;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Darks
 */
public class Ejercicio4Tema5 {

    private static boolean fin = false;
    private static final int filas = 8;
    private static final int columnas = 8;
    public static int[] posicionInicial = {1, 1};

    /**
     * Se encarag de llevar la parte logica del problema
     * @param pos
     * @param tablero
     * @param recorrido
     * @return 
     */
    public static ArrayList ejercicio4(int[] pos, int[][] tablero, ArrayList<String> recorrido) {
        if (tableroLleno(tablero)) {
            fin = true;
        } else {
            for (int fil = -2; fil <= 2; fil++) {
                if (fil != 0 && esPar(fil) && !fin) {
                    for (int col = -1; col <= 1; col++) {
                        if (col != 0) {
                            int filaNueva = crearFilaNueva(pos, fil);
                            int columnaNueva = crearColumnaNueva(pos, col);
                            if (movimientoValido(filaNueva, columnaNueva, tablero)) {
                                ArrayList<String> recorridoAntiguo = new ArrayList<>(recorrido);
                                ejercicio4(realizarMovimiento(recorrido, filaNueva, columnaNueva, tablero), tablero, recorrido);
                                recorrido = new ArrayList<>(recorridoAntiguo);
                                tablero[filaNueva][columnaNueva] = 0;
                            }
                        }
                    }

                } else {
                    for (int col = -2; col <= 2; col++) {
                        if (col != 0 && esPar(col) && !fin) {
                            int filaNueva = crearFilaNueva(pos, fil);
                            int columnaNueva = crearColumnaNueva(pos, col);
                            if (movimientoValido(filaNueva, columnaNueva, tablero)) {
                                ArrayList<String> recorridoAntiguo = new ArrayList<>(recorrido);
                                ejercicio4(realizarMovimiento(recorrido, filaNueva, columnaNueva, tablero), tablero, recorrido);
                                recorrido = new ArrayList<>(recorridoAntiguo);
                                tablero[filaNueva][columnaNueva] = 0;
                            }
                        }
                    }
                }
            }

        }
        return recorrido;
    }

    /**
     * A partir de unas coordenadas devuleve la posicion del tablero
     * @param fila
     * @param columna
     * @return 
     */
    public static int determinarPos(int fila, int columna) {
        return columnas * fila + columna;
    }

    /**
     * Se encarag de realizar el movimiento del caballo por el tablero
     * @param recorrido
     * @param fila
     * @param columna
     * @param tablero
     * @return 
     */
    public static int[] realizarMovimiento(ArrayList<String> recorrido, int fila, int columna, int[][] tablero) {
        recorrido.add(fila + "," + columna);
        int[] nuevaPosicion = {fila, columna};
        tablero[fila][columna] = 1;
        return nuevaPosicion;
    }

    /**
     * Determina la fila de la nueva posicion
     * @param posicion
     * @param fila
     * @return 
     */
    public static int crearFilaNueva(int[] posicion, int fila) {
        return posicion[0] - fila;
    }

    /** 
     * Determina la columna de la nueva posicion
     * @param posicion
     * @param columna
     * @return 
     */
    public static int crearColumnaNueva(int[] posicion, int columna) {
        return posicion[1] - columna;
    }

    /**
     * Determina si un numero es par
     * @param num
     * @return 
     */
    public static boolean esPar(int num) {
        return num % 2 == 0;
    }

    /**
     * Determina si un movimiento del caballo es valido
     * @param fila
     * @param columna
     * @param tablero
     * @return 
     */
    public static boolean movimientoValido(int fila, int columna, int[][] tablero) {
        boolean valido = false;
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas && estaVacia(fila, columna, tablero)) {
            valido = true;
        }
        return valido;
    }

    /**
     * Determina si una poasicion del tablero ya ha sido pisada o no
     * @param fila
     * @param columna
     * @param tablero
     * @return 
     */
    public static boolean estaVacia(int fila, int columna, int[][] tablero) {
        boolean vacia = true;
        if (tablero[fila][columna] == 1) {
            vacia = false;
        }
        return vacia;
    }

    /**
     * Devuelve si el tablero esta lleno o no.
     * @param tablero
     * @return 
     */
    public static boolean tableroLleno(int[][] tablero) {
        boolean lleno = true;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j] == 0) {
                    lleno = false;
                    break;
                }
            }
        }
        return lleno;
    }

    /**
     * Se encarga de inicializar el tablero
     * @param pos1
     * @param pos2
     * @return 
     */
    public static int[][] inicializarTablero(int pos1, int pos2) {
        int[][] tablero = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = 0;
            }
        }
        tablero[pos1][pos2] = 1;
        return tablero;
    }

    public static void main(String[] args) {

        ArrayList<String> recorrido = new ArrayList<>();
        ejercicio4(posicionInicial, inicializarTablero(posicionInicial[0], posicionInicial[1]), recorrido);
        System.out.println("Se ha recorrido todas las casillas del tablero, el recorrido es: ");
        recorrido.add(0, "1,1");
        for (int i = 0; i < recorrido.size(); i++) {
            String[] nodo = recorrido.get(i).split(",");
            int posicion = determinarPos(Integer.parseInt(nodo[0]), Integer.parseInt(nodo[1]));
            System.out.print(posicion + "->");
        }
    }

}
