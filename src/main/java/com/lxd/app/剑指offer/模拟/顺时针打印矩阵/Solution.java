package com.lxd.app.剑指offer.模拟.顺时针打印矩阵;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = {{3},{2}};
        ints = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.spiralOrder(ints);
    }
    public int[] spiralOrder(int[][] matrix) {
        int start_x = 0, start_y = 0, index = 0;
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int max = matrix.length * matrix[0].length;
        int[] result = new int[max];
        extracted(matrix, start_x, start_y, index, result, max);
        return result;
    }

    private static void extracted(int[][] matrix, int start_x, int start_y, int index, int[] result, int max) {
        int x = start_x, y = start_y;
        int type = 0;
        result[index++] = matrix[y][x];
        while (type != 4) {
            if (index >= max) {
                return;
            }
            switch (type) {
                case 0:
                    if (x == matrix[y].length - start_x - 1) {
                        type++;
                    } else {
                        x++;
                        result[index++] = matrix[y][x];
                    }
                    break;
                case 1:
                    if (y == matrix.length - start_y - 1) {
                        type++;
                    } else {
                        y++;
                        result[index++] = matrix[y][x];
                    }
                    break;
                case 2:
                    if (x == start_x) {
                        type++;
                    } else {
                        x--;
                        result[index++] = matrix[y][x];
                    }
                    break;
                case 3:
                    if (y == start_y + 1) {
                        type++;
                    } else {
                        y--;
                        result[index++] = matrix[y][x];
                    }
                    break;
            }
        }
        extracted(matrix, ++start_x, ++start_y, index, result, max);
    }

}