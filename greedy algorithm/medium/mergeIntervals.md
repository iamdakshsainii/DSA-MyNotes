# Merge Intervals - Java Solutions

## Quick Revision

### **1. Use of ****`Arrays.copyOf()`**

- Used to create a new array with the specified length from an existing array.
- Example:
  ```java
  int[] arr = {1, 2, 3, 4, 5};
  int[] newArr = Arrays.copyOf(arr, 3); // newArr = {1, 2, 3}
  ```

### **2. Converting List to 2D Array**

- `toArray(new int[list.size()][])` converts a `List<int[]>` to a `2D int` array.
- Example:
  ```java
  List<int[]> list = new ArrayList<>();
  list.add(new int[]{1, 2});
  list.add(new int[]{3, 4});
  int[][] array = list.toArray(new int[list.size()][]);
  ```

## Problem Statement

Given an array of `intervals` where `intervals[i] = [starti, endi]`, merge all overlapping intervals and return an array of the non-overlapping intervals that cover all the intervals in the input.

### **Example:**

```java
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Intervals [1,3] and [2,6] overlap, so they are merged into [1,6].
```

## Method 1: In-Place Merging

### **Approach:**

1. **Sort** the intervals based on the start value.
2. **Iterate** through the intervals:
   - If the current interval overlaps with the previous one, merge them.
   - Otherwise, move to the next interval.
3. **Return the merged intervals** using `Arrays.copyOf()`.

### **Java Code:**

```java
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        int first = 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length;

        for (int i = 1; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[first][1];

            if (start <= end) {
                intervals[first][1] = Math.max(intervals[first][1], intervals[i][1]);
            } else {
                first++;
                intervals[first] = intervals[i];
            }
        }
        return Arrays.copyOf(intervals, first + 1);
    }
}
```

### **Time Complexity:**

- Sorting takes **O(n log n)**.
- The merging process runs in **O(n)**.
- **Overall Complexity:** **O(n log n)**.

---

## Method 2: Using a List

### **Approach:**

1. **Sort** the intervals based on the start value.
2. **Use a List** to store merged intervals dynamically.
3. **Iterate** through the intervals:
   - If the interval overlaps, merge it.
   - Otherwise, add it to the list.
4. **Convert the list to a 2D array** and return.

### **Java Code:**

```java
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];

            if (ans.get(ans.size() - 1)[1] >= start) {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
            } else {
                ans.add(intervals[i]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
```

### **Time Complexity:**

- Sorting takes **O(n log n)**.
- The merging process runs in **O(n)**.
- **Overall Complexity:** **O(n log n)**.

---

## Method 3: Optimized List Approach

### **Approach:**

1. **Sort** the intervals based on the start value.
2. **Use a List** to store merged intervals dynamically.
3. **Use a separate variable (`end`)** to track the last interval being merged.
4. **Iterate** through the intervals:
   - If the interval overlaps, merge it.
   - Otherwise, add it to the list and update `end`.
5. **Convert the list to a 2D array** and return.

### **Java Code:**

```java
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        int[] end = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];

            if (end[1] >= start) {
                end[1] = Math.max(end[1], intervals[i][1]);
            } else {
                ans.add(end);
                end = intervals[i];
            }
        }
        ans.add(end);
        return ans.toArray(new int[ans.size()][]);
    }
}
```

### **Time Complexity:**

- Sorting takes **O(n log n)**.
- The merging process runs in **O(n)**.
- **Overall Complexity:** **O(n log n)**.

---

