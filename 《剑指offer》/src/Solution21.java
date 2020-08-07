import java.util.Stack;

/**
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class Solution21 {
    /**
     * 我的方法：学习来的方法，模拟入栈的过程。我一开始的想法是：跟出栈顺序进行比较如果不一样就入栈，直到结果一样了再说。但是中间情况有点多。
     * 时间复杂度O(2n)
     */

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int i = 0; //用于遍历pushA
        int j = 0; //用于遍历popA
        //模拟过程中需要使用的栈。
        Stack<Integer> stack = new Stack<>();
        //根据pushA来遍历。
        while(i<pushA.length){
            //每次遍历都先压栈。
            stack.push(pushA[i++]);
            //出栈条件。
            while(j<popA.length&&stack.peek()==popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
    /**
     * 上面想法的for循环实现。
     */
    public boolean IsPopOrder2(int [] pushA,int [] popA) {
        if(pushA.length == 0){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=0,j=0;i<pushA.length;){
            stack.push(pushA[i++]);
            while(j<popA.length&&stack.peek()==popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
