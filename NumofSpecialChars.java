class Solution {
    public int numberOfSpecialChars(String word) {
     char[] arr = word.toCharArray();
     int count = 0;
     boolean[] visit = new boolean[26];   

     for(int i = 0; i < arr.length; i++){
        for(int j = i + 1; j < arr.length; j++){
            if(Math.abs(arr[i] - arr[j]) == 32){
                char ch = Character.toLowerCase(arr[i]);
                int index = ch - 'a';

                if(!visit[index]) {
                        count++;
                        visit[index] = true;
                    }
            }
        }
     }
     return count;
    }
}
