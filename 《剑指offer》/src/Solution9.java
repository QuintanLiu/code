/**
 * 题目：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */

public class Solution9 {
    /**
     * 分析：小青蛙第一次可以跳1，2，。。。n个台阶所以f(n) = f(1)+.....f(n-1)+1
     * 那么f(n-1) = f(1)+....f(n-2)+1,所以f(n) = 2f(n-1),所以f(n)是等比数列。
     */
    public int JumpFloorII(int target) {
        return 1<<(target-1);

    }
    //我的第一个思路：递归，但是这个递归好像比非递归还要快。因为递归树只有一条。
    public int JumpFloorII2(int target) {

        if(target<1){
            return -1;
        }
        else if(target == 1){
            return 1;
        }
        else{
            return 2*JumpFloorII(target-1);
        }

    }

}
