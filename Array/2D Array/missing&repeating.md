# Find Missing and Repeated Values in a Grid

## Problem Statement

Given an `n x n` grid containing numbers from `1` to `n^2`, one number is missing, and another appears twice. We need to identify both.

## Approach 1: Using Frequency Array

1. **Use an array** (`count[]`) to store occurrences of numbers.
2. **Iterate over the grid**, updating the count of each number.
3. **Find the repeating and missing numbers** by checking counts.

### Code

```java
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int n2 = n * n;
        int[] count = new int[n2 + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[grid[i][j]]++;
            }
        }

        int repeating = -1, missing = -1;
        for (int i = 1; i <= n2; i++) {
            if (count[i] == 2) repeating = i;
            else if (count[i] == 0) missing = i;
        }

        return new int[]{repeating, missing};
    }
}
```

## Approach 2: Using HashMap

1. **Use a HashMap** to store counts.
2. **Iterate over the grid**, updating the map.
3. **Find the missing and repeated numbers** by checking key-value pairs.

### Code

```java
import java.util.HashMap;
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int n2 = n * n;
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                countMap.put(grid[i][j], countMap.getOrDefault(grid[i][j], 0) + 1);
            }
        }

        int repeating = -1, missing = -1;
        for (int i = 1; i <= n2; i++) {
            if (countMap.getOrDefault(i, 0) == 2) repeating = i;
            if (!countMap.containsKey(i)) missing = i;
        }

        return new int[]{repeating, missing};
    }
}
```
