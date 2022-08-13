package TwoSum;

import java.util.HashMap;

/**
 * hashmap
 * target减去每一个数组
 * 判断是否存在数组中，存在则ok
 */
public class SolutionHashMap {

    public static void main(String[] args) {

        int target = 13;
        int[] numbers = {2,7,11,15};
        int[] result = twoSum(numbers, target);
        System.out.println(result[0]+","+result[1]);
    }

    /**
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
       int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
                if (map.containsKey(numbers[i])) {
                    int index = map.get(numbers[i]);
                    result[0] = index+1 ;
                    result[1] = i+1;
                    break;
                } else {
                    map.put(target - numbers[i], i);
                }
        }
        return result;
    }
}
