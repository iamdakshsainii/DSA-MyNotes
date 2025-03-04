## **Pairing Up Elements Using List of Arrays in Java**

### **Using a List of Arrays (`List<int[]>`)**
- **Best when pairing numbers without extra fields**
- **Simple but less readable**

#### **Example Code:**
```java
import java.util.*;

public class PairingExample {
    public static void main(String[] args) {
        // Creating a list to store pairs of numbers
        List<int[]> meetings = new ArrayList<>();

        // Adding pairs (start time, end time)
        meetings.add(new int[]{1, 2});
        meetings.add(new int[]{3, 4});
        meetings.add(new int[]{5, 6});

        // Iterating and printing the pairs
        for (int[] meeting : meetings) {
            System.out.println("Start: " + meeting[0] + ", End: " + meeting[1]);
        }
    }
}
```

### **Example: Maximum Number of Meetings**
```java
import java.util.*;

class Solution {
    static class MeetingComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[1], b[1]);
        }
    }

    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        List<int[]> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new int[]{start[i], end[i]});
        }
        Collections.sort(meetings, new MeetingComparator());
        int limit = meetings.get(0)[1];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (meetings.get(i)[0] > limit) {
                limit = meetings.get(i)[1];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        int maxMeetings = obj.maxMeetings(start, end);
        System.out.println("Maximum number of meetings: " + maxMeetings);
    }
}
```

### **Key Points:**
✅ **Fast and easy to implement**
✅ **Useful when working with simple pairs**
❌ **Less readable than using a custom class**

---
Using a **custom class** is better when we need more readability and flexibility, but `List<int[]>` is good for quick solutions.
