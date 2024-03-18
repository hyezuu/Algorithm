class Solution {
    public int solution(String myString, String pat) {
        int idx =0 , cnt = 0;
        while(myString.contains(pat)){
            cnt++;
            idx = myString.indexOf(pat);
            myString = myString.substring(idx+1);
        }
        return cnt;
    }
}