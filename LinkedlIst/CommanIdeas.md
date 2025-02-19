1. Brute mostly use stack,list or array to store the value
2. comman thing to remember when use linkedlist question are - middle,reverse,add vala question
3. if you need to find the intersection point of two linked list then use hashset to store the address of one list and then check if the address is present in other list if yes then return the address else return null - better
and also brute would be use 2 pointer one is at one place and traverse second aprt by checking and if not move first and check again
4. mostly question can be solve by hashset,array etc
5. wherever you find cycle mean brute can be solve ny simple array or hashing and optimal by tortoise technique


## important
in cycle
always take a case if no cycle then null, like in length what mistake i did was i get correct code but only forgot to handle case of if no loop (i had return the null  but forgot to ensure for length you can see reference in related side file)

# **💡 Hacks to Avoid NullPointerException in Linked Lists**

## **1️⃣ Always Check for `null` Before Accessing Next/Prev Nodes**
- Before doing `node.next` or `node.prev`, **ensure the node is not `null`** to avoid `NullPointerException`.
### **Example Fix:**
```java
if (node != null && node.next != null) {
    node = node.next;
}
```
**💡 Why?** → Prevents accessing `null.next`, which causes an exception.

---

## **2️⃣ Handle Edge Cases (Empty List or Single Node)**
- Always **check if the list is empty (`head == null`)** before processing it.
### **Example Fix:**
```java
if (head == null || head.next == null) {
    return head; // No need to process an empty or single-node list
}
```
**💡 Why?** → Avoids unnecessary operations on an empty list.

---

## **3️⃣ Update Pointers Carefully While Deleting Nodes**
- If `temp.next` is `null`, don't try `temp.next.prev = temp;`.
### **Example Fix:**
```java
if (temp.next != null) {
    temp.next.prev = temp;
}
temp.next = temp.next.next;
```
**💡 Why?** → Ensures `prev` update only happens when `next` exists.

---

## **4️⃣ Use Dummy Node for Safe Head Manipulation**
- A **dummy node** helps when removing the head node.
### **Example Fix:**
```java
ListNode dummy = new ListNode(0);
dummy.next = head;
ListNode temp = dummy;
```
**💡 Why?** → Avoids edge cases when deleting the head.

---

## **5️⃣ Move Pointers Only When Necessary**
- Ensure `prev` moves **only when an element isn’t removed**.
### **Example Fix:**
```java
if (temp.val != x) {
    prev = temp;
}
temp = temp.next;
```
**💡 Why?** → Prevents skipping over elements.

---

## **6️⃣ Always Return `head` After Modifications**
- If you update `head`, **ensure you return the correct reference**.
### **Example Fix:**
```java
head = head.next; // If head is deleted
return head;
```
**💡 Why?** → Prevents returning an outdated reference.

---

### 🚀 **Summary Cheatsheet**
| Issue | Fix |
|--------|------|
| Accessing `node.next` without checking for `null` | `if (node != null && node.next != null) {...}` |
| Handling empty list incorrectly | `if (head == null) return null;` |
| Incorrect pointer updates in deletion | `if (node.next != null) node.next.prev = node;` |
| Deleting head without tracking new head | Use a **dummy node** |
| Skipping nodes due to incorrect `prev` movement | Move `prev` **only if node isn’t removed** |

---

