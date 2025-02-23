## Important concepts need to focus while solving bit manupulation question


## 1. If question given you need to maintain 32 bit then

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


## 2. where to use xor

## 🚀 XOR Uses & Examples Table

| **Use Case**                          | **Explanation**                                             | **Example Problem**                                        | **Example Code Snippet**         |
|---------------------------------|---------------------------------------------------------|----------------------------------------------------------|---------------------------|
| **Finding Bit Differences**      | XOR gives `1` where bits differ between two numbers.    | **Min Bit Flips to Convert Number**                     | `int diff = start ^ goal;` |
| **Finding Unique Element**       | XOR cancels out duplicates (`x ^ x = 0`).               | **Find the Single Number in an Array**                   | `for (int num : arr) res ^= num;` |
| **Swapping Two Numbers**         | XOR allows swapping without a temp variable.            | **Swap two numbers efficiently**                         | `a ^= b; b ^= a; a ^= b;` |
| **Finding Missing Number**       | XOR helps find a missing number in a sequence.          | **Find Missing Number in [0, n]**                        | `for (int i = 0; i <= n; i++) res ^= i ^ arr[i];` |
| **Checking if Two Numbers are Equal** | `a ^ b == 0` means `a == b`.                         | **Check if Two Numbers are Equal Without `==`**          | `if ((a ^ b) == 0) // Equal` |
| **Bitwise Toggling (Flip Bits)** | XOR with `1` flips a bit (`0 → 1`, `1 → 0`).            | **Toggle bits in a number**                              | `num ^= (1 << k);` (Flip `k`th bit) |
| **Checking Power of Two**        | XOR helps in checking if a number is a power of two.    | **Check if a number is power of 2**                      | `if ((n & (n - 1)) == 0) // True` |
| **Finding Two Non-Repeating Numbers** | XOR helps in finding two unique numbers in a list. | **Find two unique numbers when others appear twice**     | `x ^= num; y ^= num;` |

🚀 **Use this table as a quick XOR reference guide!** 🚀


### 3. How power convert for bit manupulation
```cpp
2^d = 1<<d and d*2^(cnt+1) = d << cnt+1
```

### 4. Multiple
to check multiple
count % 3 -> multiple of 3
