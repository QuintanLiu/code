import java.util.ArrayList;
import java.util.HashSet;

public class Solution27 {
    /**
     * 第一次的解法（错误），我觉得用的方法并不好，这个方法，会导致排序错误。结果集还是正确的，
     * 但是排序是不正确的。
     */
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList();
        char[] resList;
        resList = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        if(resList.length == 0){
            return res;
        }
        else if(resList.length == 1){
            sb.append(resList[0]);
            res.add(sb.toString());
        }
        else if(resList.length == 2){
            sb.append(resList[0]);
            sb.append(resList[1]);
            res.add(sb.toString());
            sb = new StringBuffer();
            sb.append(resList[1]);
            sb.append(resList[0]);
            res.add(sb.toString());
        }else {
            for(int i = 0;i<resList.length;i++){
                StringBuffer sb2 = new StringBuffer();
                sb = new StringBuffer();
                sb.append(resList[i]);
                for(int j = 0;j<resList.length;j++){
                    if(j != i){
                        sb2.append(resList[j]);
                    }
                }
                ArrayList<String> res2 = Permutation(sb2.toString());
                for (int j = 0;j < res2.size();j++){
                    sb.append(res2.get(j));
                    res.add(sb.toString());
                    sb = new StringBuffer();
                    sb.append(resList[i]);
                }
            }
        }
        HashSet<String> set = new HashSet<>();
        for(int i = 0;i<res.size();i++){
            set.add(res.get(i));
        }
        res = new ArrayList<>();
        for(String s:set){
            res.add(s);
        }
        return res;
    }

    /**
     *
     */

    public static ArrayList<String> Permutation2(String str){
        char[] resList = str.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        for(int i = 0;i<resList.length;i++){
            if(i == 0){

            }
            else{

            }

        }
        return res;
    }




    public static void swap(char[] list,int i,int j){
        char t = list[i];
        list[i] = list[j];
        list[j] = t;
    }



    public static void main(String[] args) {
        ArrayList<String> res = Permutation("abc");
        for(int i = 0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
}
