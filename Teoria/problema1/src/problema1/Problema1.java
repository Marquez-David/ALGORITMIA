/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Darks
 */
public class Problema1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList> listaAdyacencia = new ArrayList<>();
        ArrayList<ArrayList> grupos = new ArrayList<>();
        listaAdyacencia = leerArchivo("./ejemplo_voraz.txt");
        System.out.println(listaAdyacencia);
        grupos = crearGrupos(listaAdyacencia);
        System.out.println(grupos);
        System.out.println("El grado de conexion de este grupo de personas es: " + (float) grupos.size() / listaAdyacencia.size());
        escribirArchivo("./resultado.txt", grupos, listaAdyacencia);
    }
    

    public static ArrayList crearGrupos(ArrayList<ArrayList> listaAdyacencia) {
        ArrayList<ArrayList> grupos = new ArrayList<>();
        for (int i = 0; i < listaAdyacencia.size(); i++) {
            int pos = estaEnLista(grupos, listaAdyacencia.get(i).get(0).toString());
            if (pos == -1) { //No esta
                //System.out.println(listaAdyacencia.get(i).get(0) + " no esta en: " + grupos);
                grupos.add(listaAdyacencia.get(i));
            } else { //Si esta
                //System.out.println(listaAdyacencia.get(i).get(0) + " si esta en: " + grupos);
                grupos.get(pos).addAll(listaAdyacencia.get(i));
                eliminarRepetidos(grupos.get(pos));
            }
        }

        return grupos;
    }

    public static int estaEnLista(ArrayList<ArrayList> grupos, String letra) {
        int pos = -1;
        for (int i = 0; i < grupos.size(); i++) {
            for (int j = 0; j < grupos.get(i).size(); j++) {
                if (grupos.get(i).get(j).toString().equals(letra)) {
                    pos = i;
                    return pos;
                }
            }
        }
        return pos;
    }

    public static ArrayList eliminarRepetidos(ArrayList lista) {
        HashSet hs = new HashSet();
        hs.addAll(lista);
        lista.clear();
        lista.addAll(hs);
        return lista;
    }

    public static ArrayList<ArrayList> leerArchivo(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        ArrayList<ArrayList> listaAdyacencia = new ArrayList<>();
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            String[] str = cadena.split(" ");
            listaAdyacencia.add(annadirElems(str));
        }
        b.close();
        return listaAdyacencia;
    }
    
    public static ArrayList annadirElems(String[] str) {
        ArrayList<String> lista = new ArrayList<>();
        for(int i = 0; i < str.length; i++) {
            lista.add(str[i]);
        }
        return lista;
    }

    public static void escribirArchivo(String archivo, ArrayList grupos, ArrayList listaAdyacencia) throws IOException {
        File f = new File(archivo);
        try {
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write("El numero de grupos es: " + grupos.size() + "\n");
            wr.write("Los integrantes de dada grupos son: " + grupos + "\n");
            wr.write("El grado de conexion de este grupo de personas es: " + (float) grupos.size() / listaAdyacencia.size());//escribimos en el archivo
            wr.close();
            bw.close();
        } catch (IOException e) {
        };
    }

}
