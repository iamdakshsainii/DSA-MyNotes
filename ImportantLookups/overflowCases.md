### **Why Check for `Integer.MIN_VALUE` in Exponentiation?**

➡️ **`Integer.MIN_VALUE` cannot be negated in Java due to overflow.**
- **Issue:** `-(-2147483648)` exceeds `Integer.MAX_VALUE (2147483647)`, causing incorrect behavior.

#### **🚨 Problem (Without Handling)**
```java
if (n < 0) {
    n = -n;  // ❌ Overflow when n = Integer.MIN_VALUE
    x = 1 / x;
}
```

#### **✅ Correct Handling**
```java
if (n == Integer.MIN_VALUE) {
    return 1 / (myPow(x, Integer.MAX_VALUE) * x);
}
```
✔️ Prevents overflow
✔️ Ensures correct exponentiation results
