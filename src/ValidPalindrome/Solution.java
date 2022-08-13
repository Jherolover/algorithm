package ValidPalindrome;

/**
 * 给定一个字符串，含有字母和数字的;
 * 忽略大小写，
 * eg:
 * "Red rum,sir,is murder" is palindrome while Programcreek  is
 * awesome is not
 * 是否考虑到字符串为空的情况。
 * 可以考虑空字符串是回文串
 */
public class Solution {

    public static boolean isPalindrome(String s){
        if (s == null) return false;
        if (s.length() <2 ) return true;
        int len = s.length();
        char[] charArray = s.toCharArray();
        int i = 0;
        int j = len - 1;
        //从两端开始遍历
        while ( i < j ){
           char left=charArray[i], right = charArray[j];
           while ( i < len-1 && !isAlpha(left)&&!isNum(left)){
             i ++;
             left = charArray[i];
           }
           while(j>0 && !isAlpha(right) && !isNum(right)){
               j--;
               right = charArray[i];
           }
           if (i >= j ){
               break;
           }
           left = charArray[i];
           right = charArray[j];
           if (!isSame(left,right)){
               return false;
           }
           i ++;
           j--;
        }
        return true;
    }

    /**
     * 判断是否是字母
     * @param a
     * @return
     */
    public static boolean isAlpha(char a){
        if((a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z')){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 是否是数字
     * @param a
     * @return
     */
    public static boolean isNum(char a) {
        if (a >= '0' &&a <= '9'){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 字母是否一样
     * @param a
     * @param b
     * @return
     */
    public static boolean isSame(char a, char b){
        if(isNum(a) && isNum(b)){
            return a == b;
        }else if(Character.toLowerCase(a) == Character.toLowerCase(b)){
            return true;
        }else{
            return false;
        }
    }
}
