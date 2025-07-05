import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int H = Integer.parseInt(st.nextToken());
      int W = Integer.parseInt(st.nextToken());
      int N = Integer.parseInt(st.nextToken());

      int floor = N%H == 0 ? H : N%H;
      int room = N/H + (N%H == 0 ? 0 : 1);
      sb.append(floor).append(room < 10 ? 0 : "").append(room).append("\n");
    }

    System.out.print(sb);
  }
}
