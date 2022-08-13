package MedianTwoSortedArrays;

/**
 * 两个排序的数组 A(m) B(n)
 * 找到排序的数组
 * 复杂度 log(m+n)
 * 将问题找到k元素  (A+B)/2
 */
public class Solution {

    public static void main(String[] args) {
        int[] A = {1,3,5,7,9};
        int[] B = {2,4,6,8};
        System.out.println(findMedianSortedArrays(A,B));
    }

    /**
     * 两个排序数组的中间数
     * @param A
     * @param B
     * @return
     */
    public static double findMedianSortedArrays(int A[],int B[]){
        int m = A.length;
        int n = B.length;
        //奇数个
        if ( ( m + n ) % 2 != 0 ){
            return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
        }else{
            return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1)
                    + findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
        }
    }

    /**
     * 比较两个数组的中间数  中间数之间大小决定下一步走哪个比较
     *
     * @param A  A数组
     * @param B  B数组
     * @param k  K中间数的位置
     * @param aStart a 的开始位置
     * @param aEnd  a的结束位置
     * @param bStart b开始的位置
     * @param bEnd  b结束的位置
     * @return
     */
    public static int findKth(int A[],int B[],int k,
                              int aStart,int aEnd,int bStart,int bEnd){
        int aLen = aEnd - aStart + 1;
        int bLen = bEnd - bStart + 1;
        //处理特殊情况
        if ( aLen == 0 ){
            return B[bStart + k];
        }
        if ( bLen == 0 ){
            return A[aStart + k];
        }
        if ( k == 0){
           return A[aStart] < B[bStart] ? A[aStart]:B[bStart];
        }
        //中间数
        int aMid = aLen * k /(aLen + bLen); // a 的中间数
        int bMid = k - aMid - 1; //b的中间数
        // make aMid and bMid to be array index
        aMid = aMid + aStart; //A数组的中间数下标索引
        bMid = bMid + bStart; //B数组的中间数下标索引
        if (A[aMid] > B[bMid]) { //A的中间数的大于B的中间数
            k = k - (bMid - bStart + 1); //改变K的值
            aEnd = aMid; //A的结束位置移动中间数位置
            bStart = bMid + 1; //B的开始移动到中间数之后
        } else {
            k = k - (aMid - aStart + 1);
            bEnd = bMid;
            aStart = aMid + 1;
        }
        return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
    }
}
