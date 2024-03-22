class Solution {
    public String[] solution(String[] picture, int k) {
        int len = picture.length, idx = 0;
        String[] answer = new String[len*k];
        for(int i=0; i<len; i++){
            StringBuilder sb = new StringBuilder();
            String[] spl = picture[i].split("");
            for(int j=0; j<picture[i].length(); j++){
                sb.append(spl[j].repeat(k));
            }
            for(int l=0; l<k; l++){
                answer[idx++] = sb.toString();
            }
        }
        
        return answer;
    }
}