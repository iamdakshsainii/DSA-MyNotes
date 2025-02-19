## **7️⃣ Important Considerations for Cycle Detection in Linked Lists and Arrays**
### **🔹 Use Tortoise Technique (Fast and Slow Pointer) for Cycle Detection**
- Whenever you suspect a **cycle** in a linked list or array, use the **tortoise technique** (slow and fast pointers).

### **🔹 Always Handle the Case When There is No Cycle**
- This single line can save hours of debugging and prevent **TLE (Time Limit Exceeded) errors**.
```java
if (temp == null) return 0; // Always check for no cycle
```

### **🔹 Code Implementation**
```java
class Solution {
  public ListNode findStartingPoint(ListNode head) {
    ListNode forward = head;
    ListNode prev = head;
    while (forward != null && forward.next != null) {
      prev = prev.next;
      forward = forward.next.next;
      if (forward == prev) {
        prev = head;
        while (prev != forward) {
          forward = forward.next;
          prev = prev.next;
        }
        return prev;
      }
    }
    return null; // Must return this to prevent TLE
  }

  public int findLengthOfLoop(ListNode head) {
    int cnt = 1;
    ListNode temp = findStartingPoint(head);
    ListNode slow = temp;
    if (temp == null) return 0; // Always check for no cycle
    while (temp.next != slow) {
      cnt++;
      temp = temp.next;
    }
    return cnt;
  }
}
```

---

### 🚀 **Summary Cheatsheet**
| Issue | Fix |
|--------|------|
| Accessing `node.next` without checking for `null` | `if (node != null && node.next != null) {...}` |
| Handling empty list incorrectly | `if (head == null) return null;` |
| Incorrect pointer updates in deletion | `if (node.next != null) node.next.prev = node;` |
| Deleting head without tracking new head | Use a **dummy node** |
| Skipping nodes due to incorrect `prev` movement | Move `prev` **only if node isn’t removed** |
| Detecting cycle in linked list/array | Use **Tortoise Technique (Fast & Slow Pointers)** |
| Preventing TLE due to infinite loop | Always check `if (temp == null) return 0;` |
