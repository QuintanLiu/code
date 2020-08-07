/**
 *题目：输入一个链表，输出该链表中倒数第k个结点。
 */

public class Solution14 {
    /**
     * 我的方法:使用快慢指针的方式来解决这个问题。index计数，如果为k，慢指针开始走。如果遍历到底的话，输出结果就好了。
     * 如果使用快慢指针的方式进行遍历的话，第一件需要确定的事情就是快慢指针之间的间隔是多少。
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode listNode = head;//保证head不变
        ListNode result = null;  //结果数据，慢指针。
        int index = 1;//用于记录快指针到哪儿了。
        while (listNode != null){
            if(index == k){
                result = head;
            }
            else if(index > k && k!=0){
                result=result.next;
            }
            index++;
            listNode = listNode.next;
        }
        return result;
    }
}
