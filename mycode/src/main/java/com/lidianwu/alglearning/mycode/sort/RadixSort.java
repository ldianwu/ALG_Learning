package com.lidianwu.alglearning.mycode.sort;

import java.util.Arrays;

/**
 * 基数排序
 * <p>
 * 将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零
 * 从最低位开始，依次进行一次排序
 * 从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列
 * <p>
 * 时间复杂度：O(nxk)
 * 空间复杂度：O(n+k)
 * 稳定性：稳定
 *
 * @author Created by ldianwu on 2019/9/20
 */
public class RadixSort {

    public static int[] sort(int[] source) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(source, source.length);

        int maxDigit = getMaxDigit(arr);

        return radixSort(arr, maxDigit);
    }

    /**
     * 获取最高位数
     */
    private static int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLenght(maxValue);
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

    private static int getNumLenght(long num) {
        if (num == 0) {
            return 1;
        }
        int lenght = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }

    private static int[] radixSort(int[] arr, int maxDigit) {
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod * 2][0];

            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], arr[j]);
            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }

        return arr;
    }

    private static int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    public static void main(String[] args) {
        int[] source = {1, 5, 3, 6, 9, 7, 7, 2, 4, 1, 7, 9, 8, 0};
        int[] result = sort(source);
        System.out.println(Arrays.toString(result));
    }
}
