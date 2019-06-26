package list;

/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : xiangdong
 * Time : 2019-06-26
 * Package : list
 * ProjectName: algorithm
 * Describe : 合并K个有序链表
 * ========================================================================================
 */

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKList {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length <= 0) {
            return null;
        }
        return devideList(lists, 0, lists.length - 1);
    }

    public ListNode devideList(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = start + ((end - start) >> 1);
        ListNode left = devideList(lists, start, mid);
        ListNode right = devideList(lists, mid + 1, end);
        return merge(left, right);
    }
    public ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (left.val < right.val) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(right.next, left);
            return right;
        }
    }

    public ListNode mergeKList(ListNode[] lists) {
        int loopNum = getLengthStep(lists);
        ListNode head = lists[getMinIndex(lists)];

        for (int i = 1; i <= loopNum; i++) {
            int minHeadIndex = getMinIndex(lists);
            head.next = lists[minHeadIndex];
            lists[minHeadIndex] = lists[minHeadIndex].next;
        }
        return head;
    }

    public int getMinIndex(ListNode[] lists) {
        int index = 0;
        int min = lists[0].val;
        for (int i = 1; i < lists.length; i++) {
            if (min > lists[i].val) {
                min = lists[i].val;
                index = i;
            }
        }
        return index;
    }

    public int getLengthStep(ListNode[] lists) {
        int lengthTotal = 0;
        if (lists == null) {
            return lengthTotal;
        }
        for (ListNode node : lists) {
            ListNode head = node;
            while (head != null) {
                lengthTotal += 1;
                head = head.next;
            }
        }
        return lengthTotal;
    }
}
