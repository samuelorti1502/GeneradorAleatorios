/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author Samuel David Ortiz
 */
public class Aleatorios extends Thread{
    
    int numero;
    ArrayList numeros = new ArrayList();
    ArrayList estrellas = new ArrayList();
        
    public void run() {
        int min = -10000000;
        int max = 10000000;
        for (int i = 1; i <= 300000; i++) {
            numero = (int) (Math.random() * (min-max+1)+max);
            if (numeros.contains(numero)) {
                i--;
            } else {
                numeros.add(numero);
            }
        }

        System.out.println("La convinacion del Euromillones es:");
        for (Object n : numeros) {
            System.out.println(n + "");
        }
        //hilo.stop();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        (new Thread(new Aleatorios())).start();
    }
    
}
