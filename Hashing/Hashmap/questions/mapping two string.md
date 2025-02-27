## Isomorphic Strings

### Problem Statement

Given two strings `s` and `t`, determine if they are **isomorphic**.

Two strings `s` and `t` are isomorphic if the characters in `s` can be replaced to get `t`.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

### Example 1:

**Input:**

```plaintext
s = "egg", t = "add"
```

**Output:**

```plaintext
true
```

---

### Approach

- **Use Two HashMaps:**
  - One for mapping characters from `s` to `t` (`mpp1`).
  - Another for mapping characters from `t` to `s` (`mpp2`).
- **Iterate Over the Strings:**
  - If a character is encountered for the first time, store the mapping.
  - If a character mapping exists, verify that it matches the expected value.
  - If any inconsistency is found, return `false`.

### Java Solution

```java
import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
         HashMap<Character, Character> mpp1 = new HashMap<>();
         HashMap<Character, Character> mpp2 = new HashMap<>();

         for(int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            char s2 = t.charAt(i);

            if(!mpp1.containsKey(s1)) {
                mpp1.put(s1, s2);
            } else {
                if(mpp1.get(s1) != s2) {
                    return false;
                }
            }

            if(!mpp2.containsKey(s2)) {
                mpp2.put(s2, s1);
            } else {
                if(mpp2.get(s2) != s1) {
                    return false;
                }
            }
         }
         return true;
    }
}
```

---

### Complexity Analysis

- **Time Complexity:** `O(N)`, where `N` is the length of the string.
- **Space Complexity:** `O(1)`, since there are only 26 characters in the alphabet.

This solution efficiently determines if two strings are isomorphic using **two HashMaps** to track character mappings in both directions.

