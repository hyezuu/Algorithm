class Solution {
    public String[] solution(String[] strArr) {
        for(int i=0; i<strArr.length; i++){
            strArr[i] = i%2==0? strArr[i].toLowerCase() : strArr[i].toUpperCase();
        }
        return strArr;
        
        
        
        
        
        
        
        
        // int len = strArr.length;
        // String[] answer = new String[len];
        // for(int i=0; i<len; i++){
        //     if(i%2==0) answer[i]=strArr[i].toLowerCase();
        //     else answer[i]=strArr[i].toUpperCase();
        // }
        // return answer;
    }
}