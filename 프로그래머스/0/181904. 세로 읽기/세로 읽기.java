class Solution {
    public String solution(String myString, int m, int c) {
        StringBuilder sb = new StringBuilder();
        while(myString.length()>0){
            sb.append(myString.charAt(c-1));
            myString = myString.substring(m);
        }
        return sb.toString();
    }
}