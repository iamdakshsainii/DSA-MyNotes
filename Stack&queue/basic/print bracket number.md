# 🔹 Print Bracket Number (Easy)

## 📊 Problem Statement

Given a string `str`, return the bracket number for each parenthesis. Each pair of matching brackets (opening and closing) is assigned a number based on their **position** in the string.

### A bracket pair is numbered by the order in which its **opening** bracket appears.

---

## 💡 Intuition

Every time we find an opening bracket `(`, assign it a number and **push** it onto a stack. When we find a closing bracket `)`, we just **pop** the last number from the stack and assign it to that closing bracket.

---

## ⚖️ Approach

* Traverse each character of the string.
* Use a **stack** to track unmatched opening brackets.
* For every `'('`, increment a counter and push it to the stack.
* For every `')'`, pop from the stack and use that number.
* Store the result in a list and return.

---

## ⏱️ Complexity

* **Time Complexity:** `O(n)` where `n` is the length of the string
* **Space Complexity:** `O(n)` for the stack and result array

---

## 👨‍📄 Java Code

```java
class Solution {
    ArrayList<Integer> bracketNumbers(String str) {
        int n = str.length();
        Stack<Integer> st = new Stack<>();
        int cnt = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                cnt++;
                ans.add(cnt);
                st.push(cnt);
            } else if (ch == ')') {
                if (!st.isEmpty()) {
                    ans.add(st.peek());
                    st.pop();
                }
            }
        }

        return ans;
    }
}
```

---

## 🔎 Example

### Input:

```text
(aa(bdc))p(dee)
```

### Output:

```text
1 2 2 1 3 3
```

---

## ✅ Key Takeaways

* Whenever a question involves **matching pairs of brackets**, think **Stack**.
* Count opening brackets with a counter and track them to map their corresponding closing bracket.
* This logic can also apply to nested or multiple-level parentheses problems.
