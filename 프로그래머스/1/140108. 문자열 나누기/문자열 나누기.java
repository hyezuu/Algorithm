class Solution {
    public int solution(String s) {
        
        char c = s.charAt(0);
        
        int cnt1 = 0;
        int cnt2 = 0;
        
        int answer = 0;
        
        for(int i=0; i<s.length(); i++){
            if(cnt1==0){
                c = s.charAt(i);
            }
            if(c==s.charAt(i)) cnt1++;
            else cnt2++;
            
            if(cnt1==cnt2){
                cnt1=0;
                cnt2=0;
                answer++;
            }
        }
        
        return cnt1==0 ? answer : answer + 1;
    }
}