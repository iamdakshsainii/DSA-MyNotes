# 844. Backspace String Compare

vese to ye rule man lo ki jab bhi pop karo to first check is empty case and return false else pop but here it is not the case we only go to not empty then pop

## Problem Description

Given two strings `s` and `t`, return `true` if they are equal when both are typed into empty text editors. `#` means a backspace character.

**Note:** After backspacing an empty text, the text will remain empty.

### Example:

```
Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
```

---

## Intuition

To simulate typing with backspaces, we can use a **Stack**. Every time we encounter a character, we push it. If we encounter `#`, we pop from the stack (if it's not empty). This way, we build the final result of the typed string.

---

## Approach

1. Use a stack to simulate typing `s`.
2. Use the same approach for `t`.
3. Compare both resulting strings.

---

## Code

```java
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch != '#') {
                st.push(ch);
            } else {
                if (!st.isEmpty()) st.pop();
            }
        }

        String str1 = "";
        while (!st.isEmpty()) {
            str1 += st.peek();
            st.pop();
        }

        for (char ch : t.toCharArray()) {
            if (ch != '#') {
                st.push(ch);
            } else {
                if (!st.isEmpty()) st.pop();
            }
        }

        String str2 = "";
        while (!st.isEmpty()) {
            str2 += st.peek();
            st.pop();
        }

        return str1.equals(str2);
    }
}
```

---

## Complexity

* **Time Complexity:** `O(n + m)` — where `n` and `m` are lengths of `s` and `t`
* **Space Complexity:** `O(n + m)` — for storing final characters in stacks

---

## Key Takeaways

* Stack is useful when handling **backtracking**, **undo**, or **removal** problems like this.
* Always handle `#` as a pop operation **only if** the stack isn't empty.
