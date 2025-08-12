import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int N, T, P;
  static int[] size = new int[6];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < 6; i++){
      size[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());

    T = Integer.parseInt(st.nextToken());
    P = Integer.parseInt(st.nextToken());

    solve();
  }
  static void solve() {
    StringBuilder sb = new StringBuilder();
    int cnt = 0;
    for(int i = 0; i < 6; i++){
      cnt += (size[i]/T)+(size[i]%T > 0 ? 1 : 0);
    }

    sb.append(cnt).append('\n');

    sb.append(N/P).append(' ').append(N%P);

    System.out.print(sb);
  }
}