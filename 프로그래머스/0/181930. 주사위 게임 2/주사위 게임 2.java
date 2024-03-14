class Solution {
    public int solution(int a, int b, int c) {
        int fc = a+b+c;
        int sc = a*a+b*b+c*c;
        int tc = a*a*a+b*b*b+c*c*c;
        if(a!=b&&a!=c&&b!=c) return fc;
        else if(a==b&&b==c) return fc*sc*tc;
        else return fc*sc;
    }
}