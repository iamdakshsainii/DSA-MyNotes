## Revision Purpose
Check all Approches
- jha bhi check aur quick lookup ki baat ati hai vha hashing or hashmap vgrah use karo
- jaha duplicate or repaet aye xor and sum vala case jarur socho

## link-  https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/

### Problem: Find the Missing and Repeating Number in Array
**Link:** [GFG Problem](https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/)

**Problem Statement:**
Given an array of size `N` containing numbers from `1` to `N`. One number `A` is repeating twice and one number `B` is missing. Task is to find `A` (repeating) and `B` (missing).

### ✅ Approaches:
1. Brute Force (Nested Loop / Count Based)
2. Hashing with HashSet
3. XOR Approach
4. Sum-Based Mathematical Approach

---

### 🔸 Approach 1: Brute Force (Nested Loop)
**Time Complexity:** O(N²)
**Space Complexity:** O(1)

```java
import java.util.ArrayList;

public class RepeatingAndMissing1 {
    public static ArrayList<Integer> findMissingRepeatingNumbers(int[] a) {
        int n = a.length;
        int repeating = -1, missing = -1;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (a[j] == i) cnt++;
            }
            if (cnt == 2) repeating = i;
            else if (cnt == 0) missing = i;

            if (repeating != -1 && missing != -1)
                break;
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeating);
        result.add(missing);
        return result;
    }
}
```

---

### 🔸 Approach 2: Hashing using HashSet
**Time Complexity:** O(N)
**Space Complexity:** O(N)

```java
import java.util.*;

public class RepeatingAndMissing2 {
    public static ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        int repeating = -1;
        int missing = -1;

        for (int i = 0; i < n; i++) {
            if (set.contains(arr[i])) {
                repeating = arr[i];
            } else {
                set.add(arr[i]);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeating);
        result.add(missing);
        return result;
    }
}
