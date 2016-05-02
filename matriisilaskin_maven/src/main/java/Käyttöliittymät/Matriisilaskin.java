/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Käyttöliittymät;

import Matriisit.*;
import Matriisit.Neliomatriisit.*;
import Matriisit.Neliomatriisit.ErikoisetMatriisit.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Laituli
 */
public class Matriisilaskin {

    private static String[] avainsanat;
    private static HashMap<String, AbstraktiMatriisi> muuttujat;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        muuttujat = new HashMap<>();
        String[] inputs;
        Scanner scanner;
        scanner = new Scanner(System.in);
        AbstraktiMatriisi found;
        while (true) {
            anna_komento();
            inputs = scanner.nextLine().split(" ");
            switch (inputs.length) {
                case 1:
                    if (inputs[0].equals("quit")) {
                        System.exit(0);
                    }
                    if (inputs[0].equals("all")) {
                        tulosta_kaikki_muuttujat();
                        continue;
                    }
                    found = muuttujat.get(inputs[0]);
                    if (found != null) {
                        tulostaa_matriisi(inputs[0], found.matrix());
                        continue;
                    }
                    matrix_not_found(inputs[0]);
                    continue;
                case 2:
                    if (inputs[0].equals("release")) {
                        if (muuttujat.remove(inputs[1]) == null) {
                            matrix_not_found(inputs[1]);
                        }
                        continue;
                    }
                    if (inputs[0].equals("det")) {
                        found = muuttujat.get(inputs[1]);
                        if (found == null) {
                            matrix_not_found(inputs[1]);
                        } else if (found instanceof Neliomatriisi) {
                            tulosta_luku(((Neliomatriisi) found).determinant());
                        } else {
                            matrix_is_not_a_square_matrix(inputs[1]);
                        }
                        continue;
                    }
                    unknown_command();

                    continue;
                case 3:
                    found = muuttujat.get(inputs[0]);
                    if (found == null) {
                        matrix_not_found(inputs[0]);
                        continue;
                    }
                    try {
                        int i = Integer.parseInt(inputs[1]);
                        int j = Integer.parseInt(inputs[2]);
                        double num = found.get(i, j);
                        tulosta_luku(num);
                    } catch (Exception e) {
                        invalid_number();
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
                                        invalid_number();
                                        continue;
                                    }
                                    try {
                                        double[][] matrix = lue_matriisi(scanner, d, d);
                                        muuttujat.put(nimi, new TavallinenNeliomatriisi(matrix));
                                    } catch (Exception e) {
                                        matriisin_syötteen_virhe();
                                        continue;
                                    }
                                } catch (Exception e) {
                                    unknown_command();
                                }
                                continue;
                            case "eye":
                                try {
                                    int d = Integer.parseInt(inputs[3]);
                                    if (d <= 0) {
                                        invalid_number();
                                        continue;
                                    }
                                    muuttujat.put(nimi, new YksikkoMatriisi(d));
                                } catch (Exception e) {
                                    unknown_command();
                                }
                                continue;
                        }
                        if (inputs[3].equals("^T")) {
                            found = muuttujat.get(inputs[2]);
                            if (found == null) {
                                matrix_not_found(inputs[2]);
                                continue;
                            }
                            muuttujat.put(nimi, found.transpose());
                        }
                    }
                    unknown_command();
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
                                        matrix_not_found(inputs[2]);
                                        continue;
                                    }
                                    if (second == null) {
                                        matrix_not_found(inputs[4]);
                                        continue;
                                    }
                                    muuttujat.put(nimi, first.addition(second));
                                    continue;
                                case "-":
                                    if (first == null) {
                                        matrix_not_found(inputs[2]);
                                        continue;
                                    }
                                    if (second == null) {
                                        matrix_not_found(inputs[4]);
                                        continue;
                                    }
                                    muuttujat.put(nimi, first.subtract(second));
                                    continue;
                                case "*":
                                    if (first == null) {
                                        matrix_not_found(inputs[2]);
                                        continue;
                                    }
                                    if (second == null) {
                                        matrix_not_found(inputs[4]);
                                        continue;
                                    }
                                    muuttujat.put(nimi, first.dot(second));
                                    continue;
                                default:
                                    break;
                            }
                        } catch (MatriisiException.VaaraKokoinenMatriisi ex) {
                            vaarakokoiset_matriisit();
                        }
                        switch (inputs[2]) {
                            case "newmatrix":
                                try {
                                    int korkeus = Integer.parseInt(inputs[3]);
                                    int leveys = Integer.parseInt(inputs[4]);
                                    if (leveys <= 0 || korkeus <= 0) {
                                        invalid_number();
                                        continue;
                                    }
                                    try {
                                        double[][] newmatrix = lue_matriisi(scanner, korkeus, leveys);
                                        muuttujat.put(nimi, new TavallinenMatriisi(newmatrix));
                                    } catch (Exception e) {
                                        matriisin_syötteen_virhe();
                                    }
                                } catch (Exception e) {
                                    unknown_command();
                                }
                                continue;
                            default:
                                break;
                        }
                    }
                    unknown_command();
                    continue;
                case 6:
                    if (inputs[1].equals("=")) {
                        String name = inputs[0];
                        try {
                            int d = Integer.parseInt(inputs[3]);
                            int a = Integer.parseInt(inputs[4]);
                            if (d <= 0 || a < 0 || a >= d) {
                                invalid_number();
                                continue;
                            }
                            switch (inputs[2]) {
                                case "rowswitch":
                                    int b = Integer.parseInt(inputs[5]);
                                    if (b == a || b < 0 || b >= d) {
                                        invalid_number();
                                        continue;
                                    }
                                    muuttujat.put(name, new RiviVaihto(d, a, b));
                                    continue;
                                case "rowmultiply":
                                    double k = Double.parseDouble(inputs[5]);
                                    muuttujat.put(name, new RiviKerta(d, a, k));
                                    continue;
                                default:
                                    break;
                            }
                        } catch (Exception e) {
                            unknown_command();
                            continue;
                        }
                    }
                    unknown_command();
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
                                invalid_number();
                            }
                            continue;
                        }
                    }
                    unknown_command();
                    continue;
                default:
                    unknown_command();
            }

        }

    }

    public static double[][] lue_matriisi(Scanner scanner, int korkeus, int leveys) throws Exception {
        pyytaa_matriisin_input();
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

    public static void tulostaa_matriisi(String nimi, double[][] matrix) {
        System.out.println(nimi + "=");
        Algoritmit_ja_tyokalut.Metodit.tulostaa(matrix);
    }

    public static void tulosta_kaikki_muuttujat() {
        for (String nimi : muuttujat.keySet()) {
            tulostaa_matriisi(nimi, muuttujat.get(nimi).matrix());
        }
    }

    public static void matrix_not_found(String name) {
        System.out.println("matrix " + name + " not found");
    }

    public static void matrix_is_not_a_square_matrix(String name) {
        System.out.println("matirx " + name + " is not a square matrix");
    }

    public static void unknown_command() {
        System.out.println("unknown command");
    }

    public static void invalid_number() {
        System.out.println("invalid number");
    }

    public static void vaarakokoiset_matriisit() {
        System.out.println("matrices with wrong size");
    }

    public static void matriisin_syötteen_virhe() {
        System.out.println("matrix input error");
    }

    public static void anna_komento() {
        System.out.println("give command:");
    }

    public static void tulosta_luku(double luku) {
        System.out.println(luku);
    }

    public static void pyytaa_matriisin_input() {
        System.out.println("write number for each row:");
    }

}
