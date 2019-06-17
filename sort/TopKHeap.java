import java.util.Arrays;

/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : xiangdong
 * Time : 2019-06-17
 * Package : PACKAGE_NAME
 * ProjectName: algorithm
 * Describe :
 * ========================================================================================
 */
public class TopKHeap {
    public int findKthLargest(int[] nums, int k) {
        if (k > nums.length || k <= 0) {
            return Integer.MIN_VALUE;
        }
        int first = (k - 1) >> 1;
        // 建立k个节点的小根堆
        for (int point = first; point >= 0; point--) {
            adjustHead(nums, point, k - 1);
        }
        // 堆的插入调整
        for (int point = k; point < nums.length; point++) {
            if (nums[0] < nums[point]) {
                swap(nums, 0, point);
                adjustHead(nums, 0, k - 1);
            }
        }
        return nums[0];
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

    public static void main(String[] args) {
        TopKHeap topKHeap = new TopKHeap();
        System.out.println(topKHeap.findKthLargest(new int[]{-1, -2, -3, 4, 5, 6, 2, 8, 7}, 7));
    }
}
