package SpiralMatrix;

import java.util.ArrayList;

/**
 * 给定一个m * n 的矩阵，m行n列
 * 以特定的顺序返回：
 * eg:
 * [
 *  [1,2,3],
 *  [4,5,6],
 *  [7,8,9]
 *  返回
 *  [1,2,3,6,9,8,7,4,5]
 * ]
 */
public class Solution {

    public static ArrayList<Integer> spiralOrder(int[][] matrix){
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix ==null || matrix.length == 0 ) return result;
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = 0;
        while (m>0 && n >0){
            //一行或者列 没有环
            if ( m == 1){
                for (int i = 0 ; i < n; i ++){
                    result.add(matrix[x][y++]);
                }
                break;
            } else if (n==1) {
                for (int i = 0 ; i <m; i ++){
                    result.add(matrix[x++][y]);
                }
                break;
            }
            //处理环状问题
            //top - move right
            for (int i = 0 ; i < n -1; i++){
                result.add(matrix[x][y++]);
            }
            //right - move down
            for(int i=0;i<m-1;i++){
                result.add(matrix[x++][y]);
            }
            //bottom - move left
            for(int i=0;i<n-1;i++){
                result.add(matrix[x][y--]);
            }
            //lef
            for(int i=0;i<m-1;i++){
                result.add(matrix[x--][y]);
            }
            x++;
            y++;
            m=m-2;
            n=n-2;
        }

        return result;
    }
}
