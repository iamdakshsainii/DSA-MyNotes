
// package String;


//                            // method 1
// class reverse_word {
//     public String reverseWord(String word) {
//         char[] chars = word.toCharArray();  // Convert the word into a character array
//         int left = 0, right = chars.length - 1;
        
//         // Reverse the array of characters
//         while (left < right) {
//             // Swap characters
//             char temp = chars[left];
//             chars[left] = chars[right];
//             chars[right] = temp;
//             left++;
//             right--;
//         }
        
//         // Convert the character array back to a string
//         return new String(chars);
//     }
// }

//                              //Method  2
//             //   without stringbuilder juat using extra variable
// public class rev {
//     public String reverseWord(String word) {
//         // Create an empty string to store the reversed word
//         String reversed = "";

//         // Loop through the word from the end to the beginning
//         for (int i = word.length() - 1; i >= 0; i--) {
//             reversed += word.charAt(i);  // Append the character at position i
//         }

//         return reversed;  // Return the reversed string
//     }
//     // public static void main(String[] args) {
//     //     Solution solution = new Solution();
//     //     String word = "hello";
//     //     // System.out.println(solution.reverseWord(word));  // Output: "olleh"
//     // }
// }
