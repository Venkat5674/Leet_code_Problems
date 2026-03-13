class Solution {
    public int search(int[] nums, int target) {
     int low = 0;
     int high = nums.length - 1;

     while(low <= high){
        int mid = (low + high) / 2;
        int mid_num = nums[mid];

        if(target == mid_num){
            return mid;
        }
        if(target < mid_num){
            high = mid -1;
        }
        if(target > mid_num){
            low = mid + 1;
        }
     }
    return -1;
    }
    
}
