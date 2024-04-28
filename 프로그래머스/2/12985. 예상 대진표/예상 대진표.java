class Solution
{
    public int solution(int n, int a, int b){
        int answer = 0;
        while(a!=b){
            a = (int)a/2 + (a%2==0 ? 0 : 1);
            b = (int)b/2 + (b%2==0 ? 0 : 1);
            answer++;
        }
        return answer;
    }
}