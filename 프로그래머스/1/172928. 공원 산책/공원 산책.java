class Solution {
    public int[] solution(String[] park, String[] routes) {
        char[][] map = new char[park.length][park[0].length()];
        
        int x = 0;
        int y = 0;
        
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                map[i][j] = park[i].charAt(j);
                
                if(park[i].charAt(j)=='S'){
                    y = i;
                    x = j;
                }
            }
        }
        
        
        for(String route : routes){
            char direction = route.charAt(0);
            int distance = route.charAt(2)-'0';
            boolean flag = true;
            if(direction=='E' && x+distance < map[0].length){
                for(int i=x; i<=x+distance; i++){
                    if(map[y][i]=='X'){
                        flag = false;
                        break;
                    }
                }
                if(flag) x = x+distance;
            }
            else if(direction=='W' && x-distance >= 0){
                for(int i=x; i>=x-distance; i--){
                    if(map[y][i]=='X'){
                        flag = false;
                        break;
                    }
                }
                if(flag) x = x-distance;
            }
            
            else if(direction=='S' && y+distance < map.length){
                for(int i=y; i<=y+distance; i++){
                    if(map[i][x]=='X'){
                        flag = false;
                        break;
                    }
                }
                if(flag) y = y+distance;
            }
            
            else if(direction=='N' && y-distance >= 0){
                for(int i=y; i>=y-distance; i--){
                    if(map[i][x]=='X'){
                        flag = false;
                        break;
                    }
                }
                if(flag) y = y-distance;
            }
        }
        return new int[]{y, x};
    }
}