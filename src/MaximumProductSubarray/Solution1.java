package MaximumProductSubarray;

/**
 * 连续子序列乘积最大
 * eg:
 * [2,3,-2,4]
 * [2,3] = 6
 * 暴力求解
 */
public class Solution1 {

    public static int maxProduct(int[] A){
        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < A.length;i++){
            for(int j = 0 ; j < A.length;j++){
                if (i+j < A.length){
                    int product = calProduct(A,i,j);
                    max = Math.max(product,max);
                }
            }
        }
        return max;
    }
    public static int calProduct(int[] A,int i,int j){
        int result =1;
        for (int m = i; m<=j;m++){
            result = result * A[m];
        }
        return result;
    }
}
