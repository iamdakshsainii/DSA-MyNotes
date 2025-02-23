## Minimum Bit Flips to Convert Number

### Concept
Find the number of bit positions where `start` and `goal` differ.

### Approach
Use **XOR (`^`)** to find differing bits.

### Steps
1. Compute `start ^ goal` → gives a binary number with `1s` where bits differ.
2. Count the number of `1s` in the result (Hamming weight).
3. Return the count.

### Solution
```java
class Solution {
    public int minBitsFlip(int start, int goal) {
        int result = start ^ goal;
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            cnt += (result & 1);
            result = result >> 1;
        }
        return cnt;
    }
}
```

