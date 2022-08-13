package MergeSortedArr;

/**
 * 给定两个排序数组A和B，合并B到A为一个有序数组
 * 你可以假设A有足够的空间添加数组B，
 * A和B数组的个数分别是m和n
 * 思路：
 * 问题的关键是移动元素反向A，B
 *
 */
public class Solution {

    public static void main(String[] args) {
        int []A = {1,3,5,7,9,0,0,0};
        int []B = {2,4,6};
        merge(A,5,B,3);
    }

    public static void merge(int A[],int m,int B[],int n ){
        while ( m > 0 && n > 0 ){
            if(A[m-1] > B[n-1]){
                A[m+n-1] = A[m-1];
                m--;
            }else{
                A[m+n-1] = B[n-1];
                n--;
            }
        }
        while(n > 0){
            A[m+n-1] = B[n-1];
            n--;
        }
    }
}
