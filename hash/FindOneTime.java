import java.util.HashMap;
import java.util.Map;

/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : xiangdong
 * Time : 2019-06-22
 * Package : PACKAGE_NAME
 * ProjectName: algorithm
 * Describe :
 * ========================================================================================
 */

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class FindOneTime {
    public int singleNumber(int[] nums) {
        if (nums.length < 0 || null == nums) {
            return -1;
        }
        Map<Integer, Integer> result = new HashMap<>(nums.length + 1);
        for (int i = 0; i < nums.length; i++) {
            if (result.containsKey(nums[i])) {
                result.put(nums[i], 2);
            } else {
                result.put(nums[i], 1);
            }
        }
        int value = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> element : result.entrySet()) {
            if (element.getValue() == 1) {
                value = element.getKey();
                break;
            }
        }
        return value;
    }

    /**
     * 采用异或的方式 相同为0 不同为1
     *
     * @param nums 输入
     * @return
     */
    public int singleNumberSecond(int[] nums) {
        if (nums.length < 0 || null == nums) {
            return Integer.MIN_VALUE;
        }
        int value = 0;
        for (int i = 0; i < nums.length; i++) {
            value ^= nums[i];
        }
        return value;
    }

    public static void main(String[] args) {
    }
}
