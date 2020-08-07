/**
 *题目：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *保证base和exponent不同时为0
 */
public class Solution12 {
    /**
     *我的方法：如果n小于0，就对n进行取反，然后遍历求积，找出其相反数。时间复杂度位O(n)
     */
    public double Power(double base, int n) {
        double result = 1.0;
        if(n<0){
            n = -n;
            for(int i=0;i<n;i++){
                result *= base;
            }
            return 1/result;
        }
        else if(n>0){
            for(int i=0;i<n;i++){
                result *= base;
            }
            return result;
        }
        else{
            return 1;
        }

    }



    /**
     * 大佬的做法：
     * 1.全面考察指数的正负、底数是否为零等情况。
     * 2.写出指数的二进制表达，例如13表达为二进制1101。
     * 3.举例:10^1101 = 10^0001*10^0100*10^1000。
     * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
     * 这个时间复杂度要比我的小一些。最大时间复杂度位O(32),所以比我的要好。
     */
    //位运算可以做指数操作。
    public double Power2(double base, int n) {
        double res = 1,curr = base;
        int exponent;
        if(n>0){
            exponent = n;
        }else if(n<0){
            if(base==0)
                throw new RuntimeException("分母不能为0");
            exponent = -n;
        }else{// n==0
            return 1;// 0的0次方
        }
        //while出口，如果数字变成0的话，停止。
        while(exponent!=0){
            //如果最后一位是1，就把curr乘进结果。
            if((exponent&1)==1)
                res*=curr;
            curr*=curr;// 翻倍
            exponent>>=1;// 右移一位
        }
        return n>=0?res:(1/res);
    }
}
