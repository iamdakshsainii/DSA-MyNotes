# **Using Comparator in Java**

## **1. Creating a Separate Comparator Class**

```java
import java.util.*;

// Custom Comparator class to sort meetings based on end time
class MeetingComparator implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        return Integer.compare(a[1], b[1]); // Sort by end time
    }
}
```

### **Explanation:**

- The class implements `Comparator<int[]>`.
- The `compare()` method defines **how** to compare two elements.
- It sorts the meetings based on their **end times in ascending order**.

---

## **2. Using the Comparator in Sorting**

```java
Collections.sort(meetings, new MeetingComparator());
```

### **Explanation:**

- `Collections.sort()` takes a **list** and a **Comparator instance**.
- The list is sorted using the logic inside `MeetingComparator`.

---

## **3. Alternative: Using an Anonymous Class**

Instead of a separate class, you can directly use an **anonymous inner class**:

```java
Collections.sort(meetings, new Comparator<int[]>() {
    public int compare(int[] a, int[] b) {
        return Integer.compare(a[1], b[1]);
    }
});
```

### **Explanation:**

- This defines the comparator **inline** inside `Collections.sort()`.
- It works the same way but avoids creating a separate class.

---

## **4. Alternative: Using a Lambda Expression (Modern Approach)**

```java
Collections.sort(meetings, (a, b) -> Integer.compare(a[1], b[1]));
```

### **Explanation:**

- This is the **simplest** and most **readable** approach.
- Java **infers** that `a` and `b` are `int[]`, so no need to write a full class or method.

