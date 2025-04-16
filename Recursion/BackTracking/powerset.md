**Dry Run of Power Set Code in Java (Backtracking Approach)**
![alt text](<WhatsApp Image 2025-04-17 at 01.49.19_fef460fc-1.jpg>)
---

### 📁 Problem Statement:
Given an integer array `nums`, return **all possible subsets (the power set)**.

Input: `nums = [1, 2]`

Expected Output: `[[], [1], [2], [1, 2]]`

---

### 🏋️ Method Used:
Backtracking

---

### 🔄 Code:
```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Include current number
        current.add(nums[index]);
        backtrack(index + 1, nums, current, result);
        current.remove(current.size() - 1); // backtrack

        // Exclude current number
        backtrack(index + 1, nums, current, result);
    }
}
```

---

### 👁️ Dry Run with Steps:

Input: `nums = [1, 2]`

| Step | Index | Current List | Action Taken            | Result List So Far              |
|------|--------|----------------|--------------------------|----------------------------------|
| 1    | 0      | []             | Start                    | []                               |
| 2    | 0      | [1]            | Include 1                | []                               |
| 3    | 1      | [1, 2]         | Include 2                | []                               |
| 4    | 2      | [1, 2]         | Reached end ✅         | [[1, 2]]                         |
| 5    | 1      | [1]            | Remove 2 (backtrack)     | [[1, 2]]                         |
| 6    | 2      | [1]            | Exclude 2                | [[1, 2], [1]]                    |
| 7    | 0      | []             | Remove 1 (backtrack)     | [[1, 2], [1]]                    |
| 8    | 1      | [2]            | Include 2                | [[1, 2], [1]]                    |
| 9    | 2      | [2]            | Reached end ✅         | [[1, 2], [1], [2]]               |
| 10   | 1      | []             | Remove 2 (backtrack)     | [[1, 2], [1], [2]]               |
| 11   | 2      | []             | Exclude 2                | [[1, 2], [1], [2], []]           |

---

### 🔎 Final Result:
```java
[[], [1], [2], [1, 2]]
```

Sorted order or order may vary based on include/exclude call order but it's still correct power set.

---

### 🔄 Summary of Key Backtracking Concepts:

- We always explore one decision (include) → then **undo it** (remove last element) → then explore the other decision (exclude)
- `index` **always increases**, even during exclude path
- At base case, copy the current list (don’t reference it!) and add to result
- The result is the full **power set tree** where each level represents decision at `nums[index]`

---

![alt text](<WhatsApp Image 2025-04-17 at 01.49.19_fef460fc.jpg>)
