// Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
// A shift on s consists of moving the leftmost character of s to the rightmost position.
// For example, if s = "abcde", then it will be "bcdea" after one shift.


// Approches
// 1. just like array do for one then use loop
// 2. concat to itself holds all string poossible rotated also so check contains or not 


         // method 1
        //  class Solution {
        //     public boolean rotateString(String s, String goal) {
        //         int n=s.length();
        //         // jese mene array m kiya tha
        //         for(int i=0;i<n;i++){
        //                s= s.substring(1)+s.charAt(0);
        //                if(s.equals(goal)){
        //                 return true;
        //                }
        //         }
        //         return false;
        //     }
        //     }
        
        
                             // method 2
        // class Solution {
        //     public boolean rotateString(String s, String goal) {
        //                if(s.length() != goal.length()) return false;
        //                 return (s+s).contains(goal);
        //     }
        // }