package Sort;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * 这个类下面都是基于选择的排序
 * 1、简单选择排序
 * 2、堆排序
 */

public class SelectSort {
    /**
     * 简单选择排序：
     * 思想：每一轮选择一个最小的数字放到最前面。
     * 时间复杂度O(n)
     */
    public void selectSort(int[] arr){
        if(arr.length == 0){
            return;
        }
        int min;
        for(int i=0;i<arr.length-1;i++){
            min = i;
            for(int j = i;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            int t = arr[i];
            arr[i] = arr[min];
            arr[min] = t;
        }
    }




    //堆排序
    /**
     * 堆排序利用的存储结构是二叉树的顺序表表示。
     */


    public static void buildMaxHeap(int[] arr){
        int k = arr.length/2;
        for(int i = k;i>=0;i--){
            swap(arr,i);
        }
    }
    public static void swap(int[] arr,int index){
        int left = (index+1)*2-1;
        int right = (index+1)*2;
        if(left>=arr.length){
            return;
        }
        if(left == arr.length-1){
            if(arr[left]>arr[index]){
                int t = arr[index];
                arr[index] = arr[left];
                arr[left] = t;
            }
        }
        else{
            if(arr[left] > arr[index]&&arr[left]>=arr[right]){
                int t = arr[index];
                arr[index] = arr[left];
                arr[left] = t;
                swap(arr,left);
            }
            else if(arr[right] > arr[index]&&arr[right]>=arr[left]){
                int t = arr[index];
                arr[index] = arr[right];
                arr[right] = t;
                swap(arr,right);
            }
        }

    }



    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,4,1,5,6};
        new SelectSort().selectSort(a);
        for (int t :a){
            System.out.println(t);
        }
    }

}
