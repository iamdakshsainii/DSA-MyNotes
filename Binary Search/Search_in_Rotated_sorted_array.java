// class Solution {
//     public int search(int[] nums, int target) {
//         int low = 0, high = nums.length - 1;

//         while (low <= high) {
//             int mid = low + (high - low) / 2;

//             // Check if mid is the target
//             if (nums[mid] == target) {
//                 return mid;
//             }

//             // Check if the left half is sorted
//             if (nums[low] <= nums[mid]) {
//                 // Check if the target lies in the left half
//                 if (nums[low] <= target && target < nums[mid]) {
//                     high = mid - 1;
//                 } else {
//                     low = mid + 1;
//                 }
//             } 
//             // Else, the right half must be sorted
//             else {
//                 // Check if the target lies in the right half
//                 if (nums[mid] < target && target <= nums[high]) {
//                     low = mid + 1;
//                 } else {
//                     high = mid - 1;
//                 }
//             }
//         }

//         // If the target is not found
//         return -1;
//     }

//     // Test the function
//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         int[] nums = {4, 5, 6, 7, 0, 1, 2};
//         int target = 0;
//         System.out.println(sol.search(nums, target)); // Output: 4

//         target = 3;
//         System.out.println(sol.search(nums, target)); // Output: -1
//     }
// }
