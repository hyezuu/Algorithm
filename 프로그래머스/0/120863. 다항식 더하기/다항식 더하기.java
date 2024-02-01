class Solution {
    public String solution(String polynomial) {
        int x = 0;
        int y = 0;
        String answer = "";
        
        for(String poly: polynomial.split("\\s[+]\\s")){
            String trim = poly.trim();
            if(trim.contains("x")){
                if(trim.length()>1){
                    x += Integer.parseInt(trim.substring(0,trim.length()-1));
                }
                else x++;
            }
            else 
                y += Integer.parseInt(trim);
        }
        String stringX = x>1 ? x+"x" : x==1 ? "x" : "" ;
        String stringY = y>0 ? y+"" : "";
        
        if(!stringX.isEmpty() && !stringY.isEmpty()){
            return stringX +" + " +stringY;
        }
        else if(stringX.isEmpty()){
            return stringY;
        }
        else return stringX;
    }
}