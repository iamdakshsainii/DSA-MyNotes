## Longest Special Substring Occurring at Least Thrice

### Problem Statement

You are given a string `s` that consists of lowercase English letters.

A string is called **special** if it is made up of only a single character. For example:
- The string "abc" is **not** special.
- The strings "ddd", "zz", and "f" are special.

Return the length of the **longest special substring** of `s` which occurs at least **thrice**, or `-1` if no special substring occurs at least thrice.

### Example 1:

**Input:**
```plaintext
s = "aaaa"
```

**Output:**
```plaintext
2
```

**Explanation:**
The longest special substring which occurs thrice is "aa": substrings "aaaa", "aaaa", and "aaaa". It can be shown that the maximum length achievable is `2`.

---

### Example 2:

**Input:**
```plaintext
s = "abcdef"
```

**Output:**
```plaintext
-1
```

**Explanation:**
There exists no special substring which occurs at least thrice. Hence, return `-1`.

---

### Example 3:

**Input:**
```plaintext
s = "abcaba"
```

**Output:**
```plaintext
1
```

**Explanation:**
The longest special substring which occurs thrice is "a": substrings "abcaba", "abcaba", and "abcaba".

---

### Approach

1. **Use a HashMap to Count Substring Occurrences:**
   - Iterate through each character as a starting point.
   - Expand to form substrings while ensuring all characters are the same.
   - Store these substrings in a HashMap with their counts.
2. **Find the Longest Special Substring Occurring at Least Thrice:**
   - Iterate through the HashMap to find the longest substring that appears at least 3 times.
   - If no such substring exists, return `-1`.

### Java Solution

```java
import java.util.HashMap;

class Solution {
    public int maximumLength(String s) {
        HashMap<String, Integer> mpp = new HashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == ch) {
                    String substring = s.substring(i, j + 1);
                    mpp.put(substring, mpp.getOrDefault(substring, 0) + 1);
                } else {
                    break;
                }
            }
        }

        int maxlen = -1;
        for (String substr : mpp.keySet()) {
            if (mpp.get(substr) >= 3) {
                maxlen = Math.max(maxlen, substr.length());
            }
        }

        return maxlen;
    }
}
```

---

### Dry Run (Example: `s = "aaaa"`)

#### Step 1: Building the HashMap

| Iteration (i, j) | Substring | Frequency |
|---|---|---|
| (0,0) | "a" | 1 |
| (0,1) | "aa" | 1 |
| (0,2) | "aaa" | 1 |
| (0,3) | "aaaa" | 1 |
| (1,1) | "a" | 2 |
| (1,2) | "aa" | 2 |
| (1,3) | "aaa" | 2 |
| (2,2) | "a" | 3 |
| (2,3) | "aa" | 3 |
| (3,3) | "a" | 4 |

#### Step 2: Finding the Longest Special Substring
- "a" appears `4` times (valid, length = `1`).
- "aa" appears `3` times (valid, length = `2`).
- "aaa" appears `2` times (not valid).
- "aaaa" appears `1` time (not valid).
- The maximum length among valid substrings is `2`.

#### Final Output: `2`

---

### Complexity Analysis

- **Time Complexity:** `O(N^3)`, where `N` is the length of the string.
  - The outer loop runs `O(N)`,
  - The inner loop runs `O(N)`,
  - Substring creation takes `O(N)`, leading to `O(N^3)` in total.
- **Space Complexity:** `O(N^2)`, since substrings are stored in the HashMap.

This brute-force approach is inefficient for large inputs. Optimized solutions using **Suffix Arrays, Hashing, or Binary Search with Frequency Counting** can reduce complexity.

