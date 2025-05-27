import java.io.*;
import java.util.*;

public class Main {

  static int N, S, M;
  static int[] gaps;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    gaps = new int[N+1];

    st= new StringTokenizer(br.readLine());

    for (int i = 1; i <= N; i++) {
      gaps[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(dp());
  }
  static int dp(){
    Set<Integer>[] dp = new Set[N+1];
    for(int i = 0; i < N+1; i++){
      dp[i] = new HashSet<>();
    }
    dp[0].add(S);

    for(int i=1; i<=N; i++){
      for(int a : dp[i-1]){
        if(a-gaps[i] >= 0){
          dp[i].add(a-gaps[i]);
        }
        if(a+gaps[i] <= M){
          dp[i].add(a+gaps[i]);
        }
      }
      if(dp[i].isEmpty()){
        return -1;
      }
    }
    int max = -1;
    for(int a : dp[N]){
      max = Math.max(a, max);
    }

    return max;
  }
}
