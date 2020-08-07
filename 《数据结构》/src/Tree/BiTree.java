package Tree;

import sun.text.bidi.BidiBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.function.BinaryOperator;

class BiNode{
    private int data;

    public int getData() {
        return data;
    }

    public BiNode right;
    public BiNode left;

    public BiNode(){}
    public BiNode(int data){
        this.data = data;
    }

}


public class BiTree {
    private BiNode head;

    //导入二叉树的根节点。
    public BiTree(BiNode head){
        this.head = head;
    }

    //二叉树的先序遍历
    //递归实现的，问题是每一次使用的话，都需要一个BiTree对象的包装。非常的浪费空间。
    public ArrayList<Integer> preOrder(){
        ArrayList<Integer> res = new ArrayList<>();
        if(this.head!=null){
            res.add(this.head.getData());
            res.addAll(new BiTree(this.head.left).preOrder());
            res.addAll(new BiTree(this.head.right).preOrder());
        }
        return res;
    }
    //先序遍历的非递归实现
    public ArrayList<Integer> preOrder2(){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<BiNode> stack = new Stack<>();
        BiNode p = this.head;
        while (p!=null||!stack.isEmpty()){
            if(p!=null){
                stack.push(p);
                res.add(p.getData());
                p = p.left;
            }
            else {
                p = stack.pop();
                p = p.right;
            }
        }
        return res;
    }


    //中序遍历的非递归实现。
    public ArrayList<Integer> inOrder(){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<BiNode> stack = new Stack<>();
        BiNode p = this.head;
        while (p != null||!stack.isEmpty()){
            if(p != null){
                stack.push(p);
                p = p.left;
            }
            else {
                p = stack.pop();
                res.add(p.getData());
                p = p.right;
            }
        }
        return res;
    }
    //后序遍历的非递归实现

    /**
     * 我觉得这边有两种解决方法，第一种是用双栈法,想法跟我想法一样。
     * 还有一种是通过上面的先序的实现，将左右子树调换，然后倒叙就好了。
     */
    //后序遍历的第二种实现,这种方法很稳。list可以用栈来实现。
    public ArrayList<Integer> postOrder(){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<BiNode> stack = new Stack<>();
        BiNode p = this.head;
        while(p!=null||!stack.isEmpty()){
            if(p!=null){
                stack.push(p);
                res.add(p.getData());
                p = p.right;
            }
            else {
                p = stack.pop();
                p = p.left;
            }
        }
        Collections.reverse(res);
        return res;
    }



    public static void main(String[] args) {
        BiNode biNode = new BiNode(1);
        biNode.left = new BiNode(2);
        biNode.right = new BiNode(3);
        biNode.left.right = new BiNode(4);
        biNode.left.right.left = new BiNode(6);
        biNode.right.right = new BiNode(5);
        ArrayList<Integer> arr = new BiTree(biNode).postOrder();
        System.out.println(arr.size());
        for(int v:arr){
            System.out.println(v);
        }
    }
}
