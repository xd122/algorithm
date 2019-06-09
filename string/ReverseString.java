/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : xiangdong
 * Time : 2019-06-09
 * Package : PACKAGE_NAME
 * ProjectName: algorithm
 * Describe : 字符串反转 根据字符串中的空格进行分割
 * ========================================================================================
 */

/**
 * 示例 1：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 * 说明：
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class ReverseString {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String tmp = s.trim();
        if (tmp == null) {
            return null;
        }
        int lastIndex = tmp.lastIndexOf(" ");
        // 初始的字符串中不含有空格
        if (lastIndex == -1) {
            return tmp;
        }
        while (lastIndex != -1) {
            String sTmp = tmp.substring(lastIndex + 1);
            sb.append(sTmp);
            sb.append(" ");
            tmp = tmp.substring(0, lastIndex).trim();
            lastIndex = tmp.lastIndexOf(" ");
            // 最后一次的空格分割
            if (lastIndex == -1) {
                sb.append(tmp);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String s = "  hello    world!  ";
        String s = "h";
        System.out.println(new ReverseString().reverseWords(s));
    }
}
