package List;

//节点的操作
class DNode<E>{
    private E data;
    public DNode next,prior;


    DNode(){}
    public DNode(E data){
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}

//双向链表的实现
public class DLinkList<E> {
    private DNode head = new DNode();
    private DNode r = head;
    private int length = 0;

    //这是加入数据的操作
    public void add(E data){
        DNode<E> insert = new DNode<>(data);
        this.r.next = insert;
        insert.prior = this.r;
        this.r = this.r.next;
        this.length++;
    }

    //插入操作
    public void insert(int i,E data){
        DNode<E> p = new DNode<>(data);
        if(i>this.length+1||i<=0){
            System.out.println("Error");
        }
        else{
            DNode<E> s = this.head;

            for(int j=0;j<i-1;j++){
                s = s.next;
            }
            if(s.next == null){
                s.next = p;
                p.prior = s;
                this.length++;
            }
            else{
                s.next.prior = p;
                p.next = s.next;
                s.next = p;
                p.prior = s;
                this.length++;
            }

        }
    }
    //打印所有的数据
    public void printAll(){
        DNode<E> p =  this.head;
        while(p.next != null){
            System.out.println(p.next.getData());
            p = p.next;
        }
    }

    public int getLength(){
        return this.length;
    }


    public static void main(String[] args) {
        DLinkList<Integer> p =new DLinkList<>();
        for(int i = 0;i<10;i++){
            p.add(i);
        }
        p.insert(11,12);



        System.out.println(p.getLength());
        p.printAll();

    }
}
