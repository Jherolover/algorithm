package RotateImage;

/**
 * 使用关系式：
 * matrix[i][j] = matrix[n-1-j][i]
 * 交换矩阵
 */
public class Solution2 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,3},{4,10,6},{7,8,9}};
        rotate(matrix);
    }
    public static void rotate(int[][] matrix){
        int n = matrix.length;
        for (int i = 0 ; i < n /2;i++ ){
            for (int j = 0 ; j <Math.ceil(((double) n)/2.0);j++){
                int temp = matrix[i][j];
                //i=0的时候，第一行的第一个元素和最后一列的
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
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
