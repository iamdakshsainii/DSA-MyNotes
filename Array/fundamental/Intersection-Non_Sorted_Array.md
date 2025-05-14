### ✅ Your Original Code (Using List and contains check)

#### Remeber one thing first check question as mine or this method use sorted array

```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int n = nums1.length;
        int m = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> arr = new ArrayList<>();
        while(i < n && j < m){
            if(nums1[i] == nums2[j]){
                if(!arr.contains(nums1[i])){
                    arr.add(nums1[i]);
                }
                i++;
                j++;
            } else if(nums1[i] < nums2[j]){
                i++;
            } else {
                j++;
            }
        }
        int[] ans = new int[arr.size()];
        for (int k = 0; k < arr.size(); k++) {
            ans[k] = arr.get(k);
        }
        return ans;
    }
}
```

🟡 **Why it's okay:**
- It works and gets the job done.
- But using `contains()` on a list is O(n), so for large inputs this becomes inefficient.

---

### ✅ Improved Code Using Set and List Together
```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (!set.contains(nums1[i])) {
                    result.add(nums1[i]);
                    set.add(nums1[i]);
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] ans = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            ans[k] = result.get(k);
        }
        return ans;
    }
}
```

🟢 **Why this is better than your original:**
- `HashSet` makes `.contains()` O(1) instead of O(n) like in List.
- Still maintains input sort-based logic.
- Much faster on large arrays due to efficient lookup.

---

### ✅ Optimized Code Using Just TreeSet (Sorted and Unique Automatically)
```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new TreeSet<>();
        Set<Integer> result = new TreeSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num);
            }
        }

        int[] ans = new int[result.size()];
        int i = 0;
        for (int num : result) {
            ans[i++] = num;
        }

        return ans;
    }
}
```

🟢 **Why this is clean and efficient:**
- Uses TreeSet to keep elements unique and sorted.
- No need to sort manually, and ensures result is in order.
- `TreeSet` has O(log n) lookup, which is still better than List's O(n).

---

✅ Use TreeSet if you want sorted + unique
✅ Use HashSet + List if you want unique and unsorted but better performance
🟡 Avoid using List with `contains()` alone for large inputs (slow AF)

Let me know if you want to add HashSet-only version too.
