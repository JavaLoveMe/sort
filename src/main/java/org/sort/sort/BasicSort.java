package org.sort.sort;

import java.util.ArrayList;
import java.util.List;

public class BasicSort {

    public static void BasicSort(int[] array) {
        //获取最大值；要看排几次，主要看这个最大值有几位；
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        //获取最大值位数；
        int times = 0;
        while (max > 0) {
            max /= 10;
            times++;//求取这个最大值的位数，依次除以10；直到为0；
        }
        List<ArrayList> queue = new ArrayList<>();//多维数组
        for (int i = 0; i < 10; i++) {
            ArrayList q = new ArrayList();
            queue.add(q);//由于数字的特殊性，大数组中要添加10个小数组；
        }

        //开始比较,重点
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < array.length; j++) {
                // 获取每次要比较的那个数字；不管是哪个位置上的；
                // 获取对应位的值（i为0是个位，1是十位，2是百位）；
                int x = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
                ArrayList q = queue.get(x);
                //把元素添加至对应下标数组；在小数组中添加原array的数值；
                q.add(array[j]);
                queue.set(x, q);
            }
            //开始收集；
            int count = 0;
            for (int j = 0; j < 10; j++) {
                while (queue.get(j).size() > 0) {
                    ArrayList<Integer> q = queue.get(j);//拿到每一个数组；
                    array[count] = q.get(0);
                    q.remove(0);
                    count++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{ 17, 11, 4, 12, 10, 6, 15, 5, 3, 8 };
        BasicSort(array);
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
