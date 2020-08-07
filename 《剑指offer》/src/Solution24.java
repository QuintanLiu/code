import sun.java2d.pipe.AAShapePipe;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Solution24 {
    /**
     * 我的想法：递归，其实很简单的思路，就是把根节点减掉，然后递归左右子树。(错误，不能使用我这种方式递归。)
     * 存在问题：list这个列表不能递归。每次只能加入自己的这个节点。
     * 这个思路是可以的，大佬也算是这种思路，但是我不会实现。
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        return res;
    }

    /**
     * 大佬的实现：这种方法虽然可以实现，但是对逻辑的要求相当的高。
     * 我觉得这样的递归还是要学习着写一下。
     */
    //把这两个变量定义在外面，做递归的全局变量。
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath1(TreeNode root,int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            //这个部分为什么需要new一个ArrayList，因为list这个列表对象只有一个加入进去之后在对其进行改变的话，每次加入的都是这个list。
            listAll.add(new ArrayList<Integer>(list));
        //这两个左右子树的操作主要是为了把节点加入结果。
        FindPath1(root.left, target);
        FindPath1(root.right, target);
        //这里为什么要将最后一位移出去？？移出去的并不是最后一位，而是当前位。
        list.remove(list.size()-1);
        return listAll;
    }


    //二叉树的先序遍历
    /**
     * 我自己的方法：根据二叉树的先序遍历进行改进的方法。
     */
    ArrayList<Integer> res = new ArrayList<>();
    ArrayList<ArrayList<Integer>> list1 = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> PreOrder(TreeNode root,int target){
        if(root == null){
            return list1;
        }
        res.add(root.val);
        target -= root.val;
        if(target == 0){
            if(root.right==null&&root.left==null){
                list1.add(new ArrayList<>(res));
                res.remove(res.size()-1);
                return list1;
            }
            else if(root.right == null&&root.left!=null){

                PreOrder(root.left,target);
                res.remove(res.size()-1);
                return list1;
            }
            else if(root.right != null&&root.left==null){

                PreOrder(root.right,target);
                res.remove(res.size()-1);
                return list1;
            }
            else{

                PreOrder(root.left,target);
                PreOrder(root.right,target);
                res.remove(res.size()-1);
                return list1;
            }
        }
        if(root.right==null&&root.left==null){

            res.remove(res.size()-1);
            return list1;
        }
        else if(root.right == null&&root.left!=null){
            PreOrder(root.left,target);
            res.remove(res.size()-1);
            return list1;
        }
        else if(root.right != null&&root.left==null){
            PreOrder(root.right,target);
            res.remove(res.size()-1);
            return list1;
        }
        else{
            PreOrder(root.left,target);
            PreOrder(root.right,target);
            res.remove(res.size()-1);
            return list1;
        }
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        List res = new Solution24().PreOrder(head,7);
        for(int i = 0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
}
