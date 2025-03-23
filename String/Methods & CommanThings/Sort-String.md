# Sorting a String in Java

## Problem Statement:

Given a string consisting of lowercase English letters, the goal is to return the string sorted in lexicographical order.

---

## Example:

**Input:** "coding"

**Output:** "cdgino"

---

## Approach & Intuition:

### **Method 1: Counting Sort (Optimized for Lowercase Letters)**

1. **Character Frequency Array**:
   - Create an array `cnt[26]` to store the frequency of each character (since we are dealing with lowercase letters only).
   - Iterate through the string and update the frequency of each character.
2. **Reconstruct Sorted String**:
   - Iterate through the frequency array in order (from 'a' to 'z').
   - Append each character to the result string based on its occurrence count.
3. **Time Complexity:**
   - **O(n + 26) ≈ O(n)** (since iterating over 26 letters is constant-time)
   - **Space Complexity:** O(1) (fixed size auxiliary array)

```java
class Solution  {
    String sort(String s)  {
        int n = s.length();
        int[] cnt = new int[26];

        // Count frequency of each character
        for(int i = 0; i < n; i++){
            cnt[s.charAt(i) - 'a']++;
        }

        // Build sorted string
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < 26; i++){
           char ch = (char)('a' + i); // Convert index back to character
             for(int j = 0; j < cnt[i]; j++){ // Append character cnt[i] times
                ans.append(ch);
    }
}


        return ans.toString();
    }
}
```

---

### **Method 2: Sorting Using Arrays.sort()**

1. **Convert String to Character Array:**
   - Use `toCharArray()` to convert the string into a character array.
2. **Sort the Array:**
   - Use `Arrays.sort()` which internally uses **Dual-Pivot QuickSort** (O(n log n)).
3. **Convert Back to String:**
   - Return the new sorted string using `new String(sortedArray)`.
4. **Time Complexity:** O(n log n) (sorting step)
   - **Space Complexity:** O(n) (due to array creation)

```java
import java.util.*;
class Solution  {
    String sort(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}
```

---

## **Comparison of Methods**

| Method        | Time Complexity | Space Complexity | Suitable For                               |
| ------------- | --------------- | ---------------- | ------------------------------------------ |
| Counting Sort | O(n)            | O(1)             | When input contains only lowercase letters |
| Arrays.sort() | O(n log n)      | O(n)             | General cases, works for any character set |

### **Key Takeaways:**

- **Counting Sort is faster (O(n))** but only works for **fixed character sets (lowercase letters).**
- **Arrays.sort() is versatile** and works for **any character set**, but has **O(n log n) complexity**.

Use **Counting Sort** when the character set is limited; otherwise, **use built-in sorting for simplicity.** 🚀

