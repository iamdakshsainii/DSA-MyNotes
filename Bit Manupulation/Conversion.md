**Binary to decimal conversion**
```java
class Solution {
    static String decToBinary(int n) {
        String result ="";
        while(n != 1){
            if(n%2== 1) result+= "1";
            else result+="0";
            n = n/2;
        }
        result+="1";
       String reversed = new StringBuilder(n).reverse().toString();
        return reversed;
    }
}
```


