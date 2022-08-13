package ValidParentheses;

import java.util.HashMap;
import java.util.Stack;

/**
 * 给定一个字符
 *'(',')',",",'['']' 判断输入是否有效
 * 括号必须是正确的顺序，(),()[]
 *
 */
public class Solution {
    public static void main(String[] args) {
        String s = "a(s)das121[2]";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s ){
        HashMap<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < s.length() ; i++){
            char curr = s.charAt(i);
            //key是否包含现在的字符
            if (map.keySet().contains(curr)){
                //入栈
                stack.push(curr);
            }else if(map.values().contains(curr)){
                //不为空，栈顶是否包含包含
                if (!stack.empty() && map.get(stack.peek()) == curr){
                    //包含就进行出栈
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
