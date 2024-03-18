class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder(my_string);
        StringBuilder answer = new StringBuilder();
        
        return answer
            .append(sb.substring(0,s))
            .append(new StringBuilder(sb.substring(s,e+1)).reverse())
            .append(sb.substring(e+1))
            .toString();
    }
}