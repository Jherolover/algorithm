package MaximumSubarray;

/**
 * 在一个数组中查找一个连续的子序列，该子序列至少包含一个数字,使得子序列的和最大
 *
 * eg:
 * S = [-2,1,-3,4,-1,2,1,-5,4]
 *
 */
public class Solution {
    public static void main(String[] args) {
        int[] A = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(A));
    }
    public static int maxSubArray(int[] A){
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0 ; i < A.length;i++){
            sum += A[i];
            maxSum = Math.max(maxSum,sum);
            if (sum < 0 ){
                sum = 0;
            }
        }
        return maxSum;
    }
}
