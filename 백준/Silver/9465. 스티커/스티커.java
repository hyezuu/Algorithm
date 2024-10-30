import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            int[][] board = new int[2][n];

            for(int j=0; j<2; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0; k<n; k++){
                    board[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            bw.write(getMax(board, n)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int getMax(int[][] board, int n){
        int[][] dp = new int[3][n+1];

        for(int i=1; i<=board[0].length; i++){
            dp[0][i] = Math.max(dp[1][i-1], dp[2][i-1]);
            dp[1][i] = board[0][i-1] + Math.max(dp[0][i-1], dp[2][i-1]);
            dp[2][i] = board[1][i-1] + Math.max(dp[0][i-1], dp[1][i-1]);
        }
        return Math.max(dp[1][n], dp[2][n]);
    }

}
