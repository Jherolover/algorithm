package RotateArray;

/**
 * 冒泡排序
 * 时间复杂度O（n*k）
 */
public class Solution2 {
    public static  void rotate(int[] arr,int order){
        if(arr == null || order < 0 ){
            throw new IllegalArgumentException("不合法参数");
        }
        for(int i = 0 ; i < order;i++){
            for(int j = arr.length-1 ; j > 0 ;j--){
                int temp  = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int  k = 7;
        rotate(nums,k);
    }
}
