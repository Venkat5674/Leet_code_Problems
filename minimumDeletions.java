class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;

        // Find minimum and maximum indices
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        // Make minIndex the smaller index
        if (minIndex > maxIndex) {
            int temp = minIndex;
            minIndex = maxIndex;
            maxIndex = temp;
        }

        // Case 1: Remove both from the left
        int removeFromLeft = maxIndex + 1;

        // Case 2: Remove both from the right
        int removeFromRight = n - minIndex;

        // Case 3: Remove min from left and max from right
        int removeFromBothSides =
            (minIndex + 1) + (n - maxIndex);

        return Math.min(
            removeFromLeft,
            Math.min(removeFromRight, removeFromBothSides)
        );
    }
}
