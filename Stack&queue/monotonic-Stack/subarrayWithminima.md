# Sum of Subarray Minimums

## Problem Statement
Given an array `arr` of integers, find the sum of the **minimum value** of all its subarrays. The answer should be returned **modulo** `(1e9 + 7)`.

### Example:
```java
Input: arr = [3, 1, 2, 4]
Output: 17
```
**Explanation:**
- Subarrays and their minimums:
  - [3] → 3
  - [1] → 1
  - [2] → 2
  - [4] → 4
  - [3,1] → 1
  - [1,2] → 1
  - [2,4] → 2
  - [3,1,2] → 1
  - [1,2,4] → 1
  - [3,1,2,4] → 1
- **Sum = 17**

---

## Method 1: Brute Force (O(N²))
### Intuition:
- Iterate through all subarrays.
- Find the **minimum element** for each subarray.
- Add it to the sum.

### Code:
```java
class Solution {
  public int sumSubarrayMins(int[] arr) {
    int n = arr.length;
    long sum = 0;
    int mod = (int) 1e9 + 7;

    for (int i = 0; i < n; i++) {
      int mini = Integer.MAX_VALUE;
      for (int j = i; j < n; j++) {
        mini = Math.min(mini, arr[j]);
        sum = (sum + mini) % mod;
      }
    }
    return (int) sum;
  }
}
```

### Key Points:
- **Time Complexity:** `O(N²)`, as it checks all subarrays.
- **Space Complexity:** `O(1)`, as it uses no extra space.

---

## Method 2: Optimized Using Monotonic Stack (O(N))
### Intuition:
- Instead of checking all subarrays, use a **monotonic increasing stack** to find the nearest **previous smaller** and **next smaller** element.
- This helps determine how many subarrays an element contributes as the minimum value.
- **Contribution of an element = (left range) * (right range) * arr[i]**.

### Code:
```java
class Solution {
  public int sumSubarrayMins(int[] arr) {
    int n = arr.length;
    long sum = 0;
    int mod = (int) 1e9 + 7;

    int[] left = prevSmallest(arr);
    int[] right = nextLowest(arr);

    for (int i = 0; i < n; i++) {
      long totalContri = (long) (i - left[i]) * (right[i] - i);
      sum = (sum + totalContri * arr[i]) % mod;
    }
    return (int) sum;
  }

  public int[] prevSmallest(int[] arr) {
    int n = arr.length;
    int[] left = new int[n];
    Stack<Integer> st = new Stack<>();
    Arrays.fill(left, -1);

    for (int i = 0; i < n; i++) {
      while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
        st.pop();
      }
      left[i] = st.isEmpty() ? -1 : st.peek();
      st.push(i);
    }
    return left;
  }

  public int[] nextLowest(int[] arr) {
    int n = arr.length;
    int[] right = new int[n];
    Stack<Integer> st = new Stack<>();
    Arrays.fill(right, n);

    for (int i = n - 1; i >= 0; i--) {
      while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
        st.pop();
      }
      right[i] = st.isEmpty() ? n : st.peek();
      st.push(i);
    }
    return right;
  }
}
```

### Key Points:
- **Time Complexity:** `O(N)`, as each element is pushed/popped once.
- **Space Complexity:** `O(N)`, for `left[]`, `right[]`, and stack.

---

By using **Method 2**, we significantly reduce computation time from `O(N²)` to `O(N)`. 🚀🔥

### Understanding the Approach

#### Find Previous Smaller (`prevSmallest`)
- `left[i]` stores the index of the previous smaller element for `arr[i]`.
- If no smaller element exists, store `-1`.

#### Find Next Smaller (`nextLowest`)
- `right[i]` stores the index of the next smaller element for `arr[i]`.
- If no smaller element exists, store `n` (since it contributes till the end).

### Handling Duplicates
- We use `>=` to pop duplicates, ensuring that they don’t incorrectly contribute to subarrays.

### Compute Contribution of Each Element (`sumSubarrayMins`)
- `width = (i - left[i]) * (right[i] - i)`: This counts the number of subarrays where `arr[i]` is the minimum.
- Final sum is calculated using:
  ```java
  sum = (sum + arr[i] * width) % mod;
  ```

### Dry Run Example
**Input:**
```java
arr = [3, 1, 2, 4];
```

#### Step 1: Compute `prevSmallest(arr)`
```java
left = [-1, -1, 1, 2];
```

#### Step 2: Compute `nextLowest(arr)`
```java
right = [1, 4, 3, 4];
```

#### Step 3: Compute Sum Using Contribution Formula
```java
Final Sum = 17
```

### Optimized Complexity
- Finding `left[]` and `right[]` using stacks: `O(N)`
- Final sum calculation: `O(N)`
- **Overall Complexity:** `O(N)` 🔥

### Key Takeaways
✅ Use `>=` in `nextLowest()` to correctly handle duplicates and ensure the next smaller element is found.
✅ Store indices, not values, in `left[]` and `right[]`, since they help calculate the width.
✅ Formula: `(i - left[i]) * (right[i] - i)` gives the count of subarrays where `arr[i]` is the minimum.
✅ Modulo is applied at every step to prevent integer overflow.
