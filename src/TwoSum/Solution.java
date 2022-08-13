package TwoSum;

/**
 * Input numbers={2,7,11,15} target=9
 * output index1=1,index2=2
 *
 */
public class Solution {
    public static void main(String[] args) {
        int target = 9;
        int[] numbers = {2,7,11,15};
        int[] result = twoSum(numbers, target);
        System.out.println(result[0]+","+result[1]);
    }
    public static int[] twoSum(int[] numbers,int target){
        int [] ret = new int[2];
        for (int i = 0 ; i <numbers.length;i++){
            for (int j = i+1 ; j < numbers.length ; j ++){
                if ( numbers[i] + numbers[j] == target){
                    ret[0] = i + 1;
                    ret[1] = j + 1;
                }
            }
        }
        return ret;
    }
}
