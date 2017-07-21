package cn.echo0.algorithm.string;

/**
 * Author : Ech0
 * Email  : ech0.extreme@foxmail.com
 * Time   : 07/21/2017 10:32 AM
 */
public class Regex {
    public static boolean match(String str, String regex) {
        if (str == null || regex == null) {
            return false;
        }
        return matchCore(str, 0, regex, 0);
    }

    private static boolean matchCore(String str, int strIndex, String regex, int regIndex) {
        if (strIndex >= str.length() && regIndex >= regex.length() ) {
            return true;
        }
        if (strIndex < str.length()  && regIndex >= regex.length() ) {
            return false ;
        }
        if(regIndex+1<regex.length()&&regex.charAt(regIndex+1)=='*'){
            if( (strIndex<str.length()&&str.charAt(strIndex)==regex.charAt(regIndex))
                    ||(regex.charAt(regIndex)=='.'&&str.length()-1!=strIndex)){
                return matchCore(str,strIndex+1,regex,regIndex)
                        ||matchCore(str,strIndex+1,regex,regIndex+2)
                        ||matchCore(str,strIndex,regex,regIndex+2);

            }else { //跳过当前正则 a*
                return matchCore(str,strIndex,regex,regIndex+2);
            }
        }
        else if(str.length()>strIndex&&(str.charAt(strIndex)==regex.charAt(regIndex)||regex.charAt(regIndex)=='*')){
            return matchCore(str,strIndex+1,regex,regIndex+1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(match("aaaabb","a*bbc"));
    }
}
