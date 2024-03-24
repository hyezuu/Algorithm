class Solution {
    public String solution(String code) {
        boolean mode = false;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<code.length(); i++){
            if(code.charAt(i)=='1') mode=!mode;
            else{
                if(mode&&i%2!=0) sb.append(code.charAt(i));
                else if(!mode&&i%2==0) sb.append(code.charAt(i));
            }
        }
        return sb.length()>0 ?  sb.toString() : "EMPTY" ;
    }
}