class Solution {
    public String solution(String s) {
        char[] c = s.toCharArray();
        
        if(!Character.isDigit(c[0])){
            c[0] = Character.toUpperCase(c[0]);
        }
        for(int i=1; i<c.length; i++){
            if(Character.isAlphabetic(c[i])){
                if(c[i-1]==' ') c[i] = Character.toUpperCase(c[i]);
                else c[i] = Character.toLowerCase(c[i]);
            }
        }
        return String.valueOf(c);
    }
}