# Problem Statement
Given a string `s`, find the length of the longest substring without repeating characters.

## Example
**Input:** "abcabcbb"
**Output:** 3
**Explanation:** The answer is "abc", with the length of 3.

**Input:** "bbbbb"
**Output:** 1
**Explanation:** The answer is "b", with the length of 1.

---

## Intuition
To determine the length of the longest substring without repeating characters, we need to track characters as we traverse the string. The challenge is to efficiently check for repeating characters while maintaining the longest substring found.

---

## Approach
1. **Iterate through each character:** Start iterating from each index as a potential start of the substring.
2. **Use an array to track characters:** Maintain a `marked` array of size 256 (covering all ASCII characters) to check if a character has been encountered.
3. **Expand the substring:** Move forward until a duplicate character is found.
4. **Update the maximum length:** Keep track of the maximum substring length found so far.
5. **Break on duplicate:** If a duplicate character is encountered, break and restart from the next index.

---

## Code Implementation
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
       int maxlen = 0;
       int n = s.length();

       for (int i = 0; i < n; i++) {
           int[] marked = new int[256]; // Array to track encountered characters

           for (int j = i; j < n; j++) {
               if (marked[s.charAt(j)] == -1) {
                   break; // Stop when a repeating character is found
               } else {
                   maxlen = Math.max(maxlen, j - i + 1);
                   marked[s.charAt(j)] = -1; // Mark character as seen
               }
           }
       }
       return maxlen;
    }
}
```

---

## Complexity Analysis
- **Time Complexity:** O(N^2), as we use nested loops to check all substrings.
- **Space Complexity:** O(1), since the `marked` array size is fixed (256).

---

This approach provides a straightforward brute-force solution to the problem.
Optimized solutions using sliding window and hash sets can further improve efficiency.
