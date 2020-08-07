package Gragh;

import java.util.ArrayList;

/**
 * 这个类里面有着图的遍历的一些算法。
 */

public class GraghSearch {
    /**
     * BFS：广度优先遍历算法。
     * 利用队列进行遍历。
     */

    public ArrayList<Integer> BFSTraverse(Gragh gragh){
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> queue = new ArrayList<>();
        int[][] a = gragh.getEdge();
        boolean[] visited = new boolean[a.length];
        for(int i = 0;i<a.length;i++){
            visited[i] = false;
        }
        //使用队列遍历各个节点。
        for(int i=0;i<a.length;i++){
            //首先判断这个节点是否再队列里面，如果不在就加入队列。
            if(!visited[i]){
                queue.add(i);
                visited[i] = true;
            }
            //如果队列不空，对出队，并且把节点加入结果集。
            if(!queue.isEmpty()){
                int v = queue.remove(0);
                res.add(v+1);
                for(int j = 0;j<a.length;j++){
                    if(a[v][j] == 1){
                        if(!visited[j]){
                            queue.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        return res;
    }

    /**
     * 深度优先遍历算法
     */
    public ArrayList<Integer> DFS(Gragh gragh){
        ArrayList<Integer> res = new ArrayList<>();
        int[][] a = gragh.getEdge();
        boolean[] visited = new boolean[a.length];
        for(int i = 0;i<a.length;i++){
            visited[i] = false;
        }
        return res;
    }

}
