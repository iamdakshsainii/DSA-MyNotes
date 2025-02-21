# **Why Use Bits Instead of Integers?**

### ✅ **Efficiency**
- **Memory Efficient** → Uses fewer bits than full integers.
- **Faster Computation** → Bitwise operations (`&`, `|`, `^`, `<<`, `>>`) are much faster than arithmetic.
- **Optimized Storage** → Multiple boolean values can be stored in a single integer using bit-masking.

---

# **How is Sign Stored in Integers?**

### 🔹 **Two’s Complement Representation**
- Used for storing negative numbers in binary.
- **MSB (Most Significant Bit) = Sign Bit**
  - `0` → Positive number
  - `1` → Negative number

### 🔹 **Example (8-bit representation)**
| Decimal | Binary |
|---------|--------|
| `+5`    | `00000101` |
| `-5`    | `11111011` (Two’s complement) |

- Two’s complement makes addition/subtraction efficient.
- Eliminates the problem of `-0` (sign-magnitude representation issue).

---

# **Min & Max Value of `int` in Java**

- **`int` is 32-bit** → Stores values from **`-2,147,483,648` to `2,147,483,647`**
- **Formula:**
  - **Minimum Value** = `-(2^31)` = `-2,147,483,648`
  - **Maximum Value** = `(2^31) - 1` = `2,147,483,647`
- **Constants in Java:**
  - `Inte
