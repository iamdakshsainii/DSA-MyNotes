# 🚉 **Minimum Platforms Required**

## **Problem Statement**
Given arrival and departure times of trains at a railway station, find the **minimum number of platforms** required so that no train has to wait.

## **Example**
### **Input:**
```java
Arrival = {900, 940, 950, 1100, 1500, 1800};
Departure = {910, 1200, 1120, 1130, 1900, 2000};
```

### **Output:**
```java
3
```

### **Explanation:**
At time `950`, three trains are at the station, requiring **3 platforms**.

---

## **Approach**
1. **Sort both arrival and departure times**.
2. Use **two pointers** (`i` for arrival, `j` for departure) to traverse both arrays.
3. Maintain a `count` for the number of trains currently at the station.
4. If a train arrives (`Arrival[i] <= Departure[j]`), increase `count` and move `i`.
5. If a train departs (`Arrival[i] > Departure[j]`), decrease `count` and move `j`.
6. Keep track of the **maximum** `count` encountered, which is the answer.

---

## **Code Implementation**
```java
import java.util.*;
class Solution {
  public int findPlatform(int[] Arrival, int[] Departure) {
    Arrays.sort(Arrival);
    Arrays.sort(Departure);
    int n = Arrival.length;
    int maxi = Integer.MIN_VALUE;
    int count = 0;
    int j = 0;
    int i = 0;

    while(i < n && j < n){
        if(Arrival[i] <= Departure[j]){
            count++;
            i++;
        }
        else{
            count--;
            j++;
        }
        maxi = Math.max(maxi, count);
    }
    return maxi;
  }
}
```

---

## **Complexity Analysis**
- **Sorting** takes `O(N log N)`.
- **Single pass** through arrays takes `O(N)`.
- **Overall Complexity:** `O(N log N)`.

✅ **Efficient approach using sorting and two pointers!** 🚀

