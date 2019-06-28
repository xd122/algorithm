package backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : xiangdong
 * Time : 2019-06-28
 * Package : backtrace
 * ProjectName: algorithm
 * Describe :
 * ========================================================================================
 */

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。
 * 返回所有可能得到的字符串集合。
 *
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 *
 * 输入: S = "12345"
 * 输出: ["12345"]
 *
 */
public class AlphFullSort {
    List<String> result = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        dfs(new StringBuilder(S), 0);
        return result;
    }

    public void dfs(StringBuilder s, int cur) {
        if (s.length() == cur) {
            result.add(s.toString());
            return;
        }
        if (Character.isDigit(s.charAt(cur))) {
            dfs(s, cur + 1);
        } else {
            char ch = s.charAt(cur);
            // 以当前是小写字符开始的序列
            s.setCharAt(cur, Character.toLowerCase(ch));
            dfs(s, cur + 1);
            // 以当前是大写字符开始的序列
            s.setCharAt(cur, Character.toUpperCase(ch));
            dfs(s, cur + 1);
        }
    }
}
