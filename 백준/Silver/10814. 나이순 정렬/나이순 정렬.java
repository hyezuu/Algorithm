import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    StringBuilder[] members = new StringBuilder[201];

    for (int i = 0; i < 201; i++) {
      members[i] = new StringBuilder();
    }

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());

      members[num] = members[num]
          .append(num)
          .append(' ')
          .append(st.nextToken())
          .append("\n");
    }

    StringBuilder sb = new StringBuilder();

    for (StringBuilder s : members) {
      sb.append(s);
    }

    System.out.print(sb);
  }
}