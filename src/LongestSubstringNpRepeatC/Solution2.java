package LongestSubstringNpRepeatC;

import java.util.HashMap;

/**
 * 使用hashtable 追踪存在的字符和位置
 * 当一个重复的字符出现，检查从先前重复的字符
 * 计数器原理
 */
public class Solution2 {
    public static int LengthOfLongestSubstring(String s){
        //字符串数组
        char[] arr = s.toCharArray();
        int pre = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0 ; i < arr.length ; i++){
           if (!map.containsKey(arr[i])){
               map.put(arr[i],i);
           } else {
               pre = Math.max(pre,map.size());
               i = map.get(arr[i]);
               map.clear();
           }
        }
        return Math.max(pre,map.size());
    }
}
