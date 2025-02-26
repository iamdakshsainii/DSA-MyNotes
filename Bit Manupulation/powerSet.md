# Power Set Using Bit Manipulation

## Approach
1. **Understanding Power Set**:
   - The power set of a given set contains all possible subsets, including the empty set and the set itself.
   - If a set has `n` elements, its power set will have `2^n` subsets.

2. **Using Bit Manipulation**:
   - Every subset can be represented as a binary number ranging from `0` to `2^n - 1`.
   - Each bit in the binary representation determines whether to include the corresponding element in the subset.

3. **Steps**:
   - Find `size = 1 << n` (which is `2^n`), representing the total number of subsets.
   - Iterate over numbers from `0` to `size - 1`.
   - For each number, check which bits are set using `(ele & (1 << i))`.
   - If a bit is set, include the corresponding element in the subset.
   - Add the subset to the result list.

## Code Implementation

```java
import java.util.*;

class Solution {
    public List<List<Integer>> powerSet(int[] nums) {
        int n = nums.length;
        int size = 1 << n; // 2^n subsets
        List<List<Integer>> result = new ArrayList<>();

        for (int ele = 0; ele < size; ele++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((ele & (1 << i)) != 0) { // Check if the i-th bit is set
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
        }
        return result;
    }
}
```

## Complexity Analysis
- **Time Complexity**: `O(n * 2^n)`, since we iterate `2^n` times, and each subset can take `O(n)` time to generate.
- **Space Complexity**: `O(n * 2^n)`, since we store all subsets in the result list.

## Example
```java
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = sol.powerSet(nums);
        System.out.println(subsets);
    }
}
```

**Output:**
```
[[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
```
