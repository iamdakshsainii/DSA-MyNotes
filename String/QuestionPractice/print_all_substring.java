
// public class Solution {
//     public static void printSubstrings(String s) {
//         // Outer loop to pick the starting index of the substring
//         for (int i = 0; i < s.length(); i++) {

//             String substr = "";  // Start with an empty string for each starting point
//             // Inner loop to build substrings by concatenation

//             for (int j = i; j < s.length(); j++) {
//                 substr += s.charAt(j);  // Concatenate the character at position j
//                 System.out.println(substr);  // Print the current substring
//             }
//         }
//     }

//     public static void main(String[] args) {
//         String word = "abc";
//         printSubstrings(word);
//     }
// }

