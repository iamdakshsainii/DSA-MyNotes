# In-place Insertion and Special Focus on Avoiding Overwrites

## Concept of In-place Insertion
- **In-place insertion** refers to modifying the array directly without using additional space (except for constant space variables).
- The primary challenge with in-place insertion is to ensure that you do not overwrite important elements before they are needed elsewhere in the logic.


## Key Considerations:
- **Avoid Overwriting**: When performing in-place updates, be cautious about overwriting elements before they're needed.
- mene phle ye glti kri ki inplace hi kr diya bina array k like nums[pos] = nums[i] jo ki boht glt hai to keep in mind


## Problem Explanation:
The goal is to rearrange the elements of an array, placing positive and negative numbers in alternating positions. The initial code attempts to do this using in-place assignment. However, it risks overwriting values when the `pos` and `neg` indices are updated improperly during the process.

## Corrected Approach:
The following approach avoids overwriting by using a result array and managing positive and negative indices separately. Here's how to correctly implement it:

```java
import java.util.*;

class Solution {
    // Function to rearrange elements by their sign
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        // Initialize a result vector of size n
        int[] ans = new int[n];

        // Initialize indices for positive and negative elements
        int posIndex = 0, negIndex = 1;

        // Traverse through each element in nums
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {

                /* If current element is negative, place it at the next odd index in ans */
                ans[negIndex] = nums[i];
                // Move to the next odd index
                negIndex += 2;

            } else {
                /* If current element is positive, place it at the next even index in ans */
                ans[posIndex] = nums[i];

                // Move to the next even index
                posIndex += 2;

            }
        }

        // Return the rearranged array
        return ans;
    }
}
```
