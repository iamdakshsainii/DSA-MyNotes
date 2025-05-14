# 📌 Types of Sorting Algorithms: **In-place** vs **Out-of-place**

## **In-place Sorting**
These algorithms sort the array without using extra space, except for a constant amount.

- **Bubble Sort**:
  - **Time**: O(n²)
  - **Space**: O(1)

- **Selection Sort**:
  - **Time**: O(n²)
  - **Space**: O(1)

- **Insertion Sort**:
  - **Time**: O(n²)
  - **Space**: O(1)

- **Quick Sort**:
  - **Time**: O(n log n) (avg), O(n²) (worst)
  - **Space**: O(log n) (due to recursion)

- **Heap Sort**:
  - **Time**: O(n log n)
  - **Space**: O(1)

---

## **Out-of-place Sorting**
These algorithms require additional memory beyond the original array.

- **Merge Sort**:
  - **Time**: O(n log n)
  - **Space**: O(n)

- **Counting Sort**:
  - **Time**: O(n + k)
  - **Space**: O(k)

- **Radix Sort**:
  - **Time**: O(nk)
  - **Space**: O(n + k)

- **Bucket Sort**:
  - **Time**: O(n + k)
  - **Space**: O(n)

# 📌 Stable vs Unstable Sorting Algorithms

## **Stable Sorting Algorithms**
These algorithms preserve the relative order of equal elements.

- **Merge Sort**:
  - **Time**: O(n log n)
  - **Space**: O(n)
  - **Stable**: Yes

- **Bubble Sort**:
  - **Time**: O(n²)
  - **Space**: O(1)
  - **Stable**: Yes

- **Insertion Sort**:
  - **Time**: O(n²)
  - **Space**: O(1)
  - **Stable**: Yes

---

## **Unstable Sorting Algorithms**
These algorithms do not guarantee the preservation of the relative order of equal elements.

- **Quick Sort**:
  - **Time**: O(n log n) (avg), O(n²) (worst)
  - **Space**: O(log n)
  - **Stable**: No

- **Selection Sort**:
  - **Time**: O(n²)
  - **Space**: O(1)
  - **Stable**: No

- **Heap Sort**:
  - **Time**: O(n log n)
  - **Space**: O(1)
  - **Stable**: No
