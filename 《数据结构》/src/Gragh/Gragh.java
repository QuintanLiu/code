package Gragh;

import java.util.ArrayList;

/**
 * 用邻接矩阵法定义图。
 */

public class Gragh {
    private int vexnum;  //顶点数
    private int arcnum;  //边的个数；
    private int[][] edge;  //邻接矩阵，边表；
    private int[] vex;   //顶点表
    //初始化图的邻接矩阵。
    //图必须从0这个节点开始进行计算。所以这只al这个集合的时候一定需要注意。
    //无向图
    public Gragh(int vexnum, int arcnum, ArrayList<String> al){
        this.arcnum = arcnum;
        this.vexnum = vexnum;
        this.edge = new int[vexnum][vexnum];
        this.vex = new int[vexnum];
        for (int i = 0;i<vexnum;i++){
            vex[i] = i;
        }
        for(int i = 0;i < al.size();i++){
            String s = al.get(i);
            String[] strings = s.split(" ");
            edge[Integer.valueOf(strings[0])-1][Integer.valueOf(strings[1])-1] = Integer.valueOf(strings[2]);
            edge[Integer.valueOf(strings[1])-1][Integer.valueOf(strings[0])-1] = Integer.valueOf(strings[2]);
        }
    }

    public int getVexnum() {
        return vexnum;
    }

    public int getArcnum() {
        return arcnum;
    }

    public int[] getVex() {
        return vex;
    }

    public int[][] getEdge() {
        return edge;
    }


    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("1 2 1");
        al.add("1 4 1");
        al.add("3 2 1");
        al.add("3 4 1");
        al.add("3 5 1");
        al.add("2 5 1");
        Gragh gragh = new Gragh(5,5,al);
        int[][] a = gragh.getEdge();
        for(int i = 0;i < a.length;i++){
            for (int j = 0;j<a[i].length;j++){
                System.out.print(a[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        ArrayList<Integer> res = new GraghSearch().BFSTraverse(gragh);
        for(int v:res){
            System.out.println(v);
        }
    }

}
