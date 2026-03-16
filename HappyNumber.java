class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while(n != 1){
            //if number repeats -> cycle -> Not Happy Number
            if(seen.contains(n)){
                return false;
            }
            seen.add(n);
            int sum = 0;

            //step - 2 divide digits and square them
            while(n > 0){
                int digit = n % 10;
                sum += digit * digit;
                n = n / 10;
            }
            // Step - 3 replace n with sum
            n = sum;
        }
        return true;
    }
}
