package wordbreakII;

import java.util.*;

/**
 * 给定一个字符串，一个字典列表，加上分割符构造一个句子
 * eg:input => s="catsanddog" dict=["cat","cats","and","sand",dog]
 *    output=> ["cats and dog",“cat sand dog”]
 *    使用深度优先搜索算法 获取所有的可能路径
 * character  index  words
 *    c  0
 *    a  1
 *    t  2
 *    s  3     cat
 *    a  4     cats
 *    n  5
 *    d  6
 *    d  7   and sand
 *    o  8
 *    g  9
 *       10  dog
 */
public class DynamicProgramming {

    public static void main(String[] args) {
        String s = "catsanddog";
        HashSet<String> dict = new HashSet<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        wordBreak(s,dict);

    }
    public static List<String> wordBreak(String s, Set<String> dict){
        //create an array of ArrayList<String>
        List<String> dp[] = new ArrayList[s.length()+1];
        dp[0] = new ArrayList<String>();
        for (int i = 0 ; i < s.length();i++){
            if (dp[i] == null){
                continue;
            }
            for (String word:dict){
                int len = word.length();
                int end = i + len;
                if (end > s.length()){
                    continue;
                }
                if (s.substring(i,end).equals(word)){
                    if (dp[end] == null){
                        dp[end] = new ArrayList<>();
                    }
                    dp[end].add(word);
                }
            }
        }
        //
        List<String> result = new LinkedList<>();
        if (dp[s.length()] == null){
            return result;
        }
        ArrayList<String> temp = new ArrayList<>();

        dfs(dp, s.length(), result, temp);
        return result;
    }

    private static void dfs(List<String>[] dp, int end, List<String> result, ArrayList<String>  tmp) {

        if(end <= 0){
            String path = tmp.get(tmp.size()-1);
            for(int i=tmp.size()-2; i>=0; i--){
                path += " " + tmp.get(i) ;
            }
            result.add(path);
            return;
        }
        for(String str : dp[end]){
            tmp.add(str);
            dfs(dp, end-str.length(), result, tmp);
            tmp.remove(tmp.size()-1);
        }
    }

}
