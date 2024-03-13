class Solution {
    public int solution(int a, int b) {
        boolean oddA = a%2!=0;
        boolean oddB = b%2!=0;
        
        if(oddA&&oddB) return (a*a)+(b*b);
        else if(oddA||oddB) return 2*(a+b);
        else return Math.abs(a-b);
    }
}