package RotateArray;

/**
 * You may have been using Java for a while. Do you think a simple Java array question
 * can be a challenge? Let’s use the following problem to test.
 * Problem: Rotate an array of n elements to the right by k steps. For example, with n
 * = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * How many different ways do you know to solve this problem?
 */
public class Solution1 {
    /**
     * 反转数组
     * @param nums 数组
     * @param k 反转长度
     *         时间复杂度与空间复杂度都是 n
     */
    public  static  void rotate(int[] nums,int k){
        if(k > nums.length){
            k = k % nums.length;
        }
        //新建一个数组
        int[] result = new int[nums.length];
        //截取长度元素赋值
        for(int i = 0 ; i < k;i++){
            result[i] = nums[nums.length-k+i];
        }
        int j = 0;
        //从K位置开始取取原始数组的前几个数
        for(int i = k ; i <nums.length;i++){
            result[i] = nums[j];
            j++;
        }
        System.arraycopy(result,0,nums,0,nums.length);
    }

    /**
     * 测试
     */
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums,k);

    }
}
