// revision:
// check out approches

// link
// https://leetcode.com/problems/search-a-2d-matrix-ii/

// Problem Statement
// Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.

// Approches (2 methods)
// 1. binary search on each loop ( check how bool function use )   >>> agar boolean function ho to main function maine IF case lagana Jaruri h basic h but bhul jata hu main baar baar
// 3. check to that element from where i can move my pointer
           
                    

                     //  method 2

// boolean binarySearch(int[] nums, int target) {
//     int n = nums.length; 
//     int low = 0, high = n - 1;
//     while (low <= high) {
//         int mid = (low + high) / 2;
//         if (nums[mid] == target) return true;
//         else if (target > nums[mid]) low = mid + 1;
//         else high = mid - 1;
//     }
//     return false;
// }

//   public boolean searchMatrix(int[][] matrix, int target) {
//     int n = matrix.length;
//     int m=matrix[0].length;
//     for (int i = 0; i < n; i++) {
//        if(binarySearch(matrix[i], target)) return true;   
//     }
//     return false;
// }


                           // method 1

class search_in_2D_matrix_II {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m= matrix[0].length;
           int row=0;
           int col=m-1;
           while(row<n && col>=0){
                if(matrix[row][col]==target){
                    return true;
                }
                else if(matrix[row][col]>target){
                          col--;
                }
                else {
                    row++;
                }
           }
           return false;
    }
}