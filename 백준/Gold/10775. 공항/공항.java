import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  static int G, P;
  static int[] parent;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    G = Integer.parseInt(br.readLine());
    P = Integer.parseInt(br.readLine());

    parent = new int[G + 1];
    for (int i = 0; i <= G; i++) parent[i] = i;

    int cnt = 0;
    for (int i = 0; i < P; i++) {
      int port = Integer.parseInt(br.readLine());
      int g = find(port);
      if (g == 0) break;
      cnt++;
      union(g, g - 1);
    }
    System.out.print(cnt);
  }

  static int find(int x) {
    if (x == parent[x]) return x;
    return parent[x] = find(parent[x]);
  }

  static void union(int a, int b) {
    a = find(a);
    b = find(b);
    parent[a] = b;
  }
}