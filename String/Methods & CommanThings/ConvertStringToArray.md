# **Convert Sentence to Array Without Using `split()`**

> 🔹 **Objective:** Convert a sentence into an array of words using **pointers** and **manual iteration** instead of Java's `split()` method.

---

## **1️⃣ Two-Pointer Approach (Efficient)**

### 🔹 **Concept**

- **Two pointers (`i` and `j`)** track the start and end of each word.
- When a **space** is encountered, extract the substring.
- Skips **leading and multiple spaces**.

### 🔹 **Code Implementation**

```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] convertSentenceToArray(String s) {
        int n = s.length();
        int i = 0;
        int left = 0;
        int right = 0;
        List<String> words = new ArrayList<>();

        // Skip leading spaces
        while (i < n) {
            while (i < n && s.charAt(i) == ' ') i++;
            if (i >= n) break;
            left = i;

            // Move until the next space
            while (i < n && s.charAt(i) != ' ') i++;
            right = i - 1;

            // Extract the word
            String word = s.substring(left, right + 1);
            words.add(word);
        }
        return words.toArray(new String[0]);
    }
}
```

### 🔹 **Example**
```java
Solution sol = new Solution();
String sentence = "  Hello   world!  This is   Java  ";
String[] words = sol.convertSentenceToArray(sentence);
System.out.println(Arrays.toString(words));
```
**Output:** `["Hello", "world!", "This", "is", "Java"]`

---

## **2️⃣ Using `split()` Method**

### 🔹 **Concept**

- Uses `split("\\s+")` which automatically handles multiple spaces.
- Trims the sentence first to remove leading/trailing spaces.

### 🔹 **Code Implementation**

```java
class Solution {
    public String[] convertSentenceToArrayUsingSplit(String s) {
        return s.trim().split("\\s+");
    }
}
```

### 🔹 **Example**
```java
Solution sol = new Solution();
String sentence = "  Hello   world!  This is   Java  ";
String[] words = sol.convertSentenceToArrayUsingSplit(sentence);
System.out.println(Arrays.toString(words));
```
**Output:** `["Hello", "world!", "This", "is", "Java"]`

---

## **3️⃣ Reverse Words in a Sentence**

### 🔹 **Method 1: Using StringBuilder (Direct Reversal)**

```java
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        StringBuilder rev = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            rev.append(words[i]);
            if (i != 0) {
                rev.append(" ");
            }
        }
        return rev.toString();
    }
}
```

### 🔹 **Step-by-Step Example**

```java
String sentence = "  Hello   world!  This is   Java  ";
Solution sol = new Solution();
System.out.println(sol.reverseWords(sentence));
```

**Process:**
```
Original: "  Hello   world!  This is   Java  "
After trim(): "Hello   world!  This is   Java"
After split(): ["Hello", "world!", "This", "is", "Java"]
Reversed order: ["Java", "is", "This", "world!", "Hello"]
Final Output: "Java is This world! Hello"
```

**Output:**
```
"Java is This world! Hello"
```

---

### 🔹 **Method 2: Using Two-Pointer Swap**

```java
class Solution {
    private String reverseArray(String[] words) {
        int n = words.length;
        int left = 0, right = n - 1;

        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", words);
    }

    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        return reverseArray(words);
    }
}
```

### 🔹 **Example**

```java
String sentence = "  Hello   world!  This is   Java  ";
Solution sol = new Solution();
System.out.println(sol.reverseWords(sentence));
```

**Output:**
```
"Java is This world! Hello"
```

---

## **4️⃣ Performance Comparison**

| Approach            | Time Complexity | Space Complexity | Notes                            |
|---------------------|----------------|------------------|----------------------------------|
| **Two-Pointer**    | O(n)           | O(n)             | Faster, skips spaces efficiently |
| **split() Method** | O(n)           | O(n)             | Simple, uses regex               |
| **Reverse (SB)**   | O(n)           | O(n)             | Uses StringBuilder               |
| **Reverse (Swap)** | O(n)           | O(n)             | Uses in-place swap               |

### **Key Takeaways:**

- **Use `split("\\s+")` for simplicity** when converting sentences to arrays.
- **Two-pointer approach** is efficient for handling spaces manually.
- **Reversing can be done using StringBuilder or swapping.** 🚀
