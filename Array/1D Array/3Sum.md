# Three Sum Problem: Brute Force Approach

## Code:
```java
import java.util.*;

class Solution {
    //Function to find triplets having sum equals to target
    public List<List<Integer>> threeSum(int[] nums) {
        // Set to store unique triplets
        Set<List<Integer>> tripletSet = new HashSet<>();

        int n = nums.length;

        // Check all possible triplets
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        // Found a triplet that sums up to target
                        List<Integer> temp = new ArrayList<>();    // make sure you are creating a list so alwys declare here as it need to empty every time
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);

                        /* Sort the triplet to ensure
                        uniqueness when storing in set*/
                        Collections.sort(temp);
                        tripletSet.add(temp);
                    }
                }
            }
        }

        // Convert set to list of lists (unique triplets)
        List<List<Integer>> ans = new ArrayList<>(tripletSet);

        //Return the ans
        return ans;
    }
}
```

# Three Sum Problem: Better HashSet Approach

## Code:
```java
import java.util.*;

class Solution {
    // Function to find triplets having sum equals to 0
    public List<List<Integer>> threeSum(int[] nums) {
        // Set to store unique triplets
        Set<List<Integer>> tripletSet = new HashSet<>();

        int n = nums.length;

        // Check all possible triplets
        for (int i = 0; i < n; i++) {
            // Set to store elements seen so far in the loop
            Set<Integer> hashset = new HashSet<>();

            for (int j = i + 1; j < n; j++) {
                // Calculate the 3rd element needed to reach 0
                int third =  - (nums[i] + nums[j]);

                /* Find if third element exists in
                hashset (complements seen so far)*/
                if (hashset.contains(third)) {
                    // Found a triplet that sums up to target
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(third);

                    /* Sort the triplet to ensure
                    uniqueness when storing in set*/
                    Collections.sort(temp);
                    tripletSet.add(temp);
                }

                /* Insert the current element
                 into hashset for future checks*/
                hashset.add(nums[j]);
            }
        }

        // Convert set to list of lists (unique triplets)
        List<List<Integer>> ans = new ArrayList<>(tripletSet);

        //Return the ans
        return ans;
    }
}
```

# Three Sum Problem - Optimal Solution

## Code:

```java
import java.util.*;

class Solution {
    // Function to find triplets having sum equals to target
    public List<List<Integer>> threeSum(int[] nums) {

        // List to store the triplets that sum up to target
        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;

        // Sort the input array nums
        Arrays.sort(nums);

        // Iterate through the array to find triplets
        for (int i = 0; i < n; i++) {
            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Two pointers approach
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    // Found a triplet that sums up to target
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);

                    // Skip duplicates
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // weak in complexity - mistake - dont include this as n3 as it is not lookup whole array so complexity would be constant
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }

        return ans;
    }
}
```
### method to add as list
```
 List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
```
List: Can store duplicates and maintains order, with space complexity O(n).
Set: Stores only unique elements, with space complexity O(n), and typically provides faster lookups and insertions than a list (due to the underlying hash table).
