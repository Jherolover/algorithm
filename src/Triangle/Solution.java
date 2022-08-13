package Triangle;

import java.util.ArrayList;

/**
 * 给定一个三角，找到从顶部到底部和的最小值
 * 每一步都应该移动到同行相邻的数字
 * eg:
 * [
 *     [2]
 *    [3][4]
 *  [6][5][7]
 * [4][1][8][3]
 * ]
 * 最小的路径是：2+3+5+1=11
 */
public class Solution {

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int[] temp = new int[triangle.size()];
        int minTotal = Integer.MAX_VALUE;
        for(int i=0; i< temp.length; i++){
            temp[i] = Integer.MAX_VALUE;
        }
        if (triangle.size() == 1) {
            return Math.min(minTotal, triangle.get(0).get(0));
        }
        int first = triangle.get(0).get(0);
        for (int i = 0; i < triangle.size() - 1; i++) {
            for (int j = 0; j <= i; j++) {
                int a, b;
                if(i==0 && j==0){
                    a = first + triangle.get(i + 1).get(j);
                    b = first + triangle.get(i + 1).get(j + 1);
                }else{
                    a = temp[j] + triangle.get(i + 1).get(j);
                    b = temp[j] + triangle.get(i + 1).get(j + 1);
                }
                temp[j] = Math.min(a, temp[j]);
                temp[j + 1] = Math.min(b, temp[j + 1]);
            }
        }
        for (int e : temp) {
            if (e < minTotal)
                minTotal = e;
        }
        return minTotal;
    }
}
