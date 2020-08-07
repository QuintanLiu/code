package List;

import java.util.List;
//单向循环链表的实现
public class LinkListH<E> {

    private LNode head;
    private LNode r;
    private int length = 0;
    public LinkListH(){

    }

    public void add(E data){
        LNode<E> p = new LNode<>(data);
        if(this.head == null){
            this.head = p;
            this.r = this.head;
            this.r.next = this.head;
            this.length++;
        }
        else{
            this.r.next = p;
            p.next = this.head;
            this.r = this.r.next;
            this.length++;
        }

    }

    public void printAll(){
        LNode<E> p = this.head;
        for(int i=0;i<this.length;i++){
            System.out.println(p.getData());
            p=p.next;
        }

    }

    public static void main(String[] args) {
        LinkListH<Integer> l = new LinkListH<Integer>();
        l.add(1);

        l.printAll();
    }


}
