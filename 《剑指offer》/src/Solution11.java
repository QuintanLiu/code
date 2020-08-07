/**
 * 题目：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */

public class Solution11 {
    /**
     * 分析：首先要知道原码，补码和反码分别是什么。正数的原码，反码和补码都是一样的。
     * 负数的原码除了符号位其他的跟正数是一样的。反码就是除了符号位，其他位取反，补码就是在反码的基础上加1。
     */

    //我的方法：算出负数的补码。
    public int NumberOf1(int n) {
        if(n==-2147483648){
            return 1;
        }
        //sb用于存放数字的二进制。
        StringBuffer sb = new StringBuffer();
        //用m来保存n的原始值。
        int m = n;
        //如果n<0就对n进行取反。
        if(n<0){
            n = -n;
        }
        //求出正数的原码
        while(n>1){
            sb.append(n%2);
            n = n/2;
        }
        sb.append(n);
        //如果原来的n小于0，对原码进行求补码。
        if(m<0){
            //首先对sb进行填充，因为int类型一共有32位。
            for(int i=sb.length();i<32;i++){
                if(i==31){
                    sb.append(1);
                }
                else{
                    sb.append(0);
                }
            }
            //对除了符号位的，所有其他位取反。
            for(int i=0;i<sb.length()-1;i++){
                if(sb.charAt(i)=='1'){
                    sb.replace(i,i+1,"0");
                }
                else {
                    sb.replace(i,i+1,"1");
                }
            }
            //根据反码求出补码。
            for(int i=0;i<sb.length();i++){
                if(sb.charAt(i)=='1'){
                    sb.replace(i,i+1,"0");
                }
                else if(sb.charAt(i)=='0'){
                    sb.replace(i,i+1,"1");
                    break;
                }
            }
        }

        int count = 0;
        char[] arr = sb.toString().toCharArray();
        //找出二进制中的1的个数。
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='1'){
                count++;
            }
        }
        return count;
    }
    //学习之后我的想法：可以用位于的方式进行，因为负数的话，一旦进入-1就会死循环，所以需要对剩下的1的个数进行判断。
    //是不是可以先统计0的个数然后进行减一下？？？
    public static int NumberOf12(int n){
        //计数
        int count = 0;
        //如果大于0
        if(n>=0){
            //因为正数循环的最终结果一定是0，所以如果是0就结束循环。
            while(n!=0){
                if((n&1)==1){
                    count++;
                    n=n>>1;
                }
                else{
                    n=n>>1;
                }
            }
        }
        else{
            //用count2来统计已经进入循环的次数。
            int count2 = 0;
            //如果是负数的话，就用-1来结束循环。
            while(n!=-1){
                if((n&1)==1){
                    count++;
                    n = n>>1;
                }
                else{
                    n=n>>1;
                }
                count2++;
            }
            count += (32-count2);
        }
        return count;
    }
    //使用无视符号位右移
    public static int NumberOf13(int n){
        //计数
        int count = 0;
            //因为循环的最终结果一定是0，所以如果是0就结束循环。
            while(n!=0){
                if((n&1)==1){
                    count++;
                    n=n>>>1;
                }
                else{
                    n=n>>>1;
                }
            }
        return count;
    }


    //大佬的解法：因为数字在计算机运行的时候本来就是二进制，所以不需要进行二进制的转换。直接通过位运算判定1的个数。
    public static int NumberOf14(int n) {
        //用于统计
        int count = 0;
        while (n != 0) {
            ++count;
            //这边有一个问题？为什么和n-1进行位于呢？
            //其实就是一个数在二进制的情况下减1，就是把从后往前数的第一个变成0，后面全部变成1.那么用位于的方式的话，除了1那一位，其他的全部不变。
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
