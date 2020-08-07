/**
 * 题目：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Solution17 {
    /**
     * 这题我不会写，所以用的人家的方法。递归的思想。
     * 需要仔细看
     */
    //第一个函数用于判断是否需要使用第二个函数。
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;  //结果
        //同时不为空，进入判断，否则直接返回false
        if(root1 != null&&root2 != null){
            //如果相等，就进行确实性判断
            if(root1.val == root2.val){
                result = doHasSubTree(root1,root2);
            }
            //如果确实性判断失败，就进行左子树的判断。
            if(!result){
                result = HasSubtree(root1.left,root2);
            }
            //左子树判断失败就对右子树判断。
            if(!result){
                result = HasSubtree(root1.right,root2);
            }
        }
        return result;
    }
    //第二个函数用于判断是否确实两个树是一样的。
    public boolean doHasSubTree(TreeNode root1,TreeNode root2){
        //这里为什么root2为空直接返回真？？？
        //因为如果root2为空，不管root1是否为空，都满足这个分支相等的条件。
        if(root2 == null){
            return true;
        }
        //到这一步，说明root2必不为空，但是root1为空，所以返回false。
        if(root1 == null){
            return false;
        }
        //这里就是单纯的比较了。
        if(root1.val != root2.val){
            return false;
        }
        //如果值也相等，那么判断他们的左右子树。
        return doHasSubTree(root1.left,root2.left)&&doHasSubTree(root1.right,root2.right);
    }
}
