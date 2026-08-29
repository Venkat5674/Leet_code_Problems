import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        // Store {value, original index}
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // Sort by value
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int[] result = new int[n];

        int start = 0;

        while (start < n) {
            int end = start;

            // Find all elements that belong to the same group
            while (end + 1 < n &&
                   arr[end + 1][0] - arr[end][0] <= limit) {
                end++;
            }

            // Get original indices of this group
            List<Integer> indices = new ArrayList<>();

            for (int i = start; i <= end; i++) {
                indices.add(arr[i][1]);
            }

            // Sort original indices
            Collections.sort(indices);

            // Assign smallest values to smallest indices
            for (int i = 0; i < indices.size(); i++) {
                result[indices.get(i)] = arr[start + i][0];
            }

            start = end + 1;
        }

        return result;
    }
}
