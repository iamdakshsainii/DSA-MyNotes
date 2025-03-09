### **Queue Basics & Implementation in Java**

#### **1. What is a Queue?**

- A **Queue** is a **FIFO (First-In-First-Out)** data structure.
- Elements are inserted at the **rear** and removed from the **front**.
- A **circular queue** allows efficient space usage by wrapping around when needed.

---

### **2. Queue Implementation in Java**

```java
class ArrayQueue {
    int[] arr;
    int start, end, capacity, size;

    // Constructor
    public ArrayQueue() {
        capacity = 10;
        arr = new int[capacity];
        start = -1;
        end = -1;
        size = 0;
    }

    // Push (Enqueue)
    public void push(int x) {
        if (size == capacity) {
            System.out.println("Queue is full\nExiting...");
            System.exit(1);
        }
        if (end == -1) {  // First element being inserted
            start = 0;
            end = 0;
        } else {
            end = (end + 1) % capacity;
        }
        arr[end] = x;
        size++;
    }

    // Pop (Dequeue)
    public int pop() {
        if (start == -1) {
            System.out.println("Queue Empty\nExiting...");
            System.exit(1);
        }
        int popped = arr[start];

        if (size == 1) {  // Only one element left
            start = -1;
            end = -1;
        } else {
            start = (start + 1) % capacity;
        }
        size--;
        return popped;
    }

    // Peek (Get Front Element)
    public int peek() {
        if (start == -1) {
            System.out.println("Queue is Empty");
            System.exit(1);
        }
        return arr[start];
    }

    // Check if Queue is Empty
    public boolean isEmpty() {
        return (size == 0);
    }
}

// Main Method
public class QueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        queue.push(10);
        queue.push(20);
        queue.push(30);
        System.out.println("Front element: " + queue.peek()); // Output: 10
        System.out.println("Removed: " + queue.pop()); // Output: 10
        System.out.println("Front element after pop: " + queue.peek()); // Output: 20
    }
}
```

---

### **3. Queue Operations & Key Considerations**

#### **Constructor – Initialize Queue**

```java
public ArrayQueue() {
    capacity = 10;
    arr = new int[capacity];
    start = -1;
    end = -1;
    size = 0;
}
```

📌 **Purpose:** Initializes the queue with default values.
📌 **Key points:**


✅ `capacity = 10` defines the fixed size.

✅ `start = -1`, `end = -1` (indicates an empty queue).

#### **Push (Enqueue) – Insert an Element**

```java
public void push(int x) {
    if (size == capacity) {
        System.out.println("Queue is full\nExiting...");
        System.exit(1);
    }
    if (end == -1) {  // First element being inserted
        start = 0;
        end = 0;
    } else {
        end = (end + 1) % capacity;
    }
    arr[end] = x;
    size++;
}
```

📌 **Purpose:** Adds an element at the rear.
📌 **Key points:**

✅ Check if queue is **full** before inserting.

✅ If first element, update `start` and `end`.

✅ Otherwise, move `end` circularly using `(end + 1) % capacity`.

#### **Pop (Dequeue) – Remove an Element**

```java
public int pop() {
    if (start == -1) {
        System.out.println("Queue Empty\nExiting...");
        System.exit(1);
    }
    int popped = arr[start];

    if (size == 1) {  // Only one element left
        start = -1;
        end = -1;
    } else {
        start = (start + 1) % capacity;
    }
    size--;
    return popped;
}
```

📌 **Purpose:** Removes an element from the front.
📌 **Key points:**

✅ Check if queue is **empty** before removing.

✅ If only one element left, reset `start` and `end` to `-1`.

✅ Otherwise, move `start` circularly using `(start + 1) % capacity`.

#### **Peek – Get the Front Element**

```java
public int peek() {
    if (start == -1) {
        System.out.println("Queue is Empty");
        System.exit(1);
    }
    return arr[start];
}
```

📌 **Purpose:** Returns the front element without removing it.
📌 **Key points:**

✅ Ensure the queue is not **empty** before accessing.

✅ Returns `arr[start]`, which is always the front element.

#### **Check if Queue is Empty**

```java
public boolean isEmpty() {
    return (size == 0);
}
```

📌 **Purpose:** Checks if the queue has elements.
📌 **Key points:**

✅ If `size == 0`, queue is empty.

✅ Used before operations like `pop()` or `peek()` to prevent errors.

---

### **4. Edge Cases to Handle**

✅ **Queue Full:** Avoid overflow before pushing.

✅ **Queue Empty:** Avoid underflow before popping.

✅ **Single Element Case:** Reset `start` and `end` after popping.

✅ **Circular Handling:** Use `(index + 1) % capacity` to manage wrap-around efficiently.

---

### **5. Summary**

| Operation   | Condition to Check | Key Action                                |
| ----------- | ------------------ | ----------------------------------------- |
| **Push**    | Queue full         | Update `end`, wrap around if needed       |
| **Pop**     | Queue empty        | Update `start`, reset if only one element |
| **Peek**    | Queue empty        | Return `arr[start]`                       |
| **isEmpty** | -                  | Return `size == 0`                        |

