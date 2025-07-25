import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    while(T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      String s = st.nextToken();

      for(int i=0; i<s.length(); i++){
        sb.append(String.valueOf(s.charAt(i)).repeat(Math.max(0, n)));
      }
      sb.append("\n");
    }

    System.out.print(sb);
  }
}
