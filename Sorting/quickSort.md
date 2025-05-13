# 📌 Quick Sort – Intuition & Code

## 🧠 Intuition / Idea
Quick Sort is a **divide-and-conquer** algorithm that works by selecting a **pivot** and then **partitioning** the array around that pivot so that:
- All elements less than the pivot are on the left.
- All elements greater than the pivot are on the right.

It then recursively sorts the left and right subarrays.

## 🔍 How it works:
1. Choose a pivot element (commonly the first, last, or middle).
2. Partition the array into two parts:
   - Elements ≤ pivot
   - Elements > pivot
3. Recursively apply Quick Sort on both partitions.

## 📈 Time & Space Complexity
| Case       | Time       | Explanation                     |
|------------|------------|---------------------------------|
| Best Case  | O(n log n) | Balanced partitions             |
| Average    | O(n log n) | Random order                    |
| Worst Case | O(n²)      | Already sorted / unbalanced     |

- **Space**: O(log n) due to recursion stack (in-place sorting)

---

## 🧨 Partitioning in Hindi – Step by Step

- Ismein hum dekhte hain partition kaise karte hain aur pivot kaise lete hain.
- Pivot ko maan lijiye pehla element lete hain.
- Ab left pointer (`low`) ko aage badhate hain jab tak vo pivot se bada element na dhoond le. ab t ko stop krenge and
- Right pointer (`high`) ko peeche late hain jab tak pivot se chhota element na mile.
- Jab dono ruk jaayein, to dono values ko swap karo.
- Ye process tab tak chalta hai jab tak `low < high` ho.
- Jab `low` aur `high` cross ho jaayein, tab pivot ko `high` position ke element ke saath swap karte hain.
- Ab `high` ka index humein milta hai jahan pivot ko sahi jagah mil gayi hai.

---

## ❓ Interview Questions

### Q1: **How to choose the pivot in Quick Sort?**
There are multiple strategies:
- **First element**: Simple but can cause worst-case on sorted arrays.
- **Last element**: Same issues as first, depending on input.
- **Middle element**: Better for balanced partitioning.
- **Random element**: Reduces chance of worst-case, often used in practice.
- **Median of three (first, middle, last)**: Commonly used in optimized implementations.

### Q2: **What's the complexity based on pivot selection?**
| Pivot Choice     | Best Time | Worst Time | Comments                                      |
|------------------|-----------|------------|----------------------------------------------|
| First/Last       | O(n log n)| O(n²)      | Bad for sorted or reverse sorted arrays       |
| Middle           | O(n log n)| O(n²)      | Slightly better balance, still not optimal    |
| Random           | O(n log n)| O(n²)      | Randomization avoids worst-case on average    |
| Median of Three  | O(n log n)| O(n log n) | Most stable and avoids worst-case scenarios   |

---

```java
public class Solution {
    public int quickSortHelper(int[] nums, int low , int high) {
        int pivot = nums[low];
        int i = low;
        int j = high;

        while(i < j) {
            while(nums[i] <= pivot && i < high) i++;
            while(nums[j] > pivot && j > low) j--;
            if(i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
      // is swap ka reason h pivot and j vale swap honge at last when i and j crossed
        int temp = nums[low];
        nums[low] = nums[j];
        nums[j] = temp;
        return j;
    }

    public void quickSort(int[] nums, int low, int high) {
        if(low >= high) return;
        int index = quickSortHelper(nums, low, high);
        quickSort(nums, low, index - 1);
        quickSort(nums, index + 1, high);
    }

    public int[] quickSort(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        quickSort(nums, low, high);
        return nums;
    }
}
```

---

## ⚠️ Common Mistakes
- ❌ Choosing a bad pivot (can lead to O(n²) time)
- ❌ Not handling recursion base condition properly
- ❌ Confusing indices while partitioning
- ❌ Using extra space unnecessarily (should be in-place)
