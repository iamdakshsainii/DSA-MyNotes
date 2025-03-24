**Problem: Longest Substring Without Repeating Characters**
Given a string s, find the length of the longest substring without repeating characters.
LeetCode Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/

**Example 1:**
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

**Example 2:**
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.


**Approach 1: Using boolean[256] (Optimized for ASCII characters)**
```java
class LongestSubstringBooleanArray {
    public int longestNonRepeatingSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0, maxLength = 0;
        boolean[] visited = new boolean[256];  // ASCII character set

        while (right < n) {
            while (visited[s.charAt(right)]) {  // If character already visited
                visited[s.charAt(left)] = false;
                left++;
            }
            visited[s.charAt(right)] = true;
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
```

**Approach 2: Using HashSet (More flexible, handles Unicode)**
```java
import java.util.HashSet;

class LongestSubstringHashSet {
    public int longestNonRepeatingSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0, maxLength = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < n) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
```
