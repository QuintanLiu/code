package Sort;

/**
 * 这个类是交换排序：
 * 1、冒泡排序
 * 2、快速排序
 */

public class SwapSort {
    /**
     * 冒泡排序
     * 思想：最后一位开始遍历。两两比较。
     * 时间复杂度O(n2),稳定。
     */
    public void bubbleSort(int[] arr){
        boolean flag = false;
        for(int i=0;i<arr.length-1;i++){
            for(int j = arr.length-1;j>i;j--){
                if(arr[j]<arr[j-1]){
                    int t = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = t;
                    flag = true;
                }
            }
            if(false){
                flag = false;
            }
            else{
                break;
            }
        }
    }

    /**
     * 快速排序
     *
     */
    public void quickSort(int[] arr,int low,int high){
        //high能取到
        if(low>=high){
            return;
        }
        int a = partition(arr,low,high);
        quickSort(arr,low,a-1);
        quickSort(arr,a+1,high);
    }

    public int partition(int[] arr,int low,int high){
        int t = arr[low];
        while(low<high){
            while(low<high&&t<=arr[high]) high--;
            arr[low] = arr[high];
            while(low<high&&t>=arr[low]) low++;
            arr[high] = arr[low];
        }

        arr[low] = t;
        return low;
    }

    public static void main(String[] args) {
        int[] a = {5,12,5,1,3};
        new SwapSort().quickSort(a,0,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

}
