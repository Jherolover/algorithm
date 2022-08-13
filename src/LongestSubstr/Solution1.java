package LongestSubstr;

/**
 * 最长子串回文结构
 */
public class Solution1 {

    public static String LongestPalindrom1(String s){
        int maxPalinLength = 0;
        String longestPalindrome = null;
        int length = s.length();
        //check all possible sub strings
        for(int i = 0 ; i < length;i++){
            for(int j = i+1;j<length;j++){
                int len = j -i;
                String curr = s.substring(i,j+1);
                if(isPalindrome(curr)){
                    if(len > maxPalinLength){
                        longestPalindrome = curr;
                        maxPalinLength = len;
                    }
                }
            }
        }
        return longestPalindrome;
    }

    /**
     * 判断子串是否是回文结构
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
