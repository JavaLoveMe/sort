package org.sort.sort;

public class MergeSort {

    public static void mergeSort(int[] arr, int[] result, int start, int end) {
        if (start >= end)
            return;
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        mergeSort(arr, result, start1, end1);
        mergeSort(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2)
            result[k++] = arr[start1] > arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= end1)
            result[k++] = arr[start1++];
        while (start2 <= end2)
            result[k++] = arr[start2++];
        for (k = start; k <= end; k++)
            arr[k] = result[k];
        output(result);
    }

    public static void main(String[] args) {
        int[] array = new int[]{17, 11, 4, 12, 10, 6, 15, 5, 3, 8};
        int[] result = new int[array.length];
        mergeSort(array, result, 0, array.length - 1);
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
