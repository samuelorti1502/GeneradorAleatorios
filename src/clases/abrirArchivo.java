/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel David Ortiz
 */
public class abrirArchivo {

    String archivo;
    int tipo;
    int orden;
    JFileChooser file;
    File abre;

    public abrirArchivo() {

    }

    public void tipo(int tipo, int orden, JFrame generador) {
        this.tipo = tipo;

        switch (tipo) {
            case 0:
                //System.out.println("Tipo 0");
                file = new JFileChooser("./");
                file.setDialogTitle("Escoge el archivo a ordenar");
                file.showOpenDialog(generador);
                abrir(orden);
                break;
            case 1:
                //System.out.println("Tipo 1");
                try {
                    abre = new File("./aleatorios.txt");
                    
                    abrir(orden);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void abrir(int orden) {
        try {

            //JFileChooser file = new JFileChooser();
            //file.showOpenDialog(generador);
            //abre = file.getSelectedFile();

            if (abre != null) {
                Scanner scan = new Scanner(abre);
                ArrayList<String> data = new ArrayList<String>();

                while (scan.hasNextLine()) {

                    String a;
                    a = scan.nextLine();
                    int l = a.length();
                    int z[] = new int[l];
                    String x[] = new String[l];

                    x = a.split(",");

                    data.add(x[0]);
                    //System.out.println(x[0]);

                }

                int[] numbers = Arrays.stream(data.toArray(new String[]{})).mapToInt(Integer::parseInt).toArray();

                //System.out.println("Hola Hola");
                switch (orden) {
                    case 0:
                        //System.out.println("Burbuja");
                        Burbuja oBurbuja = new Burbuja();
                        oBurbuja.ordenamientoBurbuja(numbers, 0);
                        oBurbuja.start();
                        break;
                    case 1:
                        //System.out.println("Shell");
                        Shell shell = new Shell();
                        shell.shellSort(numbers);
                        shell.start();
                        break;
                    case 2:
                        //System.out.println("Insercion");
                        Insercion insercion = new Insercion();
                        insercion.insertionSort(numbers);
                        insercion.start();
                        break;
                }

            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
    }
}
