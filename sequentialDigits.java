import java.util.*;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        String source = "123456789"; // 1. The master string containing all digits in order
        
        // 2. Determine the digit-length range we need to consider
        int minLen = String.valueOf(low).length();
        int maxLen = String.valueOf(high).length();
        
        // 3. Try every possible length from minLen to maxLen
        for (int len = minLen; len <= maxLen; len++) {
            
            // 4. Slide a window of size 'len' across "123456789"
            //    source.length() - len + 1 gives the number of valid starting positions
            for (int start = 0; start + len <= source.length(); start++) {
                String candidate = source.substring(start, start + len);
                int num = Integer.parseInt(candidate);
                
                // 5. Only keep numbers that actually fall within [low, high]
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }
        
        // 6. Sort the result (numbers of the same length are generated in increasing 
        //    order, but different lengths need this final sort to merge correctly)
        Collections.sort(result);
        
        return result;
    }
}
