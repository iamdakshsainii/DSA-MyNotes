**Method 1 -> Implement Queues using Arrays->**
Focus on dequeue

```java

public class Queue {

    // Basic value initialization
    static int SIZE = 5;
    static int[] queue = new int[SIZE];
    static int front = -1, rear = -1;

    // Function created to handle enqueue
    public static void enqueue(int item) {
        if (rear == SIZE - 1) {
            System.out.println("Can't enqueue as the queue is full");
        } else {
            // The first element condition
            if (front == -1) {
                front = 0;
            }
            rear = rear + 1;
            queue[rear] = item;
            System.out.println("We have enqueued " + item);
        }
    }

    // Function created to handle dequeue
    public static void dequeue() {
        if (front == -1) {
            System.out.println("Can't dequeue as the queue is empty");
        } else {
            System.out.println("We have dequeued: " + queue[front]);
            front = front + 1;

            // Only happens when the last element was dequeued -> jab array kali ho jayegi then if want to dry run so first add element and then front at start and end at end then try dequeue all
            if (front > rear) {
                front = -1;
                rear = -1;
            }
        }
    }

    // Function to print the queue
    public static void printQueue() {
        if (rear == -1) {
            System.out.println("\nUnable to display as the queue is empty");
        } else {
            System.out.print("\nThe queue after enqueue & dequeue ops looks like: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }
}

```

**Method 2 -> Implement Queues using Arrays->**
```java
public class Queue {
    static final int MAX_CAPACITY = 5;
    static int[] queue = new int[MAX_CAPACITY];
    static int front = -1, rear = -1, currSize = 0;

    // Function to enqueue an element in the queue
    public static void enQueue(int data) {
        if (currSize == MAX_CAPACITY) {
            // Queue is full, can't enqueue
        } else {
            if (front == -1) {
                front = currSize = 0;
                rear = MAX_CAPACITY - 1;
            }

            // Using % operation to handle circular queue
            rear = (rear + 1) % MAX_CAPACITY;
            queue[rear] = data;
            currSize = currSize + 1;
        }
    }

    // Function to dequeue an element from the queue
    public static void deQueue() {
        if (currSize == 0) {
            // Queue is empty, can't dequeue
        } else {
            int item = queue[front];
            front = (front + 1) % MAX_CAPACITY;
            currSize = currSize - 1;
        }
    }

    // Function to display the current state of the queue
    public static void display() {
        if (currSize == 0) {
            // Queue is empty
        } else {
            int i;
            for (i = front; i != rear; i = (i + 1) % MAX_CAPACITY) {
                System.out.print(queue[i] + " ");
            }
            System.out.print(queue[i]); // For the last element
        }
    }
}
```
