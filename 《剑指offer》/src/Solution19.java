import java.util.ArrayList;

/**
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Solution19 {
    /**
     * 我的方法：递归打印。递归出口，
     * 好像我的方法比他的更加快一点，但是需要递归。
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();//结果集合
        //递归出口，如果长宽有一个是1，那么直接把一行或者一列加进去。直接return
        if(matrix.length == 1||matrix[0].length == 1){
            if(matrix.length == 1){
                for(int i=0;i<matrix[0].length;i++){
                    result.add(matrix[0][i]);
                }
            }
            else{
                for(int i=0;i<matrix.length;i++){
                    result.add(matrix[i][0]);
                }
            }
            return result;
        }
        //如果不是1，就打印外面的一圈。
        for(int i = 0;i<matrix[0].length;i++){
            result.add(matrix[0][i]);
        }
        for(int i = 1;i<matrix.length;i++){
            result.add(matrix[i][matrix[0].length-1]);
        }
        for(int i = matrix[0].length-2;i>=0;i--){
            result.add(matrix[matrix.length-1][i]);
        }
        for(int i = matrix.length-2;i>0;i--){
            result.add(matrix[i][0]);
        }
        //如果长宽有一个是2，那么一轮就可以打印完，直接return。
        if(matrix.length==2||matrix[0].length==2){
            return result;
        }
        //建立新的数组，把外围的一圈去掉，然后递归加入。
        int[][] a = new int[matrix.length-2][matrix[0].length-2];
        for(int i = 0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                a[i][j] = matrix[i+1][j+1];
            }
        }
        result.addAll(printMatrix(a));
        return result;
    }

    /**
     * 非递归的方法：首先计算打印的圈数。然后根据圈数进行遍历打印。
     */
    public ArrayList<Integer> printMatrix2(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int row = matrix.length;     //行数
        int collor = matrix[0].length;//列数
        //计算打印的圈数。打印的圈数就是比较小的那一个除以2，如果可以整除，就是这个结果。如果不可以整除就结果加1。
        int circle = ((row<collor?row:collor)-1)/2+1;//圈数
        for(int i=0;i<circle;i++){
            //从左向右打印
            for(int j=i;j<collor-i;j++)
                res.add(matrix[i][j]);
            //从上往下的每一列数据
            for(int k=i+1;k<row-i;k++)
                res.add(matrix[k][collor-1-i]);
            //判断是否会重复打印(从右向左的每行数据)
            for(int m=collor-i-2;(m>=i)&&(row-i-1!=i);m--)
                res.add(matrix[row-i-1][m]);
            //判断是否会重复打印(从下往上的每一列数据)
            for(int n=row-i-2;(n>i)&&(collor-i-1!=i);n--)
                res.add(matrix[n][i]);}
        return res;
    }

}
