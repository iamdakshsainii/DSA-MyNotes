### Problem: Swap Nodes in Pairs
**Problem Statement:**
You are given a singly linked list, and you need to swap every two adjacent nodes. The task is to solve this problem by swapping the nodes themselves, not just their values.

**Input:**
A singly linked list, where the nodes are connected via the next pointer.

**Output:**
The head of the modified linked list after swapping every two adjacent nodes.

**Example:**
**Input 1:**
head = [1, 2, 3, 4]
**Output 1:**
[2, 1, 4, 3]

**Explanation:**
- Swap nodes 1 and 2: [2, 1, 3, 4]
- Swap nodes 3 and 4: [2, 1, 4, 3]

```java
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        // Create a dummy node to simplify edge case handling
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode newHead = dummy; // 'newHead' points to the start of the modified list

        // Traverse the list in pairs and swap
        while (head != null && head.next != null) {
            ListNode curr = head;      // current node
            ListNode agla = head.next; // next node (to be swapped)

            // Perform the swap
            newHead.next = agla;
            curr.next = agla.next;
            agla.next = curr;

            // Move 'newHead' and 'head' to the next pair
            newHead = curr;
            head = curr.next;
        }

        // Return the new head (dummy.next points to the new head after the first swap)
        return dummy.next;
    }

    // Helper method to print the list
    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }

        ListNode current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: head = [1, 2, 3, 4]
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode result1 = solution.swapPairs(head1);
        printList(result1); // Output: [2, 1, 4, 3]

        // Example 2: head = []
        ListNode head2 = null;
        ListNode result2 = solution.swapPairs(head2);
        printList(result2); // Output: []

        // Example 3: head = [1]
        ListNode head3 = new ListNode(1);
        ListNode result3 = solution.swapPairs(head3);
        printList(result3); // Output: [1]

        // Example 4: head = [1, 2, 3]
        ListNode head4 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode result4 = solution.swapPairs(head4);
        printList(result4); // Output: [2, 1, 3]
    }
}
```
