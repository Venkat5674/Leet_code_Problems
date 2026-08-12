class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        int n = nums.length;

        int left = 0;
        int invalidCount = 0;

        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int right = 0; right < n; right++) {

            // Add current element to the window
            int currentNumber = nums[right];

            int currentFrequency =
                    frequency.getOrDefault(currentNumber, 0) + 1;

            frequency.put(currentNumber, currentFrequency);

            // This number has exceeded k frequency
            if (currentFrequency == k + 1) {
                invalidCount++;
            }

            // Shrink window by one when it becomes invalid
            if (invalidCount > 0) {

                int leftNumber = nums[left];

                int leftFrequency = frequency.get(leftNumber) - 1;

                frequency.put(leftNumber, leftFrequency);

                // This number is now back within the allowed frequency
                if (leftFrequency == k) {
                    invalidCount--;
                }

                left++;
            }
        }

        // Because the window never decreases in size,
        // the final window size is the maximum length.
        return n - left;
    }
}
