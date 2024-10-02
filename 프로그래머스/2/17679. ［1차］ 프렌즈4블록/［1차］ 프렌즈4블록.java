class Solution {
    static char[][] arr;
    static boolean[][] check;
    static final int[] dx = {0, 1, 1, 0};
    static final int[] dy = {0, 0, 1, 1};
    public int solution(int m, int n, String[] board) {
        arr = new char[m][n];        
        
        for(int i=0; i<board.length; i++){
            arr[i] = board[i].toCharArray();
        }
        boolean flag = true;
        int answer = 0;
        while(flag){
            flag = false;
            check = new boolean[m][n];
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(arr[i][j]!='0' && isBox(m, n, i, j)){
                        flag = true;
                        for(int k=0; k<4; k++){
                            check[i+dy[k]][j+dx[k]] = true;
                        }
                    }
                }
            }
            if(flag){
                for(int i=0; i<m; i++){
                    for(int j=0; j<n; j++){
                        if(check[i][j]){
                            answer++;
                            int k = i;
                            while(k>0 && arr[k-1][j]!='0'){
                                arr[k][j] = arr[k-1][j];
                                k--;
                            }
                            arr[k][j] = '0';
                        } 
                    }
                }   
            }
        }
        return answer;
    }
    private boolean isBox(int m, int n, int y, int x){
        for(int i=0; i<4; i++){
            int tempY = y+dy[i];
            int tempX = x+dx[i];
        
            if( tempX<n && tempY<m && arr[y][x]==arr[tempY][tempX]){
                continue;
            }
            else return false;
        }
        return true;
    }
}