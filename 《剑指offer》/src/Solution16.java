/**
 * 题目：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Solution16 {
    /**
     * 我得方法：同时遍历两个链表，如果比较遍历到的两个节点的大小，把小的加入结果链表，同时向后遍历。
     * 如果结束，直接把没有遍历完的加入结果链表就好。
     * 时间复杂度O(n+m)
      */
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode result = null;//结果链表
        ListNode p3 = null;
        //当两个链表同时不为空时进入循环。
        while(list1!=null && list2!=null){
            if(list1.val>list2.val){
                if(p3 == null){
                    p3 = list2;
                    result = p3;
                }
                else{
                    p3.next = list2;
                    p3 = p3.next;
                }
                list2 = list2.next;
            }
            else{
                if(p3 == null){
                    p3 = list1;
                    result = p3;
                }
                else{
                    p3.next = list1;
                    p3 = p3.next;
                }
                list1 = list1.next;
            }
        }
        //结束while循环，把还剩下的那个链表接入结果链表。
        if(list1 == null){
            if(p3 == null){
                p3 = list2;
                result = p3;
            }
            else{
                p3.next = list2;
            }

        }
        else {
            if(p3 == null){
                p3 = list1;
                result = p3;
            }
            else{
                p3.next = list1;
            }
        }
        return result;
    }
}
