# Longest Consecutive Sequence

## 🧠 Intuition
The problem requires us to find the **longest consecutive sequence** of numbers in an array.

- **Brute Force Approach (Sorting Method)**:
  - Sort the array and iterate while tracking consecutive sequences.
  - If the difference between adjacent elements is 1, increase the count.
  - If not, reset the count and update the longest sequence length.
  - **Time Complexity**: O(n log n) due to sorting.

- **Optimized Approach (HashSet Method)**:
  - Use a **HashSet** to store unique elements.
  - Iterate through numbers and check if it is the **starting element** of a sequence (i.e., `num - 1` is not in the set).
  - If yes, count the length of the sequence by checking consecutive numbers.
  - **Time Complexity**: O(n), as each number is processed only once.

---

## 🚀 Solution: Sorting Method (O(n log n))
```java
import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        Arrays.sort(nums);
        int longest = 1;
        int count = 1;
        int last = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 == last) {
                count += 1;
            } else if (nums[i] != last) {
                count = 1;
            }
            last = nums[i];
            longest = Math.max(longest, count);
        }
        return longest;
    }
}
```

---

## 🚀 Solution: HashSet Method (O(n))
```java
import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 1;
        for (int num : nums) {
            if (!set.contains(num - 1)) { // Check if it's the start of a sequence
                int count = 1;
                int current = num;
                while (set.contains(current + 1)) {
                    current += 1;
                    count += 1;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}
```

---

## 📌 Comparison of Approaches
| Method | Time Complexity | Space Complexity |
|--------|---------------|----------------|
| Sorting + Iteration | **O(n log n)** | **O(1)** |
| HashSet + Iteration | **O(n)** | **O(n)** |

### ✅ **Best Approach**: HashSet method is **optimal** since it avoids sorting and processes each element **only once**.

🚀 **Use the HashSet approach when solving problems that require efficient lookup of elements!**

