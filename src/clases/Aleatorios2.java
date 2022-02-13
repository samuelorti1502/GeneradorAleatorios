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
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import javax.swing.JLabel;

/**
 *
 * @author Samuel David Ortiz
 */
public class Aleatorios2 extends Thread {

    JLabel label;

    public void cantidad(JLabel label) {
        this.label = label;
    }

    public void run() {
        int min_val = -10000000;
        int max_val = 10000000;
        Random rand = new Random();
        AtomicInteger count = new AtomicInteger(0);
        //int i = 0;
        IntStream aleatorios = rand.ints(1000000, min_val, max_val);

        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get("./aleatorios.csv")))) {
            //pw.print("Hola");
           
            aleatorios.forEach(x -> pw.println(count.incrementAndGet() + "., " + x + ", "));
            
            pw.close();

            //aleatorios.forEach(x -> System.out.println(count.incrementAndGet() + "., " + x + ","));
        } catch (IOException ex) {
            Logger.getLogger(Aleatorios2.class.getName()).log(Level.SEVERE, null, ex);
            //pw.close();
        };

    }

    public static void main(String[] args) {
        // TODO code application logic here
        (new Thread(new Aleatorios())).start();
    }

}
