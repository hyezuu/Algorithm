class Solution {
    public int[] solution(int[] num_list, int n) {
        int len;
        if(num_list.length%n==0) len = num_list.length/n;
        else len = (num_list.length/n)+1;
        
        int[] answer = new int[len];
        int cnt = n;
        int j=0;
        for(int i=0; i<num_list.length; i++){
            if(cnt==n) {
                answer[j] = num_list[i];
                cnt=1;
                j++;
            } 
            else cnt++;
        }
        return answer;
    }
}