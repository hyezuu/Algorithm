class Solution {
    public String solution(String code) {
        boolean mode = false;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<code.length(); i++){
            char ch = code.charAt(i);
            if(ch=='1') mode=!mode;
            else{
                int num = mode ? 1 : 0;
                if(i%2==num) sb.append(ch);
            }
        }
        return sb.length()>0 ?  sb.toString() : "EMPTY" ;
    }
}