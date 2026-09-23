/**
 * @param {number[]} nums
 * @param {number} x
 * @return {number}
 */
var minOperations = function(nums, x) {
    let total = 0;
    for(let num of nums){
        total += num;
    }
    
    let target = total - x;

    if(target < 0 ){
        return -1;
    }

    if(target == 0){
        return n;
    }

    let left = 0;
    let sum = 0;
    let longest = -1;

    for(let right = 0; right < nums.length; right++){
        sum += nums[right];
   

    while(left <= right && sum > target){
        sum -= nums[left++];
    }

    if(sum == target){
        longest = Math.max(longest, right - left + 1);
    }
    }
    return longest == -1 ? -1 : nums.length - longest;
};
