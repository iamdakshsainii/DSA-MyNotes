# **Finding the Single Number (Appearing Once) in an Array**

**Key Concept Learn Form this**
1. count % n for check or it give multiple of n time like is vount is multiple of n here
2. use check and set bit carefully and rember notes.md file as if i take any vairable to store bit then it is done by setting bit

## **Problem Statement**
Given an integer array where **every element appears three times** except for **one unique element**, find and return the single number.
---


## **Method 1:Comparing Approach**

### **🔍 Intuition**

- If we sort the array, elements appearing **three times** will be **grouped together**.
- The **unique element** will be **the only one not forming a group** of three.
- We traverse the array and check if a number **does not match its previous and next elements**.

### **📝 Code Implementation**


**Method 1**
```java
import java.util.Arrays;

class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // Step 1: Sort the array

        for (int i = 1; i < n - 1; i++) { // Step 2: Traverse the array
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) { // Step 3: Find unique element
                return nums[i];
            }
        }

        return nums[n - 1]; // Step 4: If unique element is the last element
    }
}
```

### **🕒 Time Complexity**

- **Sorting takes O(n log n)**.
- **Linear scan takes O(n)**.
- **Total Complexity:** `O(n log n)`, due to sorting.

### **🛠️ Space Complexity**

- **O(1)**, as no extra space is used.

---


## **Method 2: Bitwise Counting Approach**

### **🔍 Intuition**

- Since each number appears **three times except for one**, **each bit position** in a binary number should have a count that is a **multiple of 3**, except for the unique number.
- We iterate through **each bit position (0 to 31)** and count the number of `1`s at that position.
- If the count is **not a multiple of 3**, it means the unique number contributes to that bit.
- We construct the answer bit-by-bit using bitwise OR (`|=`).

### **🚀 Approach**

1. **Initialize ****`ans = 0`** to store the result.
2. **Iterate over all 32-bit positions** (`0 to 31`).
3. **For each bit position ****`i`**, count how many numbers have `1` at that position.
4. If `cnt % 3 == 1`, it means the unique number contributes to this bit. **Set this bit in ****`ans`**.
5. **Return ****`ans`** after processing all bits.

### **📝 Code Implementation**

```java
class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < 32; i++) { // Step 1: go left to right to each bit (like 2 1 0) till 32 bit
            int cnt = 0;

            for (int j = 0; j < n; j++) { // Step 2: now check each number ith bit and aim is to check if it is multiple of 3 or not
                if ((nums[j] & (1 << i)) != 0) {
                    cnt++;
                }
            }

            if (cnt % 3 == 1) { // Step 3: if multiple of 3 then ok else if it not mean it is 1 of unique bit so set to ans 
                ans |= (1 << i);
            }
        }

        return ans; // Step 5: Return final result
    }
}
```

### **🕒 Time Complexity**

- We iterate **32 times (constant factor)** over `n` elements.
- **Total Complexity:** `O(32 * n) ≈ O(n)`.

### **🛠️ Space Complexity**

- **O(1)**, as only a few integer variables are used.


**Method 3** ->
HashMap by count frequencies
