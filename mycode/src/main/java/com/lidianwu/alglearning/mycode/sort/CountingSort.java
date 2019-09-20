package com.lidianwu.alglearning.mycode.sort;

import java.util.Arrays;

/**
 * 计数排序
 * <p>
 * 花O(n)的时间扫描一下整个序列 A，获取最小值 min 和最大值 max
 * 开辟一块新的空间创建新的数组 B，长度为 ( max - min + 1)
 * 数组 B 中 index 的元素记录的值是 A 中某元素出现的次数
 * 最后输出目标整数序列，具体的逻辑是遍历数组 B，输出相应元素以及对应的个数
 * <p>
 * 时间复杂度：O(n+k)
 * 空间复杂度：O(k)
 * 稳定性：稳定
 *
 * @author Created by ldianwu on 2019/9/20
 */
public class CountingSort {

    public static int[] sort(int[] source) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(source, source.length);

        int maxValue = getMaxValue(arr);

        return countingSort(arr, maxValue);
    }

    private static int[] countingSort(int[] arr, int maxValue) {
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        for (int value : arr) {
            bucket[value]++;
        }

        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }

    private static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] source = {1, 5, 3, 6, 9, 7, 7, 2, 4, 1, 7, 9, 8, 0};
        int[] result = sort(source);
        System.out.println(Arrays.toString(result));
    }
}
