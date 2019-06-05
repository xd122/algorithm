/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : xiangdong
 * Time : 2019-06-05
 * Package : PACKAGE_NAME
 * ProjectName: algorithm
 * Describe :
 * ========================================================================================
 */

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class IntersectList {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lenA = getLength(headA);
            int lenB = getLength(headB);
            if (lenA == 0 || lenB == 0) {
                return null;
            }
            if (lenA > lenB) {
                int step = lenA - lenB;
                while (step > 0) {
                    step--;
                    headA = headA.next;
                }
                while (headA != null && headB != null && headA != headB) {
                    headA = headA.next;
                    headB = headB.next;
                }
                return headA;
            } else if (lenA == lenB) {
                while (headA != null && headB != null && headA != headB) {
                    headA = headA.next;
                    headB = headB.next;
                }
                return headA;
            } else {
                int step = lenB - lenA;
                while (step > 0) {
                    step--;
                    headB = headB.next;
                }
                while (headA != null && headB != null && headA != headB) {
                    headA = headA.next;
                    headB = headB.next;
                }
                return headB;
            }
        }

        public int getLength(ListNode head) {
            int length = 0;
            if (head == null) {
                return length;
            }
            while (head != null) {
                length++;
                head = head.next;
            }
            return length;
        }
    }
}

