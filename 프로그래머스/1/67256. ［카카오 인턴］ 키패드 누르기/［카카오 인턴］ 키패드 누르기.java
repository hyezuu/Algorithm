class Solution {
    public String solution(int[] numbers, String hand) {
        int cl = 10;
        int cr = 12;
        
        StringBuilder sb = new StringBuilder();
    
        
        for(int n : numbers){
            if(n==0) n = 11;
            
            if(n%3==1){
                sb.append('L');
                cl = n;
            } 
            else if(n%3==0){
                sb.append('R');
                cr = n; 
            }
            else {
                int[] clc = getCoordinate(cl);
                int[] crc = getCoordinate(cr);
                int[] cnc = getCoordinate(n);
                
                if(getDistance(clc, cnc)>getDistance(crc, cnc)){
                    sb.append('R');
                    cr = n; 
                }
                else if(getDistance(clc, cnc)<getDistance(crc, cnc)){
                    sb.append('L');
                    cl = n; 
                }
                else if(hand.charAt(0)=='r'){
                    sb.append('R');
                    cr = n; 
                }
                else {
                    sb.append('L');
                    cl = n; 
                }
            }
        }
        return sb.toString();
    }
    int getDistance(int[] coord1, int[]coord2){
        int x1 = coord1[0];
        int y1 = coord1[1];
        
        int x2 = coord2[0];
        int y2 = coord2[1];
        return Math.abs(x2-x1)+Math.abs(y2-y1);
    }

    int[] getCoordinate(int n){
        return new int[]{(n-1)%3, (n-1)/3};
    }
}