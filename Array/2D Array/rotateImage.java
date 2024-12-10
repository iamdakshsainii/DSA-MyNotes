// package Array.2D Array;

// // Rotate image k 2 approches hai
// 1. using extra space
// 2. inplace
//  step 1- transpose of matrix
//  step 2- reverse each row one by one
//              #reverse also has 2 to 3 approches
//                  1. using two pointer ek start  m leke and ek last m like 1D 
//                  2. using extra space  (// Copy elements from original array to temp in reverse order
//                                            temp[i] = arr[n - i - 1];

//                                        ( Copy elements back to origi)nal array)

//                 3. swap arr[i] with arr[n - i - 1] (yaha ye yaad rakho ki j jo h vo n/2 baar hi chlega as half m ate hi reverse ho jate )


                                     //   ******* Code ***************

                            
// class rotateImage {
//                             // Method 1
//     public void rotate(int[][] matrix) {
//          int n=matrix.length;
//         int[][] rotateimage= new int[n][n];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 rotateimage[j][n-i-1]=matrix[i][j];
//             }
//         }
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 matrix[i][j]=rotateimage[i][j];
//             }
//         }        
   

//                              //method 2
//     // #reverse the array
//     //         1. using swapping
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n/2;j++){
//                 int temp = 0;
//                 temp = matrix[i][j];
//                 matrix[i][j] = matrix[i][n-j-1];
//                 matrix[i][n-j-1] = temp;
//             }
//         }

//     //    2. using two pointer

//         for(int i=0;i<n;i++){
//              int left=0;
//           int right=n-1;
//         while(left<right){
//             int temp=0;
//             temp= matrix[i][left];
//             matrix[i][left]=matrix[i][right];
//             matrix[i][right]=temp;
//             left++;
//             right--;
//         }
//         }
//     }
// }