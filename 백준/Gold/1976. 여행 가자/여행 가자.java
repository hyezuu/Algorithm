import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static int[][] cities;
  static int[] plans;
  static int[] parent;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    initInput(br);
    initParent();

    System.out.print(solve() ? "YES" : "NO");
  }

  static boolean solve(){
    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++){
        if(cities[i][j] == 1){
          union(i, j);
        }
      }
    }

    int prev = find(plans[0]-1);

    for(int i=1; i<M; i++){
      int cur = find(plans[i]-1);
      if(prev != cur){
        return false;
      }
      prev = cur;
    }
    return true;
  }

  static void union(int a, int b){
    int pa = find(a);
    int pb = find(b);

    if(pa < pb){
      parent[pb] = pa;
      return;
    }
    parent[pa] = pb;
  }

  static int find(int x){
    if(parent[x] == x){
      return x;
    }
    return parent[x] = find(parent[x]);
  }

  private static void initInput(BufferedReader br) throws IOException {
    cities = new int[N][N];

    StringTokenizer st;

    for(int i=0; i<N; i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++){
        cities[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    plans = new int[M];

    st = new StringTokenizer(br.readLine());

    for(int i=0; i<M; i++){
      plans[i] = Integer.parseInt(st.nextToken());
    }
  }

  private static void initParent() {
    parent = new int[N];

    for(int i=0; i<N; i++){
      parent[i] = i;
    }
  }
}

