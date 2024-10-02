class Solution {
    static int cl;
    static int cr;
    public String solution(int[] numbers, String hand) {
        char h = hand.charAt(0)=='l' ? 'L' : 'R';
        cl = 10;
        cr = 12;
        
        StringBuilder sb = new StringBuilder();
        
        for(int n : numbers){
            if(n==0) n = 11;
            
            char tmp = getHandToPush(n, h);
            if(tmp == 'L') cl = n;
            else cr = n;
            
            sb.append(tmp);
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
    
    char getHandToPush(int n, char h){
        if(n%3==1) return 'L';
        if(n%3==0) return 'R';
        
        int[] clc = getCoordinate(cl);
        int[] crc = getCoordinate(cr);
        int[] cnc = getCoordinate(n);
        
        if(getDistance(clc, cnc)>getDistance(crc, cnc)) return 'R';
        if(getDistance(clc, cnc)<getDistance(crc, cnc)) return 'L';
        
        return h;
    }
}