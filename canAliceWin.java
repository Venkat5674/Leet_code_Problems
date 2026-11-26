class Solution {
    public boolean canAliceWin(int n) {
        int miss = 55 - n;
        long unplayed = Math.round(Math.sqrt(2*miss));
        return unplayed % 2 == 1;
    }
}
