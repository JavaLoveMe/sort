package org.sort.sort;

public class SelectionSort {

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int target = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[target]) {
                    target = j;
                }
            }
            if (target != i) {
                int temp = array[i];
                array[i] = array[target];
                array[target] = temp;
            }
        }

        output(array);
    }

    public static void main(String[] args) {
        int[] array = new int[]{17, 11, 4, 12, 10, 6, 15, 5, 3, 8};
        selectionSort(array);
    }

    public static void output(int[] array) {
        for (int a : array) {
            System.out.print(a + ";");
        }
    }
}
