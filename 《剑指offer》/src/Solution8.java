import java.math.BigInteger;

/**
 * 题目：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */

public class Solution8 {
    //我学习的方法：就是第一个可以跳1个台阶，那么剩下的n-1个台阶就是f(n-1),
    //如果第一个跳两个台阶，那么剩下的n-2个台阶就是f(n-2)。
    //我是用的递归方法。
    public int JumpFloor(int target) {
        if(target == 1){
            return 1;
        }
        else if(target == 2){
            return 2;
        }
        else{
            return JumpFloor(target-1)+JumpFloor(target-2);
        }
    }

    //我的非递归算法
    public int JumpFloor2(int target){
        int a = 1;
        int b = 2;
        int result = 0;
        if(target == 1){
            result = 1;
            return result;
        }
        if(target == 2){
            result = 2;
            return result;
        }
        for(int i=3;i<target+1;i++){
            b = b+a;
            a = b-a;
        }
        result = b;
        return result;
    }
    public int numWays(int target) {
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("2");
        int result = 0;
        if(target == 0){
            result = 1;
            return result;
        }
        if(target == 1){
            result = 1;
            return result;
        }
        if(target == 2){
            result = 2;
            return result;
        }
        for(int i=3;i<target+1;i++){
            b = b.add(a);
            a = b.subtract(a);
        }
        result = b.mod(new BigInteger("1000000007")).intValue();
        return result;
    }

}
