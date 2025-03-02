# Jump Game II - Minimum Jumps to Reach End
Keep in mind this problem solved in coding ninja but not in tuf+ because of runtime error for below code

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
```

---

# Job Sequencing Problem - Maximum Profit

## Problem Statement
You are given a **2D array** `Jobs` of size `N x 3`, where:
- `Jobs[i][0]` represents **Job ID**
- `Jobs[i][1]` represents **Deadline**
- `Jobs[i][2]` represents **Profit** associated with the job

Each job takes **1 unit of time** to complete, and only **one job can be scheduled at a time**. The profit associated with a job is earned **only if it is completed by its deadline**. Find the **number of jobs completed** and the **maximum profit**.

---

## Example 1:
**Input:**
`Jobs = [[1, 4, 20], [2, 1, 10], [3, 1, 40], [4, 1, 30]]`

**Output:**
`2 60`

**Explanation:**
- Job `3` is performed at time `t = 1`, earning **40** profit.
- Job `1` is performed at time `t = 2`, earning **20** profit.
- No more jobs can be scheduled.
- **Total Profit = 40 + 20 = 60**.
- **Total Jobs Completed = 2** (Job `1` and Job `3`).

---

## Greedy Approach:
1. **Sort jobs** by profit in **descending order**.
2. **Iterate** through the jobs and find the latest available slot before their deadline.
3. If an empty slot is available, **schedule the job**; otherwise, ignore it.
4. Use a **disjoint set** or a **simple array** to track available slots efficiently.

---

## Solution - Java Implementation
```java
import java.util.Arrays;

class Solution {
    public int[] JobScheduling(int[][] Jobs) {
        int count = 0;
        int profit = 0;
        Arrays.sort(Jobs, (a, b) -> b[2] - a[2]); // Sort jobs by profit in descending order
        int n = Jobs.length;

        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, Jobs[i][1]);
        }
        int[] res = new int[maxDeadline + 1];
        Arrays.fill(res, -1);

        for (int i = 0; i < n; i++) {
            for (int j = Jobs[i][1]; j > 0; j--) {
                if (res[j] == -1) {
                    count++;
                    res[j] = Jobs[i][0];
                    profit += Jobs[i][2];
                    break;
                }
            }
        }
        return new int[]{count, profit};
    }
}
```
