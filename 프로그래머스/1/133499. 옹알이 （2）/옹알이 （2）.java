class Solution {
    public int solution(String[] babbling) {
        String[] str = {"aya", "ye", "woo", "ma"};
        int cnt = 0;
        for(String babble : babbling){
            String tmp = babble;
            for(int i=0; i<4; i++){
               tmp = tmp.replaceAll(str[i], String.valueOf(i));
            }
            boolean flag = true;
            for(int i=1; i<tmp.length(); i++){
                if(!Character.isDigit(tmp.charAt(i)) || tmp.charAt(i)==tmp.charAt(i-1)){
                    flag = false;
                    break;
                }
            }
            if(!Character.isDigit(tmp.charAt(0))) flag = false;
            if(flag) cnt++;
        }
        return cnt;
    }
}