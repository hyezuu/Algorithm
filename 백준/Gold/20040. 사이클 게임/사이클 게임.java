import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] parent;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    parent = new int[N];

    for(int i = 0; i < N; i++){
      parent[i] = i;
    }

    for(int i = 1; i <= M; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if(find(a) == find(b)){
        System.out.print(i);
        return;
      }
      else union(a, b);
    }
    System.out.print(0);
  }

  static int find(int x){
    if(x == parent[x]) return x;
    return parent[x] = find(parent[x]);
  }

  static void union(int a, int b){
    a = find(a);
    b = find(b);
    if(a != b) parent[b] = a;
  }
}