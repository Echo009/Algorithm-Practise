package cn.echo0.algorithm.dynamic;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 08/03/2017 03:05 PM
 */
public class LongestSubStringWithoutDuplication {
//    请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度
//    假设 字符串中仅包含 a-z
//    f(0) =1 ;
//    f(i)=f(i-1)+1
//    f(i)=d d<=f(f-1)
    static int countLongestSubStringWithoutDuplication(String str ){
        if (str==null||str.length()==0){
            throw  new IllegalArgumentException();
        }
        int [] positions = new int[26];
        for(int i = 0; i < positions.length; i++){
            positions[i]=-1;
        }
        int [] length= new int[str.length()];
        int maxLength = 0 ;
        for (int i = 0 ; i < str.length();i++){
            if(i==0){//init
                length[i]=1;
            }
            else {
                if(positions[str.charAt(i)-'a']==-1|| //没有出现过
                     i- positions[str.charAt(i)-'a'] > length[i-1]  ){// d > f(i-1) 不在当前子串中
                    length[i] = length[i-1]+1;
                }else
                    length[i] = i- positions[str.charAt(i)-'a'] ;
            }
            positions[str.charAt(i)-'a'] = i;//记录最近出现的位置
            if(maxLength<length[i]){
                maxLength=length[i];
            }
        }
        return  maxLength;
    }

    public static void main(String[] args) {
        System.out.println(countLongestSubStringWithoutDuplication("llllabccc"));
    }
}
