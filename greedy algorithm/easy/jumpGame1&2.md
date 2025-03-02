# Jump Game I -
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

**Example 1:**
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
```java
class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int maxindex=0;
         for(int i=0;i<n;i++){
            // jese  [3, 2, 1, 0, 4] hum 4 pr aye then 4+4 = 8 jha hum ja hi nhi skte
             if (i > maxindex) {
                return false;
            }
            maxindex = Math.max(maxindex, i+nums[i]);
         }

          return true;
    }
}
```






# Jump Game II - Minimum Jumps to Reach End

## Problem Statement
You are given a **0-indexed** array of integers `nums` of length `n`. You are initially positioned at `nums[0]`.

Each element `nums[i]` represents the maximum length of a **forward jump** from index `i`. In other words, if you are at `nums[i]`, you can jump to any `nums[i + j]` where:
- `0 <= j <= nums[i]`
- `i + j < n`

Return the **minimum number of jumps** required to reach `nums[n - 1]`. The test cases are generated such that you can always reach `nums[n - 1]`.

---

## Example 1:
**Input:**
`nums = [2,3,1,1,4]`

**Output:**
`2`

**Explanation:**
- Jump **1 step** from index `0` to `1`
- Jump **3 steps** from index `1` to the last index `4`

---

## Example 2:
**Input:**
`nums = [2,3,0,1,4]`

**Output:**
`2`

**Explanation:**
- Jump **1 step** from index `0` to `1`
- Jump **3 steps** from index `1` to the last index `4`

---

## Solution - Java Implementation
```java
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int maxindex = 0;
        int cnt = 0;
        int current = 0;

        if (n == 1) return 0; // Special case for single-element array

        for (int i = 0; i < n; i++) {
            maxindex = Math.max(maxindex, i + nums[i]);

            if (i == current) {
                cnt++;
                current = maxindex;
            }

            if (current >= n - 1) break;
        }

        return cnt;
    }
}
