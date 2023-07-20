package com.lxd.app.剑指offer.查找.旋转数组的最小数字_11;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * <p>
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。  
 * <p>
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numbers = [3,4,5,1,2]
 * 输出：1
 * <p>
 * 示例 2：
 * <p>
 * 输入：numbers = [2,2,2,0,1]
 * 输出：0
 * <p>
 * 提示：
 * n == numbers.length
 * 1 <= n <= 5000
 * -5000 <= numbers[i] <= 5000
 * numbers 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minArray(new int[]{3,4,5,1,2}));
    }

    /**
     * 题目旋转n次考虑了半天，其实不论旋转几次性质不变
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = Math.abs((left+ right)/2);
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] == numbers[right]) {
                right--;
            } else {
                left = mid + 1;
            }
        }
        return numbers[left];
    }
}