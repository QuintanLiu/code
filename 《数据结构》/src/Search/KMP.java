package Search;

/**
 * 这个类维护了字符串模式匹配的一些方法
 * 1、简单的模式匹配算法
 * 2、KMP算法
 */

public class KMP {
    /**
     * 1、简单字符串匹配方法
     * 时间复杂度O(n*m)
     */
    public int indexOf(String s,String t){
        char[] chars = s.toCharArray();//获取他们的字符数组。
        char[] chart = t.toCharArray();
        //遍历整个s
        for(int i=0;i<chars.length-chart.length+1;i++){
            int j = 0;
            for(;j<chart.length;j++){
                if(chars[i+j] != chart[j]){
                    break;
                }
            }
            if(j == chart.length){
                return i;
            }
        }
        return -1;
    }

    /**
     * 2、KMP算法：
     * 时间复杂度O(n+m)
     */
    public int KMP(String s,String t){
        int[] next = getNext(t);       //获取next数组
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        int i,j = 0;
        for (i=0;i<charS.length;){
            //如果遍历到最后一个也成立直接退出。
            if(j == charT.length){
                return i-j;
            }
            //如果相等i和j都加一
            if(charS[i] == charT[j]){
                i++;
                j++;
            }
            else{
                j = next[j]; //
                if(j == -1){ //j=-1表示已经匹配到头了，但是还是都不相等。如果都不相等，直接重新匹配。
                    i++;
                    j++;
                }
            }
        }
        if(j == charT.length){
            return i-j;
        }
        return -1;
    }

    /**
     * 获取next数组的步骤：
     * 1、next[0] = 0和next[1] = 1
     * 2、得到k = next[i-1],就是说k是前面一个字符的next值
     * 3、如果第k个字符与前面一个字符相等的话，直接当前值是k+1;如果不相等的话，k = next[k],从第三步再开始。
     */
    //获取next数组
    public int[] getNext(String t){
        //初始化部分
        char[] charT = t.toCharArray();
        int[] next = new int[t.length()];
        if (next.length ==0) {
            return next;
        }
        else if (next.length == 1){
            next[0] = -1;
            return next;
        }
        next[0] = -1;
        next[1] = 0;
        int k = 0;
        //next数组构建部分。
        boolean isTrue = false;
        for(int i = 2;i<next.length;){
            if(!isTrue){
                k = next[i-1];
            }
            if(charT[i-1]==charT[k]){
                next[i] = k+1;
                i++;
                isTrue = false;
            }
            else{
                k = next[k];
                if(k == -1){
                    next[i] = 0;
                    i++;
                    isTrue = false;
                }
                else{
                    isTrue = true;
                }
            }
        }

        return next;
    }

    public static void main(String[] args) {
        String s = "12m3m4";
        int[] a = new KMP().getNext("abaabc");
        for (int i:a){
            System.out.println(i);
        }
        int b = new KMP().KMP("aabaabaabaac","aabaac");
        System.out.println(b);

    }
}
