class Solution {
    public int[] solution(int[] answers) {
        
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] arr = new int[3];
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == person1[i%person1.length]) arr[0]++;
            if(answers[i] == person2[i%person2.length]) arr[1]++;
            if(answers[i] == person3[i%person3.length]) arr[2]++;
        }
        
        int max = Math.max(arr[0], Math.max(arr[1], arr[2]));
        
        int len = 0;
        
        for(int a : arr){
            if(a == max) len++;
        }
        
        int[] answer = new int[len];
        
        int idx = 0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]==max){
                answer[idx++] = i+1;
            }
        }
        
        return answer;
        
    }
}