package org.sort.sort;

import java.util.Arrays;

public class RadixSort {

    /**
     * 计数排序
     *
     * @param array
     * @return
     */
    public static void CountingSort(int[] array) {
        if (array.length == 0)
            return;
        int bias, min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
            if (array[i] < min)
                min = array[i];
        }
        bias = 0 - min;
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] + bias]++;
        }
        int index = array.length - 1, i = 0;
        while (index > 0) {
            if (bucket[i] != 0) {
                array[index] = i - bias;
                bucket[i]--;
                index--;
            } else
                i++;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{ 17, 11, 4, 12, 10, 6, 15, 5, 3, 8 };
        CountingSort(array);
        output(array);
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
