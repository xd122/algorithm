package array;

/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : xiangdong
 * Time : 2019-07-04
 * Package : array
 * ProjectName: algorithm
 * Describe :
 * ========================================================================================
 */

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class FindMidNumFromTwoOrderArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            return getKMid(nums1, 0, nums2, 0, len / 2 + 1);
        }
        return (getKMid(nums1, 0, nums2, 0, len / 2)
                + getKMid(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
    }

    public int getKMid(int[] nums1, int start1, int[] nums2, int start2, int k) {
        // 当数组1遍历完成之后 中位数应该出现在2中(数组2的长度更长)
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        // 同上
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int nums1A = start1 + k / 2 - 1 < nums1.length ? nums1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
        int nums2B = start2 + k / 2 - 1 < nums2.length ? nums2[start2 + k / 2 - 1] : Integer.MAX_VALUE;
        // 当1中的中值要是小于B的中值，说明1中的前半部分可以舍弃，反之亦然
        if (nums1A < nums2B) {
            return getKMid(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            return getKMid(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }
}
