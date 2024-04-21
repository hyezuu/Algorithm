class Solution {
    public int solution(int[][] sizes) {
        int x = 0, y = 0; 
        for(int[] card : sizes){
            x = Math.max(Math.max(card[0], card[1]),x);
            y = Math.max(Math.min(card[0], card[1]),y);
        }
        
        return x*y;
    }
}