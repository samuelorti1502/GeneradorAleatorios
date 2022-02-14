/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JLabel;

/**
 *
 * @author Samuel David Ortiz
 */
public final class Estadisticas extends Thread {

    private int maximo;
    private int minimo;
    private int par;
    private int impar;
    private int primo;

    public Estadisticas() {
        estatics();
        //primos();
    }

    public void estatics() {
        try {
            Scanner inFile = new Scanner(new FileReader("./shell.txt"));

            int min = Integer.MAX_VALUE;
            int max = 0;
            int p = 0;
            int imp = 0;
            int primo = 0;

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
                    if (num > max) {
                        max = num;
                    }
                    if (num < min) {
                        min = num;
                    }

                    if (Integer.parseInt(x[0]) % 2 == 0) {
                        p++;
                    } else {
                        imp++;
                    }

                    /*for (int I = 1; I <= Integer.parseInt(x[0]); I++) {
                        if ((Integer.parseInt(x[0]) % I) == 0) {
                            contador++;
                        }
                    }

                    if (contador <= 2) {
                        //System.out.println("El numero es primo");
                        primo++;
                    } else {
                        //System.out.println("El numero no es primo");
                    }*/
                }
            }

            this.setMaximo(max);
            this.setMinimo(min);
            this.setPar(p);
            this.setImpar(imp);

            System.out.println("max………….." + max);
            System.out.println("min………….." + min);
            System.out.println("pares………….." + p);
            System.out.println("impares………….." + imp);
            //System.out.println("primos………….." + primo);

            System.out.println();

        } catch (FileNotFoundException ex) {
        }
    }

    

    @Override
    public void run() {

    }

    public void valores(JLabel maxi, JLabel min, JLabel par, JLabel Impar) {
        maxi.setText(Integer.toString(getMaximo()));
        min.setText(Integer.toString(getMinimo()));
        par.setText(Integer.toString(getPar()));
        Impar.setText(Integer.toString(getImpar()));
    }

    /**
     * @return the maximo
     */
    public int getMaximo() {
        return maximo;
    }

    /**
     * @param maximo the maximo to set
     */
    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    /**
     * @return the minimo
     */
    public int getMinimo() {
        return minimo;
    }

    /**
     * @param minimo the minimo to set
     */
    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    /**
     * @return the par
     */
    public int getPar() {
        return par;
    }

    /**
     * @param par the par to set
     */
    public void setPar(int par) {
        this.par = par;
    }

    /**
     * @return the impar
     */
    public int getImpar() {
        return impar;
    }

    /**
     * @param impar the impar to set
     */
    public void setImpar(int impar) {
        this.impar = impar;
    }

    /**
     * @return the primo
     */
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
