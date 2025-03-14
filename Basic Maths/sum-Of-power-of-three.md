**Notes on Checking Sum of Distinct Powers of Three**

**Problem Statement:**
Given an integer `n`, determine if it can be represented as the sum of distinct powers of three.

**Understanding the Approach:**

1. **Base Concept:**

   - Powers of three are numbers like `1, 3, 9, 27, 81, ...` (i.e., `3^0, 3^1, 3^2, ...`).
   - We need to check if `n` can be formed by summing some of these numbers without repetition.

2. **Observation:**

   - Any number in base-3 representation consists of digits `0, 1, or 2`.
   - If any digit in `n`'s base-3 representation is `2`, then `n` cannot be represented as the sum of distinct powers of three.

3. **Implementation Logic:**

   - Repeatedly divide `n` by `3` (integer division).
   - If at any step, `n % 3 == 2`, return `False`.
   - If `n` reduces to `0`, return `True`.

**Time Complexity:**

- Since we are dividing `n` by 3 repeatedly, the complexity is `O(log_3(n))`, which is very efficient.

**Example Walkthrough:**

1. **Example 1:** `n = 12`

   - Base-3 representation of `12`: `110`
   - Since it only contains `0` and `1`, return `True`.
   - Breakdown: `12 = 3^2 + 3^1 (9 + 3)`

2. **Example 2:** `n = 91`

   - Base-3 representation of `91`: `10101`
   - Since it contains only `0` and `1`, return `True`.
   - Breakdown: `91 = 3^4 + 3^2 + 3^0 (81 + 9 + 1)`

3. **Example 3:** `n = 21`

   - Base-3 representation of `21`: `210`
   - Since it contains `2`, return `False`.
   - Cannot be represented as sum of distinct powers of three.

**Java Implementation to Check Sum of Distinct Powers of Three:**

```java
class PowerOfThreeSum {
    public static boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
```

