package List;


//实现给定长度的顺序表
public class SqList {
    private final int MAXSIZE = 50;         //给定最大长度
    private int[] data = new int[MAXSIZE];  //初始化数组
    private int length;                      //当前的数组长度

    public SqList(){
        this.length = 0;
    }

    //实现对顺序表中的固定位置的插入操作
    public boolean listInsert(int i, int e){
        if(i<1||i>this.length+1){
            return false;
        }                                     //判断i的值是否合法

        if(this.length>=MAXSIZE){
            return false;
        }

        for(int j = this.length;j>=i;j--){
            this.data[j] = this.data[j-1];
        }

        this.data[i-1] = e;
        this.length++;
        return true;
    }


    //每次都加入最后一个数
    public boolean put(int e){
        if(this.length>=MAXSIZE){
            return false;
        }
        this.data[this.length] = e;
        this.length++;
        return true;

    }

    //查找第i个元素
    public int get(int i){

        if(i>=this.length){
            return -1;              //假设全部是正整数的数组，这边感觉其实可以用异常的方式来实现
        }
        return this.data[i];

    }

    //获取长度
    public int getLength(){
        return this.length;
    }



    public static void main(String[] args) {
        SqList sqList = new SqList();

        for(int i=0;i<10;i++){
            sqList.put(i);
        }

        for(int i = 0;i<sqList.length;i++){
            System.out.println(sqList.get(i));

        }

    }


}
