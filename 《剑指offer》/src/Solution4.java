import java.util.Arrays;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

/**
   * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
   * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
   * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Solution4 {


    //我的方法：递归
    //分析：前序遍历的第一个节点一定是其根节点，可以将前序遍历的两个节点，每次找一个节点接上，递归他的左右子树。
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode treeNode = null;
        //递归出口
        if (pre.length == 0) {
            return treeNode;
        }
        else {
            //前面两个用于分开pre这个数组，后面两个用于分开in中序数组。
            int[] head = null;
            int[] after = null;
            int[] left = null;
            int[] right = null;
            //对数组进行分开
            for (int i = 0; i < pre.length; i++) {
                if (pre[0] == in[i]) {
                    treeNode = new TreeNode(pre[0]);
                    left = Arrays.copyOf(in, i);
                    right = Arrays.copyOfRange(in, i + 1, in.length);
                    head = Arrays.copyOfRange(pre, 1, i + 1);
                    after = Arrays.copyOfRange(pre, i + 1, pre.length);
                    break;
                }

            }
            //递归左右子树
            treeNode.left = reConstructBinaryTree(head, left);
            treeNode.right = reConstructBinaryTree(after, right);
            return treeNode;


        }
    }


}