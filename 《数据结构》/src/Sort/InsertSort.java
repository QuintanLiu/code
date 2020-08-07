package Sort;


/**
 * 这个类下面都是插入排序
 * 1、直接插入排序
 * 2、折半插入排序
 * 3、希尔排序
 */

public class InsertSort {
    /**
     * 1、直接插入排序：
     * 思想：最前面放着有序的序列，每次从待排序序列中选择一个插入前面的序列。如果是顺序存储移动的有点多。
     * 时间复杂度O(n2)，稳定。
     */
    public void insertSort(int[] arr){
        int index = 0; //用于记录第一个无序的数字的位置。
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                index = i+1;
                break;
            }
        }
        //如果是有序的，就不排序了。
        if(index == 0){
            return;
        }
        for(int i = index;i<arr.length;i++){
            int t = arr[i];
            for(int j = i-1;j>=0;j--){
                if(t>=arr[j]){
                    arr[j+1] = t;
                    break;
                }
                else if(j == 0&&t<arr[j]){
                    arr[j+1] = arr[j];
                    arr[j] = t;
                }
                else{
                    arr[j+1] = arr[j];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {5,4,3,2,1};
        new InsertSort().insertSort(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
