package RotateImage;

/**
 * 矩阵只是一个2维数组
 *
 */
public class Solution1 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
    }

    /**
     * 旋转矩阵
     * @param matrix
     */
    public static void rotate(int[][] matrix){
        if (matrix ==null || matrix.length ==0){
            return;
        }
        //矩阵的列数
        int m = matrix.length;
        //新建一个矩阵
        int[][] result = new int[m][m];
        //元素交换
        for (int i = 0 ; i < m;i++){
            for (int j = 0 ; j < m ;j++){
                result[j][m-1-i] = matrix[i][j];
            }
        }
        System.out.println("输出交换的矩阵");
        print(result);
        //旋转矩阵
        for (int i = 0 ; i < m ; i++){
            for (int j = 0 ; j < m ;j++){
                matrix[i][j] = result[i][j];
            }
        }
        print(matrix);
    }

    /**
     * 输出矩阵
     * @param matrix
     */
    public static void print(int[][] matrix){
        int m = matrix.length;
        for (int i = 0 ; i < m ; i++){
            System.out.println();
            for (int j = 0 ; j < m ;j++){
                System.out.print(matrix[i][j]+",");
            }
        }
    }
}
