package MaximumProductSubarray;

/**
 * 和最大子序列相似，
 * 与求和不同的是，符号会影响最终的结果。
 *当我们迭代数组的时候，每一个元素有两种可能，正数和负数
 * 我们需要追踪一个最小值，以至于当一个负数出现的时候，它可以乘以得到最大值。
 * 定义两个变量：一个存最大值，一个存最小值
 * 时间复杂度为O(n)
 */
public class DynamicProgramming {
    public static void main(String[] args) {
        int[] A = new int[]{2,3,-2,4};
        System.out.println(maxProduct(A));
    }
    public static int maxProduct(int[] A){
        if (A == null || A.length == 0 ){
            return 0;
        }
        int maxLocal = A[0];
        int minLocal = A[0];
        int global = A[0];
        for (int i = 1; i < A.length;i++){
            int temp = maxLocal;
            maxLocal = Math.max(Math.max(A[i]*maxLocal,A[i]),A[i]*minLocal);
            minLocal = Math.min(Math.min(A[i]*temp,A[i]),A[i]*minLocal);
            global = Math.max(global,maxLocal);
        }
        return global;
    }
}
