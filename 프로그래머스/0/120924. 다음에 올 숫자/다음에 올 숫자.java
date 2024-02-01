class Solution {
    public int solution(int[] common) {
        int comd1 = common[1]-common[0];
        int comd2 = common[2]-common[1];
                
        if(comd1==comd2){
            return common[common.length-1] + comd1;
        }
        else return common[common.length-1] * (comd2/comd1);        
    }
}