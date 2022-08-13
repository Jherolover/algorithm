package ValidPalindrome;
//先移除所有的特殊字符

public class Stack {
    /**
     * 判断是否是回文
     * @param s
     * @return
     */
    public static  boolean isPalindrome(String s){
        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int len = s.length();
        if (len < 2){
            return true;
        }
        java.util.Stack<Character> stack = new java.util.Stack<Character>();
        int index = 0 ;
        //先push
        while (index < len / 2){
            stack.push(s.charAt(index));
            index++;
        }
        if (len %  2==1){
            index ++;
        }
        while (index < len){
            if (stack.empty()){
                return false;
            }
            char temp = stack.pop();
            if (s.charAt(index) != temp){
                return false;
            }else{
                index ++;
            }
        }
        return true;
    }
}
