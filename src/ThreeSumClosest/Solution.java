package ThreeSumClosest;

import java.util.Arrays;

/**
 * 给定一个n长度的整数，找到三个整数使他们的和最靠近给定的一个数
 * 返回三个数之和，
 * eg:
 * S = {-1 2 1 -4}
 * target = 1
 * 最靠近目标的是2
 * 此种方法的思想：
 * 这种问题类似2数之和，可以使用类似的方法解决，双指针进行
 * 复杂度是0(n^2)
 */
public class Solution {

    public static int threeSumClosest(int[] num,int target){
        int min = Integer.MAX_VALUE;
        int result = 0 ;
        //先排序数组
        Arrays.sort(num);
        for (int i = 0 ; i < num.length ; i++) {
            int left = i + 1;
            int right = num.length - 1;
            while ( left < right){
                //求和
               int sum = num[i] + num[left] + num[right];
               int diff = Math.abs(sum -target);
               //如果等于直接返回
                if (diff ==0 ) return 0;
                if (diff < min){
                    min = diff;
                    result = sum;
                }
                if (sum <= target){
                    left ++ ;
                }else {
                    right ++;
                }
            }
        }
        return result;
    }
}
