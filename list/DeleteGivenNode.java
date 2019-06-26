package list;

/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : xiangdong
 * Time : 2019-06-26
 * Package : list
 * ProjectName: algorithm
 * Describe :
 * ========================================================================================
 */

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */

class ListNode {
    int val;
    ListNode next;
}

public class DeleteGivenNode {
    public ListNode removeElements(ListNode head, int val) {
        // 边界条件 一开始链表都是需要删除的节点
        while (head != null) {
            if (head.val == val) {
                head = head.next;
            } else {
                break;
            }
        }
        if (head == null) {
            return head;
        }

        // 防止空指针
        ListNode pre = head;
        ListNode cur = head;

        // 模拟前后指针
        while (cur != null) {
            if (cur.val != val) {
                pre = cur;
                cur = cur.next;
            } else {
                if (pre.next != null) {
                    pre.next = cur.next;
                    cur = pre;
                } else {
                    break;
                }
            }
        }
        return head;
    }
}
