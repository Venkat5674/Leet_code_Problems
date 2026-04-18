class Solution {
    public int mirrorDistance(int n) {
        int original = n;
        int reverse = 0;

        // Step 1: Reverse the number
        while (n > 0) {
            int digit = n % 10;
            reverse = reverse * 10 + digit;
            n = n / 10;
        }

        // Step 2: Calculate absolute difference
        return Math.abs(original - reverse);
    }
}
