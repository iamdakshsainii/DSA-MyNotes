// 3. Convert 2D to 1D
// >Eliminate the halves based on the element at index mid: To get the element, we will convert index ‘mid’ to the corresponding cell using the above formula. Here no. of columns of the matrix = M.
// row = mid / M, col = mid % M.
// >>If matrix[row][col] == target: We should return true here, as we have found the ‘target’.
// >>If matrix[row][col] < target: In this case, we need bigger elements. So, we will eliminate the left half and consider the right half (low = mid+1).
// >>If matrix[row][col] > target: In this case, we need smaller elements. So, we will eliminate the right half and consider the left half (high = mid-1).
// >>Steps 2-3 will be inside a while loop and the loop will end once low crosses high
// (i.e. low > high). If we are out of the loop, we can say the target does not exist in the matrix. So, we will return false.

//Problem Statement
// Search in a sorted 2D matrix
// Problem Statement: You have been given a 2-D array 'mat' of size 'N x M'
//  where 'N' and 'M' denote the number of rows and columns, respectively.
// The elements of each row are sorted in non-decreasing order. Moreover, 
// the first element of a row is greater than the last element of the previous
// row (if it exists). You are given an integer ‘target’, and your task is to find
//  if it exists in the given 'mat' or not.




// public boolean searchMatrix(int[][] matrix, int target) {
//     int n= matrix.length;
//     int m= matrix[0].length;
//     int low=0;
//     int high=n*m-1;
//     while(low<=high){
//           int mid=(low+high)/2;
//           int row_index= mid/m;
//           int col_index= mid%m;
//         if(matrix[row_index][col_index]== target) return true;
//         else if(matrix[row_index][col_index]> target)  high=mid-1;
//         else low=mid+1;
//     }
//     return false;
//     }
// }

