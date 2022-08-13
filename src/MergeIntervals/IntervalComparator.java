package MergeIntervals;

import java.util.Comparator;

/**
 * 比较两个开始数组的开始字符的大小
 */
public class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval o1, Interval o2) {
        return o1.start - o2.start;
    }
}
