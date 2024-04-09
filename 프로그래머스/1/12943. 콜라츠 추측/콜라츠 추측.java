class Solution {
    public int solution(int num) {
        long n = num;
        int cnt=0;
        while(n!=1){
            if(cnt>=500) return -1;
            else if(n%2==0) n/=2;
            else n=n*3+1;
            cnt++;
        }
        return cnt;
    }
}