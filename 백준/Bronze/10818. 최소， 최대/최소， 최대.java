import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for(int i=0; i<N; i++){
      int cur = Integer.parseInt(st.nextToken());
      min = Math.min(min, cur);
      max = Math.max(max, cur);
    }

    System.out.print(new StringBuilder().append(min).append(" ").append(max));
  }
}
