class Solution {
    public void reverseString(char[] s) {
        int left = 0; // 1 St pointer
        int right = s.length - 1; // 2 nd Pointer

        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
