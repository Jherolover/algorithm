package MergeSortedArr;

/**
 * 使用m+n 循环
 */
public class Solution1 {

    public static void merge(int A[],int m,int B[],int n){
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while ( k >= 0){
            if (j < 0 || ( i >= 0 && A[i] > B[j])){
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }
    }
}
