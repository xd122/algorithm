package list;

/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : xiangdong
 * Time : 2019-06-28
 * Package : list
 * ProjectName: algorithm
 * Describe :
 * ========================================================================================
 */
public class HasCycleList {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        // 快慢指针 注意空指针异常
        while (fast != null && fast.next != null && fast.val != slow.val) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == null || fast.next == null) {
            return false;
        } else {
            return true;
        }
    }
}
