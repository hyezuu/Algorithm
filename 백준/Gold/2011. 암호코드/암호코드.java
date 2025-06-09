import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static char[] alp = new char[26];
  static int[] pwNum;
  static final int MOD = 1_000_000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String pw = br.readLine();

    pwNum = new int[pw.length()+1];

    for (int i = 1; i <= pw.length(); i++) {
      pwNum[i] = pw.charAt(i-1) - '0';
    }

    System.out.println(dp(pw.length()));
  }

  static int dp(int len) {
    if(pwNum[1] == 0) return 0;
    int[] dp = new int[len+1];
    //0번째를 방문한경우의 수 + 0번쨰를 방문하지 않은 경우의 수, 10의 자리 인 경우 (첫번쨰는 0이올수 없다)
    dp[0] = 1;
    dp[1] = 1;

    //i-1번쨰를 방문한 경우, 항상방문
    //i-1번째를 방문하지않은 경우 (i-2)상태, i-1 * 10 + pw[i] 가 26 보다 작은경우에만 방문
    for (int i = 2; i <= len; i++) {
      int prev = pwNum[i - 1];
      int cur = pwNum[i];

      if (cur != 0) {
        dp[i] += dp[i - 1];
      }

      dp[i] %= MOD;

      if (prev != 0 && prev * 10 + cur <= 26) {
        dp[i] += dp[i - 2];
      }
      dp[i] %= MOD;
    }
    return dp[len];
  }
}