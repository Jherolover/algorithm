package RotateImage;

/**
 * 给定一个2D 矩阵代表一个图片
 * 顺时针方向旋转90°
 *
 */
public class Solution {

    public static void rotate(int[][] matrix){
        if (matrix == null || matrix.length == 0 ){
            return ;
        }
        //矩阵的长度
        int m = matrix.length;
        //返回旋转的矩阵
        int[][] result = new int[m][m];
        for (int i = 0 ; i < m ; i ++){
            for (int j = 0 ; j < m ; j ++){
                result[j][m-1-i] = matrix[i][j];
            }
        }
        matrix = result;
    }
}
