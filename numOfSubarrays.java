class Solution {
    public int numOfSubarrays(int[] arr) {
        int even = 1;
        int odd = 0;
        int count = 0;
        int prefix = 0;

        int Mod = 1000000007;

        for(int num : arr){
            prefix += num;

            if(prefix % 2 == 0){
                count += odd;
                even++;
            }else{
                count += even;
                odd++;
            }
            count %= Mod;
        }
        return count;
    }
}
