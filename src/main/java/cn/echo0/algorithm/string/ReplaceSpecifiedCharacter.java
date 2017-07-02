/*
 * Author : Echo0 
 * Email  : ech0.extreme@foxmail.com
 * Time   : Jun 30, 2017 8:47:09 AM
 */
package cn.echo0.algorithm.string;


/**
 *
 * @author Ech0
 */
public class ReplaceSpecifiedCharacter {

    //将字符数组中的空格替换成"%20"
    public static char[] replaceSpecifiedCharacter(char[] string) {
        if(string == null){
            return new char[0];
        }
        int spaceCount = 0;
        int length = string.length;
        for (int i = 0; i < string.length; i++) {//统计空格数量
            if (string[i] == ' ') {
                spaceCount++;
            }
        }
        int endIndexOfNew = length + (spaceCount << 1) - 1;
        System.out.println(endIndexOfNew);
        char[] result = new char[endIndexOfNew + 1];//分配合适的空间
        for (int endIndexOfOld = length-1; endIndexOfOld >= 0; endIndexOfOld--) {
            if (string[endIndexOfOld] !=' ') {
                result[endIndexOfNew--] = string[endIndexOfOld];
            } else {
                result[endIndexOfNew--] = '0';
                result[endIndexOfNew--] = '2';
                result[endIndexOfNew--] = '%';
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "hey, are you happy ?  do you know that ? is great to fall in love with you !  ";
        char[] string =str.toCharArray();
        System.out.println(string);
        System.out.println(replaceSpecifiedCharacter(string));
    }
}
