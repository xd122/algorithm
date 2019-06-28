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
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        // 反转链表 只需要额外一个之前的节点和当前节点
        ListNode pre = null;
        ListNode now = head;
        while (now != null) {
            ListNode nextTmp = now.next;
            now.next = pre;
            pre = now;
            now = nextTmp;
        }
        return pre;
    }
}
