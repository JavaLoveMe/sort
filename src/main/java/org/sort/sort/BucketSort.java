package org.sort.sort;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    /** 从小到大排序 */
    public static void BucketSort(int[] array) {

        // 确定元素的最值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }

        // 桶数：(max - min) / array.length的结果为数组大小的倍数（最大倍数），以倍数作为桶数
        int bucketNum = (max - min) / array.length + 1;
        System.out.println(bucketNum);
        // 初始化桶
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }

        // 将每个元素放入桶
        for (int i = 0; i < array.length; i++) {
            // 计算每个(array[i] - min)是数组大小的多少倍，看看放入哪个桶里
            int num = (array[i] - min) / (array.length);
            System.out.println("位置:" + num + "; 值：" + array[i]);
            bucketArr.get(num).add(array[i]);
        }

        // 对每个桶进行排序
        for (int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i));
        }

        // 合并数据
        int j = array.length - 1;
        for (ArrayList<Integer> tempList : bucketArr) {
            for (int i : tempList) {
                array[j--] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{ 17, 11, 4, 12, 10, 6, 15, 5, 3, 8 };
        BucketSort(array);
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
