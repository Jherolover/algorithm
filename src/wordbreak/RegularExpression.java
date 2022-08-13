package wordbreak;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<>();
        dict.add("go");
        dict.add("goal");
        dict.add("goals");
        dict.add("special");

        StringBuilder sb = new StringBuilder();
        //拼接字符串
        for ( String s : dict ){
            sb.append( s + "|");
        }
        //
        System.out.println(sb.toString());
        String pattern = sb.toString().substring(0,sb.length()-1);
        System.out.println("构造正则匹配："+pattern);
        pattern = "("+pattern+")*";
        Pattern p = Pattern.compile(pattern);
        Matcher m  = p.matcher("goalaspecial");
        if (m.matches()){
            System.out.println("match");
        }
    }

}
