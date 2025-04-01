# Power Function (`x^n`) - Brute Force vs Optimal Approach

## **1. Brute Force Approach**

### **Code:**

```java
class Solution {
  public double myPow(double x, int n) {
    double base = x;
    double exp = n;
    double result = 1;

    if (x == 1.0) return 1.0;
    if (x == -1.0) return (n % 2 == 0) ? 1.0 : -1.0;

    if (exp < 0) {
      if (n == Integer.MIN_VALUE) return 0; // Handle overflow case
      base = 1 / base;
      exp = -exp;
    }

    for (int i = 0; i < exp; i++) {
      result *= base;
    }

    if (result > Double.MAX_VALUE) return 0; // Handle overflow case
    return result;
  }
}
```

### **Time Complexity:**

- **O(n)** (Linear Time Complexity)
- Inefficient for large `n`

### **Key Points:**

✔ Handles negative exponents by inverting `x` and making `n` positive.\
✔ Checks for **edge cases like ********`x = 1.0`********, ********`x = -1.0`********, and \*\*\*\*****`Integer.MIN_VALUE`**.\
✖ **Inefficient for large \*\*\*\*****`n`**, as it performs `n` multiplications.\
✖ Does **not** use optimized power calculation techniques.

---

## **2. Optimal Approach (Exponentiation by Squaring)**

### **Code:**

```java
class Solution {
    public double myPow(double x, int n) {
        if (x == 1.0) return 1.0;
        if (x == -1.0) return (n % 2 == 0) ? 1.0 : -1.0;

        long exp = n; // Use long to prevent overflow
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }

        double result = 1.0;
        while (exp > 0) {
            if (exp % 2 == 1) { // If exp is odd
                result *= x;
            }
            x *= x; // Square the base
            exp = exp / 2; // Divide exp by 2
        }

        return result;
    }
}
```

### **Time Complexity:**

- **O(log n)** (Logarithmic Time Complexity)
- Efficient for large `n`

### **Key Points:**

✔ Uses **Exponentiation by Squaring**, reducing time complexity from **O(n) → O(log n)**.\
✔ **Handles ********`Integer.MIN_VALUE`******** properly** by using `long` to prevent overflow.\
✔ Uses **division (********`exp / 2`********)** for exponent reduction instead of bitwise shift.\
✔ Efficient for both **positive and negative exponents**.\
✖ Requires additional logic for `x = 1.0` and `x = -1.0` edge cases.

---

### **Suggestion: Using Bitwise Shift (********`>>`********) for Optimization**

In the original optimal approach, I used bitwise shift (`>>`) to divide the exponent by 2:

```java
exp >>= 1; // Same as exp = exp / 2
```

#### **Why use ********`>>`******** instead of ********`/ 2`********?**

- **Bitwise shifting is faster** than division because shifting is a low-level CPU operation.
- `exp >> 1` is equivalent to `exp / 2`, but performs better in terms of execution time.

---

## \*\*Key Considerations for Implementing \*\***`myPow(x, n)`**

✅ **Handle ********`x == 1.0`******** and ********`x == -1.0`******** early**, since their results are predictable.\
✅ **Use ********`long`******** for ********`n`******** to avoid integer overflow when \*\*\*\*****`n = Integer.MIN_VALUE`**.\
✅ **Use Exponentiation by Squaring** to make the solution efficient.\
✅ **Consider using ********`>>`******** instead of ********`/ 2`******** for optimization**.\
✅ **Check for ********`Double.MAX_VALUE`******** to prevent overflow in extreme cases**.

