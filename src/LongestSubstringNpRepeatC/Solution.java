package LongestSubstringNpRepeatC;

/**
 * 给定一个字符串，找到最长没有重复的子串
 * eg:
 * S = "abcabcbb" result = "abc"
 * S = "bbbbb" result = “b”
 *
 */
public class Solution {
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(LenthOfLongestSubstring(s));
    }
    public static int LenthOfLongestSubstring(String s){
        boolean[] flag = new boolean[256];
        int result = 0 ;
        int start = 0;
        char[] arr = s.toCharArray();
        for (int i = 0 ; i < arr.length; i++){
            char current = arr[i];
            if(flag[current]){
                result = Math.max(result,i-start);
                //the loop 更新新的起点
                //重置flag数组
                //for example abccab 当此时是第二个c
                //更新从0-3，重置标志 a,b
                for (int k = start;k < i ; k ++){
                   if (arr[k] == current) {
                       start = k + 1;
                       break;
                   }
                   flag[arr[k]] = false;
                }
            }else{
                flag[current] = true;
            }
        }
        result = Math.max(arr.length-start,result);
        return result;
    }
}
