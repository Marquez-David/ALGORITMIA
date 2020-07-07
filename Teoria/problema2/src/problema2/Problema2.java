/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Darks
 */
public class Problema2 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException 
     */
    public static void main(String[] args) throws IOException {

        ArrayList<Float> arrayInicial;
        arrayInicial = leerArchivo("./ejemplo_dyv.txt");

        //Controlo si el array es potencia de dos o no, importante para el algoritmo
        if (arrayInicial.size() / 2 % 2 == 0 && arrayInicial.size() % 2 == 0) {
            System.out.println("El array es potencia de dos");
            System.out.println(arrayInicial);
            float media = mediaDivYVencPot2(0, arrayInicial.size() - 1, arrayInicial);
            System.out.println(media);
            escribirArchivo("./archivoMedia.txt", media);
        } else {
            System.out.println("El array no es potencia de dos");
            System.out.println(arrayInicial);
            float media = mediaDivYVencNoPot2(0, arrayInicial.size() - 1, arrayInicial)/arrayInicial.size();
            System.out.println(media);
            escribirArchivo("./archivoMedia.txt", media);
        }

    }

    /**
     * Lee un txt y guarda los elementos en una array de enteros
     *
     * @param archivo
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList leerArchivo(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        int i = 0;
        ArrayList<Float> notas = new ArrayList<>();
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            notas.add(Float.parseFloat(cadena));
            //System.out.println(cadena + " con id " + i);
            i++;
        }
        b.close();
        return notas;
    }

    /**
     * Crea un archivo con la nota media del alumno
     *
     * @param archivo
     * @param media
     * @throws IOException
     */
    public static void escribirArchivo(String archivo, float media) throws IOException {
        File f = new File(archivo);
        try {
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write("Esta es la nota media: " + media);//escribimos en el archivo
            wr.close();
            bw.close();
        } catch (IOException e) {
        };
    }

    /**
     * Realiza la media de notas de un alumno mediante el algoritmo de divide y
     * venceras, siendo el tamanno de la lista potencia de dos.
     *
     * @param inicio
     * @param fin
     * @param arrayInicial
     * @return
     */
    public static float mediaDivYVencPot2(int inicio, int fin, ArrayList arrayInicial) {
        if (inicio == fin) {
            return (float) arrayInicial.get(inicio);
        } else {
            int mitad = (inicio + fin) / 2;
            float x = mediaDivYVencPot2(inicio, mitad, arrayInicial);
            float y = mediaDivYVencPot2(mitad + 1, fin, arrayInicial);

            return (y + x) / 2;
        }

    }
    
    /**
     * Calcula la media de una lista de notas, siendo el tamanno de la lista != potencia de dos
     * @param inicio
     * @param fin
     * @param arrayInicial
     * @return 
     */
    public static float mediaDivYVencNoPot2(int inicio, int fin, ArrayList arrayInicial) {
        if (inicio == fin) {
            return (float) arrayInicial.get(inicio);
        } else {
            int mitad = (inicio + fin) / 2;
            float x = mediaDivYVencNoPot2(inicio, mitad, arrayInicial);
            float y = mediaDivYVencNoPot2(mitad + 1, fin, arrayInicial);

            return x + y;
        }

    }
    

}
