class Solution {
    public int solution(int n, int m, int[] section) {
        //
        int covered = section[0] + m - 1;
        int count = 1;
        
        for(int i=1; i<section.length; i++){
            if(covered < section[i]){
                covered = section[i] + m - 1;
                count ++;
            }
        }
        return count;
    }
}