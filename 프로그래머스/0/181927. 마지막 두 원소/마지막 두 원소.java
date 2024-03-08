class Solution {
    public int[] solution(int[] num_list) {
        int len = num_list.length;
        int last;
        int[] answer = new int[len+1];
        if(num_list[len-1]>num_list[len-2]){
            last = num_list[len-1]-num_list[len-2];
        }
        else last = num_list[len-1]*2;
        System.arraycopy(num_list,0,answer,0,len);
        answer[len] = last;
        
        return answer;
    }
}