import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */


public class Solution6 {
    //我的方法：我并没有对数组进行旋转，而是复制了一个数组排序后得到最小值。时间复杂度O(nlogn),可以达到O(n)。
    //那么如果下次考数组旋转怎么办？？？？
    public int minNumberInRotateArray(int [] array) {
        //数组大小为0，就返回0
        if(array.length == 0){
            return 0;
        }
        int[] arr = new int[array.length];
        for(int i=0;i<array.length;i++){
            arr[i] = array[i];
        }

        Arrays.sort(arr);
        if(array[arr.length-1]<arr[arr.length-1]){
            return arr[0];
        }
        return arr[0];
    }

    //剑指offer中的分析：非递减排序的数组，旋转后实际上可以分为两个有序子数组，前面数组的值都大于后面数组的值。最小元素就是数组的分界线。
    // 但是我们不知道分界值在哪儿。
    //用二分查找的思想。跟第一个和最后一个元素比较，如果比第一个大，说明中间数字在第一个数组里面left移动，如果比最后一个小那么中间数字在后面数组里面right移动
    //这个算法有一个问题，就是数组不能有重复的值。
    //时间复杂度为O(logn)
    public int minNumberInRotateArray2(int [] array) {
        if(array.length == 0){
            return 0;
        }
        if(array.length == 1){
            return array[0];
        }

        int left = 0;
        int right = array.length-1;
        //如果left和right不相邻就进入循环
        while (left + 1  < right){
            int mid = (left+right)/2;
            //只跟第一个元素比较，如果比他大就移动left，否则移动right
            if(array[left]<array[mid]){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        //返回right
        return array[right];
    }

    //大佬的改进算法：顺序查找结合二分查找来实现的算法。
    public int minNumberInRotateArray3(int [] array) {
        int length = array.length;
        if(length == 0){
            return 0;
        }
        //定义左右两个遍历下标
        int left = 0;
        int right = length-1;
        int mid = 0;

        while (array[left] >= array[right]){
            if(right - left == 1){
                mid = right;
                break;
            }
            mid = (left+right)/2;
            if(array[left] == array[right] && array[left] == array[mid]){
                return MinOrder(array,left,right);
            }
            if(array[mid]>=array[left]){
                left = mid;
            }
            else {
                right = mid;
            }

        }
        return array[mid];
    }

    //找到left和right区间里面的最小值
    public int MinOrder(int[] array,int left, int right){
        int min = array[left];
        for(int i=left;i<right;i++){
            if(array[i]<min){
                min = array[i];
            }
        }
        return min;
    }

    //对我自己写的算法改进，根据上面大佬的想法
    //逻辑：知道什么时候需要进行顺序查找，当right，mid和left相等时候，无法判定left和right的位置的时候需要使用顺序查找。
    public int minNumberInRotateArray4(int [] array) {
        if(array.length == 0){
            return 0;
        }
        if(array.length == 1){
            return array[0];
        }

        int left = 0;
        int right = array.length-1;
        while (left + 1  < right){
            int mid = (left+right)/2;
            if(array[left]<array[mid]){
                left = mid;
            }
            else if (array[left] == array[mid]){
                if(array[right]==array[mid]){
                    return MinOrder(array,left,right+1);
                }
                else if(array[right]>array[mid]){
                    right = mid;
                }
                else {
                    left = mid;
                }
            }
            else{
                right = mid;
            }
        }
        return array[right];
    }

}
