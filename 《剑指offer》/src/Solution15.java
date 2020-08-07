/**
 * 题目：输入一个链表，反转链表后，输出新链表的表头。
 */
public class Solution15 {
    /**
     * 我得方法：用头插法得方法得到最后得结果。
     * 循环最重要得是知道每一轮进去之后都需要干嘛！！
     * 时间复杂度O(n)
     */
    public ListNode ReverseList(ListNode head) {
        ListNode listNode = head; //用于遍历整个链表
        ListNode result = null; //返回结果得节点
        ListNode p = listNode;  //为了不让节点丢失创造得节点。
        //每次循环找到本次得节点并且把节点用头插法得方式插入结果链表。
        while(listNode != null){
            listNode = listNode.next;
            p.next = result;
            result = p;
            p = listNode;
        }
        return result;
    }

}
