Two Sum Problem
 Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

# 🧠 Intuition
The Two Sum problem is a classic question that can be solved in multiple ways:
- Brute Force: Check every possible pair.
- Better: Use a HashMap to store visited elements and check if the complement exists.
- Optimal: use matrix [n][2] for store index and element so that index intact and then Sort the array and apply the two-pointer approach.


# 🔸 Method 1: Brute Force (Two Nested Loops)
```java
class Solution {
    public int[] twoSumBruteForce(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
```

---

# 🔸 Method 2: Better Approach (Using HashMap)
```java
import java.util.*;

class Solution {
    public int[] twoSumWithMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
```

---

# 🔸 Method 3: Optimal (Two Pointer + Sorting)
```java
import java.util.Arrays;

public class TwoSumSortedIndices {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        // Step 1: Store value + original index
        int[][] numsWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            numsWithIndex[i][0] = nums[i]; // value
            numsWithIndex[i][1] = i;       // original index
        }

        // Step 2: Sort based on value
        Arrays.sort(numsWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 3: Apply two-pointer logic
        int left = 0, right = n - 1;
        while (left < right) {
            int sum = numsWithIndex[left][0] + numsWithIndex[right][0];
            if (sum == target) {
                int idx1 = numsWithIndex[left][1];
                int idx2 = numsWithIndex[right][1];
                return new int[]{Math.min(idx1, idx2), Math.max(idx1, idx2)};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1}; // If not found
    }

    public static void main(String[] args) {
        TwoSumSortedIndices obj = new TwoSumSortedIndices();
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = obj.twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}

```

---

# ✅ Summary
- Brute Force: Easy but O(n²).
- HashMap: Fast and O(n), but uses extra space.
- Two Pointer: Efficient when array can be sorted (but needs index tracking).

Let me know if you want LeetCode-style I/O method or examples too.
