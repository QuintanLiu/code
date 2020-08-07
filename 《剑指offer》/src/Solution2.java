public class Solution2 {
    /**
     * 题目：请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * @param str
     * @return
     */

    //我的方法时间复杂度O(n),但是调用了大量内部方法。使用了额外空间
    public String replaceSpace(StringBuffer str) {
        String s = str.toString();

        char[] s_list = s.toCharArray();

        StringBuffer result = new StringBuffer("");

        //遍历字符数组
        for(int i = 0;i<s_list.length;i++){
            //如果是空格就进行替换
            if(s_list[i] == ' '){
                result.append("%20");
            }
            else{
                result.append(s_list[i]);
            }
        }

        return result.toString();
    }
    //在c++里面字符串就是一个字符数组可以使用数组的方式进行操作。


}

