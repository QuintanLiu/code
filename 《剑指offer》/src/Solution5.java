import java.util.Stack;


/**
 * 题目：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */


public class Solution5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();



    //我的思路：一个栈用来写，一些栈用来读。边界问题看具体代码


    //进队的代码：栈1用来写
    public void push(int node) {
        this.stack1.push(node);
    }

    //出队代码：栈2用来出队。
    public int pop() {
        //如果栈2为空，并且栈1也是空，就返回0；
        //栈2为空，栈1不空，就把栈1全部进栈2，然后再返回栈2顶部的元素。
        //栈2不为空，就直接返回就好了。
        if(this.stack2.empty()){
            if(this.stack1.empty()){
                return 0;
            }
            else{
                while(!this.stack1.empty()){
                    this.stack2.push(this.stack1.pop());
                }
                return this.stack2.pop();
            }
        }
        else{
            return this.stack2.pop();
        }
    }

}
