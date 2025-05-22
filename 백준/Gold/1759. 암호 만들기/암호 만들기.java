import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static int L, C;
  static char[] chars;
  static StringBuilder sb;
  static Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    chars = new char[C];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < C; i++) {
      chars[i] = st.nextToken().charAt(0);
    }
    sb = new StringBuilder();
    solve();
    System.out.println(sb);
  }

  public static void solve() {
    Arrays.sort(chars);

    StringBuilder password = new StringBuilder();
    dfs(password, 0, 0, 0);
  }

  public static void dfs(StringBuilder password, int start, int v, int c) {
    if (password.length() == L && v >= 1 && c >= 2) {
      sb.append(password).append("\n");
      return;
    }

    if(L-password.length() > C-start) return;

    for (int i = start; i < C; i++) {
      password.append(chars[i]);
      if(set.contains(chars[i])) {
        dfs(password, i + 1, v+1, c);
      }
      else dfs(password, i+1, v, c+1);
      password.deleteCharAt(password.length() - 1);
    }
  }
}
