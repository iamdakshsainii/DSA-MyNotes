# Common Stack Problems & Approaches

## Next Smaller Element (NSE)

**Problem:** Find the Next Smaller Element for each element in the array.

### Code Template:

```java
public int[] nextSmallest(int[] nums){
        int n = nums.length;
        int [] next = new int[n];
        Arrays.fill(next , n);
        Stack<Integer> st = new Stack<>();
        for(int i = n-1;i>=0;i--){
             if(st.isEmpty()){
                st.push(i);
             }
             else{
                // pop possiblities
                while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                    st.pop();
                }
                next[i] = st.isEmpty() ? n : st.peek();
                st.push(i);
             }
        }
        return next;
    }
```

### Example:
```java
int[] nums = {4, 8, 5, 2, 25};
System.out.println(Arrays.toString(nextSmallerElement(nums))); // Output: [2, 5, 2, -1, -1]
```

---

## Previous Smaller Element (PSE)

**Problem:** Find the Previous Smaller Element for each element in the array.

### Code Template:

```java
 public int[] prevSmallest(int[] nums){
        int n = nums.length;
        int [] prev = new int[n];
         Arrays.fill(prev , -1);
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<n;i++){
             if(st.isEmpty()){
                st.push(i);
             }
             else{
                // pop possiblities
                while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                    st.pop();
                }
                prev[i] = st.isEmpty() ? -1 : st.peek();
                st.push(i);
             }
        }
        return prev;
    }
```

### Example:
```java
int[] nums = {4, 8, 5, 2, 25};
System.out.println(Arrays.toString(prevSmallerElement(nums))); // Output: [-1, 4, 4, -1, 2]
```

---

## Next Greater Element (NGE)

**Problem:** Find the Next Greater Element for each element in the array.

### Code Template:

```java
class Solution {
    public int[] nextLargerElement(int[] arr) {
        int n = arr.length;
        int[] nums = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()){
                nums[i] = -1;
            }
            else {
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
        }
           nums[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(arr[i]);
    }
     return nums;
    }
}

```

### Example:
```java
int[] nums = {4, 8, 5, 2, 25};
System.out.println(Arrays.toString(nextGreaterElement(nums))); // Output: [8, 25, 25, 25, -1]
```

---

## Previous Greater Element (PGE)

**Problem:** Find the Previous Greater Element for each element in the array.

### Code Template:

```java
public int[] prevGreaterElement(int[] nums) {
    int n = nums.length;
    int[] arr = new int[n];
    Arrays.fill(arr, -1);
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < n; i++) {
        while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
            st.pop();
        }
        if (!st.isEmpty()) {
            arr[i] = nums[st.peek()];
        }
        st.push(i);
    }
    return arr;
}
```

### Example:
```java
int[] nums = {4, 8, 5, 2, 25};
System.out.println(Arrays.toString(prevGreaterElement(nums))); // Output: [-1, -1, 8, 5, -1]
```

---

## Largest Rectangle in Histogram

**Problem:** Given an array of integers heights representing the histogram's bar height where the width of each bar is 1 return the area of the largest rectangle in the histogram
Input: heights = [3, 5, 1, 7, 5, 9]
Output: 15
Explanation: The largest rectangle has an area of 5*3 = 15 units.

### Code Template:

```java
class Solution {
   public int[] nextSmallest(int[] nums) {
        int n =  nums.length;
        int[] arr = new int[n];
        Arrays.fill(arr, n);
        Stack<Integer> st = new Stack<>();
        for(int i =n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                 st.pop();
            }
          if(st.isEmpty()){
             arr[i] = n;
          }
          else{
            arr[i] = st.peek();
          }
          st.push(i);
        }
        return arr;
    }

    public int[] prevSmallest(int[] nums) {
        int n =  nums.length;
        int[] arr2 = new int[n];
        Arrays.fill(arr2, -1);
        Stack<Integer> st = new Stack<>();
        for(int i =0;i < n;i++){
            // in normally same value not involve so we not pop out
            // but here i need strictly smaller
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                 st.pop();
            }
          if(st.isEmpty()){
             arr2[i] = -1;
          }
          else{
            arr2[i] = st.peek();
          }
          st.push(i);
        }
        return arr2;
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] next = nextSmallest(heights);
        int[] prev = prevSmallest(heights);
        int area =0;
        int largest =0;
       for(int i =0;i<n;i++){
           area = heights[i]*(next[i] - prev[i] - 1);
           largest = Math.max(largest , area);
       }
       return largest;
    }
}

```
---

## Stock Span Problem

**Problem:** Find the stock span for each day.
Input: n = 7, arr = [120, 100, 60, 80, 90, 110, 115]
Output: 1 1 1 2 3 5 6
**Explanation:**
Traversing the given input span:
120 is greater than or equal to 120 and there are no more elements behind it so the span is 1,
100 is greater than or equal to 100 and smaller than 120 so the span is 1,
60 is greater than or equal to 60 and smaller than 100 so the span is 1,
80 is greater than or equal to 60, 80 and smaller than 100 so the span is 2,
90 is greater than or equal to 60, 80, 90 and smaller than 100 so the span is 3,
110 is greater than or equal to 60, 80, 90, 100, 110 and smaller than 120 so the span is 5,
115 is greater than or equal to all previous elements and smaller than 120 so the span is 6.
Hence the output will be 1 1 1 2 3 5 6.

### Code Template:

```java
// method 1

class Solution {
    public int[] stockSpan(int[] arr, int n) {
       int[] ans = new int[n];
       for(int i =0;i<n;i++){
          int cnt =0;
         for(int j = i; j>=0;j--){
            if(arr[j] <= arr[i]){
                cnt++;
            }
            else{
                cnt = 1;
                break;
            }
            ans[i] = cnt;
         }
       }
       return ans;
    }
}

// method 2
class Solution {
    public int[] prevSmallest(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i =0; i < n;i++){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }
        return ans;
    }
    public int[] stockSpan(int[] arr, int n) {
        int[] res = new int[n];
       int[] prev = prevSmallest(arr);
       for(int i =0;i<n;i++){
          res[i] = i-prev[i];
       }
       return res;
    }
}
```

### Example:
```java
int[] prices = {100, 80, 60, 70, 60, 75, 85};
System.out.println(Arrays.toString(stockSpan(prices))); // Output: [1, 1, 1, 2, 1, 4, 6]
```
