package StringToInteger;

/**
 * 实现字符串转化为整数
 * 考虑所有输入的情况，
 * 思路：
 * case 1: null or empty string
 * case 2: white spaces
 * case 3: +/- sign
 * case 4 : calculate real value
 * case 5 :handle min & max
 */
public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(atoi("3as2331212"));
    }
    public static  int atoi(String str){
        if (str == null || str.length() < 1){
            return 0;
        }
        //除去空格
        str = str.trim();
        char flag = '+';
        //检查所有的符号和正号
        int i = 0;
        if (str.charAt(0) == '-'){
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        // use double to store result
        double result = 0;
        // calculate value
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }
        if (flag == '-')
        result = - result;
        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int) result;
       }
}
