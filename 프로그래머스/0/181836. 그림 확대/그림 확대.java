class Solution {
    public String[] solution(String[] picture, int k) {
        int len = picture.length;
        String[] answer = new String[len*k];
        for(int i=0; i<len; i++){
            StringBuilder sb = new StringBuilder();
            for(char p : picture[i].toCharArray()){
                sb.append(String.valueOf(p).repeat(k));
            }
            
            for(int j=0; j<k; j++){
                answer[i*k+j] = sb.toString();
            }
        }
        
        return answer;
        
        
        
        
        
//         int len = picture.length, idx = 0;
//         String[] answer = new String[len*k];
//         for(int i=0; i<len; i++){
//             StringBuilder sb = new StringBuilder();
//             String[] spl = picture[i].split("");
//             for(int j=0; j<picture[i].length(); j++){
//                 sb.append(spl[j].repeat(k));
//             }
//             for(int l=0; l<k; l++){
//                 answer[idx++] = sb.toString();
//             }
//         }
        
//         return answer;
    }
}