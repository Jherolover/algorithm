package wordLadder;

import java.util.HashSet;

/**
 * 给定两个单词和一个字典列表
 * 找到  从开始到结束的最短的转换序列
 * 只有一个字母可以改变 ，每一次改变的单词必须存在在字典里边
 * eg:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * 一个最短的转换为：
 * hit->hot>dot>dog>cog
 * 程序应该返回长度5
 *
 * 最简单的方法：从开始改变一个字母。如果在字典里边，我继续替换字母，直到start=end
 *
 */
public class Solution {

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        String start = "a";
        String end = "c";
        HashSet<String> dict = new HashSet<>();
        dict.add("a");
        dict.add("b");
        dict.add("c");
        System.out.println(ladderLength(start,end,dict));
    }


    public static int ladderLength(String start, String end, HashSet<String> dict){
        int len = 0;
        HashSet<String> visited = new HashSet<String>();
        for (int i = 0 ; i < start.length() ; i++){
             //转化为字符数组
             char[] startArr = start.toCharArray();
             //遍历开始数组
             for (char c = 'a'; c <= 'z'; c++){
                 //全部替换一遍
                 if ( c == start.toCharArray()[i] ){
                     continue;
                 }
                 startArr[i] = c;
                 //替换之后还原为字符串
                 String temp = new String(startArr);
                 if (dict.contains(temp)){
                     //长度++
                     len ++;
                     start = temp;
                     if (temp.equals(end)){
                         return len;
                     }
                 }
             }
        }
        return len;
    }
}
