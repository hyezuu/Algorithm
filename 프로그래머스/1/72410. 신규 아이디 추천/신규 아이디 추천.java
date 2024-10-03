class Solution {
    public String solution(String new_id) {
        String result = new_id.toLowerCase().replaceAll("[^a-z0-9_\\-.]","")
            .replaceAll("\\.{2,}",".")
            .replaceAll("^\\.|\\.$","");
        
        if(result.length()>= 16){
            result = result.substring(0, 15).replaceAll("\\.$","");
        }
        else if(result.isEmpty()){
            result = "a";
        }
        
        while(result.length()<=2){
            result+=result.charAt(result.length()-1);
        }
        return result;
    }
}