**Problem Statement:**
Given a string `s`, reverse the order of words in the string while keeping the words themselves intact. Remove any extra spaces so that there is exactly one space between words, and there are no leading or trailing spaces.

**Example:**

```
Input: "  hello  world   "
Output: "world hello"
```

---

## **Brute Force Approach**

### **Intuition:**

- We cannot directly convert the string into an array because it contains spaces.
- We need to extract each word separately and store them.
- Then, we can reverse the order of the words and form the final result.

### **Approach:**

1. **Extract Words:**
   - Use a loop to traverse the string while ignoring leading spaces.
   - Extract words one by one and store them in a list.
   - Ignore multiple spaces between words.
2. **Reverse the Order:**
   - Iterate over the list of words in reverse order and append them to a `StringBuilder`.
   - Ensure exactly one space is added between words.
3. **Return the Result:**
   - Convert the `StringBuilder` to a string and return it.

---

## **Brute Force Code:**

```java
class Solution {
  public String reverseWords(String s) {
    int n = s.length();
    int i = 0;
    int left = 0;
    int right = 0;
    List<String> li = new ArrayList<>();

    // Traverse the string to extract words
    while (i < n) {
      // Ignore leading spaces
      while (i < n && s.charAt(i) == ' ') {
        i++;
      }

      if (i >= n) break; // If no word is left, break

      left = i; // Mark start of a word
      while (i < n && s.charAt(i) != ' ') i++; // Find the end of the word

      right = i - 1;
      String word = s.substring(left, right + 1);
      li.add(word); // Store the word
    }

    // Reverse and join words
    StringBuilder sb = new StringBuilder();
    for (int j = li.size() - 1; j >= 0; j--) {
      sb.append(li.get(j));
      if (j != 0) sb.append(' '); // Add space between words
    }

    return sb.toString();
  }
}

```

**Other Method**

```java
import java.util.Scanner;

class Solution {
    public String reverseWords(String s) {
        s = s.trim(); // Remove leading and trailing spaces
        String[] wrds = s.split("\\s+"); // Split by one or more spaces
        StringBuilder rev = new StringBuilder();
        for (int i = wrds.length - 1; i >= 0; i--) {
            if (i != wrds.length - 1) {
                rev.append(" ");
            }
            rev.append(wrds[i]);
        }
        return rev.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = scanner.nextLine();
        Solution solution = new Solution();
        String result = solution.reverseWords(input);
        System.out.println("Reversed Words: " + result);
        scanner.close();
    }
}

```
---

## **Time Complexity Analysis:**

- **Extracting words:** `O(N)`
- **Storing words in a list:** `O(N)`
- **Reversing and joining words:** `O(N)`
- **Total Complexity:** `O(N)`

## **Space Complexity Analysis:**

- `O(N)` for storing words in a list.
- `O(N)` for output string construction.
- **Total Complexity:** `O(N)`

---
