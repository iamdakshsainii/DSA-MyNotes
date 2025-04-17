## Point 1

⚠️ Incorrect Way:
```java
// where ans is list and arr also a list but atill need to add like this way to avoid changes in ans
ans.add(arr);
```

🛑 What’s wrong?
- This adds a **reference** to `arr`, **not a copy**
- If `arr` changes later (which it does in backtracking), the same reference in `ans` also changes
- Leads to **wrong, repeated, or empty results**

🧠 Why this matters:
- In backtracking, `arr` is modified a lot (add/remove elements)
- Without copying, every stored list in `ans` ends up being the same (last state of `arr`)

---

✅ Correct Way:

```java
ans.add(new ArrayList<>(arr));
```

💡 Why this works:
- Creates a **snapshot copy** of the current `arr`
- Any future changes to `arr` do **not affect** the copied version in `ans`
- Stores each subset/result **accurately** and **independently**

---

🧾 Rule to Remember:
> When adding a **list into a list** (like `List<List<>>`) and that inner list might change later,
> 👉 **Always copy it** using `new ArrayList<>(yourList)`

---
