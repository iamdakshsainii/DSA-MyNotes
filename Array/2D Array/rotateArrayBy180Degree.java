
// // Rotate image k 3 approches hai
// 1. using extra space   (approch same as of 90 )
// 2. inplace  (approch same as of 90 )
//3. two times 90Degree case (dont do this )



                      //   ******* Code ***************
                      
                             // method 1
class rotateArrayBy180Degree {
    public void rotateMatrix(int[][] mat) {
           int n = mat.length;
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                  ans[n-i-1][n-j-1] =mat[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j]=ans[i][j];
            }
        }


                       // method 2

        // Transpose
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[n-i-1][j];
                mat[n-i-1][j] = temp;
            }
        }
          // Reverse each row
        for (int i = 0; i < n; i++) {
            int start = 0, end = n - 1;
            while (start < end) {
                int temp = mat[i][start];
                mat[i][start] = mat[i][end];
                mat[i][end] = temp;
                start++;
                end--;
            }
        }
    }
}