package solutions.grind75.week1;

import solutions.util.ListNode;

public class MergeTwoSortedLists {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode sol = head;

        while (list1 != null && list2 != null) {
            int val1 = list1.val;
            int val2 = list2.val;

            if (val1 < val2) {
                sol.next = list1;
                sol = sol.next;
                list1 = list1.next;
            } else {
                sol.next = list2;
                sol = sol.next;
                list2 = list2.next;                
            }
        }

        if (list1 != null) {
            sol.next = list1;
        } else {
            sol.next = list2;
        }

        return head.next;
    }
}
