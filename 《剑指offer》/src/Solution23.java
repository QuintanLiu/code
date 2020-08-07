import java.util.*;
/**
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution23 {
    /**
     * 学来的方法：主要是怎么判断，首先这个树是一个二叉搜索树，那么这个树的中序遍历是有序的。左子树比右子树小。所以可以分析，除了根节点
     * 输入的数组必然是可以分为一个比根节点大，一个比根节点小的两个数组。用这个想法递归的判断是不是二叉搜索树。
     *
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        //如果数组长度是1或者2，直接输出真。递归出口
        if(sequence.length == 1||sequence.length==2){
            return true;
        }
        //如果数组长度为0，直接输出假。二叉搜索树不可以为空。
        if(sequence.length==0){
            return false;
        }
        //将数组分为两个部分。
        int t = para(sequence);
        if(t==-1){
            return false;
        }
        //返回他左右子树的判断结果。
        else if(t==sequence.length||t==0){

            return VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,sequence.length-1));
        }
        else{
            //返回左右子树判断的与操作。
            return VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,t))&&VerifySquenceOfBST(Arrays.copyOfRange(sequence,t,sequence.length-1));
        }


    }

    //如果返回值是-1，表示这个数组不符合二叉排序树的后续遍历。
    //如果返回0或者arr的长度，那么表示可能这个二叉树的左右子树有一个为空。
    //如果返回其他的值，表示右子树数组的第一个数字。
    public int para(int[] arr){
        if(arr[0]>arr[arr.length-1]){
            for(int i=1;i<arr.length-1;i++){
                if(arr[i]<arr[arr.length-1]){
                    return -1;
                }
            }
            return 0;
        }
        else if(arr[arr.length-2]<arr[arr.length-1]){
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]>arr[arr.length-1]){
                    return -1;
                }
            }
            return arr.length;
        }
        else{
            int index = 0;
            int index2 = -1;
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]>arr[arr.length-1]){
                    index = 1;
                    index2 = i;
                }
                else if(arr[i]<arr[arr.length-1]&&index==1){
                    return -1;
                }
            }
            return index2;
        }
    }


    /**
     * 其他人的做法：也是递归，但是确实代码量要比我少很多。思考一下怎么减少代码量。
     */
    public boolean VerifySquenceOfBST2(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }
        return judge(sequence,0,sequence.length-1);
    }

    private boolean judge(int[] a,int l,int r){
        if(l>=r){
            return true;
        }
        int i = r;
        //首先一轮找到那个分解点。
        while(i > l && a[i - 1] > a[r]) --i;
        //如果后面出现一个不和谐的点返回false
        for(int j = i - 1; j >= l; --j) if(a[j] > a[r]) return false;
        //如果可以分的话，则判断后面的值。
        return judge(a, l, i - 1) && (judge(a, i, r - 1));
    }


}
