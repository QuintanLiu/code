import java.util.ArrayList;

/**
 *输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution13 {
    /**
     * 我的方法：先遍历一遍把奇数和偶数分开，然后再遍历一遍把数字放回原来的数组。
     * 时间复杂度为：2O(n);空间上也是需要额外的空间的。
     */
    public void reOrderArray(int [] array) {
        ArrayList<Integer> ji = new ArrayList<>();
        ArrayList<Integer> ou = new ArrayList<>();
        for(int i = 0;i<array.length;i++){
            if(array[i]%2==0){
                ou.add(array[i]);
            }
            else{
                ji.add(array[i]);
            }
        }
        ji.addAll(ou);
        for(int i = 0;i<array.length;i++){
            array[i] = ji.get(i);
        }
    }

    //我复现的大佬的代码。
    public void reOrderArray3(int [] array) {
        if (array.length == 0)
            return;
        int j;
        //遍历每一次进入循环干三件事：找到第一个偶数，找到偶数后面的第一个奇数，然后把奇数前面的所有偶数全部后移。
        //奇数一定是可以遍历到底的。所以最后奇数一定是再最前面的。
        for(int i = 0;i<array.length;){
            while (i<array.length&&!isEven(array[i])){
                i++;
            }
            j = i+1;
            while(j<array.length&&isEven(array[j])){
                j++;
            }
            if(j<array.length){
                int a = array[j];
                for(;j>i;j--){
                    array[j] = array[j-1];
                }
                array[i] = a;
                i++;
            }
            else{
                break;
            }
        }

    }

    /**
     * 大佬的做法：不用额外空间的做法。时间上可能效率不高。
     * 1.要想保证原有次序，则只能顺次移动或相邻交换。
     * 2.i从左向右遍历，找到第一个偶数。
     * 3.j从i+1开始向后找，直到找到第一个奇数。
     * 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
     * 5.終止條件：j向後遍歷查找失敗。
     */
    public void reOrderArray2(int [] a) {
        if(a==null||a.length==0)
            return;
        int i = 0,j;
        while(i<a.length){
            while(i<a.length&&!isEven(a[i]))
                i++;
            j = i+1;
            while(j<a.length&&isEven(a[j]))
                j++;
            if(j<a.length){
                int tmp = a[j];
                for (int j2 = j-1; j2 >=i; j2--) {
                    a[j2+1] = a[j2];
                }
                a[i++] = tmp;
            }else{// 查找失敗
                break;
            }
        }
    }
    //判断奇偶数。
    boolean isEven(int n){
        if(n%2==0)
            return true;
        return false;
    }

}
