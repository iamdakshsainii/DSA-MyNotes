    //    For revision 
    //    check clear observation if row contoin no 1 then what to do                
                       
 //                         ******** Problem Statement ********** 
// You are given a 2D array consisting of only 1's and 0's, 
// where each row is sorted in non-decreasing order. You need to find 
// and return the index of the first row that has the most number of 1s.
//  If no such row exists, return -1.


            //              ********Approch (two methods) ********** 
            
                                //   1. simple search
                                //   2. by binary search

// 1. Simple approch
// simply har row m search karo
// and in each row ek max ka check dal do ki agar
// cnt max se zyada h to vo value
// max m chali jayegi and index return ho jayega


// 2. Binary search

// >lowerBound
// >upperBound
// >first occurance
// so first simple do one out of above in one function
// now just use a loop in another function which ensure that each row check for max_cnt
// so loop for each row
// in loop function call with arr[i] and target as 1 
// and clear observation

    // Clear observations
//   1. as lower bound return n if row contain no 1 so apply a conditon that only cnt if lower bound < col_size  
//   or ensure at least one 1 present






                //              ******** Code ********** 

// Method 1


// class rowWithMax_1s {
//     public int rowWithMax1s(int arr[][]) {
//            int max = 0;
//         int index = -1;
//         for (int i = 0; i < arr.length;i++){
//             int cnt1= 0;
//             for (int j = 0; j < arr[i].length;j++){
//                 cnt1 += arr[i][j];
//             }

//             // agar index chahiye to check dal do

//             if (cnt1> max){
//                 max = cnt1;
//                 index = i;
//             }
//         }
//         return index;
//     }
// }

// //method 2

// @SuppressWarnings("unused")
// class Solution {
//     int lowerBound(int[] nums, int target){
//         int low=0;
//         int high=nums.length-1;
//         int ans=nums.length;
//         while(low<=high){
//             int mid = low + (high-low)/2;
//             if(nums[mid]>=target){
//                  ans=mid;
//                  high=mid-1;
//         }
//         else{
//             low=mid+1;
//         }
//     }
//     return ans;
//     }
//     public int rowWithMax1s(int arr[][]) {
//         int m=arr.length;
//         int n=arr[0].length;
//         int max=-1;
//         int index=-1;
//         for(int i=0;i<m;i++){
//             // 1. as lower bound return n if row contain no 1 so apply a conditon that only cnt if lower bound < col_size  
//             //   or ensure at least one 1 present

//               int value= lowerBound(arr[i],1);
//               if (value < n) {
//                 int cnt = n - value; 
//                 if (cnt > max) {
//                     max = cnt;
//                     index = i; 
//                 }
//             }
//         }

//    return index;
// }
// }