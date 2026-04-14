class Solution {
    long[][] dp;

    long solve(int i, int j, List<Integer> robots, List<Integer> nums) {
        if (i >= robots.size()) return 0;
        if (j >= nums.size()) return (long)1e18;

        if (dp[i][j] != -1) return dp[i][j];

        long take = Math.abs(robots.get(i) - nums.get(j)) 
                    + solve(i + 1, j + 1, robots, nums);

        long notake = solve(i, j + 1, robots, nums);

        return dp[i][j] = Math.min(take, notake);
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        List<Integer> nums = new ArrayList<>();

        for (int[] f : factory) {
            for (int i = 0; i < f[1]; i++) {
                nums.add(f[0]);
            }
        }

        dp = new long[robot.size() + 1][nums.size() + 1];
        for (long[] row : dp) Arrays.fill(row, -1);

        return solve(0, 0, robot, nums);
    }
}
