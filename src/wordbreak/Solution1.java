package wordbreak;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

/**
 * 单词分割
 * eg: s = leetcode  dict=["leet","code"]
 */
public class Solution1 {

    public static void main(String[] args) {
        String s = "leetcode";
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("code");
        System.out.println(wordBreak(s,dict));
    }
    public static boolean wordBreak(String s ,Set<String> dict){
        return wordBreakHelperr(s,dict,0);
    }
    public static boolean wordBreakHelperr(String s, Set<String> dict, int start){
        if (start == s.length()){
            return true;
        }
        //遍历字典
        for (String dic:dict){
            //字典长度
            int len = dic.length();
            //从第几个字符开始
            int end = start+len;
            //超过字典则继续循环
            if (end > s.length()){
                continue;
            }
            //相等递归调用
            if( s.substring(start,start+len).equals(dic)){
                if(wordBreakHelperr(s,dict,start+len)){
                    return true;
                }
            }
        }
        return false;
    }
}
