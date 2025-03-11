# Next Greater Element

## Problem Statement

Given an array **arr** of size **n**, find the next greater element for each element in the array. The next greater element for an element **arr[i]** is the first greater element on the right side of **arr[i]** in the array. If no greater element exists, return **-1**.

## Example

### Input:

```java
arr = [4, 5, 2, 10, 8]
```

### Output:

```java
[5, 10, 10, -1, -1]
```

---

## Method 1: Brute Force (Nested Loop)

### Approach:

- Iterate through each element and compare it with the remaining elements to find the first larger element.
- If found, store that element; otherwise, store **-1**.

### Code:

```java
class Solution {
    public int[] nextLargerElement(int[] arr) {
        int n = arr.length;
        int[] nums = new int[n];
        Arrays.fill(nums, -1);

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] < arr[j]) {
                    nums[i] = arr[j];
                    break;
                }
            }
        }
        return nums;
    }
}
```

### Complexity Analysis:

- **Time Complexity**: **O(n²)** (nested loop)
- **Space Complexity**: **O(1)** (no extra space used apart from output array)

---

## Method 2: Optimized Approach (Using Stack)

### Approach:

- Use a **monotonic decreasing stack** to store elements while traversing the array in reverse.
- Maintain a stack to keep track of the next greater elements.
- If the stack is empty, the next greater element is **-1**.
- Pop elements from the stack until we find a greater element.
- Push the current element onto the stack for future elements to compare.

### Code:

```java
class Solution {
    public int[] nextLargerElement(int[] arr) {
        int n = arr.length;
        int[] nums = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            nums[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return nums;
    }
}
```

### Complexity Analysis:

- **Time Complexity**: **O(n)** (Each element is pushed and popped from the stack once)
- **Space Complexity**: **O(n)** (Stack stores elements temporarily)

### **Concepts to Remember:**

1. **Monotonic Stack:**

   - The stack maintains elements in a decreasing order (i.e., the largest elements stay on top).
   - If the current element is greater than or equal to the top of the stack, pop elements until a greater one is found.

2. **Key Observations:**

   - If using a stack, always check if it's **empty before accessing** the top element.
   - When popping elements, ensure the **loop exits correctly** to avoid errors.

3. **Points to Remember While Revising:**

   - **Stack helps in efficiently finding next greater elements in O(n) time.**
   - **Always check stack conditions after popping to avoid errors.**
   - **Iterate in reverse order (right to left) for better efficiency.**
   - **If stack is empty after popping, store -1 in the result array.**
   - **Push the current element into the stack for future comparisons.**

### **Why is Stack Efficient?**

- Avoids unnecessary comparisons by eliminating smaller elements early.
- Each element is processed only twice (push and pop).
