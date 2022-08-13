package LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的数组
 * 找到最长连续的元素序列
 * eg:
 * s = [100,4,200,1,3,2]
 * 最长连续序列应该为 [1,2,3,4]
 * 长度为4
 * 算法的复杂度应该为O(n)
 */
public class Solution {


    public  static int longestConsecutive(int[] num){
        //判断数组是否为空，为空返回0
        if (num.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int max = 1;
        //添加 到set
        for (int e:num){
            set.add(e);
        }
        //遍历元素数组
        for (int e : num){
            int left = e - 1;
            int right = e + 1;
            int count = 1;
            //找到当前元素左边的连续的元素
            while (set.contains(left)){
                count ++;
                //找到之后必须将元素进行移除，否则复杂度为o(mn)

                set.remove(left);
                left--;
            }
            //找到当前元素右边的连续元素
            while (set.contains(right)){
                count++;
                set.remove(right);
                right ++;
            }
            //当前元素最大的连续元素的长度
            max = Math.max(count,max);
        }
        return max;
    }
}
