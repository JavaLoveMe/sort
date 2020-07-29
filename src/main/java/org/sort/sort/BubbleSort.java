package org.sort.sort;

// 冒泡排序
public class BubbleSort {

    // 普通的冒泡排序
    public static void sort(int[] array) {
        for (int i = 0 ; i < array.length - 1; i++) {
            for (int j = 0 ; j < array.length - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    output(array);
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


    public static void sort1(int[] array) {
        int tmp  = 0;
        for (int i = 0; i < array.length; i++) {
            // 有序标记，每一轮的初始是true
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j+1] = tmp;
                    // 有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }
    }

    public static void sort2(int[] array) {
        int tmp  = 0;
        // 记录循环最后一次数据交换的位置
        int lastExchangeIndex = 0;
        // 无序数列的边界，每次比较只需要比到这里为止
        int unSortBorder = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            // 数组有序标记，每一轮的初始是true
            boolean isSorted = true;
            for (int j = 0; j < unSortBorder; j++) {
                if (array[j] < array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    // 有元素交换，所以数组是无序的，标记变为false
                    isSorted = false;
                    // 把无序数列的边界更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            unSortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }



    public static void main(String[] args) {
//        int[] array = gennerateArray(10, 20);
        int[] array = {17, 11, 4, 12, 10, 6, 15, 5, 3, 8};
        outputArray(array);

        int[] array1 = new int[10]; int[] array2 = new int[10];
        System.arraycopy(array, 0, array1, 0, array1.length);
        System.arraycopy(array, 0, array2, 0, array2.length);
        sort(array);
        sort1(array1);
        sort2(array2);

//        for (int i = 0; i < sortedArray.length; i++) {
//            System.out.println(sortedArray[i]);
//        }
    }

    /**
     * 生成随机数组
     * @param len 数组长度
     * @param max 数组范围
     * @return
     */
    public static int[]  gennerateArray(int len,int max){
        int[] arr = new int[len];
        for (int i = 0;i < arr.length; i++) {
            arr[i] = (int)(Math.random() * max);
        }
        return arr;
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

    private static void outputArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.println("原始数组：");
                System.out.print("[" + array[0] + ", ");
            } else if (i == array.length - 1) {
                System.out.println(array[i] + "]");
            } else {
                System.out.print(array[i] + ", ");
            }

        }
    }
}
