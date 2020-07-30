package org.sort.sort;

public class ShellSort {

    public static void shellSort(int[] array) {
        int inner, outer;

        int temp;

        int h = 1;

        while (h < array.length) {
            h = 3 * h + 1;
        }

        while (h > 0) {
            for (outer  = h; outer < array.length; outer++) {
                temp = array[outer];
                inner = outer;
                while (inner > h - 1 && array[inner - h] <= temp) {
                    array[inner] = array[inner - h];
                    inner -= h;
                }
                array[inner] = temp;
            }
            h = (h - 1) / 3;
        }
        output(array);
    }

    public static void main(String[] args) {
        int[] array = new int[]{17, 11, 4, 12, 10, 6, 15, 5, 3, 8};
        shellSort(array);
    }

    private static void output(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print("[" + array[0] + ", ");
            } else if (i == array.length - 1) {
                System.out.println(array[i] + "]");
            } else {
                System.out.print(array[i] + ", ");
            }

        }
    }
}
