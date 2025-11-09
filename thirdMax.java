class Solution {
    public int thirdMax(int[] nums) {
       Long first = null, second = null, third = null;

        for (int n : nums) {
            // Skip duplicates
            if ((first != null && n == first) || 
                (second != null && n == second) ||
                (third != null && n == third)) {
                continue;
            }

            if (first == null || n > first) {
                third = second;
                second = first;
                first = (long) n;
            } else if (second == null || n > second) {
                third = second;
                second = (long) n;
            } else if (third == null || n > third) {
                third = (long) n;
            }
        }

        return (third == null) ? first.intValue() : third.intValue();
    }  
}
