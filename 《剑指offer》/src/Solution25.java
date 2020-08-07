import jdk.management.resource.internal.ResourceNatives;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 题目：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution25 {
    /**
     * 大佬的算法：
     * 1、首先复制所有的节点，把复制出来的节点放在已有节点的后面。
     * 2、然后让复制出来的random节点指向前面节点的random节点的后面那个节点。
     * 3、把先前的节点和复制的节点分开。
     */
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        RandomListNode list = pHead;
        while(list != null){
            RandomListNode node = new RandomListNode(list.label);
            node.next = list.next;
            list.next = node;
            list = node.next;
        }
        list = pHead;
        while(list != null){
            if(list.random == null){
                list.next.random = null;
            }
            else {
                list.next.random = list.random.next;
            }
            list = list.next.next;
        }
        //奇偶位分离，分离的时候要注意，把head变回原来的节点。
        //这个步骤非常麻烦，需要仔细推敲。
        list = pHead;
        RandomListNode list3 = pHead;
        RandomListNode res = list.next;
        RandomListNode list2 = res;
        list = list.next.next;
        while(list != null){
            list2.next = list.next;
            list2 = list2.next;
            list3.next = list;
            list3 = list3.next;
            list = list.next.next;
        }
        list3.next = null;
        return res;
    }

    //别人的拆分
    public RandomListNode Clone2(RandomListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        RandomListNode list = pHead;
        while(list != null){
            RandomListNode node = new RandomListNode(list.label);
            node.next = list.next;
            list.next = node;
            list = node.next;
        }
        list = pHead;
        while(list != null){
            if(list.random == null){
                list.next.random = null;
            }
            else {
                list.next.random = list.random.next;
            }
            list = list.next.next;
        }
        //奇偶位分离，分离的时候要注意，把head变回原来的节点。
        //实现俩个链表分离的方法，很关键。
        RandomListNode res = pHead.next;
        RandomListNode tmp = null;
        list = pHead;
        while(list.next!=null){
            tmp = list.next;
            list.next = tmp.next;
            list = tmp;
        }
        return res;
    }



    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        RandomListNode r = new RandomListNode(2);
        head.next = r;
        head.random = r;
        RandomListNode k = new RandomListNode(3);
        head.next.next = k;
        head.next.random = r;
        RandomListNode a = head;
        while(a!=null){
            System.out.println(a.label);
            a = a.next;
        }


        RandomListNode d = new Solution25().Clone(head);
        while(head!=null){
            System.out.println(head.label);
            head = head.next;
        }
    }
}
