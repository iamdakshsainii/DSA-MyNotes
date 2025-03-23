# \*\*Convert Sentence to Array Without Using \*\***`split()`**

> 🔹 **Objective:** Convert a sentence into an array of words using **pointers** and **manual iteration** instead of Java's `split()` method.

---

## **1️⃣ Brute-Force Approach (Using Character Traversal)**

### 🔹 **Concept**

- Traverse the string **character by character**.
- When a **space** is encountered, store the built word and reset for the next.
- Skip **multiple spaces** to ensure proper word extraction.

### 🔹 **Code Implementation**

```java
import java.util.ArrayList;
import java.util.Arrays;

public class SentenceToArray {
    public static void main(String[] args) {
        String sentence = "  Hello   world!  This is   Java  ";
        ArrayList<String> wordsList = new ArrayList<>();
        StringBuilder word = new StringBuilder();

        for (char c : sentence.toCharArray()) {
            if (c != ' ') {
                word.append(c); // Build the word
            } else {
                if (word.length() > 0) { // If word is built, store it
                    wordsList.add(word.toString());
                    word.setLength(0); // Reset for the next word
                }
            }
        }

        if (word.length() > 0) {
            wordsList.add(word.toString()); // Add last word
        }

        String[] words = wordsList.toArray(new String[0]);
        System.out.println(Arrays.toString(words));
    }
}
```

### 🔹 **Output**

```
[Hello, world!, This, is, Java]
```

---

## **2️⃣ Two-Pointer Approach (Efficient)**

### 🔹 **Concept**

- **Two pointers (********`i`********\*\*\*\*\*\*\*\*\*\*\*\*\*\*\*\* and ************************`j`************************)** track the start and end of each word.
- When a **space** is encountered, extract the substring.
- Skips **leading and multiple spaces**.

### 🔹 **Code Implementation**

```java
import java.util.ArrayList;
import java.util.Arrays;

public class TwoPointerSplit {
    public static void main(String[] args) {
        int n = s.length();
    int i = 0;
    int left = 0;
    int right = 0;
    List<String> li = new ArrayList<>();
    // trailing space htao
    while (i < n) {
      while (s.charAt(i) == ' ') {
        i++;
      }
      if(i>=n) break;
      left = i;
      while (i<n && s.charAt(i) != ' ') i++;
      right = i - 1;
      String word = s.substring(left, right + 1);
      li.add(word);
    }
    }
}
```

### 🔹 **Output**

```
[Hello, world!, This, is, Java]
```

---

## **3️⃣ Performance Comparison**

| Approach        | Time Complexity | Space Complexity | Notes                            |
| --------------- | --------------- | ---------------- | -------------------------------- |
| **Brute-Force** | O(n)            | O(n)             | Simple character traversal       |
| **Two-Pointer** | O(n)            | O(n)             | Faster, skips spaces efficiently |

---
