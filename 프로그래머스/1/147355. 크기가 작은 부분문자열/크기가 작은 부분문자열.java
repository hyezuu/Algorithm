class Solution {
    public int solution(String t, String p) {
        int cnt = 0;
        
        int tLen = t.length();
        int pLen = p.length();
        
        Long pNum = Long.parseLong(p);
        
        for(int i=0; i<=tLen-pLen; i++){
            if(Long.parseLong(t.substring(i, i+pLen))<=pNum) cnt++;
        }
        
        return cnt;
    }
}