package wordLadder;

import java.util.HashSet;
import java.util.LinkedList;

/**
 *  树搜索问题
 *  广度搜索保证最优解
 *  假设我们有一些单词在字典
 *  从hit 开始
 *                     hit
 *                  hot  hot  hot
 *
 *  使用两个队列存：一个存储节点，另外一个存储步骤
 *
 */
public class BreathFirstSearch {

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        HashSet<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        System.out.println(ladderLength(start,end,dict));
    }
    public static  int ladderLength(String start, String end, HashSet<String> dict) {

        if (dict.size() == 0) {
            return 0;
        }
        //添加字典
        dict.add(end);
        LinkedList<String> wordQueue = new LinkedList<>();
        LinkedList<Integer> distanceQueue = new LinkedList<>();
        //添加开始
        wordQueue.add(start);
        //添加步骤数字
        distanceQueue.add(1);
        //追踪最短距离
        int result = Integer.MAX_VALUE;
        while (!wordQueue.isEmpty()) {
            //当前的单词
            String currWord = wordQueue.pop();
            //当前的距离
            Integer currDistance = distanceQueue.pop();
            if (currWord.equals(end)) {
                result = Math.min(result, currDistance);
            }
            //遍历所有的情况
            for (int i = 0; i < currWord.length(); i++) {
                char[] currCharArr = currWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {

                    currCharArr[i] = c;
                    String newWord = new String(currCharArr);
                    //新单词
                    if (dict.contains(newWord)) {
                        //匹配上上字典
                        wordQueue.add(newWord);
                        distanceQueue.add(currDistance + 1);
                        //移除字典
                        dict.remove(newWord);
                    }
                }
            }

        }
        if (result < Integer.MAX_VALUE) {
            return result;
        }else{
            return 0;
        }
    }

}
