class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        for(int i=0; i<wallpaper.length; i++){
            String icons = wallpaper[i];
            for(int j=0; j<icons.length(); j++){
                if(icons.charAt(j)=='#'){
                    if(answer[0] == 0 && answer[2] == 0){
                        answer[0] = i;
                        answer[1] = j;
                        answer[2] = i+1;
                        answer[3] = j+1;
                    }
                    else {
                        answer[0] = Math.min(i, answer[0]);
                        answer[1] = Math.min(j, answer[1]);
                        answer[2] = Math.max(i+1, answer[2]);
                        answer[3] = Math.max(j+1, answer[3]);
                    }
                }
            }
        }
        return answer;
    }
}