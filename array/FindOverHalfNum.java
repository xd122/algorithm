package array;

/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : xiangdong
 * Time : 2019-07-03
 * Package : array
 * ProjectName: algorithm
 * Describe :
 * ========================================================================================
 */
/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class FindOverHalfNum {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length < 1) {
            return Integer.MIN_VALUE;
        }
        int loops = 1;
        // 当前的候选者
        int canidate = nums[0];
        int len = nums.length;
        for (int index = 1;index < len;index++) {
            if (loops == 0) {
                canidate = nums[index];
                loops = 1;
            } else if (canidate == nums[index]) {
                loops++;
            } else {
                loops--;
            }
        }
        int count = 0;
        for (int index = 0;index < len;index++) {
            if (canidate == nums[index]) {
                count++;
            }
        }
        if (count > (len/2)) {
            return canidate;
        } else {
            return Integer.MIN_VALUE;
        }
    }
}
