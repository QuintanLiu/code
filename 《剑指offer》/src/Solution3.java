import java.util.ArrayList;
import java.util.Collections;

class ListNode {
         int val;
         ListNode next = null;

         ListNode(int val) {
             this.val = val;
         }
}

//题目：输入一个链表，按链表从尾到头的顺序返回一个ArrayList。

public class Solution3 {


    //我的方法，使用额外的可变长数组来作为返回值，如果不考虑数组反转的时间复杂度的话，我的时间复杂度是O(n)
    //有一个问题头插法插数组的效率太低了。不如直接输出一个逆序的数组，再将数组逆序的话时间复杂度为O(n)
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();//创建结果数组

        //遍历链表
        while(listNode != null){
            result.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(result);
        return result;
    }

    public int[] printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();//创建结果数组

        //遍历链表
        while(listNode != null){
            result.add(listNode.val);
            listNode = listNode.next;
        }
        int[] res = new int[result.size()];
        for(int i = 0;i < result.size();i++){
            res[i] = result.get(result.size()-i-1);
        }

        return res;
    }

}
