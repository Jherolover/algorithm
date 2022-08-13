package wordbreak;

import java.util.HashSet;
import java.util.Set;

/**
 * 动态规划解决
 * t[] t[i]==true => o-(i-I)
 * Initial state t[o] == true
 */
public class DynamicSolution {
    public static void main(String[] args) {
        String s = "leetcode";
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("code");
        System.out.println(wordBreak(s,dict));
    }
    public static boolean wordBreak(String s , Set<String> dict){
        //初始化定义数组
        boolean[] t = new boolean[s.length()+1];
        //初始化第一个为true
        t[0] = true;
        //我们需要初始化状态
        for (int i = 0 ; i < s.length(); i++){
            if(t[i]){
                continue;
            }
            //循环遍历
            for (String dic:dict){
                int len = dic.length();
                int end = i + len;
                if(end > s.length()){
                    continue;
                }
                if(t[end]) continue;
                if(s.substring(i,end).equals(dic)){
                    t[end] = true;
                }
            }
        }
        return t[s.length()];
    }
}
