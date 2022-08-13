package LongestSubstr;

/**
 * 动态规划解决问题
 * 字符串s  i,j指字符串的下标位置
 * 定义二维数组table[i][j] 标记从i ->j的子串是否是回文
 *
 * table[i][i] == 1
 * table[i][i+1] == 1 => s.charAt(i) == s.charAt(i+1)
 * 改变条件
 * table[i+1][j-1]==1 && s.charAt(i) == s.charAt(j)
 * ==> table[i][j] == 1
 * time o(n^2)space(O(n^2))
 */
public class DynamicSolution {

  public static String longestPalindrome2(String s){
      if(s == null){
          return  null;
      }
      if(s.length() <=1){
          return s;
      }
      int maxLen = 0 ;
      String longestStr = null;
      int length = s.length();
      //定义一个二维数组
      int[][] table = new int[length][length];
      //单个字符都是回文
      for(int i = 0 ; i < length ;i++){
          table[i][i] = 1;
      }
      printTable(table);
      //两个连续字符相同的为回文
      for(int i = 0 ; i < length -2;i++){
          if(s.charAt(i)==s.charAt(i+1)){
              table[i][i+1] = 1 ;
              longestStr = s.substring(i,i+2);
          }
      }
      printTable(table);
      //计算整个table
      for(int l = 3; l <= length ;l++){
          for(int i = 0 ; i <= length -l;i++){
              int j = i+l-1;
              if(s.charAt(i) == s.charAt(j)){
                  table[i][j] = table[i+1][j-1];
                  if(table[i][j]==1 && l > maxLen){
                      longestStr = s.substring(i,j+1);
                  }
              } else {
                  table[i][j] = 0;
              }
              printTable(table);
          }
      }
      return  longestStr;
  }
    public static void printTable(int[][] x){
        for(int [] y : x){
            for(int z: y){
                System.out.print(z + " ");
            }
            System.out.println();
        }
        System.out.println("------");
    }
}
