### **Stack Implementation Using Queue**

#### **1. Concept Overview**

- A **Stack (LIFO - Last In, First Out)** can be implemented using a **Queue (FIFO - First In, First Out)**.
- We use a **single queue** and maintain the LIFO order by rotating elements after every push.
- Operations supported: `push()`, `pop()`, `top()`, `poll()`, `isEmpty()`.

---

### **2. Implementation in Java**

```java
import java.util.*;

// Stack implementation using a Queue
class QueueStack {
    // Queue for stack operations
    Queue<Integer> q = new LinkedList<>();

    // Push an element onto the stack
    public void push(int x) {
        int s = q.size(); // Store current size
        q.add(x); // Insert new element

        // Rotate previous elements to maintain LIFO order
        for (int i = 0; i < s; i++) {
            q.add(q.poll());
        }
    }

    // Pop (Remove and return the top element)
    public int pop() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q.poll();
    }

    // Peek (Return the top element without removing it)
    public int top() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q.peek();
    }

    // Poll (Remove and return the front element, similar to pop)
    public int poll() {
        if (q.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q.poll();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return q.isEmpty();
    }
}

// Main class for execution
class Main {
    public static void main(String[] args) {
        QueueStack st = new QueueStack();

        // Array of commands
        String[] commands = {"QueueStack", "push", "push", "pop", "top", "poll", "isEmpty"};
        int[][] inputs = {{}, {4}, {8}, {}, {}, {}, {}};

        for (int i = 0; i < commands.length; ++i) {
            switch (commands[i]) {
                case "push":
                    st.push(inputs[i][0]);
                    System.out.print("null ");
                    break;
                case "pop":
                    System.out.print(st.pop() + " ");
                    break;
                case "top":
                    System.out.print(st.top() + " ");
                    break;
                case "poll":
                    System.out.print(st.poll() + " ");
                    break;
                case "isEmpty":
                    System.out.print(st.isEmpty() ? "true " : "false ");
                    break;
                case "QueueStack":
                    System.out.print("null ");
                    break;
            }
        }
    }
}
```

---

### **3. Explanation of Queue Initialization**

```java
Queue<Integer> q = new LinkedList<>();
```

- `Queue<Integer>` is an interface in Java, meaning it cannot be instantiated directly.
- `LinkedList<>` is one of the classes that implement the `Queue` interface.
- `q` behaves as a **FIFO (First In, First Out)** queue but is manipulated to work as a stack using element rotations.
- Other queue implementations like `ArrayDeque<>` could also be used instead of `LinkedList<>`.

---

### **4. Operations & Key Insights**

#### **Push (Insert Element)**

📌 **Before pushing:**
✅ Add the new element to the queue.
✅ Rotate all previous elements to maintain LIFO order.

#### **Pop (Remove and Return Top Element)**

📌 **Before popping:**
✅ Check if the stack is empty to prevent errors.
✅ Remove the front element (which acts as the top of the stack).

#### **Top (Peek at Top Element Without Removing It)**

📌 **Before peeking:**
✅ Ensure the stack is not empty.
✅ Return the front element of the queue.

#### **Poll (Remove and Return Front Element, Like Pop)**

📌 **Before polling:**
✅ Ensure the stack is not empty.
✅ Remove and return the front element of the queue.

#### **isEmpty (Check if Stack is Empty)**

✅ Returns `true` if there are no elements in the queue.

---

### **5. Edge Cases to Handle**

✅ **Stack Empty:** Avoid underflow when popping, polling, or peeking.
✅ **Order Maintenance:** Ensure LIFO order using rotation after each push.

---

### **6. Summary**

| Operation   | Condition to Check | Key Action                      |
| ----------- | ------------------ | ------------------------------- |
| **Push**    | -                  | Add element and rotate queue    |
| **Pop**     | Stack empty        | Remove and return front element |
| **Top**     | Stack empty        | Return front element            |
| **Poll**    | Stack empty        | Remove and return front element |
| **isEmpty** | -                  | Return `q.isEmpty()`            |

