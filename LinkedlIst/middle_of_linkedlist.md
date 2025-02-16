# Finding the Middle of a Linked List

## Problem Statement
Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.

### Example
#### Input:
```
head = [1,2,3,4,5]
```
#### Output:
```
[3,4,5]
```
#### Explanation:
The middle node of the list is node 3.

---

## Brute Force Approach
### **Idea:**
1. Traverse the linked list to count the total number of nodes (**O(n)**).
2. Traverse the list again to reach the middle node (**O(n)**).
3. Return the middle node.

### **Java Implementation:**
```java
class Solution {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode temp = head;

        // Step 1: Count the number of nodes
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Step 2: Find the middle node
        temp = head;
        int middle = count / 2; // Middle index
        for (int i = 0; i < middle; i++) {
            temp = temp.next;
        }

        return temp;
    }
}
```
### **Time & Space Complexity:**
- **Time Complexity:** `O(n) + O(n) = O(n)`
- **Space Complexity:** `O(1)` (No extra space used)

---

## Optimized Approach (Two Pointer - Tortoise & Hare)
### **Idea:**
- Use **slow and fast pointers**.
- The **fast pointer** moves two steps at a time, while the **slow pointer** moves one step.
- When the fast pointer reaches the end, the slow pointer will be at the middle node.

### **Java Implementation:**
```java
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        // Move fast pointer twice as fast as slow pointer
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
```
### **Time & Space Complexity:**
- **Time Complexity:** `O(n)` (Only one traversal)
- **Space Complexity:** `O(1)` (No extra space used)

---
### **Comparison of Approaches**
| Approach  | Time Complexity | Space Complexity | Extra Traversal |
|-----------|---------------|-----------------|----------------|
| **Brute Force** | O(n) | O(1) | Yes |
| **Optimized (Two Pointer)** | O(n) | O(1) | No |

🚀 **The Two Pointer method is the most efficient!**

