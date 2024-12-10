// package String.QuestionPractice;

// Learning 
// 1. when you apply looping then yaad rakho pen paper pr hr baar looping
// par kya update ho raha h vo likho like
// yaha jb tumne phle baar solve kiya tumne miss kiya ki like "codingislife" me phle iteration m "coding islife" hoga so index
// ek aage bad gayi

// 2. learning is string is immutable so dont change by insert
//instead use stringbuilder(s) in which i is intialised and then
//insert only



// You are given a 0-indexed string s and a 
// 0-indexed integer array spaces that describes 
// the indices in the original string where spaces 
// will be added. Each space should be inserted before 
// the character at the given index.
 

// Example 1:

// Input: s = "LeetcodeHelpsMeLearn", spaces = [8,13,15]
// Output: "Leetcode Helps Me Learn"
// Explanation: 
// The indices 8, 13, and 15 correspond to the underlined characters in "LeetcodeHelpsMeLearn".
// We then place spaces before those characters.





// method 1

// class Solution {
//     public String addSpaces(String s, int[] spaces) {
//         StringBuilder sb= new StringBuilder();
//         int j=0;
//           for(int i=0;i<s.length();i++){
//                     if(j<spaces.length && i ==spaces[j]){
//                         sb.append(" ");
//                         j++;
//                     }
//                     sb.append(s.charAt(i));
//           }
//           return sb.toString();
//     }
// }


// method 2
//learning part 

class Solutions {
    public String addSpaces(String s, int[] spaces) {
         int n=s.length();
         int cntspace=0;
         StringBuilder sb= new StringBuilder(s);
         for(int i=0;i<n;i++){
              if(cntspace<spaces.length){
               sb.insert(spaces[i]+cntspace ," ");
               cntspace++;
         }
         }
         return sb.toString();
    }
}
