**Problem: Sum of Subarray Ranges**

**Description:**
Given an integer array `nums`, determine the range of a subarray, defined as the difference between the largest and smallest elements within the subarray. Calculate and return the sum of all subarray ranges of `nums`.

A subarray is defined as a contiguous, non-empty sequence of elements within the array.

**Example:**
```
Input: nums = [1, 2, 3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
Total sum = 0 + 0 + 0 + 1 + 1 + 2 = 4
```
---

## **Brute Force Approach**

### **Explanation:**
- We iterate through all possible subarrays.
- For each subarray, find the minimum and maximum elements.
- Calculate the difference (max - min) and add it to the sum.

### **Code Implementation:**
```java
class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for(int i = 0; i < n; i++) {
            int mini = nums[i];
            int maxi = nums[i];
            for(int j = i; j < n; j++) {
                mini = Math.min(mini, nums[j]); // Update minimum value
                maxi = Math.max(maxi, nums[j]); // Update maximum value
                sum += (maxi - mini); // Add the difference to the sum
            }
        }
        return sum;
    }
}
```

### **Complexity Analysis:**
- Time Complexity: **O(n^2)** (as we iterate through all subarrays)
- Space Complexity: **O(1)**

---

## **Optimized Approach Using Monotonic Stack**

// **target** -> largest(sum of subarray mximum) - smallest(sum of subarray minimum)
// we did miniumum vala case in previous question just pop condition changre do samefor largest
// at last just return the subtraction of both the sum

### **Explanation:**
- Instead of iterating through all subarrays, we calculate two sums:
  - **Sum of all subarray maximums**
  - **Sum of all subarray minimums**
- The final result is obtained by subtracting the sum of subarray minimums from the sum of subarray maximums.

### **Step 1: Finding Subarray Minimum Contribution**
- We use two stacks:
  - `prevSmallest(nums)`: Stores indices of the previous smaller element for each element.
  - `nextSmallest(nums)`: Stores indices of the next smaller element for each element.
- Using these indices, compute the contribution of each element as the minimum in various subarrays.

### **Code Implementation:**
```java
class Solution {
    // Function to find previous smaller elements
    public int[] prevSmallest(int[] nums) {
        int n = nums.length;
        int[] prev = new int[n];
        Arrays.fill(prev, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return prev;
    }

    // Function to find next smaller elements
    public int[] nextSmallest(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        Arrays.fill(next, n);
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return next;
    }

    // Function to calculate sum of subarray minimums
    public long minsumArray(int[] nums) {
        int n = nums.length;
        int[] arrL = prevSmallest(nums);
        int[] arrR = nextSmallest(nums);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long totalContri = (i - arrL[i]) * (arrR[i] - i);
            sum += (long) (totalContri * nums[i]);
        }
        return sum;
    }
```

---

### **Step 2: Finding Subarray Maximum Contribution**
- Similar to the minimum calculation, we use:
  - `prevGreatest(nums)`: Stores indices of the previous greater element.
  - `nextGreatest(nums)`: Stores indices of the next greater element.

### **Code Implementation:**
```java
    // Function to find next greater elements
    public int[] nextGreatest(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }

    // Function to find previous greater elements
    public int[] prevGreatest(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    // Function to calculate sum of subarray maximums
    public long sumSubarrayMaxs(int[] arr) {
        int[] arrL = prevGreatest(arr);
        int[] arrR = nextGreatest(arr);
        int n = arr.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long freq = (i - arrL[i]) * (arrR[i] - i);
            sum += (freq * arr[i]);
        }
        return sum;
    }

    // Main function to calculate subarray range sum
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums) - minsumArray(nums);
    }
}
```

### **Complexity Analysis:**
- Time Complexity: **O(n)** (due to stack operations)
- Space Complexity: **O(n)** (for stack storage)

### **Final Thoughts:**
- Brute force is easy to understand but inefficient.
- The optimized approach uses stacks to efficiently compute subarray min/max contributions.
- This reduces computation time from **O(n^2)** to **O(n)**.
