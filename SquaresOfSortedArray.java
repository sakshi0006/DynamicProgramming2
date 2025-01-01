/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 
Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
*/
class Solution {
    public int[] sortedSquares(int[] nums) {
        int result[] = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }
        int j = -1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] < nums[i]){
                 j=i-1; break;
            }
        }

        int z=0, p1, p2; 
        if(j == -1){
           j= nums.length-1;
        }
        result[z++] = nums[j];
        p1 = j-1;
        p2 = j+1;

        while(p1 >= 0 && p2 < nums.length) {
           if(nums[p1] < nums[p2]){
              result[z++] = nums[p1--];
           }else {
            result[z++] = nums[p2++];
           }
        }
        while(p1>=0) result[z++] = nums[p1--];
        while(p2 <nums.length) result[z++] = nums[p2++];
      return result;
    }
}
