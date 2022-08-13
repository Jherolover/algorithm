package Search2DMatrix;

/**
 * 在矩阵（m * n）的中查询值
 * 矩阵特点：
 * 1、每一行从左到右是排序好的
 * 2、每一行的第一个元素大于上一行的最后一个整数
 * eg:
 * [
 * [1,3,5,7],
 * [10,11,16,20],
 * [23,30,34,50]
 * ]
 * 给定一个目标值：
 * target=3,return true
 */
public class Solution {

    public static boolean searchMatrix(int[][] matrix,int target){
        if (matrix==null || matrix.length ==0 || matrix[0].length ==0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0 ;
        int end = m * n -1;
        //本质还是二分法
        while (start <= end ){
            int mid = (start+end)/2;
            int midX = mid / n ;
            int midY = mid % n;
            if (matrix[midX][midY] == target){
                return true;
            }
            if (matrix[midX][midY] < target){
                start = mid + 1;
            }else {
                end = mid -1;
            }
        }
        return false;
    }
}
