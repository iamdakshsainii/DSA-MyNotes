// package Array.2D Array;
// Give a N * N square matrix A, return all the elements of its anti-diagonals from top to bottom.
// Input: 
// N = 3 
// A = [[1, 2, 3],
//      [4, 5, 6],
//      [7, 8, 9]]
// Output: 
// 1 2 4 3 5 7 6 8 9
// Explanation: 
// Hence, elements will be returned in 
// the order {1, 2, 4, 3, 5, 7, 6, 8, 9}.

//      *Approch - 1 Approch
// hum ise two pointer se krenge and secondary diagonal tk alg then niche alag
// phle hum colume m end tk jayege to upper triangle print ho jayega then two pointer reintialise krna pdega 
//for row wise movement for lower triangular matrix.


                         //   ******* Code ***************

// public class print_diagonals {
//     ArrayList<Integer> arr = new ArrayList<>();
//         int col=0;
//         int n=mat.length;
        // phle column wise chal rhe hai 
//         while(col<n){
//             int i=0;
//             int j=col;
//             int n;
//                         while(i<n && j>=0){
//                 arr.add(A[i][j]);
//                 i++;
//                 j--;
//             }
//             col++;
//         }
//         ? abhi row wise niche jayege
//         int row=1;
//         while(row<n){
//             int i=row;
//             int j=n-1;
//             while(i<n && j>=0){
//                 arr.add(A[i][j]);
//                 i++;
//                 j--;
//             }
//             row++;
//         }
//       return arr;  
//     }
// }

// }
