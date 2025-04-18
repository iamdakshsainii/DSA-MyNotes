
# 📘 Linked List Java Practice Guide — Daksh Bhai Edition 🔥

---

## 🧩 Problem 1: Remove Last Element from Singly Linked List

### ❓ Problem Statement:
You are given a list of integers. You need to remove the **last element** from the singly linked list and print the remaining elements.

### 🔡 Input Format:
- First line: Integer `n`, the size of the list.
- Second line: `n` space-separated integers.

### 🖨️ Output Format:
- Print the elements of the list after removing the last element, separated by space.

### ✅ Code:
```java
class Node {
    int data;
    Node next;
    Node(int data) { this.data = data; }
}

class SinglyLL {
    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) head = newNode;
        else {
            Node curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = newNode;
        }
    }

    public void removeLast() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        Node curr = head;
        while (curr.next.next != null) curr = curr.next;
        curr.next = null;
    }

    public void printLL() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
```

---

## 🧩 Problem 2: Remove Duplicates from Singly Linked List

### ❓ Problem Statement:
You are given an unsorted singly linked list. Remove duplicate elements so that only the first occurrence of each element remains.

### 🔡 Input Format:
- First line: Integer `n`, number of elements.
- Second line: `n` space-separated integers.

### 🖨️ Output Format:
- The final linked list after removing duplicates, printed space-separated.

### ✅ Code:
```java
public void removeDupli() {
    Set<Integer> seen = new HashSet<>();
    Node current = head;
    Node prev = null;

    while (current != null) {
        if (seen.contains(current.data)) {
            prev.next = current.next;
        } else {
            seen.add(current.data);
            prev = current;
        }
        current = current.next;
    }
}
```

---

## 🧩 Problem 3: Circular Linked List – Remove Last Node

### ❓ Problem Statement:
You are given a circular linked list that represents a queue. Remove the **last node** (person) from the circular queue.

### 🔡 Input Format:
- First line: Integer `n`, number of people in the queue.
- Second line: `n` space-separated unique identifiers.

### 🖨️ Output Format:
- The circular linked list after removing the last node, space-separated.

### ✅ Code:
```java
class CircularLL {
    Node head = null;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newNode;
            newNode.next = head;
        }
    }

    public void removeLast() {
        if (head == null || head.next == head) {
            head = null;
            return;
        }

        Node curr = head;
        while (curr.next.next != head) curr = curr.next;
        curr.next = head;
    }

    public void printList() {
        if (head == null) return;
        Node curr = head;
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != head);
    }
}
```

---

## 🧩 Problem 4: Doubly Linked List – Remove Duplicates

### ❓ Problem Statement:
You are given a doubly linked list where some product IDs may repeat. You need to remove all **duplicate** nodes such that each ID appears only once.

### 🔡 Input Format:
- First line: Integer `n`, number of elements.
- Second line: `n` space-separated integers.

### 🖨️ Output Format:
- The final list after removing duplicates, space-separated.

### ✅ Code:
```java
class DLLNode {
    int data;
    DLLNode prev, next;
    DLLNode(int data) { this.data = data; }
}

class DoublyLL {
    DLLNode head;

    public void insertFront(int data) {
        DLLNode newNode = new DLLNode(data);
        newNode.next = head;
        if (head != null) head.prev = newNode;
        head = newNode;
    }

    public void removeDuplicates() {
        Set<Integer> seen = new HashSet<>();
        DLLNode curr = head;

        while (curr != null) {
            if (seen.contains(curr.data)) {
                DLLNode next = curr.next;
                if (curr.prev != null) curr.prev.next = curr.next;
                if (curr.next != null) curr.next.prev = curr.prev;
                if (curr == head) head = curr.next;
                curr = next;
            } else {
                seen.add(curr.data);
                curr = curr.next;
            }
        }
    }

    public void printList() {
        DLLNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
```

---

## 🧠 Summary of Common Mistakes:

| Mistake                  | Fix                            |
|--------------------------|---------------------------------|
| `System.out.print();`    | Use `System.out.println();`    |
| Case mismatch (`newNode`)| Be consistent in variable names|
| No space in output       | Add space after each print     |
| Missing edge cases       | Always check for `head == null`|
| Typos (`current`)        | Double check variable names    |

---

🔥 YOU GOT THIS. Want sorting, reversal, or more challenges? Ping me bro!
