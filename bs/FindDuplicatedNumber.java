package bs;

/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : xiangdong
 * Time : 2019-06-25
 * Package : bs
 * ProjectName: algorithm
 * Describe :
 * ========================================================================================
 */

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 */
public class FindDuplicatedNumber {
    public int findDuplicate(int[] nums) {
        if (nums.length <= 0 || null == nums) {
            return Integer.MIN_VALUE;
        }
        int n = nums.length - 1;
        int[] tmp = new int[nums.length];
        int index = 0;
        // 根据题意 数据大小[1-n]并为超过数据size,所有采用"元神归位"的思路
        // 就是将下标对应的数值放在本身自己应该的位置上
        for (int i = 1; i <= n; i++) {
            if (tmp[nums[i]] != nums[i]) {
                tmp[nums[i]] = nums[i];
            } else {
                index = nums[i];
                break;
            }
        }
        if (tmp[nums[0]] == nums[0]) {
            index = nums[0];
        }
        return index;
    }
}
