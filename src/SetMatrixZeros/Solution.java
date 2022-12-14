package SetMatrixZeros;

/**
 * 给定 a m x n 矩阵，放置位置使行列都为0
 * 思路：
 * 1.检查第一行第一列是否为0
 * 2.在第一行第一列标记为0
 * 3.使用标记设置元素
 * 4.根据是否为0 标记第一行是否为0
 */
public class Solution {

    public static void setZeros(int[][] matrix){
        boolean firstRowZero = false;
        boolean firstColumnZero = false;
        //检查第一行第一列是否为0
        for (int i = 0 ; i < matrix.length; i++){
            if (matrix[i][0] == 0){
                firstColumnZero =true;
                break;
            }
        }
        //第一行
        for (int i = 0 ; i < matrix[0].length ;i++){
            if (matrix[0][i] == 0 ){
                firstRowZero = true;
                break;
            }
        }
        //标记为0
        for (int i = 1; i < matrix.length;i++){
            for (int j = 1; j < matrix[0].length; j++){
                if (matrix[i][j] == 0 ){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0 ;
                }
            }
        }
        //use mark to set elements
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
//set first column and row
        if(firstColumnZero){
            for(int i=0; i<matrix.length; i++)
                matrix[i][0] = 0;
        }
        if(firstRowZero){
            for(int i=0; i<matrix[0].length; i++)
                matrix[0][i] = 0;
        }

    }
}
