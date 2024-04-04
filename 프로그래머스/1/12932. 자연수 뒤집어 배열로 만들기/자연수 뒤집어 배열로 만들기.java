class Solution {
    public int[] solution(long n) {
        String str = new StringBuilder(n+"").reverse().toString();
        int[] answer = new int[str.length()];
        for(int i=0; i<str.length(); i++){
            answer[i] = str.charAt(i)-'0';
        }
        
        return answer;
    }
}