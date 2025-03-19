class Solution {
    public int solution(String[] babbling) {
        int cnt = 0;
        for(String b : babbling){
            b = b.replaceAll("ayaaya|yeye|woowoo|mama", "1");
            b = b.replace("aya", " ");
            b = b.replace("ye", " ");
            b = b.replace("woo", " ");
            b = b.replace("ma", " ");
            
            if(b.trim().length() == 0) cnt++;
        }
        
        return cnt;
    }
}