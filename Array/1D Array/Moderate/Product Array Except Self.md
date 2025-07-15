# Product of Array Except Self

## Problem Statement

Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`.

- You must write an algorithm that runs in **O(n)** time.
- You **cannot use the division operation**.
- The product of any prefix or suffix of `nums` fits in a 32-bit integer.

---



**Example 1:**
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

**Example 2:**
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]


Approches(3 methods)
1. using simple nested loop
2. using prefix and suffix array and product array

 **Approch 1 -> TLE**
 ```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int[] ans = new int[n];
          for(int i=0;i<n;i++){
             int product = 1;
             for(int j=0;j<n;j++){
                if(i !=j){
                    product *= nums[j];
                }
             }
             ans[i]= product;

          }
          return ans;
    }
}
```

**Code = Approch 2**
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
          int n = nums.length;
        // If only one element, return a nums with 1
        if (n == 1) {
            return new int[]{1};
        }
        int[] prefix = new int[n];
        int[] suffix = new int[n];
         int[] prod = new int[n];
        // Construct the prefix array
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i - 1] * prefix[i - 1];
        }
        // Construct the suffix array
        suffix[n - 1] = 1;
        for (int j = n - 2; j >= 0; j--) {
            suffix[j] = nums[j + 1] * suffix[j + 1];
        }
        // Construct the product array using prefix[] and suffix[]
        for (int i = 0; i < n; i++) {
            prod[i] = prefix[i] * suffix[i];
        }
        return prod;
    }
}
```
