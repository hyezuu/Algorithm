import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int[][] steps;
  static int[] max, min;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    steps = new int[N][3];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        steps[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    solve();
    System.out.println(sb);
  }

  static void solve(){
    dp();

    int maxValue = Math.max(Math.max(max[0], max[1]), max[2]);
    int minValue = Math.min(Math.min(min[0], min[1]), min[2]);

    sb.append(maxValue).append(" ").append(minValue);
  }

  static void dp(){
    max = new int[3];
    min = new int[3];

    for(int i=0; i<3; i++){
      max[i] = min[i] = steps[0][i];
    }

    for(int i=1; i<N; i++){
      int tmp = max[1];
      max[1] = Math.max(max[0], Math.max(max[1], max[2])) + steps[i][1];
      max[0] = Math.max(max[0], tmp) + steps[i][0];
      max[2] = Math.max(tmp, max[2]) + steps[i][2];

      tmp = min[1];
      min[1] = Math.min(min[0], Math.min(min[1], min[2])) + steps[i][1];
      min[0] = Math.min(min[0], tmp) + steps[i][0];
      min[2] = Math.min(tmp, min[2]) + steps[i][2];
    }
  }
}
