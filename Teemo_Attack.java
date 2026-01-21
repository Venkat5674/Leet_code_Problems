class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        
        int totalPoisoned = 0;
        
        for (int i = 0; i < timeSeries.length - 1; i++) {
            totalPoisoned += Math.min(duration, timeSeries[i + 1] - timeSeries[i]);
        }
        
        totalPoisoned += duration;
        
        return totalPoisoned;
    }
}
