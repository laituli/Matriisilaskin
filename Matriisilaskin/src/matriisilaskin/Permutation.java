/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriisilaskin;

/**
 *
 * @author Laituli
 */
public class Permutation {

    int[] permutation;
    int[] controller;
    int index;
    int parity;

    public Permutation(int d) {
        permutation = new int[d];
        controller = new int[d];
        for (int i = 0; i < d; i++) {
            permutation[i] = i;
            controller[i] = 0;
        }
        index = 1;
        parity = 1;
    }
    /*
     public int parity() {
     boolean[] visited = new boolean[permutation.length];
     for (int i = 0; i < visited.length; i++) {
     visited[i] = false;
     }
     int parity = 1;
     for (int i = 0; i < permutation.length; i++) {
     if (visited[i]) {
     continue;
     }
     int length = 0;
     for (int next = i; !visited[next]; next = permutation[next]) {
     length++;
     visited[next] = true;
     }
     if (length % 2 == 0) {
     parity = -parity;
     }
     }
     return parity;
     }
     */

    public int[] permutation() {
        return permutation;
    }

    public boolean hasNext() {
        return index < permutation.length;
    }

    public void next() {
        if (controller[index] < index) {
            int j = index % 2 == 0 ? 0 : controller[index];
            int z = permutation[j];
            permutation[j] = permutation[j];
            permutation[index] = z;
            controller[index]++;
            index = 1;
            parity = -parity;
            return;
        } else {
            controller[index] = 0;
            index++;
        }

    }

    public int parity() {
        return parity;
    }

}
