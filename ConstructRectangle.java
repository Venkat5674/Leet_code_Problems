class Solution {
    public int[] constructRectangle(int area) {
        int i = (int) Math.sqrt(area);
        while(i >= 1 && area % i != 0)
            i--;
        return new int[] {area / i, i};
    }
}
