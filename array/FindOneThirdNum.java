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

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <p>
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: [3]
 * 示例 2:
 * <p>
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 */
public class FindOneThirdNum {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return resultList;
        }
        // 根据问题描述：分解成 最多的候选人是2个,注意此时候选人不可从nums[0]开始，需要指定默认数值；
        int loopFirst = 0;
        int loopSecond = 0;
        int canidateA = 0;
        int canidateB = 0;
        int len = nums.length;
        // 如果当前时刻某个候选人轮询结束 需要新的元素是不是另一个候选人，要不是就把它当作当前的候选人
        for (int index = 0; index < len; index++) {
            if (loopFirst == 0 && canidateB != nums[index]) {
                canidateA = nums[index];
                loopFirst = 1;
            } else if (loopSecond == 0 && canidateA != nums[index]) {
                canidateB = nums[index];
                loopSecond = 1;
            } else if (canidateA == nums[index]) {
                loopFirst++;
            } else if (canidateB == nums[index]) {
                loopSecond++;
            } else {
                loopFirst--;
                loopSecond--;
            }
        }
        // 计数操作
        int count1 = 0;
        int count2 = 0;
        for (int index = 0; index < len; index++) {
            if (canidateA == nums[index]) {
                count1++;
            }
            if (canidateB == nums[index]) {
                count2++;
            }
        }
        // 注意数组中全是一样的数值
        if ((count1 * 3 > len) && (count2 * 3 > len) && (canidateA == canidateB)) {
            resultList.add(canidateA);
            return resultList;
        }
        if (count1 * 3 > len && canidateA != canidateB) {
            resultList.add(canidateA);
        }
        if (count2 * 3 > len && canidateB != canidateA) {
            resultList.add(canidateB);
        }
        return resultList;
    }
}
