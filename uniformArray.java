class Solution {
    public boolean uniformArray(int[] nums1) {
       int addcount = 0;
       int evencount = 0;
        for(int num : nums1){
            if(num % 2 == 0) evencount++;
            else addcount++;
        }
        boolean allEvenPossible = (addcount == 0) || (addcount >= 2);
        boolean allOddPossible = (evencount == 0) || (addcount >= 1);

        return allEvenPossible || allOddPossible;
    }
}
