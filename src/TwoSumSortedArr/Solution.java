package TwoSumSortedArr;

/**
 * 问题相似于两个数相加
 * 排序数组，从两边进行相加判断
 */
public class Solution {

    public static int[] twoSum(int[] numbers,int target){
        if ( numbers == null || numbers.length ==0 ){
            return null;
        }
        int i = 0 ;
        int j = numbers.length -1;
        while ( i < j ){
            int x = numbers[i] + numbers[j];
            if ( x < target){
                ++i;
            }else if ( x > target){
                j --;
            }else {
                return new int[]{ i+1,j+1};
            }
        }
        return null;
    }
}
