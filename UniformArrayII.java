class Solution {
    public boolean uniformArray(int[] nums1) {
        int mn = nums1[0];
        for (int num : nums1) {
            if (num < mn) {
                mn = num;
            }
        }
        
        if (mn % 2 != 0) {
            return true;
        } else {
            
            for (int num : nums1) {
                if (num % 2 != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
