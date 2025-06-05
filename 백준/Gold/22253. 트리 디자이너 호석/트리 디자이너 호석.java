import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int[] arr;
  static List<Integer>[] tree;
  static long mod = 1000000007;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    arr = new int[N + 1];
    tree = new List[N + 1];
    visited = new boolean[N + 1];
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
    long[] dp = dfs(1);

    long total = 0;

    for(long v : dp){
      total += v;
      total %= mod;
    }

    System.out.println(total);
  }

  public static long[] dfs(int node){
    visited[node] = true;
    long[] result = new long[10];
    result[arr[node]] += 1;

    for(int next : tree[node]){
      if(visited[next]) continue;

     long[] nextResult = dfs(next);
     for(int i = 0; i < 10; i++){
       result[i] += nextResult[i];
//       if(i >= arr[node]) result[arr[node]] += nextResult[i];
       result[i] %= mod;
     }

     for(int i=arr[node]; i<10; i++){
       result[arr[node]] += nextResult[i];
       result[arr[node]] %= mod;
     }
    }
    return result;
  }
}