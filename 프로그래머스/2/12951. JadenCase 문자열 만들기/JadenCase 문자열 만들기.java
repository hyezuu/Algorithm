class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for(char c : s.toCharArray()){
            if(isFirst){
                isFirst = false;
                if(Character.isAlphabetic(c)){
                    sb.append(Character.toUpperCase(c));
                    continue;
                }
            }
        
            if(c == ' ') isFirst = true;
            sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }
}