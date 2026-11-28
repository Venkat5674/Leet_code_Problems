import java.util.Arrays;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freq = new int[n + 1];
        int minPrice = Integer.MAX_VALUE;

        // 1. Count frequencies of each factor and find the global minimum price
        for (int[] item : items) {
            freq[item[0]]++;
            if (item[1] < minPrice) {
                minPrice = item[1];
            }
        }

        // 2. Compute multiples[f] = total items whose factor is divisible by f
        // Runs in O(N log N) time
        int[] multiples = new int[n + 1];
        for (int f = 1; f <= n; f++) {
            if (freq[f] > 0) {
                for (int m = f; m <= n; m += f) {
                    multiples[f] += freq[m];
                }
            }
        }

        // 3. Pack (price, gain) into a single primitive long to avoid Object sorting overhead
        long[] packed = new long[n];
        for (int i = 0; i < n; i++) {
            int f = items[i][0];
            int p = items[i][1];
            int gain = multiples[f] - 1; // Exclude item i itself
            packed[i] = ((long) p << 32) | (gain & 0xFFFFFFFFL);
        }

        // Sort by price ascending
        Arrays.sort(packed);

        long totalItems = 0;
        long remBudget = budget;
        long twoMinPrice = 2L * minPrice;

        // 4. Greedily buy value-2 copies while they beat buying two value-1 copies
        for (int i = 0; i < n; i++) {
            long price = packed[i] >>> 32;
            if (price >= twoMinPrice || remBudget < price) {
                break;
            }
            
            long gain = packed[i] & 0xFFFFFFFFL;
            if (gain == 0) {
                continue;
            }

            long canBuy = remBudget / price;
            long take = Math.min(gain, canBuy);
            
            totalItems += take * 2;
            remBudget -= take * price;
        }

        // 5. Spend all remaining budget on the cheapest item (value 1 per copy)
        totalItems += remBudget / minPrice;

        return (int) totalItems;
    }
}
