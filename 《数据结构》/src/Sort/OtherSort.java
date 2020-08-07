package Sort;

/**
 * 其他的一些排序算法
 * 1、归并排序
 * 2、基数排序（桶排序）
 */

public class OtherSort {
    /**
     * 归并排序：
     * 思路：
     * 时间复杂度O(nlogn),空间复杂度O(n),稳定。
     */
    public void merge(int[] arr,int low,int mid,int high){
        int[] brr = new int[high+1];
        for(int i = 0;i<=high;i++){
            brr[i] = arr[i];
        }
        int i,j,k;
        for(i = low,j = mid+1,k=i;i<=mid&&j<=high;k++){
            if(brr[i]<=brr[j]){
                arr[k] = brr[i++];
            }
            else{
                arr[k] = brr[j++];
            }
        }//end for
        while(i<=mid) arr[k++] = brr[i++];
        while(j<=high) arr[k++] = brr[j++];


    }
    public void mergeSort(int[] arr,int low,int high){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }

    /**
     * 基数排序
     * 思路：根据位数排序，从最低位向下排序。
     * 时间复杂度O(d(n+r)),空间复杂度为O(r),稳定。其中r表示位数。
     */


    public static void main(String[] args) {
        int[] a = new int[]{2,3,1,4,1,5,6};
        new OtherSort().mergeSort(a,0,a.length-1);
        for (int t :a){
            System.out.println(t);
        }
    }
}
