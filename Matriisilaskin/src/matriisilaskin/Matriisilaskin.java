/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriisilaskin;

import java.util.HashMap;
import java.util.Scanner;

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
        String[] inputs;
        Scanner scanner;
        scanner = new Scanner(System.in);
        boolean stringscanner;
        stringscanner = false;
        //test case
        
         scanner = new Scanner(
         "A = newmatrix 2 3\n"
         + "1 2\n"
         + "3 4\n"
         + "5 6\n"
         + "B = newmatrix 2 3\n"
         + "7 8\n"
         + "9 10\n"
         + "11 12\n"
         + "C = newmatrix 3 4\n"
         + "-1 -2 -3\n"
         + "-4 -5 -6\n"
         + "-7 -8 -9\n"
         + "-10 -11 -12\n"
         + "D = C * A\n"
         + "E = A + B\n"
         + "F = A ^T\n"
         + "all\n"
         + "A\n"
         + "D\n"
         + "quit\n");
         stringscanner = true;
         
        while (scanner.hasNext()) {
            inputs = scanner.nextLine().split(" ");
            if (stringscanner) {
                for (int i = 0; i < inputs.length; i++) {
                    System.out.print(inputs[i] + " ");
                }
                System.out.println("");
            }
            boolean whilecontinue = false;
            switch (inputs.length) {
                case 1:
                    if (inputs[0].equals("quit")) {
                        System.exit(0);
                    }
                    if (inputs[0].equals("all")) {
                        print_kaikki_muuttujat();
                        continue;
                    } else {
                        for (String nimi : muuttujat.keySet()) {
                            if (inputs[0].equals(nimi)) {
                                System.out.println(nimi + "=");
                                print(muuttujat.get(nimi).matrix());
                                whilecontinue = true;
                                break;
                            }
                        }
                        if (whilecontinue) {
                            continue;
                        }
                    }
                    System.out.println("unknown command");
                    continue;
                case 2:
                    if (inputs[0].equals("release")) {
                        for (String nimi : muuttujat.keySet()) {
                            if (inputs[1].equals(nimi)) {
                                muuttujat.remove(nimi);
                                whilecontinue = true;
                                break;
                            }
                        }
                        if (whilecontinue) {
                            continue;
                        }
                        System.out.println("matrix " + inputs[1] + " not found");
                        break;
                    }
                    System.out.println("unknown command");
                    break;
                case 3:
                    try {
                        int i = Integer.parseInt(inputs[1]);
                        int j = Integer.parseInt(inputs[2]);
                        for (String nimi : muuttujat.keySet()) {
                            if (inputs[0].equals(nimi)) {
                                muuttujat.get(nimi).get(i, j);
                                whilecontinue = true;
                                break;
                            }
                        }
                        if (whilecontinue) {
                            continue;
                        }
                        System.out.println("matrix " + inputs[0] + " not found");
                        continue;
                    } catch (Exception e) {
                    }
                    System.out.println("unknown command");
                    break;
                case 4:
                    if (inputs[1].equals("=")) {
                        switch (inputs[2]) {
                            case "squarematrix":
                                try {
                                    String nimi = inputs[0];
                                    int d = Integer.parseInt(inputs[3]);
                                    System.out.println("write numbers each row");
                                    whilecontinue = true;
                                    try {
                                        double[][] newmatrix = new double[d][d];
                                        for (int i = 0; i < d; i++) {
                                            inputs = scanner.nextLine().split(" ");
                                            for (int j = 0; j < d; j++) {
                                                newmatrix[i][j] = Double.parseDouble(inputs[j]);
                                            }
                                        }
                                        AbstraktiMatriisi mat = new TavallinenMatriisi(newmatrix);
                                        muuttujat.put(nimi, mat);
                                    } catch (Exception e) {
                                        System.out.println("wrong input");
                                        break;
                                    }
                                } catch (Exception e) {
                                    System.out.println("unknown command");
                                }
                                break;
                        }
                        if (whilecontinue) {
                            continue;
                        }
                        if (inputs[3].equals("^T")) {
                            for (String nimi : muuttujat.keySet()) {
                                if (inputs[2].equals(nimi)) {
                                    AbstraktiMatriisi matrix = muuttujat.get(nimi).transpose();
                                    muuttujat.put(inputs[0], matrix);
                                    whilecontinue = true;
                                    break;
                                }
                            }
                            if (whilecontinue) {
                                continue;
                            }
                            System.out.println("matrix " + inputs[2] + " not found");
                        }
                    }
                    System.out.println("unknown command");
                    break;
                case 5:

                    if (inputs[1].equals("=")) {
                        AbstraktiMatriisi first, second, matrix;
                        whilecontinue = true;
                        switch (inputs[3]) {
                            case "+":
                                try {
                                    first = muuttujat.get(inputs[2]);
                                    second = muuttujat.get(inputs[4]);
                                    matrix = first.addition(second);
                                    muuttujat.put(inputs[0], matrix);
                                } catch (MatriisiException.VaaraKokoinenMatriisi ex) {
                                    System.out.println("väärä kokoinen matriisi");
                                } catch (NullPointerException npe) {
                                    System.out.println("matrix not found");
                                }
                                break;
                            case "-":
                                try {
                                    first = muuttujat.get(inputs[2]);
                                    second = muuttujat.get(inputs[4]);
                                    matrix = first.substract(second);
                                    muuttujat.put(inputs[0], matrix);
                                } catch (MatriisiException.VaaraKokoinenMatriisi ex) {
                                    System.out.println("väärä kokoinen matriisi");
                                } catch (NullPointerException npe) {
                                    System.out.println("matrix not found");
                                }
                                break;
                            case "*":
                                try {
                                    first = muuttujat.get(inputs[2]);
                                    second = muuttujat.get(inputs[4]);
                                    matrix = first.dot(second);
                                    muuttujat.put(inputs[0], matrix);
                                } catch (MatriisiException.VaaraKokoinenMatriisi ex) {
                                    System.out.println("väärä kokoinen matriisi");
                                } catch (NullPointerException npe) {
                                    System.out.println("matrix not found");
                                }
                                break;
                            default:
                                whilecontinue = false;
                                break;
                        }
                        if (whilecontinue) {
                            continue;
                        }
                        whilecontinue = true;
                        switch (inputs[2]) {
                            case "newmatrix":
                                try {
                                    String nimi = inputs[0];
                                    int leveys = Integer.parseInt(inputs[3]);
                                    int korkeus = Integer.parseInt(inputs[4]);
                                    System.out.println("write numbers each row");
                                    try {
                                        double[][] newmatrix = new double[korkeus][leveys];
                                        for (int i = 0; i < korkeus; i++) {
                                            inputs = scanner.nextLine().split(" ");
                                            for (int j = 0; j < leveys; j++) {
                                                newmatrix[i][j] = Double.parseDouble(inputs[j]);
                                            }
                                        }
                                        AbstraktiMatriisi mat = new TavallinenMatriisi(newmatrix);
                                        muuttujat.put(nimi, mat);
                                    } catch (Exception e) {
                                        System.out.println("wrong input");
                                        break;
                                    }
                                } catch (Exception e) {
                                    System.out.println("unknown command");
                                }
                                break;
                        }
                        if (whilecontinue) {
                            continue;
                        }
                    }
                    System.out.println("unknown command");
                    break;
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
