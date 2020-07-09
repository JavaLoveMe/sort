package org.sort.sort;

// 冒泡排序
public class BubbleSort {

    // 普通的冒泡排序
    public static int[] sort(int[] array) {
        long start = System.currentTimeMillis();
        long roundTime = 0, swapTime = 0;
        for (int i = 0 ; i < array.length - 1; i++) {
            for (int j = 0 ; j < array.length - 1 - i; j++) {
                roundTime++;
                if (array[j] < array[j + 1]) {
                    swapTime++;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("普通的冒泡排序-循环次数：" + roundTime + ";交换次数：" + swapTime);
        System.out.println("普通的冒泡排序-用时：" + (end - start));
        return array;
    }

    // 优化了循环次数的冒泡排序
    public static int[] sort1(int[] array) {
        long start = System.currentTimeMillis();
        long roundTime = 0, swapTime = 0;
        boolean needSwap = false;
        for (int i = 0 ; i < array.length - 1; i++) {
            needSwap = false;
            for (int j = 0 ; j < array.length - 1 - i; j++) {
                roundTime++;
                if (array[j] < array[j + 1]) {
                    needSwap = true;
                    swapTime++;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (!needSwap) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("优化了循环次数的冒泡排序-循环次数：" + roundTime + ";交换次数：" + swapTime);
        System.out.println("优化了循环次数的冒泡排序-用时：" + (end - start));
        return array;
    }



    public static void main(String[] args) {
        int[] array = gennerateArray(100000, 2000000);
        int[] array1 = new int[100000];
        System.arraycopy(array, 0, array1, 0, array1.length);
        sort(array);
        sort1(array1);
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
}
