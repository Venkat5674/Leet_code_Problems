class Solution {
    public int lengthOfLastWord(String s) {
       int length = 0;
        int i = s.length() - 1;

        // Step 1: Skip trailing spaces in string
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Step 2: Count last word of String
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        // return the length of Long Word
        return length; 
    }
}
