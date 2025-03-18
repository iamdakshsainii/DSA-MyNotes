# Trapping Rainwater Problem

## Problem Statement
Given an array of non-negative integers representing the heights of bars in a histogram where the width of each bar is 1, compute how much water it can trap after raining.

### Example
#### Input:
```plaintext
height = [0,1,0,2,1,0,1,3,2,1,2,1]
```
#### Output:
```plaintext
6
```
#### Explanation:
The above elevation map (given in the example) can trap 6 units of water.

---
## Approach 1: Brute Force (O(n^2))
### Intuition:
For each element, find the maximum height to its left and right. The trapped water is the difference between the current height and the minimum of the left and right max heights.

### Code:
```python
def trap_brute_force(height):
    n = len(height)
    water = 0
    for i in range(n):
        left_max = max(height[:i+1])
        right_max = max(height[i:])
        water += min(left_max, right_max) - height[i]
    return water
```

---
## Approach 2: Using Precomputed Arrays (O(n) time, O(n) space)
### Intuition:
Precompute left max and right max arrays to avoid redundant calculations.

### Code:
```python
def trap_precomputed(height):
    n = len(height)
    if n == 0:
        return 0

    left_max = [0] * n
    right_max = [0] * n
    left_max[0] = height[0]
    for i in range(1, n):
        left_max[i] = max(left_max[i-1], height[i])

    right_max[n-1] = height[n-1]
    for i in range(n-2, -1, -1):
        right_max[i] = max(right_max[i+1], height[i])

    water = 0
    for i in range(n):
        water += min(left_max[i], right_max[i]) - height[i]

    return water
```

---
## Approach 3: Two-Pointer Approach (Optimal O(n) time, O(1) space)
### Intuition:
Instead of using extra space, use two pointers and track left max and right max dynamically.

### Code:
```python
def trap_two_pointer(height):
    if not height:
        return 0

    l, r = 0, len(height) - 1
    left_max, right_max = height[l], height[r]
    water = 0

    while l < r:
        if left_max < right_max:
            l += 1
            left_max = max(left_max, height[l])
            water += left_max - height[l]
        else:
            r -= 1
            right_max = max(right_max, height[r])
            water += right_max - height[r]

    return water
```

---
## Summary
| Approach | Time Complexity | Space Complexity |
|----------|----------------|------------------|
| Brute Force | O(n^2) | O(1) |
| Precomputed Arrays | O(n) | O(n) |
| Two-Pointer | O(n) | O(1) |

The two-pointer approach is the most optimal in terms of space efficiency, making it the best choice for solving the problem efficiently.
