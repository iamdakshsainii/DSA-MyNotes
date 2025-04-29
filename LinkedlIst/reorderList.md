## Problem: Reorder List
Given the head of a singly linked list, reorder it to follow the pattern:
L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

```java
Input: head = [1,2,3,4]
Output: [1,4,2,3]
```

**Approach:**
To achieve this, we can break down the process into the following steps:

**Find the middle of the list:**

Use the "tortoise and hare" technique, where a slow pointer (slow) moves one step at a time, and a fast pointer (fast) moves two steps at a time. When the fast pointer reaches the end, the slow pointer will be at the middle of the list.

**Reverse the second half of the list:**

Once the middle node is found, reverse the second half of the list, starting from the node after the middle.

**Merge the two halves:**

Finally, alternate between nodes from the first half and the reversed second half to create the reordered list.


```java
class Solution {
    public ListNode middleList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode future = current.next;
            current.next = prev;
            prev = current;
            current = future;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode middle = middleList(head);
        ListNode second = reverseList(middle.next);
        middle.next = null;
        ListNode first = head;

        while (second != null) {
            ListNode next1 = first.next;
            ListNode next2 = second.next;
            first.next = second;
            second.next = next1;
            first = next1;
            second = next2;
        }
    }
}
```
