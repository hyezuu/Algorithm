class Solution {
    public int solution(int a, int b) {
        if(b==1){
            return 1;
        }
        if(a>b){
            a= a%b;
        }
        for(int i=a; i>1; i--){
            if(a%i==0){
                if(b%i==0){
                    b= b/i;
                    break;//최대공약수로 나누기
                }
            }
        }
        while(b>1){
            if(b%10==0){
                b/=10;
            }
            else if(b%2==0){
                b/=2;
            }
            else if(b%5==0){
                b/=5;
            }
            else return 2;
        }
        return 1;
    }
}