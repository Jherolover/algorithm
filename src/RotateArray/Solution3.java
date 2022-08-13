package RotateArray;

/**
 * an we do this in O(1) space and in O(n) time? The following solution does.
 *
 * Assuming we are given 1,2,3,4,5,6 and order 2. The basic idea is:
 *
 * . Divide the array two parts: 1,2,3,4 and 5, 6
 *
 * . Rotate first part: 4,3,2,1,5,6
 *
 * . Rotate second part: 4,3,2,1,6,5
 *
 * . Rotate the whole array: 5,6,1,2,3,4
 */
public class Solution3 {

    public static void rotate(int[] arr,int order){
        order = order % arr.length;
        if(arr ==null || order < 0 ){
            throw new IllegalArgumentException("不合法参数");
        }
        int a = arr.length - order;
        reverse(arr,0,a-1);
        reverse(arr,a,arr.length-1);
        reverse(arr,0,arr.length-1);
    }
    public static  void reverse(int[] arr,int left,int right){
        if(arr == null || arr.length == 1){
            return;
        }
        while( left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        int k = 3;
        rotate(nums,k);

    }
}
