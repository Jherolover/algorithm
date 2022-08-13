package InertInterval;

import java.util.ArrayList;

/**
 * 给一个非重叠有序的interval
 * 插入一个新的interval 有必须的进行合并
 * eg1:
 * intervals: [1,3],[6,9] inert and merge [2,5] in as [1,5],[6,9]
 * eg2:
 * [1,2],[3,5],[6,7],[8,10],[12,16] inert and merge [4,9] in as
 * [1,2],[3,10],[12,16]
 */
public class Solution {

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals,Interval newInterval){
        ArrayList<Interval> result = new ArrayList<Interval>();
        //遍历
        for(Interval interval: intervals){
            //比较第一个的结束值和新值的开始
            if(interval.end < newInterval.start){
                result.add(interval);
            }else if(interval.start > newInterval.end){
                result.add(newInterval);
                newInterval = interval;
            }else if(interval.end >= newInterval.start || interval.start <=
                    newInterval.end){
                newInterval = new Interval(Math.min(interval.start,
                        newInterval.start), Math.max(newInterval.end, interval.end));
            }
        }
        result.add(newInterval);
        return result;
    }
}
