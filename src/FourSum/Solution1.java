package FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定一个n个整形的数组，是否存在a,b,c,d ，满足
 * a+b+c+d=target
 * 注意：每一个元组必须是升序排序
 * 不包含重复
 * 典型的k-sum 问题  time is N
 * eg:
 * S = {1 0 -1 0 -2 2} target = 0
 * A solution set is:
 * (-1,0,0,1)
 * (-2,-1,1,2)
 * (-2,0,0,-2)
 */
public class Solution1 {

    public ArrayList<ArrayList<Integer>> fourSum(int[] num,int target){
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> hashSet = new HashSet<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        //从第一个元素开始
        for (int i = 0; i < num.length; i++) {
            //从第二个元素开始
            for (int j = i + 1; j < num.length; j++) {
                //第三个元素
                int k = j + 1;
                //最后一个元素
                int l = num.length - 1;
                while (k < l) {
                    int sum = num[i] + num[j] + num[k] + num[l];
                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else if (sum == target) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[k]);
                        temp.add(num[l]);
                        if (!hashSet.contains(temp)) {
                            hashSet.add(temp);
                            result.add(temp);
                        }
                        k++;
                        l--;
                    }
                }
            }
        }
        return result;
    }
}
