# Short Notes for Rotating a Linked List

## Problem Understanding:
- Given a linked list and a number `k`, rotate the list to the right by `k` positions.
- If `k` is larger than the length of the list, use `k % length` to reduce unnecessary rotations.

## Key Observations:
- If `k == 0` or `k % length == 0`, no rotation is needed.
- Rotation only affects the position of the head; the list structure remains unchanged.

## Approach Steps:
1. **Find Length of List:**
   - Traverse the list to count the total number of nodes (`n`).

2. **Adjust `k`:**
   - Use `k = k % n` to avoid redundant rotations (e.g., rotating by `n` or multiples of `n` brings the list back to its original state).
   - If `k == 0`, return the list as-is.

3. **Make the List Circular:**
   - Connect the last node to the head of the list (`tail.next = head`).

4. **Find the New Head and Tail:**
   - Traverse the list to find the `(n - k - 1)`-th node, which will be the new tail.
   - The next node will be the new head.

5. **Break the Circular Link:**
   - Set `newTail.next = null` to break the circular connection and finalize the rotated list.

## Time and Space Complexity:
- **Time Complexity:** O(n) (since we traverse the list twice).
- **Space Complexity:** O(1) (constant extra space).

## Why `k % length`?
- If `k >= n`, rotating the list by `k` positions is equivalent to rotating it by `k % n` positions. This saves unnecessary rotations.
- Example: For `k = 7` and list length `n = 5`, `k % n = 2`, so rotating by 7 is the same as rotating by 2.

## Example:
For the list `[1, 2, 3, 4, 5]` and `k = 2`:
- Length of list `n = 5`
- `k % 5 = 2` (no change)
- Circularly connect the list and then find the new head at position 3 (index 2).
- New list: `[4, 5, 1, 2, 3]`.

## When No Rotation:
- If `k == 0` or `k % n == 0`, simply return the original list as no rotation is needed.



# Code for Rotating a Linked List


## Code Implementation:

```java
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        int cnt = 1;

        // Find the length of the linked list
        while (temp.next != null) {
            temp = temp.next;
            cnt++;
        }

        // Adjust k if it's greater than the length of the list
        k = k % cnt;
        if (k == 0) return head;

        // Make the list circular
        temp.next = head;

        // Find the new tail, which will be (cnt - k - 1)
        ListNode forward = head;
        for (int i = 1; i < cnt - k; i++) {
            forward = forward.next;
        }

        // The new head will be the next of the new tail
        ListNode newHead = forward.next;

        // Break the circular connection
        forward.next = null;

        return newHead;
    }
}
