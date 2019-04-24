package com.lidianwu.alglearning;

/**
 * 只出现一次的数字
 *
 * <pre>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * </pre>
 *
 * @author ldianwu
 */
public class Solution {

    // 异或：相同为0，不同为1. 异或同一个数两次，原数不变。
    public static int singleNumber(int[] nums) {
        int len = nums.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            result ^= nums[i];
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }
}
