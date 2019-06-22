package hash;

/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : xiangdong
 * Time : 2019-06-22
 * Package : hash
 * ProjectName: algorithm
 * Describe : 需找第一个不重复出现的字符，没有返回-1
 * ========================================================================================
 */
public class FindFirstUniqueChar {
    // 利用额外的26个字符转换的数值表示
    public int firstUniqChar(String s) {
        if (s.length() <= 0 || null == s) {
            return -1;
        }
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            nums[c - 'a'] += 1;
        }
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            if (nums[s.charAt(i) - 'a'] == 1) {
                index = i;
                break;
            }
        }
        return index;
    }
}
