import java.io.*;
import java.util.*;

public class Main {
  static int N, M;
  static int[][] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N+1][N+1];
    for(int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      arr[a][b] = 1;
      arr[b][a] = 1;
    }

    solve();
  }

  static void solve() {
    int[][] map = new int[N+1][N+1];

    final int INF = Integer.MAX_VALUE;
    for(int i = 1; i <= N; i++){
      for(int j = 1; j <= N; j++){
        if(arr[i][j]==1) map[i][j] = 1;
        else if(i==j) map[i][j] = 0;
        else map[i][j] = INF;
      }
    }

    for(int k = 1; k <= N; k++){
      for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
          if(map[i][k] != INF && map[k][j] != INF){
            map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
          }
        }
      }
    }

    int[] pair = new int[2];
    int min = Integer.MAX_VALUE;
    int sum = 0;

    for(int i=1; i<N; i++){
      for(int j=i+1; j<=N; j++){
        for(int k=1; k<=N; k++){
          sum += Math.min(map[i][k], map[j][k]);
        }
        if(sum < min){
          pair = new int[]{i, j};
          min = sum;
        }
        sum = 0;
      }
    }

    System.out.println( pair[0] + " " + pair[1] + " " + min*2);
  }
}