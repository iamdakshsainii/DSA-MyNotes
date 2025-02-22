# 🛠️ Bit Manipulation Tricks and Techniques

Bit manipulation is an efficient way to perform mathematical and logical operations directly on binary numbers.

## 🔄 1. Swapping Two Numbers Without a Third Variable

### **Concept:** XOR (`^`)

```cpp
A = A ^ B;
B = A ^ B;
A = A ^ B;
```

✅ **Time Complexity:** `O(1)`\
✅ **Space Complexity:** `O(1)`

---

## 🔍 2. Checking if the i-th Bit is Set

### **Formula:**

```cpp
bool isBitSet(int n, int i) {
    return (n & (1 << i)) != 0;
}
```

---

## 🔧 3. Setting the i-th Bit

### **Formula:**

```cpp
int setBit(int n, int i) {
    return n | (1 << i);
}
```

---

## 🛢️ 4. Clearing the i-th Bit

### **Formula:**

```cpp
int clearBit(int n, int i) {
    return n & ~(1 << i);
}
```

---

## 🔄 5. Toggling the i-th Bit

### **Formula:**

```cpp
int toggleBit(int n, int i) {
    return n ^ (1 << i);
}
```

---

## ❌ 6. Removing the Last Set Bit

### **Formula:**

```cpp
int removeLastSetBit(int n) {
    return n & (n - 1);
}
```

---

## 🔴 7. Checking if a Number is a Power of 2

### **Formula:**

```cpp
bool isPowerOfTwo(int n) {
    return (n > 0) && ((n & (n - 1)) == 0);
}
```

---

## 📊 8. Counting the Number of Set Bits

### **Approach 1: Using `n & 1` and Right Shift (`>>`)**

```cpp
int countSetBits(int n) {
    int count = 0;
    while (n > 0) {
        count += (n & 1);
        n >>= 1;
    }
    return count;
}
```

✅ **Time Complexity:** `O(logN)`

### **Approach 2: Using `n & (n-1)` (Optimized)**

```cpp
int countSetBits(int n) {
    int count = 0;
    while (n) {
        n &= (n - 1);
        count++;
    }
    return count;
}
```

✅ **Time Complexity:** `O(K)`, where `K` is the number of set bits.

---

## **Bitwise Operations - General Use Cases**

### **1. `n & 1` → Check Even/Odd**
- **Use Case**: Determines if the **least significant bit (LSB)** is set.
- **Key Point**:
  - If `n & 1 == 1` → **Odd**
  - If `n & 1 == 0` → **Even**

### **2. `n & (n - 1)` → Unset Rightmost Set Bit (Efficient Traversal of Set Bits)**
- **Use Case**:
  - Removes the **rightmost set bit** in `n`.
  - Efficiently **counts set bits** in `O(number of set bits)`.
  - Checks if `n` is a **power of 2** (`n & (n - 1) == 0`).
- **Example** (Count Set Bits):
  ```java
  int count = 0;
  while (n > 0) {
      n = n & (n - 1); // Unset rightmost set bit
      count++;
  }
  ```

### **3. Masking (`n & mask`) → Isolate/Manipulate Specific Bits**
- **Use Case**:
  - **Extract a bit** → `n & (1 << k)` (Check `k`-th bit).
  - **Set a bit** → `n | (1 << k)`.
  - **Clear a bit** → `n & ~(1 << k)`.
  - **Toggle a bit** → `n ^ (1 << k)`.
- **Example** (Check if `k`-th bit is set):
  ```java
  boolean isSet = (n & (1 << k)) != 0;
  ```

### **Key Takeaways**
- `n & 1` → **LSB check** (odd/even).
- `n & (n - 1)` → **Efficient set-bit traversal**, unset rightmost bit.
- `n & mask` → **Bit masking** (isolate/manipulate specific bits). 🚀

---

## 📝 Summary of Important Formulas

| Operation                  | Formula                                 | Description |
| -------------------------- | --------------------------------------- | ----------- |
| Check if `i-th` bit is set | `n & (1 << i)`                         | Used to determine if a specific bit is 1 or 0. |
| Set `i-th` bit             | `n | (1 << i)`                         | Turns on a specific bit without affecting others. |
| Clear `i-th` bit           | `n & ~(1 << i)`                        | Turns off a specific bit while keeping others unchanged. |
| Toggle `i-th` bit          | `n ^ (1 << i)`                         | Flips a specific bit from 1 to 0 or 0 to 1. |
| Remove last set bit        | `n & (n - 1)`                          | Clears the rightmost set bit in `n`. |
| Check power of 2           | `(n > 0) && (n & (n - 1)) == 0`        | Determines if a number is a power of 2. |
| Count set bits (loop)      | `while(n) { count += n & 1; n >>= 1; }` | Counts number of 1s in binary representation using a loop. |
| Count set bits (optimized) | `while(n) { n &= (n - 1); count++; }`   | Faster way to count set bits by removing the last set bit in each step. |


## **Handling 32-bit Integer Constraints in Division**

### **Problem Statement**
- The environment only supports **32-bit signed integers** within the range **[-2³¹, 2³¹ - 1]**.
- If the quotient exceeds **2³¹ - 1**, return **2³¹ - 1**.
- If the quotient is below **-2³¹**, return **-2³¹**.

### **Cases to Handle**
1. **Normal Division**: When the result is within the valid range.
2. **Overflow Case**: `Integer.MIN_VALUE / -1`, which exceeds `Integer.MAX_VALUE`.
3. **Underflow Case**: Large negative values exceeding `Integer.MIN_VALUE`.
4. **Edge Cases**:
   - Large positive or negative numbers causing overflow/underflow.
   - Division by `1` or `-1`, especially for extreme values.

---

### **Java Implementation**
```java
class Solution {
    public int divide(int dividend, int divisor) {
        // Edge case: Handling overflow when dividing INT_MIN by -1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Perform division normally
        int result = dividend / divisor;

        // Ensuring the result stays within the valid 32-bit integer range
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return result;
    }
}
```

### **Handled Cases:**
1. **Normal Division** → `10 / 2 = 5` ✅
2. **Overflow Case** → `Integer.MIN_VALUE / -1 → Return Integer.MAX_VALUE` ✅
3. **Underflow Case** → `Integer.MIN_VALUE / 1 → Return Integer.MIN_VALUE` ✅
4. **Edge Case (large numbers)** → Any division exceeding the range is clamped ✅

### **Key Takeaways**
- Always **check for overflow/underflow** before returning the result.
- **Special handling** is needed for `Integer.MIN_VALUE / -1` to prevent exceeding `Integer.MAX_VALUE`.
- Use **integer limits** (`Integer.MAX_VALUE` and `Integer.MIN_VALUE`) to validate results.
