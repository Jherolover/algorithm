package Triangle;

import java.util.ArrayList;

/**
 * 从底端开始
 *
 *  * eg:
 *  * [
 *  *     [2]
 *  *    [3][4]
 *  *  [6][5][7]
 *  * [4][1][8][3]
 *  * ]
 *  * 最小的路径是：2+3+5+1=11
 */
public class GoodSolution {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> one = new ArrayList<>();
        one.add(2);
        ArrayList<Integer> two = new ArrayList<>();
        two.add(3);
        two.add(4);
        ArrayList<Integer> three = new ArrayList<>();
        three.add(6);
        three.add(5);
        three.add(7);
        ArrayList<Integer> four = new ArrayList<>();
        four.add(4);
        four.add(1);
        four.add(8);
        four.add(3);
        triangle.add(one);
        triangle.add(two);
        triangle.add(three);
        triangle.add(four);
        int total = minimunTotal(triangle);
        System.out.println(total);
    }

    public static int minimunTotal(ArrayList<ArrayList<Integer>> triangle){
        //构造最短路径数组
        int[] total = new int[triangle.size()];
        //三角的高度
        int l = triangle.size() - 1;
        //遍历最后一行
        for (int i = 0 ; i < triangle.get(l).size();i++){
            total[i] = triangle.get(l).get(i);
        }
        //total = {4,1,8,3}

        //从倒数第二行开始迭代
        //[6][5][7]
        for (int i = triangle.size()-2;i >= 0 ;i--){
            for (int j = 0 ; j < triangle.get(i+1).size()-1;j++){
                total[j] = triangle.get(i).get(j) + Math.min(total[j],total[j+1]);
            }
        }
        return total[0];
    }
}
