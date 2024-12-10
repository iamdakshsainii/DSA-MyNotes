    // revision-  
    // kuch kaas nhi bas ek baar tino approch dimag m sochlo and ha ek baar code deekhlo phle baar krte 
    // waqt ye dimag m nhi aa rha tha range m check krna h hr element k   
    // convert 2d to 1D              
                     
                     // ********* Problem Statement **************

//link- https://leetcode.com/problems/search-a-2d-matrix/

// You are given an m x n integer matrix matrix with the following two properties:
// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.
// You must write a solution in O(log(m * n)) time complexity.


//                                         ***** Approch(3 Approch) *******
// 1. normal linear search
// 2. Binary Search
// 3. convert to 1D Array (not in code just think off to get mid anbd then use binaru search easily)

// 2. Binary Search
// We will use a loop(say i) to select a particular row at a time.
// Next, for every row, i, we will check if it contains the target.
// If matrix[i][0] <= target && target <= matrix[i][m-1]: If this condition is met, we can conclude that row i has the possibility of containing the target.
// So, we will apply binary search on row i, and check if the ‘target’ is present. If it is present, we will return true from this step. Otherwise, we will return false.
// Otherwise, after completing the traversal, we will return false.

// 3. Convert 2D to 1D
// >Eliminate the halves based on the element at index mid: To get the element, we will convert index ‘mid’ to the corresponding cell using the above formula. Here no. of columns of the matrix = M.
// row = mid / M, col = mid % M.
// >>If matrix[row][col] == target: We should return true here, as we have found the ‘target’.
// >>If matrix[row][col] < target: In this case, we need bigger elements. So, we will eliminate the left half and consider the right half (low = mid+1).
// >>If matrix[row][col] > target: In this case, we need smaller elements. So, we will eliminate the right half and consider the left half (high = mid-1).
// >>Steps 2-3 will be inside a while loop and the loop will end once low crosses high
// (i.e. low > high). If we are out of the loop, we can say the target does not exist in the matrix. So, we will return false.

// Method 2
class searchIn2D_Array {
    boolean binarySearch(int[] arr, int target) {
    int n = arr.length;
    int low = 0, high = n - 1;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (arr[mid] == target) return true;
        else if (target > arr[mid]) low = mid + 1;
        else high = mid - 1;
    }
    return false;
}
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
         for(int i=0;i<n;i++){
               if(matrix[i][0]<=target && matrix[i][m-1]>=target){
                   return binarySearch(matrix[i],target);
                //    for (int i = 0; i < n; i++) {
                //     if(binarySearch(matrix[i], target)) return true;   
                //  }
               }
         }
         return false;
    }



//Method 3
public boolean searchMatrixII(int[][] matrix, int target) {
    int n= matrix.length;
    int m= matrix[0].length;
    int low=0;
    int high=n*m-1;
    while(low<=high){
          int mid=(low+high)/2;
          int row_index= mid/m;
          int col_index= mid%m;
        if(matrix[row_index][col_index]== target) return true;
        else if(matrix[row_index][col_index]> target)  high=mid-1;
        else low=mid+1;
    }
    return false;
    }
}
