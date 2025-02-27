# Sorting 2D Array and HashMap in Java - Quick Revision

## **Sorting a 2D Array**
Sorting a 2D array in Java can be done using `Arrays.sort()` with a custom comparator.

### **Sorting by a Specific Column**
```java
import java.util.Arrays;

public class Sort2DArray {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 4, 20},
            {2, 1, 10},
            {3, 2, 40},
            {4, 3, 30}
        };

        // Sort by 3rd column (index 2) in descending order
        Arrays.sort(arr, (a, b) -> b[2] - a[2]);

        // Print sorted array
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}
```

### **Sorting in Ascending Order (Example: First Column)**
```java
Arrays.sort(arr, (a, b) -> a[0] - b[0]);
```

### **Sorting by Multiple Conditions**
Sort by **first column** (ascending), then **third column** (descending):
```java
Arrays.sort(arr, (a, b) -> a[0] == b[0] ? b[2] - a[2] : a[0] - b[0]);
```

---

## **Sorting a HashMap**
### **Sorting by Keys**
```java
import java.util.*;

public class SortHashMapByKey {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(3, "C");
        map.put(1, "A");
        map.put(2, "B");

        // Sort by key
        Map<Integer, String> sortedMap = new TreeMap<>(map);
        System.out.println(sortedMap);
    }
}
```

### **Sorting by Values**
```java
import java.util.*;

public class SortHashMapByValue {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Apple", 50);
        map.put("Banana", 20);
        map.put("Mango", 30);

        // Sort by value
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> a.getValue() - b.getValue());

        // Convert back to LinkedHashMap to maintain order
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        System.out.println(sortedMap);
    }
}
```

---
