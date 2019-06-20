import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : xiangdong
 * Time : 2019-06-20
 * Package : PACKAGE_NAME
 * ProjectName: algorithm
 * Describe : 找寻不重复的第N大数值，注意数据大小越界问题
 * ========================================================================================
 */

/**
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入:[3,2,1]
 * <p>
 * 输出:1
 * <p>
 * 解释:第三大的数是 1.
 * 示例 2:
 * <p>
 * 输入:[1,2]
 * <p>
 * 输出:2
 * <p>
 * 解释:第三大的数不存在,所以返回最大的数 2 .
 * 示例 3:
 * <p>
 * 输入:[2,2,3,1]
 * <p>
 * 输出:1
 * <p>
 * 解释:注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 */
public class TheThirdBigNumber {
    public int thirdMax(int[] nums) {
        if (nums.length == 0 || null == nums) {
            return Integer.MIN_VALUE;
        }
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return nums[0];
            } else {
                return nums[1];
            }
        } else {
            // 注意越界问题
            Set<Integer> set = new TreeSet<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (o2 > o1) {
                        return 1;
                    } else if (o2 < o1) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
            for (int num : nums) {
                set.add(num);
            }
            Object[] values = set.toArray();
            if (values.length <= 2) {
                return (int) values[0];
            }
            return (int) values[2];
        }
    }


    public boolean isAtHeap(int[] nums, int key) {
        for (int num : nums) {
            if (num == nums[key]) {
                return true;
            }
        }
        return false;
    }

    // 调整堆结构
    public void adjustHead(int[] nums, int index, int length) {
        int left = (index << 1) + 1;
        int right = left + 1;
        int min = left;
        if (left > length) {
            return;
        }
        if (right <= length && nums[left] > nums[right]) {
            min = right;
        }
        if (nums[min] < nums[index]) {
            swap(nums, min, index);
            adjustHead(nums, min, length);
        }
    }

    public void swap(int[] nums, int head, int tail) {
        int tmp = nums[head];
        nums[head] = nums[tail];
        nums[tail] = tmp;
    }

    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length || k <= 0) {
            return Integer.MIN_VALUE;
        }
        int first = (k - 1) >> 1;
        // 建立k个节点的小根堆
        for (int point = first; point >= 0; point--) {
            adjustHead(nums, point, k - 1);
            // 创建一个不重复的堆
            if (isAtHeap(nums, point + 1)) {
                continue;
            }
        }
        // 堆的插入调整
        for (int point = k; point < nums.length; point++) {
            if (isAtHeap(nums, point)) {
                continue;
            }
            if (nums[0] < nums[point]) {
                swap(nums, 0, point);
                adjustHead(nums, 0, k - 1);
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println(new TheThirdBigNumber().thirdMax(new int[]{-2, -2, -2147483648}));
        System.out.println(new TheThirdBigNumber().thirdMax(new int[]{2, 3, 1}));
        System.out.println(new TheThirdBigNumber().findKthLargest(new int[]{-1, 2, 1, 1, 1, 1}, 3));
    }
}
