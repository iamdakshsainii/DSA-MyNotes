**Choosing Between ************`int`************ and ************`long`************ in Java**

## **📌 When to Use ************`int`************ vs ************`long`************?**

| Type   | Size   | Range                                        | When to Use                                                                                        |
| ------ | ------ | -------------------------------------------- | -------------------------------------------------------------------------------------------------- |
| `int`  | 32-bit | `-2^31` to `2^31 - 1` (≈ **±2 billion**)     | When numbers are **guaranteed** to stay within this range.                                         |
| `long` | 64-bit | `-2^63` to `2^63 - 1` (≈ **±9 quintillion**) | When numbers **might exceed 2 billion** (common in multiplication, large sums, and combinatorics). |

---

## **🔍 How to Identify When ************`long`************ is Needed?**

### **1️⃣ Large Constraints in the Problem Statement**

- If the problem mentions `1e5` (**100,000**) elements and asks for **sum/multiplication**, it **might exceed 2 billion**.
- Example:
  ```java
  int[] arr = new int[100000];
  long sum = 0; // ✅ Prevents overflow
  ```

### **2️⃣ When Doing Multiplication**

- If you multiply two large numbers, **always use** `long` to avoid overflow.
- Example:
  ```java
  int a = 100000;
  int b = 100000;
  long product = (long) a * b; // ✅ Prevents overflow
  ```

### **3️⃣ If You're Using ****`mod = 1e9 + 7`**

- **Rule**: **Always use ****`long`**** before applying ****`% mod`**, because `int` can overflow before modding.
- Example:
  ```java
  int mod = (int) 1e9 + 7;
  int a = 100000, b = 100000;

  long result = ((long) a * b) % mod; // ✅ Correct
  ```

---

## **✅ General Rule of Thumb**

| Scenario                                                 | Use `int` or `long`? |
| -------------------------------------------------------- | -------------------- |
| **Indexing an array**                                    | `int` ✅              |
| **Loop counters (****`for`**** loop)**                   | `int` ✅              |
| **Summing large arrays (e.g., ****`sum += arr[i]`****)** | `long` 🔥            |
| **Multiplying two large numbers**                        | `long` 🔥            |
| **Calculating factorials or combinatorics**              | `long` 🔥            |
| **Using ****`(a * b) % mod`**                            | `long` 🔥            |

---

## **🔥 Example Fix in Code**

### **Issue: Integer Overflow**

```java
long totalContri = (long) (i - left[i]) * (right[i] - i); // ✅ Safe multiplication
long sum = (sum + totalContri * arr[i]) % mod; // ✅ Correct mod operation
```

---

## **🚀 Summary**

- ✅ **Use ****`int`** for small values, loop counters, and array indexing.
- ✅ **Use ****`long`** for large sums, multiplications, or modulo operations.
- ✅ **Convert to ****`long`**** before multiplication** if numbers might exceed 2 billion.

