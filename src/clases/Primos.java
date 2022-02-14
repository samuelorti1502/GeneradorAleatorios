/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel David Ortiz
 */
public class Primos extends Thread {

    private int primo;

    public Primos() {
        //primoss();
        
    }

    public void primoss() {

        int cont = 0;

        try {
            Scanner inFile = new Scanner(new FileReader("./shell.txt"));

            while (inFile.hasNextLine()) {
                Scanner inLine = new Scanner(inFile.nextLine());
                while (inLine.hasNextLine()) {
                    String a;
                    a = inLine.nextLine();
                    int l = a.length();
                    //int z[] = new int[l];
                    String x[] = new String[l];

                    x = a.split(",");

                    int num = Integer.parseInt(x[0]);
                    if(esPrimo(num)){
                        
                        cont++;
                    }

                }
            }
            System.out.println(cont);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Primos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static boolean esPrimo(int num) {
        boolean primo = (num == 1) ? false : true;
        int divisor = 2;
        while (primo && divisor <= Math.sqrt(num)) {
            if (num % divisor == 0) {
                primo = false;
            }
            divisor++;
        }
        return primo;
    }

    public void primo() {

        Scanner inFile;
        try {
            inFile = new Scanner(new FileReader("./shell.txt"));
            while (inFile.hasNextLine()) {
                Scanner inLine = new Scanner(inFile.nextLine());
                while (inLine.hasNextLine()) {

                    String a;
                    a = inLine.nextLine();
                    int l = a.length();
                    //int z[] = new int[l];
                    String x[] = new String[l];

                    x = a.split(",");

                    int num = Integer.parseInt(x[0]);

                    if (num <= 0) {
                        //System.out.printf("El número debe ser mayor que cero%n");
                    } else {
                        int cant_divisores = 0;
                        int i = 2;
                        while (i < num) {
                            if (num % i == 0) {
                                cant_divisores++;
                            }
                            i++;
                        }
                        if (cant_divisores == 0 && num > 1) {
                            //System.out.printf("El número es primo%n");
                            setPrimo(getPrimo() + 1);
                        } else {
                            //System.out.printf("El número no es primo%n");
                        }
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Primos.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("primo = " + getPrimo());

    }

    public void run() {
        primo();
    }

    public int getPrimo() {
        return primo;
    }

    /**
     * @param primo the primo to set
     */
    public void setPrimo(int primo) {
        this.primo = primo;
    }

}
