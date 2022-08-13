package SpiralMatrix;

import java.util.ArrayList;

/**
 * 可以递归解决这个问题
 *
 */
public class Solution1 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }
    /**
     * 矩阵旋转
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> spiralOrder(int[][] matrix){
        if (matrix==null || matrix.length ==0){
            return new ArrayList<>();
        }
        return spiralOrder(matrix,0,0,matrix.length,matrix[0].length);
    }

    /**
     *
     * @param matrix
     * @param x
     * @param y
     * @param m 矩阵的行数
     * @param n 矩阵的列数
     * @return
     */
    public static  ArrayList<Integer> spiralOrder(int [][] matrix, int x, int y, int m, int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (m <= 0 || n <= 0)
            return result;
        //only one element left
        if (m == 1 && n == 1) {
            result.add(matrix[x][y]);
            return result;
        }
        //top - move right
        //顶端  从右开始
        for (int i = 0; i < n - 1; i++) {
            result.add(matrix[x][y++]);
        }
        //right - move down
        //从顶端往下走
        for (int i = 0; i < m - 1; i++) {
            result.add(matrix[x++][y]);
        }
        //bottom - move left
        //底端从右往左
        if (m > 1) {
            for (int i = 0; i < n - 1; i++) {
                result.add(matrix[x][y--]);
            }
        }
        //left - move up
        //左边往上移动
        if (n > 1) {
            for (int i = 0; i < m - 1; i++) {
                result.add(matrix[x--][y]);
            }
        }
        if (m == 1 || n == 1)
            result.addAll(spiralOrder(matrix, x, y, 1, 1));
        else
            result.addAll(spiralOrder(matrix, x + 1, y + 1, m - 2, n - 2));
        return result;
    }
}
