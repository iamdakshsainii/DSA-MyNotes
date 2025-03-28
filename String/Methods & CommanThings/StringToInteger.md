**Concept**
Java program demonstrating conversion of String and Character to Integer
```java
public class StringToInteger {
    public static void main(String[] args) {

        // Case 1: Converting String to Integer (Always check for empty string)
        String s = "123";
        int num1 = 0;
        if (!s.isEmpty()) { // Ensuring the string is not empty before parsing
            num1 = Integer.parseInt(s);
        }
        System.out.println("String to Integer: " + num1);

        // Case 2: Converting Character to Integer
        // Directly subtracting '0' from character gives its integer value
        char c = '5';
        int num2 = c - '0'; // '5' - '0' = 5
        System.out.println("Character to Integer: " + num2);
    }
}
```



### Java program demonstrating various string and number operations

**Problem 1** -> Problem 1: Sum of Numbers in a String
```java
import java.util.*;

public class StringNumberProblems {
    public static int sumNumbersInString(String str) {
        int sum = 0;
        String num = "";
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                num += c;
            } else {
                if (!num.isEmpty()) {
                    sum += Integer.parseInt(num);
                    num = "";
                }
            }
        }
        if (!num.isEmpty()) sum += Integer.parseInt(num);
        return sum;
    }
```

### Problem 2: Extract and Print Numbers from a String

    ```java
    public static void extractAndPrintNumbers(String str) {
        String s = "";
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                s += c;
            } else {
                if (!s.isEmpty()) {
                    System.out.print(s + " ");
                    s = "";
                }
            }
        }
        if (!s.isEmpty()) System.out.print(s);
    }
```

### Problem 3: Find the Largest Number in a String
```java
    public static int findLargestNumber(String str) {
        int maxNum = 0;
        String num = "";
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                num += c;
            } else {
                if (!num.isEmpty()) {
                    maxNum = Math.max(maxNum, Integer.parseInt(num));
                    num = "";
                }
            }
        }
        if (!num.isEmpty()) maxNum = Math.max(maxNum, Integer.parseInt(num));
        return maxNum;
    }
```

### Problem 4: Sum of Even Numbers in a String
```java
    public static int sumEvenNumbers(String str) {
        int sum = 0;
        String num = "";
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                num += c;
            } else {
                if (!num.isEmpty() && Integer.parseInt(num) % 2 == 0) {
                    sum += Integer.parseInt(num);
                }
                num = "";
            }
        }
        if (!num.isEmpty() && Integer.parseInt(num) % 2 == 0) sum += Integer.parseInt(num);
        return sum;
    }
```

### General inputs
```java
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println("Sum of Numbers: " + sumNumbersInString(str));
        System.out.print("Extracted Numbers: "); extractAndPrintNumbers(str);
        System.out.println("\nLargest Number: " + findLargestNumber(str));
        System.out.println("Sum of Even Numbers: " + sumEvenNumbers(str));

        sc.close();
    }
}
```
