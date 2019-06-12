import java.util.Arrays;

/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : xiangdong
 * Time : 2019-06-12
 * Package : PACKAGE_NAME
 * ProjectName: algorithm
 * Describe : 在一个升序数组中，求出2个数之和等于目标值的下标位置
 * ========================================================================================
 */
public class TwoNumSum {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length <= 0 || numbers[0] > target) {
            return null;
        }
        // 减少遍历的次数
        int last = getLastLowTargetIndex(numbers, target, 0, numbers.length - 1);
        int first = 0;
        // 双指针扫描，快排的思想
        while (first != last) {
            int com = numbers[first] + numbers[last];
            if (com < target) {
                first++;
            } else if (com > target) {
                last--;
            } else {
                break;
            }
        }
        return new int[]{first + 1, last + 1};
    }

    /**
     * 找到第一个大于目标值的位置
     *
     * @param numbers 输入数组
     * @param target  目标值
     * @param start   开始下标
     * @param end     结束下标
     * @return
     */
    public int getLastLowTargetIndex(int[] numbers, int target, int start, int end) {
        if (numbers[numbers.length - 1] < target) {
            return numbers.length - 1;
        }
        int mid = start + (end - start) / 2;
        if (numbers[mid] > target) {
            if (numbers[mid - 1] <= target) {
                return mid;
            }
            end = mid - 1;
        } else if (numbers[mid] < target) {
            start = mid + 1;
        } else {
            return mid + 1;
        }
        return getLastLowTargetIndex(numbers, target, start, end);
    }

    public static void main(String[] args) {
//        int[] arr = {2, 7, 8, 9, 10, 11, 15};
        int[] arr = {-1, 1, 3, 40};
        int target = 0;
        TwoNumSum twoNumSum = new TwoNumSum();
        int index = twoNumSum.getLastLowTargetIndex(arr, target, 0, 3);
        System.out.println(index);
        int[] result = twoNumSum.twoSum(arr, target);
        System.out.println(Arrays.toString(result));
    }
}
