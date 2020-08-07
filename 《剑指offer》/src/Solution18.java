/**
 * 题目：操作给定的二叉树，将其变换为源二叉树的镜像。所有的节点左右子树互换。
 */
public class Solution18 {
    /**
     * 我的方法：递归。递归出口，当输入的节点为空的时候退出。否则进行左右节点的交换。递归交换左右子树。
     */
    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        else if(root != null){
            TreeNode t = root.left;
            root.left = root.right;
            root.right = t;
            Mirror(root.left);
            Mirror(root.right);
        }
    }
}
