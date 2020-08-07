package List;

class LNode<E>{
    private E data = null;

    public LNode next;

    LNode(){}

    public LNode(E data){
        this.data = data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }
}
//单链表的实现
public class LinkList<E> {
    private LNode<E> head = new LNode<>();

    private LNode<E> r = head;

    private int length = 0;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public LinkList(){

    }
    //将一个数组加入链表
    public void addAll(E[] list){
        for(int i=0;i<list.length;i++){
            this.r.next = new LNode<>(list[i]);
            this.r = this.r.next;
            this.length++;
        }
    }

    //加入一个字段
    public void add(E a){
        r.next = new LNode(a);
        r = r.next;
        this.length++;
    }
    public E get(){
        return r.getData();
    }


    public static void main(String[] args) {
        LinkList<Integer> list = new LinkList<>();

        list.add(1);
        System.out.println(list.get());
        list.addAll(new Integer[]{2,3,4,2});
        System.out.println(list.get());
        System.out.println(list.getLength());

    }
}
