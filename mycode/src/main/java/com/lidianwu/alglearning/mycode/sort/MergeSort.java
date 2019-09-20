package com.lidianwu.alglearning.mycode.sort;

import java.util.Arrays;

/**
 * 归并排序
 * <p>
 * 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
 * 设定两个指针，最初位置分别为两个已经排序序列的起始位置；
 * 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
 * 重复步骤 3 直到某一指针达到序列尾；
 * 将另一序列剩下的所有元素直接复制到合并序列尾。
 * <p>
 * 时间复杂度：O(nLogn)
 * 空间复杂度：O(n)
 * 稳定性：稳定
 *
 * @author Created by ldianwu on 2019/9/20
 */
public class MergeSort {

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }

    public static int[] sort(int[] source) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(source, source.length);

        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(sort(left), sort(right));
    }

    public static void main(String[] args) {
        int[] source = {1, 5, 3, 6, 9, 7, 7, 2, 4, 1, 7, 9, 8, 0};
        int[] result = sort(source);
        System.out.println(Arrays.toString(result));
    }

}
