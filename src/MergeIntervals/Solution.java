package MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;

/**
 * 合并间隔
 * 给定一个间隔的集合，合并重叠的部分
 * eg:
 * Given : [1,3],[2,6],[8,10],[15,18]
 * return [1,6],[8,10],[15,18]
 */
public class Solution {
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        Interval interval1 = new Interval(1,3);
        Interval interval2 = new Interval(2,6);
        Interval interval3 = new Interval(8,10);
        Interval interval4 = new Interval(15,18);
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);
        System.out.println(merge(intervals));
    }
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals){
        if ( intervals ==null || intervals.size() <=1 ){
            return intervals;
        }
        //排序
        Collections.sort(intervals,new IntervalComparator());
        ArrayList<Interval> result = new ArrayList<>();
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(prev.end >= curr.start){
                //合并
                Interval merged = new Interval(prev.start, Math.max(prev.end,curr.end));
                prev = merged;
            }else{
                result.add(prev);
                prev  = curr;
            }
        }
        result.add(prev);
        return result;
    }
}
