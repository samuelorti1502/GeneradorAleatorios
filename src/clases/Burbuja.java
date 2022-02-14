/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel David Ortiz
 */
public class Burbuja extends Thread {

    private int tipoOrdenamiento;
    private int array[];

    private long startDate;
    private long endDate;

    private String tiempo;

    public void Burbuja() {

    }

    public void ordenamientoBurbuja(int[] array, int tipo) {
        this.array = array;
        this.tipoOrdenamiento = tipo;
    }

    public void bAscendente() {
        IntStream.range(0, this.array.length).flatMap(outer -> IntStream.range(1, array.length - outer))
                .forEach(inner -> {

                    if (array[inner - 1] > array[inner]) {

                        int temp = array[inner - 1];

                        array[inner - 1] = array[inner];

                        array[inner] = temp;

                    }

                });
    }

    public void bDescendente() {

        IntStream.range(0, array.length).flatMap(outer -> IntStream.range(1, array.length - outer))
                .forEach(inner -> {

                    if (array[inner - 1] < array[inner]) {

                        int temp = array[inner - 1];

                        array[inner - 1] = array[inner];

                        array[inner] = temp;

                    }

                });

    }

    public static String getDate(long milliseconds, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(milliseconds);
    }

    public void run() {
        long dateTimeStart = System.currentTimeMillis();
        switch (this.tipoOrdenamiento) {
            case 0:
                bAscendente();
                System.out.println("Ordenamiento finalizado ");
                break;
            case 1:
                bDescendente();
                break;
        }

        //String fecha = df.format(today);
        //String hora = dfh.format(today);
        PrintWriter pw;
        try {
            pw = new PrintWriter(Files.newBufferedWriter(Paths.get("./Oburbuja.txt")));

            pw.println("Inicio: " + getDate(dateTimeStart, "dd/MM/yyyy HH:mm:ss:SSS"));

            Arrays.stream(array).forEach(x -> pw.println(x + ", "));

            long dateTimeEnd = System.currentTimeMillis();

            pw.println("Fin: " + getDate(dateTimeEnd, "dd/MM/yyyy HH:mm:ss:SSS"));

            //this.tiempo = "Se tardo: " + getDate((dateTimeEnd - dateTimeStart), "HH:mm:ss:SSS");
            System.out.println("Se tardo: " + getDate((dateTimeEnd - dateTimeStart), "HH:mm:ss:SSS"));

            pw.println("Se tardo: " + getDate((dateTimeEnd - dateTimeStart), "HH:mm:ss:SSS"));

            //pw.println(this.tiempo);
            pw.close();
        } catch (IOException ex) {
            Logger.getLogger(Burbuja.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JOptionPane.showMessageDialog(null, "Ha finalizado el ordenamiento burbuja");

    }

    public String tiempo() {
        return tiempo;
    }

    public static void main(String[] args) {
        (new Thread(new Burbuja())).start();
    }

}
