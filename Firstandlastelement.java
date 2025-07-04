// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
// Approach: Taking two private methods to find first and last.comparing my target and mid values.if equal to target searching in the left side if it greater or less than mid search for right n left and same with finding last element also.
class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums==null || nums.length==0){
            return new int[]{-1,-1};
        }
        int first= binarySearchFirst(nums,target);
        if(first==-1){
          return new int[]{-1,-1};
        }
        int second=binarySearchLast(nums,target);
        return new int[]{first,second};
        
    }
    private int binarySearchFirst(int [] nums,int target){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if((mid==0) || (nums[mid-1] != nums [mid])){
                    return mid;
                }
                high=mid-1;
            }
            else if(target < nums[mid]){
                high=mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }

        private int binarySearchLast(int [] nums,int target){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if((mid==nums.length-1) || (nums[mid+1] != nums [mid])){
                    return mid;
                }
                low=mid+1;
            }
            else if(target < nums[mid]){
                high=mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
       }
}
