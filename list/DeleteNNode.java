package list;

/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : xiangdong
 * Time : 2019-07-04
 * Package : list
 * ProjectName: algorithm
 * Describe :
 * ========================================================================================
 */

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class DeleteNNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n<=0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while((n--)>0) {
            fast = fast.next;
        }
        // 遍历超了，需要删除头结点
        if (fast == null) {
            head = head.next;
            return head;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return head;
    }
}
