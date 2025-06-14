import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static final int MOD = 1_000_000_000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    System.out.println(solve());
  }

  static int solve(){
    int[][][] dp = new int[N+1][10][1<<10];

    for(int i=1; i<10; i++){
      dp[1][i][1<<i] = 1;
    }

    for(int i=2; i<=N; i++){
      for(int j=0; j<10; j++){
        for(int k=0; k<1024; k++){
          int nxtBit = k | (1<<j);
          if(j==0) dp[i][j][nxtBit] = (dp[i][j][nxtBit] + dp[i-1][j+1][k])%MOD;
          else if(j==9) dp[i][j][nxtBit] = (dp[i][j][nxtBit] + dp[i-1][j-1][k])%MOD;
          else dp[i][j][nxtBit] = (dp[i][j][nxtBit] + dp[i-1][j+1][k] + dp[i-1][j-1][k])%MOD;
        }
      }
    }

    int result = 0;
    for(int i=0; i<10; i++){
      result += dp[N][i][1023];
      result %= MOD;
    }

    return result;
  }
}