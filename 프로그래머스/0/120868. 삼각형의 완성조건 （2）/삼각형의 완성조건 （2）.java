class Solution {
    public int solution(int[] sides) {
        int max = sides[0];
        if(sides[0] < sides[1]){
            max = sides[1];
            sides[1] = sides[0];
            sides[0] = max;      
        }
        return (sides[0]-(sides[0]-sides[1]))+(sides[0]+sides[1]-(sides[0]+1));
    }
}