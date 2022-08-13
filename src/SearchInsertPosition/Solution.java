package SearchInsertPosition;

/**
 * 给定一个排序数组和一个目标值，发现目标值返回下标
 * 找不到，返回一个它可以插入的下标位置，假设数组不重复。
 * eg:
 * [1,3,5,6],5->2
 * [1,3,5,6],2->1
 * [1,3,5,6],7->4
 * [1,3,5,6],0->0
 *
 * 思路：
 * 遍历数组，比较目标值 和 i + 1元素的值
 * 时间复杂度为O（n）
 */
public class Solution {

    public static int searchInsertPos(int [] A,int target){
        //空数组返回0
        if (A == null ) return 0;
        //边界值
        if (A[0] >= target ) return 0;
        for (int i = 0 ; i < A.length - 1 ; i ++){
            if (target > A[i] && target <= A[i+1] ){
                return i +1;
            }
        }
        return A.length;
    }
}
