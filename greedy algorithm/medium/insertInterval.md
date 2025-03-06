# Insert Interval Problem

## Problem Statement

You are given an array of non-overlapping intervals `intervals`, where `intervals[i] = [start_i, end_i]`, representing the start and end of an interval. You are also given an interval `newInterval = [start, end]` that needs to be inserted into `intervals` while ensuring that the final list of intervals remains non-overlapping and sorted.

Return the updated list of intervals after merging, if necessary.

### Constraints:

- `0 <= intervals.length <= 10^4`
- `intervals[i].length == 2`
- `newInterval.length == 2`
- `intervals` are sorted based on the start value.
- `newInterval` may overlap with one or more intervals.

## Example

### **Input:**

```java
intervals = {{1,3}, {6,9}};
newInterval = {2,5};
```

### **Output:**

```java
{{1,5}, {6,9}}
```

## Solution

### **Approach**

1. **Initialize a list** to store the merged intervals.
2. **Iterate through the intervals** in three phases:
   - Add all intervals that come **before** the new interval.
   - Merge all **overlapping intervals**.
   - Add all intervals that come **after** the merged interval.
3. **Convert the list** back to an array and return the result.

### **Java Implementation**

```java
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> li = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        // Add non-overlapping intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            li.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        li.add(newInterval);

        // Add remaining intervals after newInterval
        while (i < n) {
            li.add(intervals[i]);
            i++;
        }

        return li.toArray(new int[li.size()][]);
    }
}
```

### **Complexity Analysis**

- **Time Complexity:** `O(N)`, where `N` is the number of intervals.
- **Space Complexity:** `O(N)`, as we store the intervals in a list.

### **Edge Cases Considered**

| Case                       | Input                                             | Expected Output         |
| -------------------------- | ------------------------------------------------- | ----------------------- |
| New interval before all    | `intervals = {{3,6}}, newInterval = {1,2}`        | `{{1,2}, {3,6}}`        |
| New interval after all     | `intervals = {{1,3}}, newInterval = {4,5}`        | `{{1,3}, {4,5}}`        |
| New interval overlaps all  | `intervals = {{1,2}, {3,5}}, newInterval = {0,6}` | `{{0,6}}`               |
| New interval in the middle | `intervals = {{1,2}, {5,7}}, newInterval = {3,4}` | `{{1,2}, {3,4}, {5,7}}` |

