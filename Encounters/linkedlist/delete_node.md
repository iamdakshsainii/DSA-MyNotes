
---

## 💡 Intuition

In a **singly linked list**, to delete a node, you usually need the **previous node** (to update its `.next`).

But here:

- We **don’t have access to the previous node**
- And we **can’t go backward**, since it’s singly linked

### ✅ Trick:
- Copy the `data` from the next node into `del_node`
- Then, skip over the next node by changing the `.next` pointer

This **fakes** deleting the current node by **turning it into the next one**, and then **removing the next**.

---

## ✅ Approach

### Steps:

1. `del_node.data = del_node.next.data`
   → Replace the value
2. `del_node.next = del_node.next.next`
   → Bypass the next node

---

## 🧱 Code (Java)

```java
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
    }
}

public class Solution {
    public void deleteNode(Node del_node) {
        if (del_node == null || del_node.next == null) return;

        // Step 1: Copy value from next
        del_node.data = del_node.next.data;

        // Step 2: Remove next node
        del_node.next = del_node.next.next;
    }
}
