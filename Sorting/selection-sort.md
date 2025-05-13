## 📌 Selection Sort – Intuition & Code
### 🧠 Intuition / Idea
Selection Sort ek simple comparison-based sorting algorithm hai. Har step mein:

- Ek element ko fix karte hain (starting from index 0)

- Uske baad ke sabhi elements se compare karke, sabse chhota element dhoondte hain

- Fir use current index pe swap kar dete hain

## 🧠 Yaad Rakho (Hindi section):
- Yaha hum minimum index (minIndex) dhundhte hain

- Pointer i pe fixed rakhte hain aur j se compare karte hain aage ke elements

- Har bar sabse chhota milne par minIndex update hota hai

- End me minIndex != i ho to hi swap hota hai

## 📈 Time & Space Complexity

| Case       | Time  | Explanation               |
| ---------- | ----- | ------------------------- |
| Best Case  | O(n²) | Sabhi comparisons honge   |
| Average    | O(n²) | Har bar minimum dhoondhna |
| Worst Case | O(n²) | Poori tarah unsorted ho   |

- Space: O(1) – In-place sorting
- Stable? ❌ Nahin (Same value ka order badal sakta hai)

## ⚠️ Common Mistakes
❌ arr[j] < arr[i] likhna — Galat comparison

✅ Sahi: arr[j] < arr[minIndex]

❌ Har iteration mein swap karna

✅ Sirf minIndex != i ho tabhi swap karo

## ⏳ Code :

```java
public class Solution {
    public int[] selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }
}
```
