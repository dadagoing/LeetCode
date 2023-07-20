package com.lxd.app.剑指offer.查找.二维数组中的查找_4;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右 非递减 的顺序排序，每一列都按照从上到下 非递减 的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        nums = new int[][]{{},{1}};
        System.out.println(solution.findNumberIn2DArray(nums, 25));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 ||  target > matrix[matrix.length - 1][matrix[0].length - 1] || target < matrix[0][0]) {
            return false;
        }
        int n = 0, m = matrix[0].length - 1;
        while (n > -1 && m > -1 && n < matrix.length && m < matrix[0].length) {
            if (target == matrix[n][m]) {
                return true;
            }
            if (target > matrix[n][m]) {
                n++;
            } else {
                m--;
            }
        }
        return false;
    }
}