package solutions.grind75.week1;

import java.lang.classfile.components.ClassPrinter.ListNode;
import java.util.ArrayList;
import java.util.List;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        List<ListNode> visited = new ArrayList<>();
        
        return hasCycle(head, visited);
    }

    public boolean hasCycle(ListNode head, List<ListNode> visited) {
        if (head == null) {
            return false;
        }
        
        if (visited.contains(head)) {
            return true;
        }

        visited.add(head);
        head = head.next;

        return hasCycle(head, visited);
    }
}
