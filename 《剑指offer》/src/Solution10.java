/**
 * 题目：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */

public class Solution10 {
    /**
     *分析：由题意知，f(n) = f(n-1)+f(n-2)
     */
    //我的方法：递归，但是存在问题。这种递归空间上和时间上都是不好的。因为存在着很多的重复计算。
    public int RectCover(int target) {
        if(target == 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        else if(target == 2){
            return 2;
        }
        else{
            return RectCover(target-1)+RectCover(target-2);
        }
    }

    //非递归算法。
    public int RectCover2(int target) {
        int a = 1;
        int b = 2;
        if(target == 1||target==2||target==0){
            return target;
        }

        for(int i = 3;i<target+1;i++){
            b = a+b;
            a = b-a;
        }
        return b;
    }


}
