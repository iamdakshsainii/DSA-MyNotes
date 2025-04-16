### Problem Statement:

Generate all combinations of well-formed parentheses for a given number `n` (number of pairs).

---

### ✅ Input:

- Integer `n` (1 <= n <= 8)

### ✅ Output:

- List of strings, each representing a valid combination of `n` pairs of parentheses.

### 🔍 Example:

```java
Input: n = 3
Output: ["((()))", "(()())", "(())()", "()(())", "()()()"]
```

---

## 🔁 Method 1: Brute Force with Validation (Tag: **Brute Force**)

```java
class Solution {
    public boolean isValid(String str){
        int cnt = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '(') cnt++;
            else cnt--;
            if(cnt < 0) return false;
        }
        return cnt == 0;
    }

    public void backtracking(List<String> ans, String str, int n){
        if(str.length() == 2*n){
            if(isValid(str)){
                ans.add(str);
            }
            return;
        }

        str = str + '(';
        backtracking(ans, str, n);
        str = str.substring(0, str.length() - 1);no

        str += ')';
        backtracking(ans, str, n);
        str = str.substring(0, str.length() - 1);
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtracking(ans, "", n);
        return ans;
    }
}
```

### 🚩 Drawbacks:

- Generates **all possible** combinations (including invalid ones).
- Then checks each one for validity using `isValid()`.
- Inefficient as `n` grows, as it explores invalid branches.

### ❗ Common Mistake in Brute Force:

- Mutating the `str` variable without actually backtracking cleanly (e.g., forgetting to restore previous state correctly).

---

## ✅ Method 2: Smart Backtracking with Constraints (Tag: **Optimal**)

```java
class Solution {
    public void backtracking(List<String> ans , int openCnt, int closeCnt, StringBuilder currentStr, int n){
        if(openCnt + closeCnt == 2*n) {
            ans.add(currentStr.toString());
            return;
        }

        if(openCnt < n){
            currentStr.append('(');
            backtracking(ans, openCnt + 1, closeCnt, currentStr, n);
            currentStr.deleteCharAt(currentStr.length() - 1);
        }
        if(closeCnt < openCnt){
            currentStr.append(')');
            backtracking(ans, openCnt, closeCnt + 1, currentStr, n);
            currentStr.deleteCharAt(currentStr.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtracking(ans, 0, 0, new StringBuilder(), n);
        return ans;
    }
}
```

#### ✅ Another Way:

```java
if (openCnt + closeCnt == 2 * n) {
            ans.add(currentStr);  // Add to result when the string length reaches 2*n
            return;
        }

        if (openCnt < n) {
            currentStr = currentStr + '(';  // Add '(' to the string
            backtracking(ans, openCnt + 1, closeCnt, currentStr, n);
            currentStr = currentStr.substring(0, currentStr.length() - 1);  // Backtrack (undo)
        }

        if (closeCnt < openCnt) {
            currentStr = currentStr + ')';  // Add ')' to the string
            backtracking(ans, openCnt, closeCnt + 1, currentStr, n);
            currentStr = currentStr.substring(0, currentStr.length() - 1);  // Backtrack (undo)
        }
```

#### ✅ Why this is less efficient:

Every time you add a character or remove it, you're creating a new string object (even if you "undo" with substring).

This results in more memory overhead and potentially slower performance, especially if n is large because you're repeatedly copying strings.



Why StringBuilder Is More Efficient:

StringBuilder modifies the same object without needing to create new ones every time. It's designed to handle dynamic string manipulation efficiently.

## 🧵 Method 3: Using `StringBuilder` for Efficient Backtracking (Alternate Clean Form)

```java
class Solution {
    public void backtrack(List<String> ans, StringBuilder sb, int open, int close, int n){
        if(sb.length() == 2 * n){
            ans.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append('(');
            backtrack(ans, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close < open){
            sb.append(')');
            backtrack(ans, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }
}
```

### ⚡ Why Use `StringBuilder`?

- More memory-efficient because it reuses the same object.
- Saves time by avoiding string copy on each recursion level.

### ❗ Mistake to Avoid:

- Always undo changes using `deleteCharAt()` to backtrack properly.
