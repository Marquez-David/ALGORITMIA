/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author David Marquez Minguez
 */
public class Problema4 {

    static String[][] tablero;
    static ArrayList<ArrayList<String>> solucion = new ArrayList<>();
    static ArrayList<String> movimientos = new ArrayList<>();
    static int numFilas = 0;
    static int numColumnas = 0;

    public static void main(String[] args) throws IOException {

        leerArchivo("./ejemplo_backtracking.txt");
        System.out.println("Num filas: " + numFilas);
        System.out.println("Num columnas: " + numColumnas);
        System.out.println("-------TABLERO-------");
        imprimirTablero();
        int[] posInicial = getPosInicial(tablero);

        if (encontrarSolucion(posInicial[0], posInicial[1])) { //encuentra solucion
            System.out.println("------SOLUCION------");
            escribirSolucion();
            imprimirSolucion();
        } else { //no encunetra solucion
            System.out.println("No hay solucion");
            escribirArchivo("No hay solucion");
        }

    }

    /**
     * Inicializa el array de solucion
     */
    public static void inicializarSolucionTablero() {
        ArrayList<String> temp;
        tablero = new String[numFilas][numColumnas];
        for (int i = 0; i < numFilas; i++) {
            temp = new ArrayList<>();
            for (int j = 0; j < numColumnas; j++) {
                temp.add("0");
                tablero[i][j] = "0";
            }
            solucion.add(temp);
        }
    }

    /**
     * Imprime el tablero
     */
    public static void imprimirTablero() {
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                System.out.print(tablero[i][j] + "\t");
            }
            System.out.print("\n\n");
        }
    }

    /**
     * Escribe el un archivo de salida la socuion encontrada
     *
     * @throws IOException
     */
    public static void escribirSolucion() throws IOException {
        Collections.reverse(movimientos);
        String temp = "";
        ArrayList<String> texto = new ArrayList<>();
        for (int i = 0; i < movimientos.size(); i++) {
            texto.add(0, temp + movimientos.get(i) + "\n");
            temp = texto.get(0);
        }
        escribirArchivo(texto.get(0));
    }

    /**
     * Imprime el array solucion
     *
     * @throws IOException
     */
    public static void imprimirSolucion() throws IOException {
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                System.out.print(solucion.get(i).get(j) + "\t");
            }
            System.out.print("\n\n");
        }
    }

    /**
     * Obtiene la posicion de salida a partir de un tablero
     *
     * @param laberinto
     * @return
     */
    public static int[] getPosInicial(String[][] laberinto) {
        int[] pos = {0, 0};
        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                if ("1".equals(laberinto[i][j])) {
                    pos[0] = i;
                    pos[1] = j;
                }
            }

        }
        return pos;
    }

    /**
     * Se encarga de encontrar la posicion final mediante backtracking
     *
     * @param fila
     * @param columna
     * @return
     */
    public static boolean encontrarSolucion(int fila, int columna) {
        if ((fila == 0) && (columna == 3)) { //solucion?
            solucion.get(fila).add(columna, "x");
            return true;
        }
        if (dentroTablero(fila, columna) && posValida(fila, columna)) { //pos valida?
            solucion.get(fila).set(columna, "x");
            if (encontrarSolucion(fila - 1, columna)) { //arriba
                movimientos.add("[" + fila + "," + columna + "]" + " movimiento hacia arriba");
                return true;
            }
            if (encontrarSolucion(fila, columna + 1)) { //derecha
                movimientos.add("[" + fila + "," + columna + "]" + " movimiento hacia la derecha");
                return true;
            }
            solucion.get(fila).set(columna, "0");
            return false;
        }
        return false;
    }

    /**
     * Determina si una posicion enta dentro del tablero o no
     *
     * @param fila
     * @param columna
     * @return
     */
    public static boolean dentroTablero(int fila, int columna) {
        boolean dentro = false;
        if (fila >= 0 && columna >= 0 && fila < numFilas && columna < numColumnas) {
            dentro = true;
        }
        return dentro;
    }

    /**
     * Determina si una posicion es valida o no
     *
     * @param fila
     * @param columna
     * @return
     */
    public static boolean posValida(int fila, int columna) {
        boolean valida = false;
        if ("0".equals(solucion.get(fila).get(columna)) && "0".equals(tablero[fila][columna]) || "1".equals(tablero[fila][columna]) || "2".equals(tablero[fila][columna])) {
            valida = true;
        }
        return valida;
    }

    /**
     * Lee datos de un archivo txt
     *
     * @param archivo
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void leerArchivo(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        int i = 0;
        String[] temp;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            if (i == 0) { //leo el numero de filas
                numFilas = Integer.parseInt(cadena);
            } else if (i == 1) { //leo el numeor de columnas
                numColumnas = Integer.parseInt(cadena);
                inicializarSolucionTablero();
            } else {
                temp = new String[numColumnas];
                //System.out.println(Arrays.toString(cadena.split("\t")));
                temp = cadena.split("\t");
                for (int j = 0; j < numColumnas; j++) {
                    tablero[i - 2][j] = temp[j]; //-2 porque el else entra con i = 2
                }
            }
            i++;
        }
        b.close();
    }

    /**
     * Escribe datos en un archivo txt
     *
     * @param cadena
     * @throws IOException
     */
    public static void escribirArchivo(String cadena) throws IOException {
        try {
            File salida = new File("./solucion.txt"); //fichero salida
            FileWriter w = new FileWriter(salida);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write(cadena);//escribimos en el archivo
            wr.close();
            bw.close();
        } catch (IOException e) {
        };
    }

}
