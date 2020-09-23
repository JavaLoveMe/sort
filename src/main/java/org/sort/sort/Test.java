package org.sort.sort;

public class Test {

    public static void minHeapDown(int[] array, int start, int end) {
        int current = start;            // 当前(current)节点的位置
        int left = 2 * current + 1;        // 左(left)孩子的位置
        int tmp = array[current];            // 当前(current)节点的大小

        for (; left <= end; current = left, left = 2 * left + 1) {
            // "left"是左孩子，"left+1"是右孩子
            if (left < end && array[left] > array[left + 1])
                left++;        // 左右两孩子中选择较小者
            if (tmp <= array[left])
                break;        // 调整结束
            else {            // 交换值
                array[current] = array[left];
                array[left] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        // [3, 5, 4, 11, 8, 6, 15, 17, 12, 10]
        int[] array = new int[]{ 17, 11, 4, 12, 10, 6, 15, 5, 3, 8 };
        minHeapDown(array, 4, array.length - 1);
        output(array);
        minHeapDown(array, 3, array.length - 1);
        output(array);
        minHeapDown(array, 2, array.length - 1);
        output(array);
        minHeapDown(array, 1, array.length - 1);
        output(array);
        minHeapDown(array, 0, array.length - 1);
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
