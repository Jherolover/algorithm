package RemoveDuplicateFrSortedArray;

/**
 * 如果只是单独想统计独立元素的个数
 * 下边的方法足够
 */
public class Solution3 {

    //统计独立元素的个数
    public static int countUnique(int[] A){
        int count = 0 ;
        for (int i = 0 ; i <  A.length -1 ;i++){
            if (A[i] == A[i+1]){
                //统计相同元素的个数
                count++;
            }
        }
        return (A.length - count);
    }
    //统计独立元素的个数
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3};
        int size = countUnique(arr);
        System.out.println(size);
    }
}
