class Solution {
    public long solution(int a, int b) {
        long len = Math.abs(b-a)+1;
        return ((len/2) * (a+b)) + ((len % 2) == 0 ? 0 : (a+b) /2) ;
    }
}