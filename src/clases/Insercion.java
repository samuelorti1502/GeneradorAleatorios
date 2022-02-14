/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import static clases.Burbuja.getDate;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel David Ortiz
 */
public class Insercion extends Thread {

    private int arrayToSort[];

    public Insercion() {

    }

    public void insertionSort(int array[]) {
        this.arrayToSort = array;
        
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public void run() {
        
        long dateTimeStart = System.currentTimeMillis();

        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get("./Oinsercion.txt")))) {

            pw.println("Inicio: " + getDate(dateTimeStart, "dd/MM/yyyy HH:mm:ss:SSS"));

            insertionSort(this.arrayToSort);

            Arrays.stream(this.arrayToSort).forEach(x -> pw.println(x + ", "));

            long dateTimeEnd = System.currentTimeMillis();
            
            pw.println("Fin: " + getDate(dateTimeEnd, "dd/MM/yyyy HH:mm:ss:SSS"));
            System.out.println("Se tardo: " + getDate((dateTimeEnd - dateTimeStart), "HH:mm:ss:SSS"));
            pw.println("Se tardo: " + getDate((dateTimeEnd - dateTimeStart), "HH:mm:ss:SSS"));
            
            pw.close();

        } catch (IOException ex) {
            Logger.getLogger(Shell.class.getName()).log(Level.SEVERE, null, ex);
        };

    }

}
