class Solution {
    public int solution(int balls, int share) {
        if(share==balls|| share == 0){
            return 1;
        }
        else return solution(balls-1, share-1) + solution(balls-1, share);
    }
}