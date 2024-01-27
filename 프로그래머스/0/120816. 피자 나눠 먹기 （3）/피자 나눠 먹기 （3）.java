class Solution {
    public int solution(int slice, int n) {
       int q = n/slice;
       if(n%slice!=0){
           return q+1;
       } 
        else return q;
    }
}