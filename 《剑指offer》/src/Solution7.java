/**
 * 题目：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */

public class Solution7 {
    //我的方法：递归，F(n) = F(n-1)+F(n-2)
    public int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        else{
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }
    //非递归算法：时间复杂度为O(n)
    public int Fibonacci2(int n){
        int[] arr = new int[n+1];
        for(int i =0;i<arr.length;i++){
            if(i==0||i==1){
                arr[i] = i;
            }
            else{
                arr[i] = arr[i-1]+arr[i-2];
            }
        }
        return arr[n];
    }

    //大佬的动态规划版本,不需要额外的存储空间。
    public int Fibonacci3(int n){
        int f=0,g=1;
        //g表示n+1位置上的数字。
        while(n-->0){
            g+=f;
            f = g-f;
        }
        System.out.println(g);
        return f;
    }

    public static void main(String[] args) {
        Solution7 s = new Solution7();
        System.out.println(s.Fibonacci3(4));
    }

}
