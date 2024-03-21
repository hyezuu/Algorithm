class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        int[] answer;
        if(n==1){
            answer = new int[b+1];
            System.arraycopy(num_list,0,answer,0,b+1);
        }
        else if(n==2){
            answer = new int[num_list.length-a];
            System.arraycopy(num_list,a,answer,0,num_list.length-a);
        }
        else if(n==3){
            answer = new int[b-a+1];
            System.arraycopy(num_list,a,answer,0,b-a+1);
        }
        else {
            int len = (b-a+1)%c==0? (b-a+1)/c : (int)((b-a+1)/c)+1;
            answer = new int[len];
            int idx = 0;
            for(int i=a ; i<=b; i+=c){
                answer[idx++] = num_list[i];
            }            
        }
        return answer;
    }
}