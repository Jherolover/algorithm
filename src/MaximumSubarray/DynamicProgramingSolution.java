package MaximumSubarray;

/**
 * 动态规划
 * 动态规划的改变条件是：如果第n个元素已经比和大的情况下，
 * 我们应该不去计算前n-1个元素。
 */
public class DynamicProgramingSolution {

    public static int maxSubArray(int[] A){
        int max = A[0];
        int[] sum = new int[A.length];
        sum[0] = A[0];
        for (int i = 1;i < A.length;i++){
            sum[i] = Math.max(A[i],sum[i-1]+A[i]);
            max = Math.max(max,sum[i]);
        }
        return max;
    }
}
