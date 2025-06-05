import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int[] arr;
  static List<Integer>[] tree;
  static int mod = 1000000007;
  static boolean[] visited;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    arr = new int[N + 1];
    tree = new List[N + 1];
    visited = new boolean[N + 1];
    dp = new int[N + 1][10];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      tree[i] = new ArrayList<>();
    }

    for (int i = 1; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      tree[a].add(b);
      tree[b].add(a);
    }
    dfs(1);

    long total = 0;

    for (long v : dp[1]) {
      total += v;
      total %= mod;
    }

    System.out.println(total);
  }

  public static void dfs(int node) {
    visited[node] = true;
    dp[node][arr[node]]++;

    for (int next : tree[node]) {
      if (visited[next]) {
        continue;
      }

      dfs(next);

      for (int i = 0; i < 10; i++) {
        dp[node][i] += dp[next][i];
        dp[node][i] %= mod;
      }

      for (int i = arr[node]; i < 10; i++) {
        dp[node][arr[node]] += dp[next][i];
        dp[node][arr[node]] %= mod;
      }
    }
  }
}