import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n, x;
  static int[] arr;
  static boolean[] visit;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    arr = new int[n];
    visit = new boolean[1000001];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for(int i=0; i<n; i++){
      arr[i] = Integer.parseInt(st.nextToken());
      visit[arr[i]] = true;
    }

    x = Integer.parseInt(br.readLine());

    System.out.println(solve());
  }

  public static int solve() {
    int cnt = 0;
    for(int num : arr){
      int t = x - num;
      if(t >= 0 && t < 1_000_001 && visit[t]){
        cnt++;
      }
    }
    return cnt/2;
  }
}