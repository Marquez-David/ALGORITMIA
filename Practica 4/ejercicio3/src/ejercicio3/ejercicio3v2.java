/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import static ejercicio3.Ejercicio3.devolverCambio;
import java.util.HashMap;

/**
 *
 * @author Darks
 */
public class ejercicio3v2 {
    public static void main(String[] args) {
        Ejercicio3 ej3 = new Ejercicio3();
        int[] billetes = {1, 2, 2, 2, 3, 3, 4};
        
        respuesta(billetes, ej3.devolverCambio(billetes, 7));
    }
    
    public static void respuesta(int[] valor, int[][] tabla){
        if(tabla[tabla.length-1][tabla[0].length-1]!=9999){
            HashMap<Integer,Integer> billetes  = new HashMap<>();
            for(int i=0;i<valor.length;i++) {
                billetes.put(valor[i], 0);
            }
            respuestaAlgoritmo(valor, tabla, tabla.length-1, tabla[0].length-1, billetes);
            System.out.println("Para devolver un cambio de "+(tabla[0].length-1)+" se necesitan:");
            for(int v:billetes.keySet()){
                System.out.println(billetes.get(v)+" billetes de "+v);
            }
        }else{
            System.out.println("No es posible dar el cambio de "+(tabla[0].length-1));
        }
        System.out.println();
    }
    
    private static void respuestaAlgoritmo(int[] valor, int[][] devolucion, int f, int c, HashMap<Integer,Integer> billetes){
        if((devolucion[f][c] != 9999)&&(f>=0)&&(c>=0)){
            if(f>0){
                if(c<valor[f]) respuestaAlgoritmo(valor, devolucion, f-1, c, billetes);
                else{
                    if(devolucion[f-1][c]>devolucion[f][c]){
                        billetes.put(valor[f], billetes.get(valor[f])+1);
                        respuestaAlgoritmo(valor, devolucion, f-1, c-valor[f], billetes);
                    }else{
                        respuestaAlgoritmo(valor, devolucion, f-1, c, billetes);
                    }
                }
            }else{
                if((devolucion[f][c]!=0)&&(devolucion[f][c]!=9999)){
                    billetes.put(valor[f], billetes.get(valor[f])+1);
                }
            }
        }
    }
    
}
