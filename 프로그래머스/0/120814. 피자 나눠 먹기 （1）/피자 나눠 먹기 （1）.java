class Solution {
    public int solution(int n) {
        int q = n/7;
        if(n%7!= 0){
            return q+1;
        }
        else return q;
    }
}