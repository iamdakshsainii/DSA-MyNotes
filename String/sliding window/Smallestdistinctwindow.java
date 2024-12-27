// // Given a string s, your task is to find the smallest window length that contains all the characters of the given string at least one time.
// // Example:
// // Input: s = "AABBBCBBAC"
// // Output: 3
// // Explanation: Sub-string -> "BAC"
// // Input: s = "aaab"
// // Output: 2
// // Explanation: Sub-string -> "ab"

// class Solution {
//     public int findSubString(String s) {
//        int n=s.length();
//        int first=0;
//        int minlen=Integer.MAX_VALUE;
//        HashSet<Character> hs = new HashSet<>();
//        for(int i=0;i<n;i++){
//            hs.add(s.charAt(i));
//        }
//        int cnt= hs.size();
//        hs.clear();
//        for(int second=0;second<n;second++){
//             while(hs.size()== cnt){
//                  hs.remove(s.charAt(first));
//                  first++;
//             }
//             hs.add(s.charAt(second));
//             minlen = Math.min(minlen,second-first+1);
//        }
//        return minlen;
//     }
// }