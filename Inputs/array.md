import java.util.*;

public class Solution {

    // Example Function (Modify this for Different Questions)
    public static int[] processArray(int[] arr) {
        // Modify this function as per the problem statement
        Arrays.sort(arr);  // Example: Sorting the array
        return arr;
    }

    // Function to print an array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of test cases
        int t = scanner.nextInt();

        while (t-- > 0) {
            // Read the size of the array
            int n = scanner.nextInt();
            int[] arr = new int[n];

            // Read array elements
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // Process the array
            int[] result = processArray(arr);

            // Print the processed array
            printArray(result);
        }

        scanner.close();
    }
}
