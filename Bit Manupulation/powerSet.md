## Power Set using Bit Manipulation

### 📌 Problem:

Given an array of integers `nums`, return **all possible subsets (the power set)**.

### 🎯 Objective:

Generate all subsets using **bit manipulation** (no recursion).

---

### ✅ Approach: Bit Manipulation

```java
class Solution {
    public List<List<Integer>> powerSet(int[] nums) {
        int n = nums.length;
        int size = 1 << n; // 2^n subsets
        List<List<Integer>> result = new ArrayList<>();

        for (int ele = 0; ele < size; ele++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((ele & (1 << i)) != 0) { // Check if the i-th bit is set
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
        }
        return result;
    }
}
```

---

### 🧠 Step-by-Step Explanation:

#### 1. `int size = 1 << n;`

- Calculates `2^n`, total number of subsets
- Each number from `0` to `2^n - 1` represents a subset via its **binary bits**

#### 2. Outer loop: `for (int ele = 0; ele < size; ele++)`

- Loops through all possible `2^n` bitmasks

#### 3. Inner loop: `for (int i = 0; i < n; i++)`

- For each bit in `ele`, check if it's set using:

```java
(ele & (1 << i)) != 0
```

- If yes, include `nums[i]` in the current subset

#### 4. Add the constructed subset to `result`

---

### 🧪 Dry Run Example

Input: `nums = [1, 2]`

- `n = 2`
- `size = 1 << 2 = 4`

| ele (decimal) | ele (binary) | Bits Interpretation  | Subset |
| ------------- | ------------ | -------------------- | ------ |
| 0             | 00           | exclude 1, exclude 2 | []     |
| 1             | 01           | include 1, exclude 2 | [1]    |
| 2             | 10           | exclude 1, include 2 | [2]    |
| 3             | 11           | include 1, include 2 | [1, 2] |

### 🔚 Final Output:

```java
[[], [1], [2], [1, 2]]
```

### 🧩 Bit Manipulation Concepts Used:

#### ✅ `1 << n`

- **Left shift** operator — shifts `1` to the left by `n` positions.
- Equivalent to `2^n` (used to calculate total number of subsets).

#### ✅ `(ele & (1 << i))`

- **Bitwise AND** used to check if the `i-th` bit is set in `ele`.
- `1 << i` sets only the `i-th` bit ON (all others are 0).
- `&` checks if that bit is also ON in `ele` → meaning include `nums[i]`

#### ✅ Binary Representation of Numbers:

- Numbers from `0` to `2^n - 1` represent subset combinations.
- Each bit = a decision → `0` = exclude, `1` = include

---

