**Problem Statement:**
Given a string s, find the length of the longest substring without repeating characters.

**Examples**:
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

**Example 2**:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

**Example 3**:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

**Intuition**:
The problem requires us to find the longest contiguous substring with unique characters.
A brute force approach would be to iterate over all substrings and check for uniqueness,
but an optimized approach using a sliding window can be used to improve efficiency.

Code:
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxlen = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < n; j++) {
                if (sb.indexOf(String.valueOf(s.charAt(j))) == -1) {
                    sb.append(s.charAt(j));
                    maxlen = Math.max(maxlen, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return maxlen;
    }
}
```
