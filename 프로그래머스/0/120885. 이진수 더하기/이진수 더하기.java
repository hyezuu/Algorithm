class Solution {
    public String solution(String bin1, String bin2) {
        int bin11 = 0;
        int bin22 = 0;
        for(int i=0; i<bin1.length(); i++){
            if(bin1.charAt(i)=='1'){
                bin11 += Math.pow(2,bin1.length()-1-i);
            }            
        }
        for(int i=0; i<bin2.length(); i++){
            if(bin2.charAt(i)=='1'){
                bin22 += Math.pow(2,bin2.length()-1-i);
            }            
        }
        return Integer.toBinaryString(bin11+bin22);
    }
}