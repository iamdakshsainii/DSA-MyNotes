**Do Yourself First:**
Before checking the solution, try to solve the problem using these hints:

- **Brute Force Approach:**
  - For each element, check the next greater element by iterating over the circular array.
  - Use modulo `% n` to handle circular behavior.
  - Time Complexity: **O(n²)**

- **Optimized Stack Approach:**
  - Use a **monotonic decreasing stack** to keep track of elements.
  - Traverse the array **twice** (simulating a circular array) from right to left.
  - Use `% n` to wrap around indices efficiently.
  - Time Complexity: **O(n)**

**Monotonic Decreasing Stack (General Template):**
```java
Stack<Integer> stack = new Stack<>();
for (int i = n-1; i >= 0; i--) {
    while (!stack.isEmpty() && stack.peek() <= arr[i]) {
        stack.pop();
    }
    // Process next greater element logic here
    stack.push(arr[i]);
}
```

---

**Problem:**
Given a circular array, find the next greater element for each element in the array. The next greater element of an element `x` is the first greater element to its right. If it doesn't exist, return -1.

---

**Example:**

```
Input: [1, 2, 1]
Output: [2, -1, 2]
Explanation:
- 1's next greater is 2
- 2 has no greater element, so -1
- 1's next greater (circular array) is 2
```

---

### **Method 1: Brute Force**
```java
class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < i + n; j++) {
                int ind = j % n;
                if (arr[i] < arr[ind]) {
                    nums[i] = arr[ind];
                    break;
                }
            }
        }
        return nums;
    }
}
```

**Time Complexity:** O(n^2)
**Space Complexity:** O(1)

---

### **Method 2: Optimized Using Stack**
```java
class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            int index = i % n;
            while (!stack.isEmpty() && stack.peek() <= arr[index]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                nums[index] = stack.peek();
            }
            stack.push(arr[index]);
        }
        return nums;
    }
}
```

**Time Complexity:** O(n)
**Space Complexity:** O(n)

---

### **Revision Points:**
- **Handling Circular Array:** Use modulo `% n` to wrap around indices.
- **Stack Usage:** Maintain a decreasing stack to efficiently find the next greater element.
- **Iterate Twice:** Looping from `2n - 1` to `0` ensures we handle circularity without extra checks.
- **Pop Elements:** Ensure smaller elements are popped to maintain a decreasing stack order.
