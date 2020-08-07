import java.util.ArrayList;

/**
 * 题目：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Solution22 {
    /**
     * 学习来的方法：用队列解决这个问题。
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        //用队列来实现这个过程。
        ArrayList<TreeNode> queue = new ArrayList<>();
        //结果集合
        ArrayList<Integer> result = new ArrayList<>();
        //如果为空，返回空
        if(root == null) return result;
        //加入第一个节点。
        queue.add(root);
        //每一次遍历干两件事，从队列去除节点，然后判断左右子树是否需要入队。
        while (!queue.isEmpty()) {
            TreeNode t = queue.remove(0);
            result.add(t.val);
            if(t.left != null) queue.add(t.left);
            if(t.right != null) queue.add(t.right);
        }
        return result;
    }
}
