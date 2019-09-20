package com.lidianwu.alglearning.mycode.sort;

import java.util.Arrays;

/**
 * 插入排序
 * <p>
 * 将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 * 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。
 * （如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
 * <p>
 * 时间复杂度：O(n的2次方)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 *
 * @author Created by ldianwu on 2019/9/20
 */
public class InsertSort {

    public static int[] sort(int[] source) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(source, source.length);

        for (int i = 1; i < arr.length; i++) {

            // 待插入的值
            int tmp = arr[i];

            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                // 和有序序列中最右（最大）的值比较，较小就交换位置
                arr[j] = arr[j - 1];
                j--;
            }

            if (j != i) {
                arr[j] = tmp;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] source = {1, 5, 3, 6, 9, 7, 7, 2, 4, 1, 7, 9, 8, 0};
        int[] result = sort(source);
        System.out.println(Arrays.toString(result));
    }
}
