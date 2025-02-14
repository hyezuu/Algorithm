class Solution {
    public int solution(int num) {
        if(num==1) return 0;
        long tmp = num;
        
        for(int i=1; i<=500; i++){
            tmp = tmp%2==0 ? tmp/2 : tmp*3+1;
            
            if(tmp==1) return i;
        }
        
        return -1;
    }
}