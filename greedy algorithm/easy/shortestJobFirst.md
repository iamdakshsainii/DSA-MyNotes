# **Shortest Job First (SJF) Scheduling**

## **Problem Statement**
A software engineer is tasked with using the **Shortest Job First (SJF)** policy to calculate the **average waiting time** for each process. The shortest job first (also known as shortest job next) scheduling policy selects the waiting process with the **least execution time** to run next.

![alt text](<WhatsApp Image 2025-03-04 at 00.24.37_f9baf6fe.jpg>)

### **Input:**
Given an array of `n` integers representing the burst times of processes, determine the **average waiting time** for all processes and return the closest whole number that is **less than or equal to the result**.

## **Example**
### **Input 1:**
```java
bt = {4, 1, 3, 7, 2};
```
### **Output 1:**
```
4
```
### **Explanation:**
The total waiting time is `20`.
So the average waiting time will be `20 / 5 = 4`.

### **Input 2:**
```java
bt = {1, 2, 3, 4};
```
### **Output 2:**
```
2
```
### **Explanation:**
The total waiting time is `10`.
So the average waiting time will be `10 / 4 = 2`.

## **Waiting Time Calculation Table**
| **Process (bt[i])** | **Waiting Time (WT)** |
|------------------|----------------|
| **1**  (First)  | `0` (Since it starts immediately) |
| **2**  (Second) | `1` (It waits for `1` to finish) |
| **3**  (Third)  | `1 + 2 = 3` (It waits for `1` and `2`) |
| **4**  (Fourth) | `1 + 2 + 3 = 6` (It waits for `1`, `2`, and `3`) |

✅ **Total Waiting Time =** `0 + 1 + 3 + 6 = 10`
✅ **Average Waiting Time =** `10 / 4 = 2`

## **Java Code**
```java
import java.util.*;

class Solution {
    public static int averageWaitingTime(int[] bt) {
        Arrays.sort(bt);
        long waitTime = 0;
        long totalTime = 0;
        int n = bt.length;

        for (int i = 0; i < n - 1; ++i) {
            waitTime += bt[i];
            totalTime += waitTime;
        }

        return (int) (totalTime / n); // Return floor value
    }

    public static void main(String[] args) {
        int[] bt1 = {4, 1, 3, 7, 2};
        int[] bt2 = {1, 2, 3, 4};

        System.out.println("Output 1: " + averageWaitingTime(bt1));
        System.out.println("Output 2: " + averageWaitingTime(bt2));
    }
}
```
