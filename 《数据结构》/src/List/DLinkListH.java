package List;


//双向循环链表的实现
public class DLinkListH<E> {
    private int length = 0;
    private DNode<E> head;
    private DNode<E> r;


    public void add(E data){
        DNode<E> p = new DNode<>(data);
        if(this.head == null){
            this.head = p;
            this.r = p;
            this.r.next = this.head;
            this.r.prior = this.head;
            this.length++;
        }
        else{
            this.r.next = p;
            p.prior = this.r;
            p.next = this.head;
            this.head.prior = p;
            this.r = this.r.next;
            this.length++;
        }
    }

    public void printAll(){
        DNode<E> p = this.head;
        for(int i=0;i<this.length;i++){
            System.out.println(p.getData());
            p=p.next;
        }
    }

    public static void main(String[] args) {
        DLinkListH<String> dLinkListH = new DLinkListH<>();
        dLinkListH.add("1");
        dLinkListH.add("2");
        dLinkListH.printAll();
    }
}
