import java.util.Stack;

/**
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 */

public class Solution20 {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /**
     *  我的方法：初始化两个栈，一个栈用来遍历存储的结果，然后再把出栈的栈放进去。
     */

    public void push(int node) {
        stack1.push(node);
    }

    public void pop() {
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        int min = stack1.peek();
        while(!stack1.isEmpty()){
            int a = stack1.pop();
            if(a<min){
                min = a;
            }
            stack2.push(a);
        }
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return min;
    }
}
