//                               ***** revision *********-

// like we do in hashmap to put element along with occurance 
// we do just take array of count and add in 2D array

// hashing same hi hoti h bas do loop lag jate h
// in hashset please dont first add element to hashset and then check for condition
// instead do check whether element present or not if not use else for add and yes use if for that or vice versa just get the context clear


// Problem Statement
// You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2].
//  Each integer appears exactly once except a which appears twice and b which is missing. 
//  The task is to find the repeating and missing numbers a and b.

// Approches(3 approch)
// 1. using count array
// 2. HashSet and hashing 



                                    // method 1

// class Solution {
//     public int[] findMissingAndRepeatedValues(int[][] grid) {
//          int n = grid.length;
//         int n2 = n * n; 
//         int[] count = new int[n2+1];
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 int num = grid[i][j];
//                 count[num]++;
//             }
//         }
//         int repeating = -1;
//         int missing = -1;
//         for (int i = 1; i <= n2; i++) {
//             if (count[i] == 2) {
//                 repeating = i;  
//             } else if (count[i] == 0) {
//                 missing = i; 
//             }
//         }
//         return new int[] {repeating, missing};

//     }
// }


                                          // Method 2

// public class Solution {
//     public int[] findMissingAndRepeating(int[][] grid) {
//         int n = grid.length;
//         int n2 = n * n;  // Total number of elements should be n^2
        
//         // Create a HashSet to store the numbers we've seen
//         HashSet<Integer> seen = new HashSet<>();
        
//         int repeating = -1;
//         int missing = -1;
        
//         // Traverse the matrix to identify the repeating number
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 int num = grid[i][j];
//                 if (seen.contains(num)) {
//                     repeating = num;  // If already in set, this is the repeating number
//                 } else {
//                     seen.add(num);  // Add number to the set
//                 }
//             }
//         }
        
//         // Now we find the missing number by checking all numbers from 1 to n^2
//         for (int i = 1; i <= n2; i++) {
//             if (!seen.contains(i)) {
//                 missing = i;  // The number that is not in the set is the missing one
//                 break;
//             }
//         } 
//         return new int[] {repeating, missing};
//     }