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

## Space Complexity Analysis
- **Outer `Set<List<Integer>>`**: Ensures unique quadruplets → `O(no. of unique quadruplets)`.
- **Inner `Set<Long>`**: Tracks seen elements in the third loop → `O(n)`.
- **Final List Storage**: Storing quadruplets → `O(no. of unique quadruplets)`.
- **Overall Space Complexity**: `O(n + unique quadruplets)`.

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
