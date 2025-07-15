## 🧩 Problem Statement

Given an integer array `nums`, find the **contiguous subarray** (containing at least one number) which has the **largest sum** and return its sum.

**Example:**
```java
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```

---

## 🐌 Brute Force Approach (O(n^2))

You can use two nested loops to try out every possible subarray and keep track of the maximum sum.

```java
public int maxSubArrayBruteForce(int[] nums) {
    int maxSum = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
        int currentSum = 0;
        for (int j = i; j < nums.length; j++) {
            currentSum += nums[j];
            maxSum = Math.max(maxSum, currentSum);
        }
    }
    return maxSum;
}
```

---

## ⚡ Optimal Approach - Kadane's Algorithm (O(n))

```java
public class Solution {
    // Function to find maximum sum of subarrays using Kadane's Algorithm
    public int maxSubArray(int[] nums) {

        // Maximum sum encountered so far
        long maxi = Long.MIN_VALUE;

        // Current subarray sum
        long sum = 0;

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // Update maximum if current sum is higher
            if (sum > maxi) {
                maxi = sum;
            }

            // Reset the current sum if it drops below 0
            if (sum < 0) {
                sum = 0;
            }
        }

        // Return the result as an integer
        return (int) maxi;
    }

    // Optional main method to test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = sol.maxSubArray(nums);
        System.out.println("Maximum Subarray Sum: " + maxSum); // Output should be 6
    }
}
```

---

## ✅ Summary

| Approach        | Time Complexity | Space Complexity |
|----------------|------------------|-------------------|
| Brute Force    | O(n^2)           | O(1)              |
| Kadane's Algo  | O(n)             | O(1)              |

Kadane's Algorithm is the go-to method when solving this problem optimally.
