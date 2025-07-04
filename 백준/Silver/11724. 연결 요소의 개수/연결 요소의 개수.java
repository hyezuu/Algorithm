import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static int[] parent;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    parent = new int[N];

    for(int i = 0; i < N; i++){
      parent[i] = i;
    }

    for(int i = 0; i< M; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;

      union(a, b);
    }

    System.out.print(solve());
  }

  static int solve(){
    Set<Integer> set = new HashSet<>();

    for(int i = 0; i < N; i++){
      set.add(find(i));
    }

    return set.size();
  }

  static void union(int a, int b){
    int parentA = find(a);
    int parentB = find(b);

    if(parentA < parentB){
      parent[parentB] = parentA;
      return;
    }
    parent[parentA] = parentB;
  }

  static int find(int x){
    if(parent[x] == x) return x;
    return parent[x] = find(parent[x]);
  }
}
