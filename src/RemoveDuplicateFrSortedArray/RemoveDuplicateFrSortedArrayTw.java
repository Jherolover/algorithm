package RemoveDuplicateFrSortedArray;

/**
 * 运行重复两次的情况
 */
public class RemoveDuplicateFrSortedArrayTw {

    //错误的答案
    public static int removeDuplicates(int[] A){
        if (A == null || A.length == 0){
            return 0;
        }
        int pre = A[0];
        boolean flag =false;
        int count = 0;
        for (int i = 1; i < A.length ;i++){
            int curr = A[i];
            if (curr == pre){
                if(!flag){
                    flag = true;
                    continue;
                }else{
                    count++;
                }
            }else{
                pre = curr;
                flag = false;
            }
        }
        return A.length - count;
    }
    //正确的做法
    public static int removeDuplicatesSolution2(int[] A){
        if (A == null || A.length == 0 ){
            return 0;
        }
        int pre = A[0];
        boolean flag = false;
        int count = 0;
        //更新索引
        int o = 1;
        for (int i = 1; i <  A.length ; i++){
            int curr = A[i];
            if (curr == pre){
                if(!flag){
                    flag = true;
                    A[o++] = curr;
                    continue;
                }else{
                    count++;
                }
            }else{
                pre = curr;
                A[o++] =curr;
                flag =false;
            }
        }
        return A.length -count;
    }
    //比较好的解决方法
    public static int removeDuplicatesBetterSolution(int[] A){
        if (A.length <= 2){
            return A.length;
        }
        int prev = 1;//指向前一个元素的指针
        int curr = 2;//指向当前的指针
        while (curr < A.length){
            if (A[curr] == A[prev] && A[curr]==A[prev-1]){
                curr++;
            }else{
                prev++;
                A[prev] = A[curr];
                curr++;
            }
        }
        return prev+1;
    }
}
