## **Intuition Behind the Problem: Maximum Number of Meetings**
The goal of this problem is to schedule the **maximum number of non-overlapping meetings** in a single conference room. Given the **start** and **end** times of `n` meetings, we need to determine the highest number of meetings that can be accommodated without any conflicts.

---

## **Step-by-Step Intuition: How to Approach the Problem**
### 1. **Understanding the Problem Statement:**
- Each meeting has a start and end time.
- A meeting can only be scheduled if there is no overlap with a previously scheduled one.
- We want to maximize the number of meetings.

### 2. **Identifying a Pattern:**
- If we **always pick the meeting that ends the earliest**, we maximize the available time for future meetings.
- This means sorting meetings by their **end times** ensures we take the best possible sequence of meetings.

### 3. **Why Greedy Approach Works?**
- If we **always pick the earliest finishing meeting**, we ensure that we leave as much room as possible for later meetings.
- If we pick a meeting that ends late when an earlier ending one was available, it might block multiple future meetings.
- Hence, **sorting by end time** ensures an optimal solution.

---

## **Understanding the `Comparator` Concept**
In Java, a **Comparator** is used to define a custom sorting order. The default sorting in Java (for numbers or strings) might not always be what we need. For example:
- If we have a list of objects (like meetings), we may want to **sort based on a specific attribute** (e.g., end time).
- A **Comparator** allows us to specify how two elements should be compared.

---

## **When to Use a `Comparator` in Java?**
You should use a `Comparator` when:
1. **You need custom sorting logic.**
   - Example: Sorting objects based on an attribute like price, age, name length, etc.
2. **You need to sort in a specific order.**
   - Example: Sorting in descending order instead of ascending.
3. **You are working with non-primitive data types.**
   - Example: Sorting an array of objects like `Meeting`, `Student`, etc.

---

## **How to Decide When to Use a `Comparator`?**
1. **Look at the problem statement:**
   - If you need to sort based on a specific attribute (not default sorting), use a `Comparator`.
   - Example: In this problem, sorting by **end time** is not the default behavior, so we need a `Comparator`.

2. **Think about the sorting criteria:**
   - If sorting is based on multiple attributes, a `Comparator` helps specify the order.

3. **Check if the default sorting works:**
   - If you're dealing with primitive data types, default sorting (`Arrays.sort()`, `Collections.sort()`) might be enough.
   - If sorting needs a custom rule, use a `Comparator`.

---

## **Java Code Implementation**
```java
import java.util.*;

class Solution {
    // Comparator function to sort meetings based on end times
    static class MeetingComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            // Sort by end time in ascending order
            return Integer.compare(a[1], b[1]);
        }
    }

    // Function to find the maximum number of meetings that can be held
    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        // List to store meetings
        List<int[]> meetings = new ArrayList<>();

        // Fill the meetings list with start and end times
        for (int i = 0; i < n; i++) {
            meetings.add(new int[]{start[i], end[i]});
        }

        // Sort the meetings based on the custom comparator
        Collections.sort(meetings, new MeetingComparator());

        // The end time of last selected meeting
        int limit = meetings.get(0)[1];
        // Initialize count
        int count = 1;

        /*Iterate through the meetings
        to select the maximum number
        of non-overlapping meetings*/
        for (int i = 1; i < n; i++) {
            /*If the current meeting starts
            after the last selected meeting ends*/
            if (meetings.get(i)[0] > limit) {
                /*Update the limit to the end
                time of the current meeting*/
                limit = meetings.get(i)[1];
                // Increment count
                count++;
            }
        }

        // Return count
        return count;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        // Start and end times of the meetings
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        // Get the maximum number of meetings that can be held
        int maxMeetings = obj.maxMeetings(start, end);
        // Output the maximum number of meetings
        System.out.println("Maximum number of meetings: " + maxMeetings);
    }
}
```

---

## **How the Comparator is Used in the Code?**
```java
// Comparator function to sort meetings based on end times
static class MeetingComparator implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        // Sort by end time in ascending order
        return Integer.compare(a[1], b[1]);
    }
}
```
### **Breaking it Down:**
- `implements Comparator<int[]>` → Defines a custom comparator for sorting arrays of integers.
- `compare(int[] a, int[] b)` → Compares two meeting arrays (`a` and `b`).
- `Integer.compare(a[1], b[1])` → Compares the **end times** (`a[1]` and `b[1]`), ensuring sorting in ascending order.

---

## **Final Thought**
- The core idea behind solving **greedy problems** is to **find a sorting strategy** that allows you to take optimal steps.
- In this case, sorting by **end times** ensures the most meetings can be scheduled.
- Whenever a problem involves **sorting non-primitive objects** (like meetings, jobs, or tasks), think about using a **Comparator** to define a custom order.

This thought process will help you **intuitively decide when to use a Comparator in Java**. 🚀
