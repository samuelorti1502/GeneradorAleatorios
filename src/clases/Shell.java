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
public class Shell extends Thread {

    private int arrayToSort[];

    public Shell() {

    }

    public void shellSort(int array[]) {
        this.arrayToSort = array;
        int n = this.arrayToSort.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = this.arrayToSort[i];
                int j = i;
                while (j >= gap && this.arrayToSort[j - gap] > key) {
                    this.arrayToSort[j] = this.arrayToSort[j - gap];
                    j -= gap;
                }
                this.arrayToSort[j] = key;
            }
        }
    }

    public void run() {
        long dateTimeStart = System.currentTimeMillis();
        //System.out.println("Inicio: " + getDate(dateTimeStart, "dd/MM/yyyy HH:mm:ss:SSS"));

        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get("./shell.txt")))) {

            pw.println("Inicio: " + getDate(dateTimeStart, "dd/MM/yyyy HH:mm:ss:SSS"));

            shellSort(this.arrayToSort);

            Arrays.stream(this.arrayToSort).forEach(x -> pw.println(x + ", "));

            long dateTimeEnd = System.currentTimeMillis();
            //System.out.println("Fin: " + getDate(dateTimeEnd, "dd/MM/yyyy HH:mm:ss:SSS"));

            System.out.println("Se tardo: " + getDate((dateTimeEnd - dateTimeStart), "HH:mm:ss:SSS"));
            pw.println("Se tardo: " + getDate((dateTimeEnd - dateTimeStart), "HH:mm:ss:SSS"));
            
            pw.close();

        } catch (IOException ex) {
            Logger.getLogger(Shell.class.getName()).log(Level.SEVERE, null, ex);
        };

    }

    public static void main(String[] args) {
        (new Thread(new Shell())).start();
    }
}
