package org.sort.sort;

public class HeapSort {

    /*
     * (最小)堆的向下调整算法
     *
     * 注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
     *     其中，N为数组下标索引值，如数组中第1个数对应的N为0。
     *
     * 参数说明：
     *     a -- 待排序的数组
     *     start -- 被下调节点的起始位置(一般为0，表示从第1个开始)
     *     end   -- 截至范围(一般为数组中最后一个元素的索引)
     */
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


    /*
     * 堆排序(从大到小)
     *
     * 参数说明：
     *     a -- 待排序的数组
     *     n -- 数组的长度
     */
    public static void HeapSort(int[] array) {
        int start, tmp;
        int length = array.length;

        for (start = length / 2 - 1; start >= 0; start--)
            minHeapDown(array, start, length - 1);
        // 从最后一个元素开始对序列进行调整，不断的缩小调整的范围直到第一个元素
        for (start = length - 1; start > 0; start--) {
            // 交换array[0]和array[i]。交换后，array[i]是array[0...i]中最小的。
            tmp = array[0];
            array[0] = array[start];
            array[start] = tmp;
            // 调整array[0...i-1]，使得array[0...i-1]仍然是一个最小堆。
            // 即，保证array[i-1]是array[0...i-1]中的最小值。
            minHeapDown(array, 0, start - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{ 17, 11, 4, 12, 10, 6, 15, 5, 3, 8 };
        HeapSort(array);
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
