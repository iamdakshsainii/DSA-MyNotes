## Brute Force

```java
class Solution {
   public void rotateArray(int[] nums, int k) {
    int n = nums.length;
      for(int count = 0;count<k;count++){
           int temp = nums[0];
               for(int i = 1;i<n;i++){
           nums[i - 1]=nums[i];       }
        nums[n-1] = temp;
        }
    }
 }
```

## Optimal

```java
class Solution {
    public void reverse(int[] arr,int left , int right){
          while(left <= right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
          }
    }
    public void rotateArray(int[] nums, int k) {
        int n= nums.length;
        k = k%n;
        // reverse first half
        reverse(nums, 0 ,k-1);

        //reverse second half
        reverse(nums, k ,n-1);

        //reverse completely
        reverse(nums,0,n-1);
    }
}
``
