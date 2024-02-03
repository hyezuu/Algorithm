class Solution {
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        
        int count = 0;
        for(int i=0; i<babbling.length; i++){
            String babblin1 = babbling[i];
            for(int j=0; j<4; j++){
                babblin1 = babblin1.replaceAll(words[j], " ");
            }
            if(babblin1.trim().isEmpty()){
                count++;
            }
        }
        return count ;
    }
}