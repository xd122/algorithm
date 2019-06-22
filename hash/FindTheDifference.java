package hash;

/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : xiangdong
 * Time : 2019-06-22
 * Package : hash
 * ProjectName: algorithm
 * Describe : 找出2个字符串不同之处
 * ========================================================================================
 */

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：
 * s = "abcd"
 * t = "abcde"
 * <p>
 * 输出：
 * e
 * <p>
 * 解释：
 * 'e' 是那个被添加的字母。
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] nums = new int[26];
        for (int i = 0; i < t.length(); i++) {
            nums[t.charAt(i) - 'a'] += 1;
        }
        char result = Character.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a'] -= 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                result = (char) ('a' + i);
                break;
            }
        }
        return result;
    }
}
