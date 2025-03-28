**Java program demonstrating conversion of String and Character to Integer**

**String to Integer conversion**
```java
class StringToInteger {
    public static int convert(String s) {
        // Always check if the string is empty before parsing
        if (!s.isEmpty()) {
            return Integer.parseInt(s);
        }
        return 0; // Default value if string is empty
    }
}

// Main class to test conversions
public class Main {
    public static void main(String[] args) {
        String s = "123";
        int num1 = StringToInteger.convert(s); // Ensuring non-empty string check
        System.out.println("String to Integer: " + num1);
    }
}
```

**Character to Integer conversion**

```java
class CharToInteger {
    public static int convert(char c) {
        return c - '0'; // Converts char digit to integer
    }
}

// Main class to test conversions
public class Main {
    public static void main(String[] args) {
        char c = '5';
        int num2 = CharToInteger.convert(c);
        System.out.println("Character to Integer: " + num2);
    }
}
```
