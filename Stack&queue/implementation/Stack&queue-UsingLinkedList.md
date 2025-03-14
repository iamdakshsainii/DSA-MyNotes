Stack me -> linkedlsit m push from start
Queue me - push to end

## Problem Statement
Implement a **Stack** and a **Queue** using a **Linked List** in Java. Each structure should support basic operations such as push, pop, peek/top, and checking if the structure is empty.

---

## Queue using Linked List
### Operations
1. **Push (Enqueue)**
   - Create a new node with the given value.
   - If the queue is empty, set `start` and `end` to the new node.
   - Otherwise, update the `next` pointer of `end` to the new node and update `end`.
   - Increment the size.

2. **Pop (Dequeue)**
   - If the queue is empty, return `-1`.
   - Store the value of `start`, update `start` to `start.next`.
   - Decrease the size and return the stored value.

3. **Peek**
   - If the queue is empty, return `-1`.
   - Otherwise, return the value of `start`.

4. **isEmpty**
   - Return `true` if the queue size is `0`, else return `false`.

### Implementation
```java
import java.util.*;

// Node structure
class Node {
    int val;
    Node next;
    Node(int d) {
        val = d;
        next = null;
    }
}

// Structure to represent queue
class LinkedListQueue {
    private Node start;
    private Node end;
    private int size;

    // Constructor
    public LinkedListQueue() {
        start = end = null;
        size = 0;
    }

    // Push Operation (Enqueue)
    public void push(int x) {
        Node element = new Node(x);
        if (start == null) {
            start = end = element;
        } else {
            end.next = element;
            end = element;
        }
        size++;
    }

    // Pop Operation (Dequeue)
    public int pop() {
        if (start == null) {
            return -1;
        }
        int value = start.val;
        start = start.next;
        size--;
        return value;
    }

    // Peek Operation
    public int peek() {
        if (start == null) {
            return -1;
        }
        return start.val;
    }

    // isEmpty Operation
    public boolean isEmpty() {
        return (size == 0);
    }
}
```

---

## Stack using Linked List
### Operations
1. **Push**
   - Create a new node with the given value.
   - Set `next` of the new node to `head`.
   - Update `head` to the new node.
   - Increment the size.

2. **Pop**
   - If the stack is empty, return `-1`.
   - Store the value of `head`, update `head` to `head.next`.
   - Decrease the size and return the stored value.

3. **Top**
   - If the stack is empty, return `-1`.
   - Otherwise, return the value of `head`.

4. **isEmpty**
   - Return `true` if the stack size is `0`, else return `false`.

### Implementation
```java
// Structure to represent stack
class LinkedListStack {
    private Node head; // Top of Stack
    private int size; // Size

    // Constructor
    public LinkedListStack() {
        head = null;
        size = 0;
    }

    // Push Operation
    public void push(int x) {
        Node element = new Node(x);
        element.next = head;
        head = element;
        size++;
    }

    // Pop Operation
    public int pop() {
        if (head == null) {
            return -1;
        }
        int value = head.val;
        head = head.next;
        size--;
        return value;
    }

    // Top Operation
    public int top() {
        if (head == null) {
            return -1;
        }
        return head.val;
    }

    // isEmpty Operation
    public boolean isEmpty() {
        return (size == 0);
    }
}
