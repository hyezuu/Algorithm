class Solution {
    public long solution(long n) {
        long r = (long)Math.sqrt(n);
        if(r*r == n) return (r+1)*(r+1);
        else return -1;
    }
}