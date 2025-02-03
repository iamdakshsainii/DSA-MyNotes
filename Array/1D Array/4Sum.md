# Four Sum Problem (Using HashSet for Unique Quadruplets)
Make sure ki tum kaha set declare krte ho jo 4th number or 3rd number in 3sum store krega for check - it declare in last 2 bw last 2 loops which means ki last 2 pointers responsible and last pointers mid vlaues stored in hashset

## Problem Statement
Given an integer array `nums` and an integer `target`, return all **unique quadruplets** `[a, b, c, d]` such that:

\[
a + b + c + d = target
\]

## Approach
1. **Use Three Nested Loops**: Iterate through the array to pick the first three elements.
2. **Use a HashSet**: Store previously seen elements to find the fourth element efficiently.
3. **Sort and Store Unique Quadruplets**: Add quadruplets to a `Set` to avoid duplicates.

##  Complexity Analysis
# **Complexity Analysis of Four Sum Algorithm**

## **Time Complexity Analysis**
### **1. Three Nested Loops: `O(N³)`**
- The **first loop** runs `N` times.
- The **second loop** runs `N-1` times.
- The **third loop** runs `N-2` times.
- **Total iterations**:
  \[
  O(N) \times O(N) \times O(N) = O(N^3)
  \]

### **2. Operations on Set: `O(log M)`**
- Inside the innermost loop, we use a `Set<Long>` (hashset) to store elements and check if a required element (`fourth` value) exists.
- The lookup and insert operations in a `HashSet` are **O(1) on average**, but in some cases (if using **TreeSet** or a balanced BST-based Set), it can be **O(log M)**.
- Since `M` is the number of elements stored in the set, the worst-case time complexity per iteration is **O(log M)**.

### **Final Time Complexity**
\[
O(N^3 \times \log M)
\]
where:
- `N` is the size of the array.
- `M` is the number of elements in the set (can be at most `N` in the worst case).

---

## **Space Complexity Analysis**
### **1. Space for Storing Unique Quadruplets: `O(2 × no. of quadruplets)`**
- We use a **Set<List<Integer>>** to store unique quadruplets.
- We also use a **List<List<Integer>>** to return the final result.
- In the worst case, if we have `Q` unique quadruplets, the space taken will be:
  \[
  O(2Q) = O(Q)
  \]

### **2. Space for Storing Array Elements: `O(N)`**
- The `HashSet<Long>` used inside the loops stores **at most `N` elements** (one for each number in the array).
- The worst case occurs when all elements are distinct.
- Space taken:
  \[
  O(N)
  \]

### **Final Space Complexity**
\[
O(Q) + O(N)
\]
where:
- `Q` is the number of unique quadruplets.
- `N` is the number of elements in the array.

---

## **Summary**
| Complexity | Breakdown | Final Complexity |
|------------|-----------|-----------------|
| **Time Complexity** | 3 nested loops (`O(N³)`) + set operations (`O(log M)`) | **O(N³ × log M)** |
| **Space Complexity** | Storing quadruplets (`O(Q)`) + storing array elements (`O(N)`) | **O(Q + N)** |

This breakdown clarifies the computational requirements for solving the **Four Sum** problem efficiently. 🚀



## Code Implementation (Java)
```java
import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        // Set to store unique quadruplets
        Set<List<Integer>> set = new HashSet<>();

        // Checking all possible quadruplets
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Set to store elements seen so far in the loop
                Set<Long> hashset = new HashSet<>();

                for (int k = j + 1; k < n; k++) {

                    long sum = (long) nums[i] + nums[j] + nums[k];
                    long fourth = target - sum;

                    if (hashset.contains(fourth)) {
                        // Found a quadruplet that sums up to target
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int) fourth);
                        Collections.sort(temp);
                        set.add(temp);
                    }

                    // Insert the kth element into hashset for future checks
                    hashset.add((long) nums[k]);
                }
            }
        }

        // Convert set to list (unique quadruplets)
        ans.addAll(set);
        return ans;
    }
}
```

### Optimal
```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        // Sort the input array nums
        Arrays.sort(nums);

        // Iterate through the array to find quadruplets
        for (int i = 0; i < n; i++) {
            // Skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < n; j++) {
                // Skip duplicates for j
                if (j > i + 1 && nums[j] == nums[j - 1])
                
                    continue;

                // Two pointers approach
                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        // Found a quadruplet that sums up to target
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        ans.add(temp);

                        // Skip duplicates for k and l
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return ans;
    }
}
```
