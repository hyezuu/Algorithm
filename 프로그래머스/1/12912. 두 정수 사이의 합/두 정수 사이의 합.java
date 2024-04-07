class Solution {
    public long solution(int a, int b) {
        long n = Math.min(a,b);
        long m = Math.max(a,b);
        long d = m-n+1;
        return (m+n)*(long)(d/2)+((m+n)/2)*(d%2);
    }
}