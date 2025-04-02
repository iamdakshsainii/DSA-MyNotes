**## Problem: Compute ********************************`x^n`******************************** Efficiently**

### **Given:** Base `x` and exponent `n`, compute `x^n` efficiently.

---

## **Approaches to Solve the Problem**

### **1️⃣ Simple For Loop (Brute Force) ❌**

- **Idea:** Multiply `x` repeatedly `n` times.
- **Issue:** Inefficient (`O(n)` complexity).
- **Important Note:** Must handle `Integer.MIN_VALUE` carefully or use `double` to avoid overflow.

#### **Code:**

```java
public double myPow(double x, int n) {
    double ans = 1;
    if (x == 1.0) return 1.0;
    if (x == -1.0) return (n % 2 == 0) ? 1.0 : -1.0;
    if (n < 0) {
        if (n == Integer.MIN_VALUE) return 0; // Prevent overflow
        x = 1 / x;
        n = -n;
    }
    for (int i = 0; i < n; i++) {
        ans *= x;
    }
    return (ans > Integer.MAX_VALUE) ? 0 : ans;
}
```

**⚠️ Issues:** Inefficient and fails for `Integer.MIN_VALUE` due to overflow.

---

### **2️⃣ Even-Odd Exponent (Optimized using Bit Manipulation) ✅**

- **Idea:** Use `x^n = x^(n/2) * x^(n/2)` for even `n` and `x^n = x^(n-1) * x` for odd `n`.
- **Bit Manipulation:**  we are using exponent to half so instead directly half we can replace division with right shift (`n >> 1`), and also modulo of checking odd and even with bitwise AND (`n & 1`).
- **Important Note:** Handle `Integer.MIN_VALUE` or use `double` to prevent overflow.

#### **Code:**

```java
public double myPow(double x, int n) {
    double ans = 1;
    double base = x;
    double exp = n;

    while (exp < 0) { // Handle negative exponents
        base = 1 / base;
        exp = -exp;
    }

    while (exp > 0) {
        if (exp % 2 == 1) {
            ans *= base;
            exp -= 1;
        } else {
            exp /= 2;
            base *= base;
        }
    }
    return ans;
}
```

**✅ Efficient ********************************`O(log n)`********************************, prevents overflow, and uses bitwise operations for fast computation.**

---

### **3️⃣ Recursive (Divide & Conquer) ✅**

- **Idea:** Recursively reduce `n` using the even-odd exponent rule.
- **Complexity:** `O(log n)`.
- **Current Code Explanation:** Handles edge cases like `Integer.MIN_VALUE`.

#### **Code:**

```java
public double myPow(double x, int n) {
    if (n == 0) return 1;
    if (n == 1) return x;
    if (n < 0) {
        if (n == Integer.MIN_VALUE) return 0; // Prevent overflow
        x = 1 / x;
        n = -n;
    }
    if (n % 2 == 0) {
        return myPow(x * x, n / 2);
    } else {
        return x * myPow(x, n - 1);
    }
}
```

**✅ Efficient ********************************`O(log n)`********************************, handles ********************************`Integer.MIN_VALUE`********************************, and uses recursion for clean implementation.**

---

## **🔹 Key Takeaways**

✅ **Use ********************************`double`******************************** for ********************************`n`******************************** to avoid overflow checks.**
✅ **Bit manipulation (********`&`********\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*, ********************************`>>`********************************) speeds up computation in iterative approach.**
✅ **Recursive approach is intuitive but may have function call overhead.**
✅ **Optimized approaches reduce time complexity from ********************************`O(n)`******************************** to ********************************`O(log n)`********************************.**

🚀 **Final Tip:** Always prefer `O(log n)` approaches over brute force!

