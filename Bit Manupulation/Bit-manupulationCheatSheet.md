**Bit Manipulation Concepts Cheat Sheet**

---

### 🫠 Introduction

This article serves as an introduction to some fundamental concepts in binary number manipulation, including binary number conversion, one's complement, two's complement, and other classic bit tricks. These concepts are not only essential to understanding how computers work at a low level but also extremely helpful in solving a variety of problems in computer science, competitive programming, and system design.

Everything stored and processed in a computer is done using only 0s and 1s. So having a clear grasp on binary operations gives you a serious edge. Let's dive into the details.

---

### ♻️ Binary Number Conversion

#### ✅ Decimal to Binary Conversion

Transform a decimal number into binary by continuously dividing by 2 and recording the remainders.

**Example: Convert 13 to binary**

```
13 / 2 = 6 remainder 1
6 / 2 = 3 remainder 0
3 / 2 = 1 remainder 1
1 / 2 = 0 remainder 1
```

Reading from bottom to top: `1101`
✅ So, the binary equivalent of **13** is `1101`

**Time Complexity**: O(logN)**Space Complexity**: O(logN)

**Java Code:**

```java
String decimalToBinary(int n) {
    String result = "";
    while (n != 1) {
        if (n % 2 == 1) result += '1';
        else result += '0';
        n = n / 2;
    }
    result += '1'; // since loop stops at 1, add final 1
    StringBuilder sb = new StringBuilder(result);
    return sb.reverse().toString();
}
```

#### ✅ Binary to Decimal Conversion

Convert binary to decimal by multiplying each bit by 2^index (starting from rightmost bit).

**Example: Convert 1101 to decimal**

```
1 * 2^0 = 1
0 * 2^1 = 0
1 * 2^2 = 4
1 * 2^3 = 8
Total = 1 + 0 + 4 + 8 = 13
```

✅ Decimal equivalent is **13**

**Time Complexity**: O(n)**Space Complexity**: O(1)

**Java Code:**

```java
int binaryToDecimal(String str) {
    int len = str.length();
    int val = 1, num = 0;
    for (int i = len - 1; i >= 0; i--) {
        if (str.charAt(i) == '1') {
            num = num + val;
        }
        val = val * 2;
    }
    return num;
}
```

---

### 🧩 One's Complement & Two's Complement

#### 🔄 One's Complement

Flip all the bits (0 ↔ 1).

- Binary of 13: `00001101`
- One's complement: `11110010`

This is useful for representing negative numbers in older systems.

#### 🔄 Two's Complement

Take one's complement and add 1.

```
13 → binary:        00001101
One's complement:  11110010
Add 1:             11110011
```

Two’s complement of 13 is `11110011`

This is how most modern systems represent negative numbers in binary.

---

### ⚙️ Bitwise Operators

| Operator    | Symbol | Function                       | Example (13 & 7)              |      |          |
| ----------- | ------ | ------------------------------ | ----------------------------- | ---- | -------- |
| AND         | `&`    | Bit is 1 only if both are 1    | `13 & 7 = 5`                  |      |          |
| OR          | \`     | \`                             | Bit is 1 if at least one is 1 | \`13 | 7 = 15\` |
| XOR         | `^`    | Bit is 1 if bits are different | `13 ^ 7 = 10`                 |      |          |
| NOT         | `~`    | Flip all bits                  | `~5 = -6`                     |      |          |
| Left Shift  | `<<`   | Shift left (multiply by 2)     | `13 << 1 = 26`                |      |          |
| Right Shift | `>>`   | Shift right (divide by 2)      | `13 >> 1 = 6`                 |      |          |

---

### ⚖️ Bit Manipulation Techniques

(unchanged below this)

