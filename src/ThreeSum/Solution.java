package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定一个n个整数的数据，是否存在三个数 a + b +c = 0 ?
 * 找出所有符合给定的和为0的三个组元素
 * 元组(a,b,c) 必须是升序的，a<=b<=c
 * 解决 方法不能包含重复的元组
 * eg:
 *  S = {-1,0,1,2,-1,-4}
 *  A solution set is:
 *  (-1,0,1)
 *  (-1,-1,2)
 *  bad solution
 */
public class Solution {

    public static ArrayList<ArrayList<Integer>> threeSum(int[] num){
        //先排序数组
        Arrays.sort(num);
        //最终的元组list
        ArrayList<ArrayList<Integer>> result = new
                ArrayList<ArrayList<Integer>>();
        //一组
        ArrayList<Integer> each = new ArrayList<Integer>();
        for (int i = 0 ; i < num.length ; i++){
            if (num[i] > 0 ) break;
            for (int j = i +1; j < num.length ; j++){
                if (num[i] + num[j] >0 && num[j] > 0 )
                    break;
                for (int k = j+1; k < num.length ; k++){
                    if(num[i]+num[j]+num[k] == 0){
                        each.add(num[i]);
                        each.add(num[j]);
                        each.add(num[k]);
                        result.add(each);
                        each.clear();
                    }
                }
            }
        }

        return result;
    }
}
