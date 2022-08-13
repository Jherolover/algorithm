package DistinctSubsequenceTotal;

/**
 * 给定一个字符串S和T
 * 统计S中T的唯一的子序列的数
 * 子序列的定义是指从原始串中删除部分字母，不能打乱相关的位置顺序。
 * ACE 是ABCDE的子序列，然而AEC不是
 * eg:
 * S="rabbbit",T="rabbit"
 * return 3
 */
public class Solution {


    /**
     * 思路
     * 当你看到字符串问题或者子序列或则匹配问题，动态规划方法应该自然而然的
     * 浮现在你的脑海。关键是查找改变的条件。
     * w(i,j) 代表 S(o,i) in T(o,j)
     * 如果 S.charAt(i) == T.charAt(j)
     * w(i,j) = w(i-1,j-1)+w(i-1,j)
     * 否则： w(i,j) = w(i-1,j).
     */
    public static int numDistincts(String S,String T){
        int[][] table = new int[S.length()+1][T.length()+1];
        for (int i = 0 ; i < S.length() ;i++){
            table[i][0] = 1;
        }
        //遍历进行比较两个子串大小
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    table[i][j] += table[i - 1][j] + table[i - 1][j - 1];
                } else {
                    table[i][j] += table[i - 1][j];
                }
            }
        }
        return table[S.length()][T.length()];
    }

}
