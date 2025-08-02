# Get Min at Pop

## Problem Statement

You are given an integer array `arr[]`. You need to:

1. Push all elements of the array into a stack.
2. While popping each element from the stack, print the **minimum element** present in the stack **at that point**.

An element is considered pushed in order from left to right. You always pop from the top.

---

## Example

**Input:**

```java
arr[] = [1, 2, 3, 4, 5]
```

**Output:**

```
1 1 1 1 1
```

**Explanation:**
Stack after all elements are pushed: `Top -> 5, 4, 3, 2, 1`

* Pop 5 → Min is 1
* Pop 4 → Min is 1
* Pop 3 → Min is 1
* Pop 2 → Min is 1
* Pop 1 → Min is 1

---

## Intuition

We need a way to track the **minimum** at each level of the stack. Instead of storing the actual element, we store the **minimum so far** at each position.

---

## Approach

1. In `_push`, push the current element if the stack is empty.
2. Otherwise, push the **minimum of current element and top of stack**.
3. In `_getMinAtPop`, just pop and print.

---

## Code

```java
class GetMin {
    public static Stack<Integer> _push(int arr[], int n) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (st.empty()) {
                st.push(arr[i]);
            } else {
                int min = Math.min(st.peek(), arr[i]);
                st.push(min);
            }
        }
        return st;
    }

    static void _getMinAtPop(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
}
```

---

## Complexity

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(n)` (for storing min values in stack)

---

---

## Key Takeaways

* Stack can be used to track minimum by storing min-so-far.
* Each pop can directly give you the correct answer if the stack is built smartly.
