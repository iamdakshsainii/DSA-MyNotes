**💡 Problem: Sum of Subarray Minimums**

![alt text](<WhatsApp Image 2025-03-15 at 19.32.44_441abfbc.jpg>)

**Lookup Points- Revision** ->
1. overflow conditions (long and int) - please check concept of overflow before method 2 in lookup folder as it is major point to focus you can get code but there are some xcase you cant imagine but exist need to look for long and int so focus o that part of code also

2. in next greatest you need to popout equal elements also see in picture as theyt can possibly create duplicates refer example - [2,6,2,4,2] just make subarrays of all 3 2s and you get so many duplicates there so we need to pop out from stack for next one

3. no need for previous to pop as they dont contribute to subarray

Key Difference in Left (prevSmallest) and Right (nextLowest)
💡 **Goal of prevSmallest():**
We find the nearest smaller element on the left.
Duplicates are fine because they don’t affect how many valid subarrays exist.

💡 **Goal of nextLowest():**
We find the nearest smaller element on the right.
Duplicates must be popped to avoid double-counting subarrays.



### **📝 Problem Statement**
Given an array `arr` of integers, find the sum of the **minimum value** of all its subarrays. The answer should be returned **modulo** `(1e9 + 7)`.

### **🔹 Example:**
```java
Input: arr = [3, 1, 2, 4]
Output: 17
```
**Explanation:**
- Subarrays and their minimums:
  - [3] → 3
  - [1] → 1
  - [2] → 2
  - [4] → 4
  - [3,1] → 1
  - [1,2] → 1
  - [2,4] → 2
  - [3,1,2] → 1
  - [1,2,4] → 1
  - [3,1,2,4] → 1
- **Sum = 17**

---

## **🔹 Method 1: Brute Force (O(N²))**
### **🧠 Intuition:**
- Iterate through all subarrays.
- Find the **minimum element** for each subarray.
- Add it to the sum.

### **🔹 Code:**
```java
class Solution {
  public int sumSubarrayMins(int[] arr) {
    int n = arr.length;
    long sum = 0;
    int mod = (int) 1e9 + 7;

    for (int i = 0; i < n; i++) {
      int mini = Integer.MAX_VALUE;
      for (int j = i; j < n; j++) {
        mini = Math.min(mini, arr[j]);
        sum = (sum + mini) % mod;
      }
    }
    return (int) sum;
  }
}
```

### **✅ Key Points:**
- **Time Complexity:** `O(N²)`, as it checks all subarrays.
- **Space Complexity:** `O(1)`, as it uses no extra space.

---

## **🔹 Method 2: Optimized Using Monotonic Stack (O(N))**
### **🧠 Intuition:**
- Instead of checking all subarrays, use a **monotonic increasing stack** to find the nearest **previous smaller** and **next smaller** element.
- This helps determine how many subarrays an element contributes as the minimum value.
- **Contribution of an element = (left range) * (right range) * arr[i]**.

### **🔹 Code:**
```java
class Solution {
  public int[] prevSmallest(int[] arr){
     int n = arr.length;
     int[] left = new int[n];
     Arrays.fill(left,-1);
     Stack<Integer> st = new Stack<>();
     for(int i =0;i<n;i++){
           if(st.isEmpty()){
              st.push(i);
           }
           else {
             while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                 st.pop();
             }
             left[i] = st.isEmpty() ? -1  : st.peek();
             st.push(i);
           }
     }
     return left;
  }

    public int[] nextLowest(int[] arr){
     int n = arr.length;
     int[] right = new int[n];
     // n fill because we compare from last side so it may possible ki last bhi bda hi ho (abhi nhi smjh aya t oex 1 dry run krlo)
     Arrays.fill(right,n);
     Stack<Integer> st2 = new Stack<>();
     for(int i= n-1;i>=0;i--){
           if(st2.isEmpty()){
              st2.push(i);
           }

           else {
            // important thing is -> to handle duplicate as it dont contribute to subarray so pop
             while(!st2.isEmpty() && arr[st2.peek()] >= arr[i]){
                 st2.pop();
             }
             right[i] = st2.isEmpty() ? n : st2.peek();
             st2.push(i);
           }
     }
    return right;
  }

  public int sumSubarrayMins(int[] arr) {
    int[] arrL = prevSmallest(arr);
    int[] arrR = nextLowest(arr);
    int n = arr.length;
    long sum=0;
    int mod = ((int) 1e9 + 7);
    for(int i = 0;i<n;i++){
      long totalContri = (long) ((i - arrL[i]) * (arrR[i] - i));
      sum = (sum + totalContri * (long)arr[i]) % mod;
    }
    return (int)(sum);
  }
}
```

### **✅ Key Points:**
- **Time Complexity:** `O(N)`, as each element is pushed/popped once.
- **Space Complexity:** `O(N)`, for `left[]`, `right[]`, and stack.

---

## **📌 Dry Run Example**
### **Input:**
`arr = [3, 1, 2, 4]`

### **Step 1: Compute prevSmallest(arr)**

| i  | arr[i] | Stack (Indexes) | Popping Condition | left[i] Update | Final Stack |
|----|--------|----------------|------------------|----------------|-------------|
| 0  | 3      | Empty → Push 0 | No pop (stack empty) | -1 | [0] |
| 1  | 1      | Stack [0] | Pop 0 (3 > 1) | -1 | [1] |
| 2  | 2      | Stack [1] | No pop (1 < 2) | 1 | [1,2] |
| 3  | 4      | Stack [1,2] | No pop (2 < 4) | 2 | [1,2,3] |

**Output:** `left = [-1, -1, 1, 2]`

### **Step 2: Compute nextLowest(arr)**

| i  | arr[i] | Stack (Indexes) | Popping Condition | right[i] Update | Final Stack |
|----|--------|----------------|------------------|-----------------|-------------|
| 3  | 4      | Empty → Push 3 | No pop (stack empty) | 4 | [3] |
| 2  | 2      | Stack [3] | Pop 3 (4 >= 2) | 3 | [2] |
| 1  | 1      | Stack [2] | Pop 2 (2 >= 1) | 4 | [1] |
| 0  | 3      | Stack [1] | No pop (1 < 3) | 1 | [1,0] |

**Output:** `right = [1, 4, 3, 4]`

### **Step 3: Compute Sum Using Contribution Formula**

`width = (i - left[i]) * (right[i] - i);`

Final Sum: **`17`**

---

🚀 **Optimized Complexity:** `O(N)`, much better than `O(N²)`. 🔥
