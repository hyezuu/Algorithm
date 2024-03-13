class Solution {
    public int solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder();
        for(char c : pat.toCharArray()){
            if(c=='A') sb.append('B');
            else if(c=='B') sb.append('A');
            else sb.append(c);
        }
        return myString.contains(sb.toString())?1:0;
    }
}