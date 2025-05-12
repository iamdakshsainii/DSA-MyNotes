🤯 Backtracking vs. Recursion (How to Choose?)

Here’s the one-line rule:
🧠 If you need to build/print/store paths → use **backtracking**.
🧲 If you just need a count/value/result → use **recursion with return**.

---

## ✅ Use **Backtracking** when:

- You need **all the actual combinations/subsets**.
- You need to **print**, **return**, or **store** them.
- You care about the **contents** of the solution, not just how many exist.

### 📟 Example Problems:

- Generate all subsets (power set)
- N-Queens (print all board states)
- Sudoku solver
- Word break (print all sentences)
- Combinations/Permutations

### Java Skeleton:

```java
path.add(...);
backtrack(...);
path.remove(...); // undo = backtrack
```

---

## ✅ Use **Recursion with return** when:

- You only want to **count**, **sum**, **find max/min**, or **check if a solution exists**.
- You don’t care about which paths — just the final answer.

### 📟 Example Problems:

- Count how many subsets sum to X
- Count ways to climb stairs
- Fibonacci
- Is there a path? (true/false)

### Java Skeleton:

```java
return f(left) + f(right); // no undo
```

---
