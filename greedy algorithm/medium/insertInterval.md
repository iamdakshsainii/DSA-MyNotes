# Insert Interval Problem

## Problem Statement
Given a set of non-overlapping intervals sorted by their start time, insert a new interval into the list (merge if necessary).

### **Example**
```plaintext
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
```

---

## **Solution Steps**

### **Step 1: Add Non-Overlapping Intervals**
**Condition:** Add intervals that end before `newInterval[0] (4)`.

#### **Check `[1,2]`**
- `2 < 4` ✅ **(No overlap) → Add `[1,2]` to result.**
- **Array after adding:** `[[1,2]]`
- **Move to next interval `[3,5]`.**

#### **Check `[3,5]`**
- `5 >= 4` ❌ **(Overlaps with `[4,8]`) → Stop adding and move to merging.**
- **Remaining Intervals to check:** `[[3,5], [6,7], [8,10], [12,16]]`

---

### **Step 2: Merge Overlapping Intervals**
**Condition:** If `newInterval[1] >= intervals[i][0]`, merge them.

#### **Check `[3,5]`**
- `8 >= 3` ✅ **(Overlap) → Merge `[3,5]` into `[4,8]`.**
- **New Merged Interval:** `[min(4,3), max(8,5)] = [3,8]`
- **Move to next interval `[6,7]`.**

#### **Check `[6,7]`**
- `8 >= 6` ✅ **(Overlap) → Merge `[6,7]` into `[3,8]`.**
- **New Merged Interval:** `[min(3,6), max(8,7)] = [3,8]`
- **Move to next interval `[8,10]`.**

#### **Check `[8,10]`**
- `8 >= 8` ✅ **(Overlap) → Merge `[8,10]` into `[3,8]`.**
- **New Merged Interval:** `[min(3,8), max(8,10)] = [3,10]`
- **Move to next interval `[12,16]`.**

#### **Check `[12,16]`**
- `8 >= 12` ❌ **(No overlap) → Stop merging.**
- **Final merged interval:** `[3,10]`

✅ **Array after merging:** `[[1,2], [3,10]]`

---

### **Step 3: Add Remaining Non-Overlapping Intervals**
Now, add intervals **after merging**.

#### **Add `[12,16]`**
- **No overlap → Add it directly.**
- **Final array:** `[[1,2], [3,10], [12,16]]`

---

## **Final Output**
```plaintext
[[1,2], [3,10], [12,16]]
```

---

## **Java Code Implementation**
```java
import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0, n = intervals.length;

        // Step 1: Add all non-overlapping intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Step 3: Add remaining non-overlapping intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        int[][] result = sol.insert(intervals, newInterval);

        System.out.println("Output:");
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
```

