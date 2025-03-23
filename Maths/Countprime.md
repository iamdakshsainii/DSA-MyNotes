For Count you can first check Prime Facotrization file

```java
class Solution {
    public int countPrimes(int n) {
        int cnt = 0;
        boolean[] isprime = new boolean[n+1];
        for(int i =2;i<=n;i++){
            isprime[i] = true;
        }
        for(int i =2;i*i<=n;i++){
            if(isprime[i]){
                for(int j = i*i ; j<=n;j+=i){
                     isprime[j] = false;
                }
            }
        }
        for(int i =2;i<n;i++){
            if(isprime[i]){
                cnt++;
            }
        }
        return cnt;
    }
}
```
