package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 使用双指针
 * 时间复杂度 O(n^2)
 * 避免重复，利用排序数组
 *
 */
public class BetterSolution {

    public static void main(String[] args) {
        int[] num = {-1,0,1,2,-1,-4};
        ArrayList<ArrayList<Integer>> arrayLists = threeSum(num);
        for ( ArrayList<Integer> list : arrayLists){
            System.out.print("[");
            for (Integer i : list){
                System.out.print(i+",");
            }
            System.out.print("]");
        }

    }
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num.length < 3){
            return result;
        }
        //排序数组
        Arrays.sort(num);

        for (int i = 0 ; i < num.length - 2;i++){
            //避免重复
            if (i ==0 || num[i] > num[i-1]){
               int negate = -num[i];
               int start = i + 1;
               int end = num.length - 1;
               while (start < end){
                   //情况1
                   if (num[start] + num[end] == negate){
                       ArrayList<Integer> temp = new ArrayList<>();
                       temp.add(num[i]);
                       temp.add(num[start]);
                       temp.add(num[end]);
                       result.add(temp);
                       start++;
                       end--;
                       //避免重复
                       while (start < end && num[end] == num[end +1]){
                           end --;
                       }
                       while (start < end && num[start] == num[start -1]){
                           start ++;
                       }
                   } else if (num[start]+num[end] < negate) {
                       start ++;
                   }else {
                       end --;
                   }
               }
            }
        }
        return result;
    }
}
