# Java Template for Array, LinkedList, String, 2D Array, and Matrix Input on Platforms like HackerRank

## Overview
This Java template is designed for coding platforms like **HackerRank**, where input is provided via `Scanner`, and the function implementation is required.

## Array Code Template
```java
import java.util.*;

public class Solution {

    // Function to process the array (Modify this as per the problem requirement)
    public static int processArray(int[] arr) {
        // Example: Return sum of the array (Modify logic as needed)
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the array
        int n = scanner.nextInt();
        int[] arr = new int[n];

        // Read the array elements
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Call the function and print the result
        int result = processArray(arr);
        System.out.println(result);

        scanner.close();
    }
}
```

## LinkedList Code Template
```java
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Solution {

    // Function to process the linked list (Modify logic as per the problem requirement)
    public static int processLinkedList(Node head) {
        // Example: Return sum of LinkedList elements (Modify logic as needed)
        int sum = 0;
        Node temp = head;
        while (temp != null) {
            sum += temp.data;
            temp = temp.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of the LinkedList
        int n = scanner.nextInt();
        Node head = null, tail = null;

        // Read the LinkedList elements
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Call the function and print the result
        int result = processLinkedList(head);
        System.out.println(result);

        scanner.close();
    }
}
```

## String Code Template
```java
import java.util.*;

public class Solution {

    // Function to process the string (Modify as per requirement)
    public static String processString(String str) {
        // Example: Convert to uppercase (Modify logic as needed)
        return str.toUpperCase();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the string input
        String str = scanner.nextLine();

        // Call the function and print the result
        System.out.println(processString(str));

        scanner.close();
    }
}
```

## 2D Array / Matrix Code Template
```java
import java.util.*;

public class Solution {

    // Function to process the matrix (Modify as per requirement)
    public static int processMatrix(int[][] matrix, int rows, int cols) {
        // Example: Return sum of all elements (Modify logic as needed)
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read matrix dimensions
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];

        // Read matrix elements
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Call the function and print the result
        int result = processMatrix(matrix, rows, cols);
        System.out.println(result);

        scanner.close();
    }
}
```

## Explanation
1. **`processArray(int[] arr)`**: Processes an array and returns a computed result.
2. **`processLinkedList(Node head)`**: Processes a linked list and returns a computed result.
3. **`processString(String str)`**: Processes a string input and returns a modified result.
4. **`processMatrix(int[][] matrix, int rows, int cols)`**: Processes a 2D matrix and returns a computed result.
5. **`main` function**:
   - Reads input for **array, LinkedList, string, or matrix**.
   - Calls the respective function and prints the result.

## Example Execution
### **Input (Array):**
```
5
1 2 3 4 5
```
### **Output:**
```
15
```

### **Input (LinkedList):**
```
5
1 2 3 4 5
```
### **Output:**
```
15
```

### **Input (String):**
```
hello world
```
### **Output:**
```
HELLO WORLD
```

### **Input (Matrix):**
```
2 3
1 2 3
4 5 6
```
### **Output:**
```
21
```

Modify the functions based on the problem statement and requirements! 🚀
