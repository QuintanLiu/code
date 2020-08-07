import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Solution26 {
    /**
     * 我的想法：对二叉树的中序遍历进行改进。
     * 但是我没什么思路，或者说我太菜了。直接上大佬的代码吧。
     */
    //二叉树的中序遍历，递归版。

    public ArrayList<Integer> inOrder(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }

        res.addAll(inOrder(root.left));
        res.add(root.val);
        res.addAll(inOrder(root.right));
        return res;
    }
    //二叉树的中序遍历非递归版。
    public ArrayList<Integer> inOrder2(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null)
            return res;
        TreeNode p = root;
        boolean isFirst = true;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            res.add(p.val);
            p = p.right;

        }
        return res;
    }



    public TreeNode Convert(TreeNode pRootOfTree) {

        return pRootOfTree;
    }

    /**
     * 大佬的代码非递归版：
     * 核心思想是中序遍历的非递归实现。修改当前遍历节点和前一遍历节点的指针指向。
     */

    public TreeNode ConvertBSTToBiList(TreeNode root) {
        if(root==null)
            return null;
        //建立一个栈，用于存储最右边的数字。
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode pre = null;// 用于保存中序遍历序列的上一节点
        boolean isFirst = true;  //用于判断pre和root是否指向了最小的那个节点。
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst){
                root = p;// 将中序遍历序列中的第一个节点记为root
                pre = root;
                isFirst = false;
            }else{
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return root;
    }

    //大佬的递归版。
    public TreeNode Convert2(TreeNode root) {
        if(root==null)
            return null;
        if(root.left==null&&root.right==null)
            return root;
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert2(root.left);
        TreeNode p = left;
        // 2.定位至左子树双链表最后一个节点
        while(p!=null&&p.right!=null){
            p = p.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            p.right = root;
            root.left = p;
        }
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert2(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = root;
            root.right = right;
        }
        return left!=null?left:root;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        ArrayList<Integer> res = new Solution26().inOrder(tree);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
}
