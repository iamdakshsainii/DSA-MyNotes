## 🧾 Problem Statement

Given an array of **negative and non-negative integers**, you have to make the array *beautiful*.
An array is beautiful if **no two adjacent elements have opposite signs**, i.e., both must be either non-negative or both negative.

### ✅ Operation:
- If `arr[i]` and `arr[i+1]` have opposite signs, remove both.
- Repeat this operation from **left to right**, any number of times.
- Return the final beautiful array.

### 🔍 Note:
- An empty array is also considered beautiful.
- Continue removing pairs **until no such adjacent pair exists**.

---

## 🧪 Example
[4,2,-2,1]

### Explanation:
- At index 1 and 2, `2` and `-2` are opposite signed → removed.
- Final array becomes `[4, 1]`.

---

## 💡 Approach (Using Stack):

1. Initialize an empty stack.
2. Traverse each element in the array:
   - If the stack is not empty and top has opposite sign to current → **pop**.
   - Else → **push** the current element.
3. Convert the final stack to an array and **reverse** it for correct order.

---

## 🧾 Java Code

```java
import java.util.*;

class Solution {
    public static ArrayList<Integer> makeBeautiful(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!st.isEmpty()) {
                int top = st.peek();
                if ((top >= 0 && arr[i] < 0) || (top < 0 && arr[i] >= 0)) {
                    st.pop();  // Remove opposite sign pair
                } else {
                    st.push(arr[i]);
                }
            } else {
                st.push(arr[i]); // First element
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }

        Collections.reverse(ans);
        return ans;
    }
}
