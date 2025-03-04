## Non-Overlapping Intervals - Two Methods

### Intuition
The problem is similar to the **N Meetings in One Room** problem, where we select meetings that do not overlap by sorting based on end times. However, here, instead of counting the maximum number of non-overlapping intervals, we need to remove overlapping ones to make them non-overlapping. The idea remains the same: sort by the ending time and track the last selected interval.

---

**(Similar to N Meetings)**
you can understand by this hum ne meeting m bhi yhi kaam kiya tha non overlapping pr hi ja rhe the bs hum overalpping htne h yha to non overlapping nikl lo and remove from total


### Method 1: Greedy Approach (Similar to N Meetings)
```java
import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1])); // Sort by end time

        int count = 1; // Count of non-overlapping intervals
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= lastEnd) { // If no overlap, take it
                count++;
                lastEnd = intervals[i][1];
            }
        }

        return intervals.length - count; // Remove overlapping intervals
    }
}
```

---

### Method 2: Comparator-based Sorting
```java
import java.util.*;

class Solution {
    public class mcomparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[1], b[1]);
        }
    }

    public int MaximumNonOverlappingIntervals(int[][] Intervals) {
        int n = Intervals.length;
        int cnt = 0;
        if (n == 0) return 0;
        Arrays.sort(Intervals, new mcomparator());
        int endtime = Intervals[0][1];
        for (int i = 1; i < n; i++) {
            int starttime = Intervals[i][0];
            if (starttime < endtime) {
                cnt++;
            } else {
                endtime = Intervals[i][1];
            }
        }
        return cnt;
    }
}
