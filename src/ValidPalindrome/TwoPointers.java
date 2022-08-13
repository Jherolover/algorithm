package ValidPalindrome;

public class TwoPointers {

    /**
     * 判断是否为回文串
     * @param s
     * @return
     */
    public static boolean isValidPalindrome(String s){

        if (s == null || s.length() == 0 ) return false;
        //正则表达式去除特殊字符
        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        System.out.println(s);
        for (int i = 0 ; i < s.length() ;i++){
            if (s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man,a plan,a canal:Panama";
        System.out.println(isValidPalindrome(str));
    }
}
