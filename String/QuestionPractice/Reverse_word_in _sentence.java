//                                  revision
                 //                 Point 1
// how to give space bw words while checking condition
//if (i != wrds.length - 1) {
//                 rev.append(" ");
//             }


                   //                 Point 2
//  agr huum split krte h kuch and Aarray m convert krte h to 
// use vps s string m cobvert karo like reverse words m hum phle aaaray m krte 
// h words ko then reverse function m reverse krte h baad m at last
// abhi vo array m result dega so back to string karo use 

// // Concatenate words manually (without StringBuilder)
//     String result = "";
//     for (int i = 0; i < n; i++) {
//         result += s[i];
//         if (i < n - 1) {
//             result += " ";
//         }
//     }
//     return result;

// // Join the words back into a single string with spaces
//       StringBuilder result = new StringBuilder();
//       for (int i = 0; i < n; i++) {
//           result.append(words[i]);
//           if (i < n - 1) {
//               result.append(" ");
//           }



//                                      Probelm
// Given an input string s, reverse the order of the words.
// A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
// Return a string of the words in reverse order concatenated by a single space.
// Note that s may contain leading or trailing spaces or multiple spaces between two words. 
// The returned string should only have a single space separating the words. Do not include any extra spaces.

 


// class Solution {
//     public String reverseWords(String s) {
//         s = s.trim();
//         String[] wrds = s.split("\\s+");
//         StringBuilder rev = new StringBuilder();
//         for (int i = wrds.length - 1; i >= 0; i--) {
//             if (i != wrds.length - 1) {
//                 rev.append(" ");
//             }
//             rev.append(wrds[i]);                                
//         }
//         return rev.toString();
//     }

//     @SuppressWarnings("unused")
//     boolean reverseWord(String word) {
//         throw new UnsupportedOperationException("Not supported yet.");
//     }
// }