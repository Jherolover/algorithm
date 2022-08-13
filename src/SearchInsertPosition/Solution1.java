package SearchInsertPosition;

/**
 * 这类似一个二分法搜索问题
 * 时间复杂度可以缩小为o(nlog(n))
 *
 */
public class Solution1 {

    public static  int searchInsert(int [] A,int target){
        if (A ==null  || A.length == 0 ){
            return 0;
        }
        return searchInsert(A,target,0,A.length-1);
    }
    public static int searchInsert(int[] A,int target,int start,int end){
        int mid = (start + end)/2;
        if (target == A[mid]){
            return mid;
        } else if ( target < A[mid]) {
            return start < mid ? searchInsert(A, target, start, mid - 1) : start;
        }else {
            return end > mid ? searchInsert(A, target, mid + 1, end) : (end + 1);
        }
    }
}
