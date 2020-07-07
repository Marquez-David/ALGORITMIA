/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Darks
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] billetes = {1, 2, 2, 2, 3, 3, 4};
        int cambio = 7;
        int[][] matriz = devolverCambio(billetes, cambio);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == 9999){
                   System.out.print("inf"); 
                   System.out.print("   ");
                }else{
                    System.out.print(matriz[i][j]);
                    System.out.print("     ");
                }
                if(j == cambio){
                    System.out.println();
                }
            }
        }
        
    }
    
    public static int[][] devolverCambio(int[] billetes, int cambio) {
        int[][] matriz = new int[billetes.length][cambio + 1];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (j == 0) { //Si nos encontramos en la primera columna de la tabla
                    matriz[i][j] = 0; //El numero de billetes a devolver sera 0
                } else if (i == 0) { //Si estamos en al primera fila
                    if (billetes[i] == j) {
                        matriz[i][j] = 1; //Solo usamos un billete, el que tenemos
                    } else {
                        matriz[i][j] = 9999;
                    }
                } else if (j < billetes[i]) { //Si estamos en el resto de celdas
                    matriz[i][j] = matriz[i - 1][j];
                } else {
                    matriz[i][j] = Integer.min(matriz[i - 1][j - billetes[i]] + 1, matriz[i - 1][j]);
                }
            }
        }

        return matriz;
    }
    
    

}
