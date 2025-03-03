# Valid Parenthesis Checker

## Problem Statement
Given a string `s` containing only three types of characters: `'('`, `')'`, and `'*'`, return `true` if `s` is valid.

The following rules define a valid string:
- Any left parenthesis `'('` must have a corresponding right parenthesis `')'`.
- Any right parenthesis `')'` must have a corresponding left parenthesis `'('`.
- Left parenthesis `'('` must go before the corresponding right parenthesis `')'`.
- `'*'` could be treated as a single right parenthesis `')'`, a single left parenthesis `'('`, or an empty string `""`.

---

## Example 1:
**Input:**
`s = "(*)"`

**Output:**
`true`

**Explanation:**
The `'*'` can be replaced by an opening `'('` bracket. The string after replacing `'*'` becomes `"(())"`, which is valid.

---

## Example 2:
**Input:**
`s = "*(())"`

**Output:**
`false`

**Explanation:**
The `'*'` replaced with any bracket does not form a valid string.

---

## Solution - Java Implementation
```java
class Solution {
    public boolean isValid(String s) {
        int minOpen = 0, maxOpen = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else if (c == '*') {
                minOpen--;
                maxOpen++;
            }
            if (maxOpen < 0) return false;
            if (minOpen < 0) minOpen = 0;
        }
        return minOpen == 0;
    }
}
