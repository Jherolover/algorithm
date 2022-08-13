package RemoveDuplicateFrSortedArray;

/**
 * 给定一个排序的数组，从其中移除重复的元素，保证每一个元素只出现一次，返回新的长度
 * 不能从另外的数组分配额外的空间，必须在这个常量空间
 * eg:input = [1,1,2] 函数应该返回2
 *    A = [1,2]
 */
public class Solution {
    public static void main(String[] args) {
        int[] A = new int[]{1,1,2};
        System.out.println(removeDuplicatesNative(A));
    }
    /**
     * 此方法能够计算出独立元素的个数，但是没能改变原始数组的
     * @param A
     * @return
     */
    public static  int removeDuplicatesNative(int[] A){
        if (A.length <2){
            return A.length;
        }
        int j = 0 ;
        int i = 1 ;
        while (i < A.length){
            if (A[i] == A[j]){
                i ++;
            }else{
                j++;
                A[j] = A[i];
                i++;
            }
        }
        return j+1;
    }
}
