public class Solution1 {

    /**
     * 题目：在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     *请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * @param int target
     * @param int[][] array
     * @return boolean
     */


    //我自己的代码,时间复杂度是O(nm)
    public boolean Find(int target, int [][] array) {
        //如果数组为空的话，直接输出false
        if(array.length == 0||array[0].length == 0){
            return false;
        }
        //将数组按行扫描
        for(int i = 0;i<array.length;i++){
            //如果这一行目标的值在这一行最大和最小之间，遍历这一行。
            if(array[i][0]<=target&&array[i][array[0].length-1]>=target){
                for(int j = 0;j<array[0].length;j++){
                    if(target == array[i][j]){
                        return true;
                    }
                }
            }
        }
        //没找到返回false
        return false;
    }

    //最高赞的代码，时间复杂度为O(n+m)

    public boolean Find2(int target, int[][] array){
        //同上
        if(array.length == 0||array[0].length == 0){
            return false;
        }
        //从右上角或者左下角进行遍历
        //为什么不选择左上角或者右下角，因为无论哪个方向都是比他大或者比他小的节点，不好遍历（遍历起来比较麻烦）。
        int i = 0;
        int j = array[0].length-1;
        //循环推出条件就是
        while(j>=0&&i<array.length){
            if(array[i][j]==target) return true;
            //如果目标值大于此时的值就下移，如果小于就左移，（选择合适的开始节点很重要）
            if(array[i][j]>target){
                j--;
            }
            else{
                i++;
            }
        }
        return false;
    }

    //还有一种方法对每一行使用二分查找来实现这种时间复杂度为O(nlogn)

}
