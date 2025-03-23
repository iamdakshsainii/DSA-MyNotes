**Problem Statement:**
Given a 0-indexed string s, permute s to get a new string t such that:
- All consonants remain in their original places.
- The vowels must be sorted in nondecreasing order of their ASCII values.

The vowels are 'a', 'e', 'i', 'o', 'u' (both uppercase and lowercase).
Consonants comprise all letters that are not vowels.

**Example 1:**
Input: s = "lEetcOde"
Output: "lEOtcede"
Explanation: 'E', 'O', and 'e' are the vowels in s; 'l', 't', 'c', and 'd' are all consonants. The vowels are sorted according to their ASCII values, and the consonants remain in the same places.

**Approach / Intuition:**
1. **Identify vowels**: Iterate through the string and collect all vowels while maintaining consonants in their original positions.
2. **Sort vowels**: Sort the collected vowels based on ASCII values.
3. **Replace vowels in the original string**: Traverse the string again, replacing vowels in their original positions with sorted ones.

**Method 1: Using ArrayList**

```java
class Solution {
    public String sortVowels(String s) {
        int n = s.length();
        ArrayList<Character> totalvowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        ArrayList<Character> vowels = new ArrayList<>();

        // Step 1: Collect vowels
        for (int i = 0; i < n; i++) {
            if (totalvowels.contains(s.charAt(i))) {
                vowels.add(s.charAt(i));
            }
        }

        // Step 2: Sort vowels
        Collections.sort(vowels);

        // Step 3: Replace vowels in sorted order
        int index = 0;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            if (totalvowels.contains(s.charAt(i))) {
                sb.setCharAt(i, vowels.get(index));
                index++;
            }
        }
        return sb.toString();
    }
}
```

**Method 2: Using Array**

```java
class SolutionArray {
    boolean isVowel(char c, char[] totalvowels, int n) {
        for (int i = 0; i < n; i++) {
            if (c == totalvowels[i]) {
                return true;
            }
        }
        return false;
    }

    public String sortVowels(String s) {
        int n = s.length();
        char[] totalvowels = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        char[] vowels = new char[n];
        int index2 = 0;

        // Step 1: Collect vowels
        for (int i = 0; i < n; i++) {
            if (isVowel(s.charAt(i), totalvowels, totalvowels.length)) {
                vowels[index2++] = s.charAt(i);
            }
        }

        // Step 2: Sort vowels
        Arrays.sort(vowels, 0, index2);

        // Step 3: Replace vowels in sorted order
        int index = 0;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            if (isVowel(s.charAt(i), totalvowels, totalvowels.length)) {
                sb.setCharAt(i, vowels[index]);
                index++;
            }
        }
        return sb.toString();
    }
}
```
