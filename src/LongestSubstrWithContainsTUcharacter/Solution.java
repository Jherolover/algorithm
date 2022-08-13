package LongestSubstrWithContainsTUcharacter;

import java.util.HashSet;

/**
 * 这是google问题
 */
public class Solution {
    /**
     * 给定一个字符串，找到只包含两个独立字符的子串
     * eg:abcbbbbcccbdddadacb
     * 最长包含两个字符的子串为：
     * bcbbbbcccb
     * @param s
     * @return
     */
    public static String subString(String s){
      char[] arr = s.toCharArray();
      int max = 0 ;
      int j = 0;
      int m = 0,n = 0 ;
        HashSet<Character> set = new HashSet<>();
        set.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (set.add(arr[i])) {
                if (set.size() > 2) {
                    String str = s.substring(j, i);
                    //keep the last character only
                    set.clear();
                    set.add(arr[i - 1]);
                    if ((i - j) > max) {
                        m = j;
                        n = i - 1;
                        max = i - j;
                    }
                    j = i - helper(str);
                }
            }
        }
        return s.substring(m, n + 1);
    }
    // This method returns the length that contains only one character from righ side.
    public static int helper(String str) {
     // null & illegal checking here
        if(str == null){
            return 0;
        }
        if(str.length() == 1){
            return 1;
        }
        char[] arr = str.toCharArray();
        char p = arr[arr.length - 1];
        int result = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (p == arr[i]) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }
}
