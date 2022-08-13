package TwoSumDataStructureDesign;

import java.util.HashMap;

/**
 * 设计一个 两个数相加的类
 * 应该支持下边的操作：
 * 添加和查找功能
 * 添加：添加一个数到内部数据结构，
 * 查找：存在任意的一对数之和等于查找的值
 * eg:1
 * add(1)
 * add(3)
 * add(5)
 * find(4) ->true
 * find(7) -> false
 */
public class TwoSum {
    //设计一个map结构
    private HashMap<Integer,Integer> elements = new HashMap<>();

    /**
     * 实现添加功能
     * @param number
     */
    public void add(int number){
        //key 存输入number,value代表number个数
        if(elements.containsKey(number)){
            elements.put(number,elements.get(number)+1);
        }else {
            elements.put(number,1);
        }
    }
    public boolean find(int value){
        for (Integer i : elements.keySet()){
            //构造转化目标值减去数组的key
            int target = value - i;
            if (elements.containsKey(target)){
                //如果当前的的数和目标值一致 ,且目标值的个数小于2则继续循环
                if ( i == target && elements.get(target) < 2){
                    continue;
                }
                return true;
            }
        }
        return false;
    }
}
