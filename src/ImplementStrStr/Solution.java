package ImplementStrStr;

/**
 * 返回一个指针
 * 思路：
 * 需要正确理解问题，指针简单的说指一个子串
 * 确保循环不要超过两个字符串的边界
 * needle是不是haystack的一部分
 */
public class Solution {


    public static String strStr(String haystack,String needle){
        int needleLen = needle.length();
        int haystackLen = haystack.length();
        if (needleLen == haystackLen && needleLen == 0 ){
            return "";
        }
        if (needleLen == 0 ){
            return haystack;
        }
        for (int i = 0 ; i < haystackLen ; i++){
            //确保指针的边界
            if (haystackLen - i + 1 < needleLen){
                return null;
            }
            int k = i ;
            int j = 0 ;
            while (j < needleLen && k < haystackLen && needle.charAt(j) == haystack.charAt(k)){
                 j ++;
                 k ++;
                 if ( j == needleLen){
                     return haystack.substring(i);
                 }
            }
        }
        return null;
    }
}
