import java.util.*;
public class sorting {
    public static void bubbleSort(int[] nums, int n){
        // number of pass
         for(int i =0;i<n;i++){
             // number of swaps
             for(int j=0;j<n-i-1;j++){
                 if(nums[j] > nums[j+1]){
                      int temp = nums[j];
                      nums[j] = nums[j+1];
                      nums[j+1] = temp;
                 }
             }
         }
    }
      public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter number fo element: ");
            int n = sc.nextInt();
            System.out.println("Enter Array Elements: ");
            int[] arr = new int[n];

            for(int i =0;i<n;i++){
                arr[i] = sc.nextInt();
            }

            bubbleSort(arr,n);
            System.out.println("Sorted Array: ");
        for(int i =0;i<n;i++){
            System.out.println(arr[i]);
        }
        }

        }
}
