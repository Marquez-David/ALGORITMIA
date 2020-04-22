/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio7;

/**
 *
 * @author Darks
 */
public class Ejercicio7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] sec1 = {0, 1, 1, 0, 1, 0, 1, 0};
        int[] sec2 = {1, 0, 1, 0, 0, 1, 0, 0, 1};

        int[][] tabla = subsecuencias(sec1, sec2);
        int tamSecMasLarga = tabla[sec2.length - 1][sec1.length - 1];

        System.out.println("tabla");
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                System.out.print(tabla[i][j]);
            }
            System.out.println();
        }

        System.out.println("El tamano de la secuencia ams larga es: " + tamSecMasLarga);
        System.out.println("Una de las subsecuencias mas argas es: " + subSecuenciaMasLarga(sec1, sec2, tamSecMasLarga));
    }

    public static int[][] subsecuencias(int[] secuencia1, int[] secuencia2) {

        int[][] tabla = new int[secuencia2.length][secuencia1.length]; //Esta avriable representanra la tabal del ejemplo
        //Ahora nos encaregamos de rellenar la tabla
        for (int i = 0; i < tabla.length; i++) { //Recorremos las columnas
            for (int j = 0; j < tabla[0].length; j++) { //Recorremos las filas
                if (i == 0) { //Si estamos en la primera columna
                    if (secuencia2[0] == secuencia1[j]) {
                        tabla[i][j] = 1;
                    } else {
                        tabla[i][j] = 0;
                    }

                } else if (j == 0) { //Si estamos en la primera fila
                    if (secuencia2[0] == secuencia1[j]) {
                        tabla[i][j] = 1;
                    } else {
                        tabla[i][j] = tabla[i - 1][j];
                    }
                } else { //Si estamos en el resto de la tabla
                    if (secuencia2[i] == secuencia1[j]) {
                        tabla[i][j] = 1 + tabla[i - 1][j - 1];
                    } else {
                        tabla[i][j] = Math.max(tabla[i][j - 1], tabla[i - 1][j]);
                    }
                }
            }

        }

        return tabla;
    }

    /**
     * Funcion que detemrina la subsecuencia mas larga dadas dos secuencias
     *
     * @param secuencia1
     * @param secuencia2
     * @return
     */
    public static String subSecuenciaMasLarga(int[] secuencia1, int[] secuencia2, int tamSec) {

        int[][] tabla2 = new int[secuencia2.length][secuencia1.length];
        String secMasLarga = "";
        for (int i = 0; i < tabla2.length; i++) { //Recorremos las columnas
            for (int j = 0; j < tabla2[0].length; j++) { //Recorremos las filas
                if (secuencia2[i] == secuencia1[j]) {
                    tabla2[i][j] = 1;
                } else {
                    tabla2[i][j] = 0;
                }
            }
        }

        int cont = 0;
        int i = 1;
        int j = 0;
        while (cont < tamSec) {
            if (tabla2[i][j] == 1) {
                secMasLarga += secuencia2[i];
                i++;
                j++;
                cont ++;
            } else {
                j++;
            }
        }

        return secMasLarga;
    }

}
