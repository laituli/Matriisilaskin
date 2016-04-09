/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriisilaskin;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.org.mozilla.javascript.internal.ScriptRuntime;

/**
 *
 * @author Laituli
 */
public class Matriisilaskin {

    String[] avainsanat;
    HashMap<String, AbstraktiMatriisi> muuttujat;

    public Matriisilaskin() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Matriisilaskin matriisilaskin = new Matriisilaskin();
        matriisilaskin.main_();
    }

    public void main_() {
        muuttujat = new HashMap<>();
        avainsanat = new String[]{"=", "+", "-", "*","^T", "matrix"};
        String input;
        String[] apustrings;
        String left, right;

        //Scanner scanner = new Scanner(System.in);
        /*
        Scanner scanner = new Scanner("A = matrix 2 3\n"
                + "1 2\n"
                + "3 4\n"
                + "5 6\n"
                + "B = matrix 2 3\n"
                + "7 8\n"
                + "9 10\n"
                + "11 12\n"
                + "C = A + B\n"
                + "quit\n");
        */
        Scanner scanner = new Scanner("A = matrix 2 3\n"
                + "1 2\n"
                + "3 4\n"
                + "5 6\n"
                + "B = matrix 2 3\n"
                + "7 8\n"
                + "9 10\n"
                + "11 12\n"
                + "C = A * B\n"
                + "all\n"
                + "A\n"
                + "C\n"
                + "quit\n");
        while (true) {
            input = scanner.nextLine();
            if (input.equals("quit")) {
                break;
            }
            if(!input.contains(" ")){
                if(input.equals("all")){
                    print_kaikki_muuttujat();
                }else{
                    for (String nimi : muuttujat.keySet()) {
                        if(input.equals(nimi)){
                            System.out.println(nimi+"=");
                            print(muuttujat.get(nimi).matrix());
                        }
                    }
                }
                continue;
            }
            apustrings = input.split("=");
            left = apustrings[0];
            right = apustrings[1];
            if (!muuttuja_nimi(left)) {
                continue;
            }
            right = right.trim();
            apustrings = right.split(" ");
            if (apustrings[0].equals("matrix")) {
                int leveys, korkeus;
                leveys = Integer.parseInt(apustrings[1]);
                korkeus = Integer.parseInt(apustrings[2]);
                double[][] matrix = new double[korkeus][leveys];
                for (int i = 0; i < korkeus; i++) {
                    apustrings = scanner.nextLine().split(" ");
                    for (int j = 0; j < leveys; j++) {
                        matrix[i][j] = Double.parseDouble(apustrings[j]);
                    }
                }
                AbstraktiMatriisi mat = new TavallinenMatriisi(matrix);
                muuttujat.put(left.trim(), mat);
            } else if (apustrings[1].equals("+")) {
                AbstraktiMatriisi eka = muuttujat.get(apustrings[0]);
                AbstraktiMatriisi toka = muuttujat.get(apustrings[2]);
                try {
                    AbstraktiMatriisi tulos = eka.addition(toka);
                    double[][] matrix = tulos.matrix();
                    System.out.println(left + "=");
                    print(matrix);
                    muuttujat.put(left.trim(), tulos);
                } catch (MatriisiException.VaaraKokoinenMatriisi ex) {
                    System.out.println("error");
                    System.out.println("continue");
                    System.out.println("---");
                    continue;
                }
            } else if (apustrings[1].equals("-")) {
                AbstraktiMatriisi eka = muuttujat.get(apustrings[0]);
                AbstraktiMatriisi toka = muuttujat.get(apustrings[2]);
                try {
                    AbstraktiMatriisi tulos = eka.substract(toka);
                    double[][] matrix = tulos.matrix();
                    System.out.println(left + "=");
                    print(matrix);
                    muuttujat.put(left.trim(), tulos);
                } catch (MatriisiException.VaaraKokoinenMatriisi ex) {
                    System.out.println("error");
                    System.out.println("continue");
                    System.out.println("---");
                    continue;
                }
            } else if (apustrings[1].equals("*")) {
                AbstraktiMatriisi eka = muuttujat.get(apustrings[0]);
                AbstraktiMatriisi toka = muuttujat.get(apustrings[2]);
                try {
                    AbstraktiMatriisi tulos = eka.dot(toka);
                    double[][] matrix = tulos.matrix();
                    System.out.println(left + "=");
                    print(matrix);
                    muuttujat.put(left.trim(), tulos);
                } catch (MatriisiException.VaaraKokoinenMatriisi ex) {
                    System.out.println("error");
                    System.out.println("continue");
                    System.out.println("---");
                    continue;
                }
            }
            
        }

    }

    public boolean muuttuja_nimi(String string) {
        return true;
    }

    public void print(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public void print_kaikki_muuttujat() {
        for (String nimi : muuttujat.keySet()) {
            System.out.println(nimi + "=");
            print(muuttujat.get(nimi).matrix());
        }
    }
}
