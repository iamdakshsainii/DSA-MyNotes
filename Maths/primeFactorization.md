**Problem Statement:**
 Given an array of integers, return a list where each element contains the prime factors of the corresponding integer.
Example:
Input: [10, 15, 17, 20]
Output: [[2, 5], [3, 5], [17], [2, 2, 5]]

### Step 1
**Check For Prime**
```java
 // Step 1: Check if a number is prime
    public static boolean isPrime(int n) {
        if (n < 2) return false; // 0 and 1 are not prime
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
```
### Step 2
**Prime Factorization**
```java
public static List<Integer> getPrimeFactors(int num) {
        List<Integer> factors = new ArrayList<>();

        // Handle 2 separately since it's the only even prime number
        while (num % 2 == 0) {
            factors.add(2);
            num /= 2;
        }

        // Check for odd factors starting from 3
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            while (num % i == 0) {
                factors.add(i);
                num /= i;
            }
        }

        // If num is still greater than 2, it must be prime
        if (num > 2) {
            factors.add(num);
        }

        return factors;
    }
```

**Complete Code**

```java
class PrimeFactorsConcepts {

    // Step 1: Check if a number is prime
    public static boolean isPrime(int n) {
        if (n < 2) return false; // 0 and 1 are not prime
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Step 2: Get prime factors of a given number
    public static List<Integer> getPrimeFactors(int num) {
        List<Integer> factors = new ArrayList<>();

        // Handle 2 separately since it's the only even prime number
        while (num % 2 == 0) {
            factors.add(2);
            num /= 2;
        }

        // Check for odd factors starting from 3
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            while (num % i == 0) {
                factors.add(i);
                num /= i;
            }
        }

        // If num is still greater than 2, it must be prime
        if (num > 2) {
            factors.add(num);
        }

        return factors;
    }

    // Step 3: Process multiple queries
    public static List<List<Integer>> primeFactors(int[] queries) {
        List<List<Integer>> result = new ArrayList<>();

        for (int num : queries) {
            result.add(getPrimeFactors(num));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] queries = {10, 15, 17, 20};
        List<List<Integer>> results = primeFactors(queries);

        for (int i = 0; i < queries.length; i++) {
            System.out.println("Prime factors of " + queries[i] + ": " + results.get(i));
        }
    }
}
```

**Unique Factor only**
Given a number N. Find its unique prime factors in increasing order.

**Example 1:**
Input: N = 100
Output: 2 5
Explanation: 2 and 5 are the unique prime
factors of 100.

```java
class Solution
{
    public int[] AllPrimeFactors(int N)
    {
      List<Integer> li = new ArrayList<>();
      if(N % 2 == 0){
          li.add(2);
      while(N % 2 == 0){
          N /= 2;
      }
      }
      for(int i = 3 ;i<=N ;i+=2){
          if(N % i == 0){
              li.add(i);
              while(N % i == 0){
                    N /= i;
              }

          }
      }
      int [] arr = new int[li.size()];
      for(int i =0;i<li.size();i++){
          arr[i] = li.get(i);
      }
      return arr;
    }
}

```
