# **Monotonic Stack Revision**

## **Key Indicators for Using a Monotonic Stack**
A monotonic stack is typically useful when you need to process elements in order while maintaining a sorted stack (either increasing or decreasing). Look for these signs:

🔹 **Next/Previous Greater or Smaller Element Problems**
If a problem asks for the next/previous greater/smaller element for each element in an array.
Example:
- **Next Greater Element** → Use a **decreasing** monotonic stack.
- **Next Smaller Element** → Use an **increasing** monotonic stack.

🔹 **Brute Force Approach is Inefficient**
If a problem can be solved using nested loops in O(n²), but a monotonic stack allows an **O(n) solution** by maintaining useful elements and discarding unnecessary ones.

## **Types of Monotonic Stacks**

| Problem Type                   | Stack Order | Used For |
|--------------------------------|------------|----------|
| **Next Greater Element**       | Decreasing | Finding Next Greater Number |
| **Next Smaller Element**       | Increasing | Finding Next Smaller Number |
| **Stock Span Problem**         | Decreasing | Finding Stock Span Days |
| **Daily Temperatures**         | Decreasing | Finding Days Until a Warmer Temperature |
| **Largest Rectangle in Histogram** | Increasing | Finding Maximum Rectangle Area |
| **Asteroid Collision**         | Decreasing | Handling Collisions Efficiently |
| **Sum of Subarray Minimums**   | Increasing | Finding Contribution of Each Element |
| **Range Queries with Monotonic Stack** | Varies | Efficient Range Processing |
| **Remove K Digits**            | Increasing | Removing Digits to Form Smallest Number |

---

## **Example 1: Next Greater Element Using Decreasing Stack**

### **Problem Statement**
Find the **next greater element** for each element in an array. If no greater element exists, return `-1`.

### **Example Input & Output**
```plaintext
Input:  arr = [4, 5, 2, 10, 8]
Output:      [5, 10, 10, -1, -1]
```

### **Implementation in Java**
```java
import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] arr) {
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

---

## **Example 2: Next Smaller Element Using Increasing Stack**

### **Problem Statement**
Find the **next smaller element** for each element in an array. If no smaller element exists, return `-1`.

### **Example Input & Output**
```plaintext
Input:  arr = [4, 5, 2, 10, 8]
Output:      [2, 2, -1, 8, -1]
```

### **Implementation in Java**
```java
import java.util.*;

class Solution {
    public int[] nextSmallerElement(int[] arr) {
        int n = arr.length;
        int[] nums = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            nums[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return nums;
    }
}
```

---

## **Intuition Behind Other Monotonic Stack Problems**

### **Asteroid Collision**
- Use a **decreasing stack** to handle asteroid collisions efficiently.
- If a new asteroid is positive, push it onto the stack.
- If a new asteroid is negative, compare it with the stack's top and resolve collisions.

### **Sum of Subarray Minimums**
- Use an **increasing stack** to find the contribution of each element as the minimum of subarrays.
- Helps in breaking the problem into efficient range calculations.

### **Range Queries with Monotonic Stack**
- Often used in **RMQ (Range Minimum Query)** problems.
- Helps process subarray properties without nested loops.

### **Remove K Digits**
- Use an **increasing stack** to maintain the smallest possible number.
- If a larger digit appears before a smaller one, pop larger ones to get the smallest result.

---

## **Key Takeaways**
- **Next Greater Element → Use a Decreasing Stack (Pop Smaller Elements).**
- **Next Smaller Element → Use an Increasing Stack (Pop Larger Elements).**
- **Always check for empty stack conditions before accessing the top.**
- **Process elements from right to left for efficiency.**
- **Use Monotonic Stacks for problems involving sequential dependencies.**
