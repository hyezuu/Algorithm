class Solution {
    public int[] solution(int brown, int yellow) {
        int area = brown+yellow;
        int x = 0, y = 0;
        for(int i=1; i<=Math.sqrt(area); i++){
            if(area%i==0){
                x = Math.max(area/i , i);
                y = area/x;
                
                if((x-2) * (y-2) == yellow) break;
            }
        }
        return new int[]{x,y};
    }
}