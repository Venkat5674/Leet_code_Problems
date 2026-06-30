public class Optimal {
    public int numberOfSubstrings(String s) {
        int[] lastSeen = {-1, -1, -1}; // last index where a, b, c was seen
        long count = 0;
        
        for (int j = 0; j < s.length(); j++) {
            lastSeen[s.charAt(j) - 'a'] = j;
            
            // minimum of last seen positions of a, b, c
            int minIndex = Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
            
            // if minIndex == -1, not all 3 chars seen yet, contributes 0
            count += (minIndex + 1);
        }
        
        return (int) count;
    }
}
