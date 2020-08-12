package org.sort.sort;

public class QuickSort {

    public static int[] quickSort(int arr[],int start,int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while ((i < j) && (arr[j] < pivot)) {
                j--;
            }
            while ((i < j) && (arr[i] > pivot)) {
                i++;
            }
            if ((arr[i] == arr[j]) && (i > j)) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i - 1 > start)
            arr = quickSort(arr,start,i-1);
        if (j + 1 < end)
            arr = quickSort(arr,j+1,end);
        return (arr);
    }

    public static void main(String[] args) {
        int[] array = new int[]{17, 11, 4, 12, 10, 6, 15, 5, 3, 8};
        int[] result = quickSort(array, 0, array.length - 1);
        output(result);
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
