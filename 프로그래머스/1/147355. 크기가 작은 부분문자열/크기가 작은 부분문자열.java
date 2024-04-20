class Solution {
    public int solution(String t, String p) {
        int end = t.length()-p.length()+1;
        long num = Long.parseLong(p);
        int cnt = 0;
        
        for(int i=0; i<end; i++){
            Long tmp = Long.parseLong(t.substring(i, i+p.length()));
            if(tmp <= num) cnt++;
        }
        return cnt;
    }
}