#### Problem: Sum of Digits in a Given Number
Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
Example: num = 529 => 5+2+9=16 => 1+6=7 (Output: 7)
Example: num = 101 => 1+0+1=2 (Output: 2)

### Iterative Approach
```java
class SolutionIterative {
    public int addDigits(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += digit;
            n /= 10;
        }
        while (sum > 9) {
            int sumi = 0;
            while (sum != 0) {
                int newsum = sum % 10;
                sumi += newsum;
                sum /= 10;
            }
            sum = sumi;
        }
        return sum;
    }
}
```
### Optimized Approach (Using Digital Root Formula, O(1) Complexity)
```java
class SolutionOptimized {
    public int addDigits(int n) {
        if (n == 0) return 0;
        return 1 + (n - 1) % 9;
    }
}
```
