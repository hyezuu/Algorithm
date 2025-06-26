import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  static int N;
  static int[] line;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    line = new int[N];

    for(int i=0; i<N; i++){
      line[i] = Integer.parseInt(br.readLine());
    }
    System.out.println(solve());
  }

  static int solve(){
    //i번째 인덱스까지 고려했을때 증가하는 최대 수열의 길이
    int[] dp = new int[N];
    
    for(int i=0; i<N; i++){
      dp[i] = 1;
      for(int j=0; j<i; j++){
        if(line[j] < line[i]){
          dp[i] = Math.max(dp[i], dp[j]+1);
        }
      }
    }

    int max = 0;

    for(int i=0; i<N; i++){
      max = Math.max(max, dp[i]);
    }

    return N-max;
  }
}