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
        /*
         scanner = new Scanner(
         "A = newmatrix 2 3\n"
         + "1 2\n"
         + "3 4\n"
         + "5 6\n"
         + "B = newmatrix 2 3\n"
         + "7 8\n"
         + "9 10\n"
         + "11 12\n"
         + "X = squarematrix 3\n"
         + "7 8 9\n"
         + "9 10 11\n"
         + "11 12 13\n"
         + "Y = squarematrix 3\n"
         + "7 8 9\n"
         + "9 10 11\n"
         + "20 12 13\n"
         + "C = newmatrix 3 4\n"
         + "-1 -2 -3\n"
         + "-4 -5 -6\n"
         + "-7 -8 -9\n"
         + "-10 -11 -12\n"
         + "D = C * A\n"
         + "E = A + B\n"
         + "F = A ^T\n"
         + "all\n"
         + "X\n"
         + "det X\n"
         + "A\n"
         + "D\n"
         + "quit\n");
         stringscanner = true;
         */
        AbstraktiMatriisi found;
        boolean whilecontinue;
        while (scanner.hasNext()) {
            whilecontinue = false;
            inputs = scanner.nextLine().split(" ");
            if (stringscanner) {
                for (int i = 0; i < inputs.length; i++) {
                    System.out.print(inputs[i] + " ");
                }
                System.out.println("");
            }
            switch (inputs.length) {
                case 1:
                    if (inputs[0].equals("quit")) {
                        System.exit(0);
                    }
                    if (inputs[0].equals("all")) {
                        print_kaikki_muuttujat();
                        continue;
                    }
                    found = muuttujat.get(inputs[0]);
                    if (found != null) {
                        tulostaa_tuloste_1(inputs[0], found.matrix());
                        continue;
                    }
                    tulostaa_tuloste_2(inputs[0]);
                    continue;
                case 2:
                    if (inputs[0].equals("release")) {
                        if (muuttujat.remove(inputs[1]) == null) {
                            tulostaa_tuloste_2(inputs[1]);
                        }
                        continue;
                    }
                    if (inputs[0].equals("det")) {
                        found = muuttujat.get(inputs[1]);
                        if (found == null) {
                            tulostaa_tuloste_2(inputs[1]);
                        } else if (found instanceof Neliomatriisi) {
                            tulostaa_tuloste_9(((Neliomatriisi) found).determinant());
                        } else {
                            tulostaa_tuloste_3(inputs[1]);
                        }
                        continue;
                    }
                    tulostaa_tuloste_4();

                    continue;
                case 3:
                    found = muuttujat.get(inputs[0]);
                    if (found == null) {
                        tulostaa_tuloste_2(inputs[0]);
                        continue;
                    }
                    try {
                        int i = Integer.parseInt(inputs[1]);
                        int j = Integer.parseInt(inputs[2]);
                        double num = found.get(i, j);
                        tulostaa_tuloste_9(num);
                    } catch (Exception e) {
                        tulostaa_tuloste_5();
                    }
                    continue;
                case 4:
                    if (inputs[1].equals("=")) {
                        String nimi = inputs[0];
                        switch (inputs[2]) {
                            case "squarematrix":
                                try {
                                    int d = Integer.parseInt(inputs[3]);
                                    if (d <= 0) {
                                        tulostaa_tuloste_5();
                                        continue;
                                    }
                                    try {
                                        double[][] matrix = read_matrix(scanner, d, d);
                                        muuttujat.put(nimi, new TavallinenNeliomatriisi(matrix));
                                    } catch (Exception e) {
                                        tulostaa_tuloste_7();
                                        continue;
                                    }
                                } catch (Exception e) {
                                    tulostaa_tuloste_4();
                                }
                                continue;
                            case "eye":
                                try {
                                    int d = Integer.parseInt(inputs[3]);
                                    if (d <= 0) {
                                        tulostaa_tuloste_5();
                                        continue;
                                    }
                                    muuttujat.put(nimi, new YksikkoMatriisi(d));
                                } catch (Exception e) {
                                    tulostaa_tuloste_4();
                                }
                                continue;
                        }
                        if (inputs[3].equals("^T")) {
                            found = muuttujat.get(inputs[2]);
                            if (found == null) {
                                tulostaa_tuloste_2(inputs[2]);
                                continue;
                            }
                            muuttujat.put(nimi, found.transpose());
                        }
                    }
                    continue;
                case 5:
                    if (inputs[1].equals("=")) {
                        String nimi = inputs[0];
                        AbstraktiMatriisi first, second;
                        first = muuttujat.get(inputs[2]);
                        second = muuttujat.get(inputs[4]);
                        try {
                            switch (inputs[3]) {
                                case "+":
                                    if (first == null) {
                                        tulostaa_tuloste_2(inputs[2]);
                                        continue;
                                    }
                                    if (second == null) {
                                        tulostaa_tuloste_2(inputs[4]);
                                        continue;
                                    }
                                    muuttujat.put(nimi, first.addition(second));
                                    continue;
                                case "-":
                                    if (first == null) {
                                        tulostaa_tuloste_2(inputs[2]);
                                        continue;
                                    }
                                    if (second == null) {
                                        tulostaa_tuloste_2(inputs[4]);
                                        continue;
                                    }
                                    muuttujat.put(nimi, first.subtract(second));
                                    continue;
                                case "*":
                                    if (first == null) {
                                        tulostaa_tuloste_2(inputs[2]);
                                        continue;
                                    }
                                    if (second == null) {
                                        tulostaa_tuloste_2(inputs[4]);
                                        continue;
                                    }
                                    muuttujat.put(nimi, first.dot(second));
                                    continue;
                                default:
                                    break;
                            }
                        } catch (MatriisiException.VaaraKokoinenMatriisi ex) {
                            tulostaa_tuloste_6();
                        }
                        switch (inputs[2]) {
                            case "newmatrix":
                                try {
                                    int leveys = Integer.parseInt(inputs[3]);
                                    int korkeus = Integer.parseInt(inputs[4]);
                                    if (leveys <= 0 || korkeus <= 0) {
                                        tulostaa_tuloste_5();
                                        continue;
                                    }
                                    try {
                                        double[][] newmatrix = read_matrix(scanner, leveys, korkeus);
                                        muuttujat.put(nimi, new TavallinenMatriisi(newmatrix));
                                    } catch (Exception e) {
                                        tulostaa_tuloste_7();
                                    }
                                } catch (Exception e) {
                                    tulostaa_tuloste_4();
                                }
                                continue;
                            default:
                                break;
                        }
                    }
                    tulostaa_tuloste_4();
                    continue;
                case 6:
                    if (inputs[1].equals("=")) {
                        String name = inputs[0];
                        try {
                            int d = Integer.parseInt(inputs[3]);
                            int a = Integer.parseInt(inputs[4]);
                            if (d <= 0 || a < 0 || a >= d) {
                                tulostaa_tuloste_5();
                                continue;
                            }
                            switch (inputs[2]) {
                                case "rowswitch":
                                    int b = Integer.parseInt(inputs[5]);
                                    if (b == a || b < 0 || b >= d) {
                                        tulostaa_tuloste_5();
                                        continue;
                                    }
                                    muuttujat.put(name, new Rivivaihto(d, a, b));
                                    continue;
                                case "rowmultiply":
                                    double k = Double.parseDouble(inputs[5]);
                                    muuttujat.put(name, new RiviKerta(d, a, k));
                                    continue;
                                default:
                                    break;
                            }
                        } catch (Exception e) {
                            tulostaa_tuloste_4();
                            continue;
                        }
                    }
                    tulostaa_tuloste_4();
                    continue;
                case 7:
                    if (inputs[1].equals("=")) {
                        String name = inputs[0];
                        if (inputs[2].equals("rowadd")) {
                            try {
                                int d = Integer.parseInt(inputs[3]);
                                int a = Integer.parseInt(inputs[4]);
                                int b = Integer.parseInt(inputs[5]);
                                double k = Double.parseDouble(inputs[6]);
                                muuttujat.put(name, new RiviLisays(d, a, b, k));
                            } catch (Exception e) {
                                tulostaa_tuloste_5();
                            }
                        }
                    }
                    tulostaa_tuloste_4();
                    continue;
                default:
                    tulostaa_tuloste_4();
            }
        }
    }

    public boolean muuttuja_nimi(String string) {
        return true;
    }

    public void print_kaikki_muuttujat() {
        for (String nimi : muuttujat.keySet()) {
            tulostaa_tuloste_1(nimi, muuttujat.get(nimi).matrix());
        }
    }

    public double[][] read_matrix(Scanner scanner, int leveys, int korkeus) throws Exception {
        tulostaa_tuloste_10();
        double[][] newmatrix = new double[korkeus][leveys];
        for (int i = 0; i < korkeus; i++) {
            String[] numbers = scanner.nextLine().split(" ");
            if (numbers.length != leveys) {
                throw new Exception();
            }
            for (int j = 0; j < leveys; j++) {
                newmatrix[i][j] = Double.parseDouble(numbers[j]);
            }
        }
        return newmatrix;
    }

    public static double[][] copy(double[][] matrix) {
        double[][] ret = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ret[i][j] = matrix[i][j];
            }
        }
        return ret;
    }

    public static void tulostaa_tuloste_1(String nimi, double[][] matrix) {
        System.out.println(nimi + "=");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public void tulostaa_tuloste_2(String name) {
        System.out.println("matrix " + name + " not found");
    }

    public void tulostaa_tuloste_3(String name) {
        System.out.println("matirx " + name + " is not a square matrix");
    }

    public void tulostaa_tuloste_4() {
        System.out.println("unknown command");
    }

    public void tulostaa_tuloste_5() {
        System.out.println("invalid number");
    }

    public void tulostaa_tuloste_6() {
        System.out.println("matrices with wrong size");
    }

    public void tulostaa_tuloste_7() {
        System.out.println("matrix input error");
    }

    public void tulostaa_tuloste_8() {
        System.out.println("give command:");
    }

    public void tulostaa_tuloste_9(double luku) {
        System.out.println(luku);
    }

    public void tulostaa_tuloste_10() {
        System.out.println("write number for each row:");
    }

}
