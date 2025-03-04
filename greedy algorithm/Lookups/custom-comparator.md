# **Using Comparator in Java**
When to Use Comparator?
📌 When sorting objects based on custom logic (like sorting meetings by end time).
📌 When sorting primitive data types stored in custom structures (like sorting a list of Pair objects).
📌 When the default sorting (Comparable) isn’t sufficient (e.g., sorting by multiple fields).


## Sorting and Pairing in Java: List vs Array

## 1️⃣ Using `List<int[]>` (Array Inside List)
### When to Use?
- When we need to store **pairs of values** like (start time, end time) for meetings.
- When we need **dynamic resizing**.
- When using **sorting with comparators**.

### Code Example: Maximum Meetings
```java
import java.util.*;

class Solution {
    // Comparator function to sort meetings based on end times
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

---

## 2️⃣ Using a Custom Class (Recommended)
### When to Use?
- When each element **has multiple attributes** (e.g., id, deadline, profit).
- When sorting based on **multiple criteria**.

### Code Example: Job Sequencing Problem
```java
import java.util.*;

class Job {
    int id, deadline, profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

// Comparator to sort jobs by profit in descending order
class ProfitComparator implements Comparator<Job> {
    public int compare(Job a, Job b) {
        return Integer.compare(b.profit, a.profit); // Descending order
    }
}

public class JobSequencing {
    public static int maxProfit(Job[] jobs, int n) {
        Arrays.sort(jobs, new ProfitComparator());

        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        int[] schedule = new int[maxDeadline + 1];
        Arrays.fill(schedule, -1);

        int totalProfit = 0, count = 0;

        for (Job job : jobs) {
            for (int j = job.deadline; j > 0; j--) {
                if (schedule[j] == -1) {
                    schedule[j] = job.id;
                    totalProfit += job.profit;
                    count++;
                    break;
                }
            }
        }

        System.out.println("Total Jobs Done: " + count);
        System.out.println("Total Profit: " + totalProfit);
        return totalProfit;
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job(1, 2, 100),
            new Job(2, 1, 19),
            new Job(3, 2, 27),
            new Job(4, 1, 25),
            new Job(5, 3, 15)
        };

        maxProfit(jobs, jobs.length);
    }
}
```

---

## 🔥 Key Takeaways
✅ **List<int[]>** is useful for **storing pairs** and **sorting efficiently**.
✅ **Custom Class + Comparator** is best for **multi-attribute sorting** (like profit-based job sequencing).
✅ **Use Comparator when sorting needs a custom rule (e.g., descending profit, ascending end time, etc.)**.

