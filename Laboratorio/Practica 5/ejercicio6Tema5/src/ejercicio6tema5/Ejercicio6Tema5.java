/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio6tema5;

import java.util.ArrayList;

/**
 *
 * @author Darks
 */
public class Ejercicio6Tema5 {

    private static boolean fin;

    public static void ejercicio6(String[][] matriz, ArrayList<String> secuencia, String caracterFinal, ArrayList<String> listaSecuencias) {
        if ((secuencia.size() == 1) && (caracterFinal.equals(secuencia.get(0)))) {
            for (int i = 0; i < listaSecuencias.size(); i++) {
                System.out.println(listaSecuencias.get(i));
            }
            fin = true;
        } else {
            int cont = 0;
            while (cont < secuencia.size() - 1 && !fin) {
                //Guardamos la palabra para los nodos hermanos
                ArrayList<String> palabraAnterior = new ArrayList<>(secuencia);
                ArrayList<String> secuenciasAnterior = new ArrayList<>(listaSecuencias);
                //Creamos la nueva palabra según la matriz
                String sustituto = matriz[determinarPos(secuencia.get(cont))][determinarPos(secuencia.get(cont + 1))];
                secuencia = new ArrayList<>(crearSecuencia(secuencia, sustituto, cont));
                listaSecuencias.add(secuencia.toString());
                cont++;
                ejercicio6(matriz, secuencia, caracterFinal, listaSecuencias);
                listaSecuencias = new ArrayList<>(secuenciasAnterior);
                secuencia = new ArrayList<>(palabraAnterior);
            }

        }

    }

    public static int determinarPos(String letra) {
        int pos = 0;
        if ("a".equals(letra)) {
            pos = 0;
        } else if ("b".equals(letra)) {
            pos = 1;
        } else if ("c".equals(letra)) {
            pos = 2;
        } else {
            pos = 3;
        }
        return pos;
    }

    /**
     * Devuleve una secuencia nueva dada una posicion y la tabla
     * @param palabra
     * @param sustituto
     * @param pos
     * @return 
     */
    public static ArrayList<String> crearSecuencia(ArrayList<String> palabra, String sustituto, int pos) {
        palabra.remove(pos);
        palabra.remove(pos);
        palabra.add(pos, sustituto);
        return palabra;
    }

    public static void main(String[] args) {
        ArrayList<String> secuencia = new ArrayList<>();
        secuencia.add("a");
        secuencia.add("c");
        secuencia.add("a");
        secuencia.add("b");
        secuencia.add("a");
        secuencia.add("d");
        secuencia.add("a");
        ArrayList<String> secuencias = new ArrayList<>();
        secuencias.add(secuencia.toString());
        String[][] tabla = {{"b", "b", "a", "d"}, {"c", "a", "d", "a"}, {"b", "a", "c", "c"}, {"d", "c", "d", "b"}};

        ejercicio6(tabla, secuencia, "d", secuencias);
    }

}
