
//                                   **** Revision***********
// num.charAt(i) - '0':

// This operation converts the character num.charAt(i) into its numeric value.
// Characters representing digits (e.g., '0', '1', '2', ...) have a corresponding integer value, where:
// '0' becomes 0
// '1' becomes 1
// '2' becomes 2
// '9' becomes 9
// Subtracting the Unicode value of '0' from the character num.charAt(i) gives the integer value of the digit.
// For example:
// If num.charAt(i) is '5', then '5' - '0' results in the integer 5.
// If num.charAt(i) is '2', then '2' - '0' results in the integer 2.
// % 2 != 0:





// Longest odd number

// class Solution {
//     public String largestOddNumber(String num) {
//               int n= num.length();
//               for(int i=n-1;i>=0;i--){
//                if ((num.charAt(i) - '0') % 2 != 0) {
//                 return num.substring(0, i + 1);
//             }
//               }
//               return "";
//     }
// }