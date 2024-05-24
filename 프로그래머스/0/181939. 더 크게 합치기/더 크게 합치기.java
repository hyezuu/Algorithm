class Solution {
    public int solution(int a, int b) {
        int c = Integer.parseInt(a+""+b+"");
        int d = Integer.parseInt(b+""+a+"");
        return Math.max(c,d);
    }
}