## Rotate Image 90 Degrees Clockwise

#### Problem: Given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

---------------------------------------------------
🧠 Intuition:
---------------------------------------------------
To rotate a matrix 90 degrees clockwise, the idea is to move the elements layer by layer:
1. The first row becomes the last column.
2. The second row becomes the second last column, and so on.

There are two main approaches to solve this:
- Brute Force using Extra Space
- Optimal In-place Rotation


 ---------------------------------------------------
## 🔸 Method 1: Brute Force (Using Extra Space)
- Time Complexity: O(n^2)
- Space Complexity: O(n^2) for the extra matrix
 ---------------------------------------------------

```java
class RotateImage {
    public void rotateWithExtraSpace(int[][] matrix) {
        int n = matrix.length;
        int[][] rotatedImage = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedImage[j][n - i - 1] = matrix[i][j];

        }

        // Copy the rotated image back to original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = rotatedImage[i][j];
            }
        }
    }
    }
}
```
    ----------------------------------------------------------------------------------
## 🔸 Method 2: Optimal In-place Rotation (No Extra Space)
-  Time Complexity: O(n^2)
-  Space Complexity: O(1)
     ----------------------------------------------------------------------------------
     **Step 1**: Transpose the matrix (convert rows to columns)
     **Step 2**: Reverse each row
    public void rotateInPlace(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row using two-pointer method
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

----------------------------------------------------------------------------------
### 📒 Note: How to Reverse a 2D Matrix (Row-wise)
    ----------------------------------------------------------------------------------
**There are 2 main methods to reverse a 2D matrix row-wise:**


###  1. 🔁 Using Swapping

```java
    public void reverseMatrixWithSwapping(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - j - 1];
                matrix[i][matrix[i].length - j - 1] = temp;
            }
        }
    }
```

## 2. ⏰ Using Two-Pointer

```java
    public void reverseMatrixWithTwoPointer(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            int left = 0;
            int right = matrix[i].length - 1;
            while(left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
```

 ##  3. ⏰ (i,n-j-1)

 ```java
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
```
