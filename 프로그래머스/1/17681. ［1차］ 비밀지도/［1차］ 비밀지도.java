class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            int tmp = arr1[i]|arr2[i];
            int w = n;
            
            while(w--!=0){
                sb.insert(0, tmp%2 == 0? " " : "#");
                tmp>>=1; 
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}