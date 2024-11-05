package solutions.grind75.week2;

import solutions.util.ListNode;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        temp = head;
        size = size / 2;
        int count = 0;
        while (count < size) {
            temp = temp.next;
            count++;
        }

        return temp;
    }
}
