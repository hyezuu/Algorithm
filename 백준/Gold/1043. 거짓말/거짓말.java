import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  static int[] parent;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    //사람 수
    N = Integer.parseInt(st.nextToken());
    //파티 수
    M = Integer.parseInt(st.nextToken());

    parent = new int[N+1];

    for(int i = 1; i <= N; i++){
      parent[i] = i;
    }

    //진실아는 사람 수
    st = new StringTokenizer(br.readLine());
    int peoples = Integer.parseInt(st.nextToken());
    for(int i = 0; i < peoples; i++){
      parent[Integer.parseInt(st.nextToken())] = 0;
    }

    System.out.print(solve(br));
  }

  static int solve(BufferedReader br) throws Exception{
    List<Integer>[] parties = new List[M];
    StringTokenizer st;

    for(int i=0; i<M; i++){
      st = new StringTokenizer(br.readLine());
      int k = Integer.parseInt(st.nextToken());

      List<Integer> party = new ArrayList<>();
      for(int j=0; j<k; j++){
        party.add(Integer.parseInt(st.nextToken()));
      }
      for(int j=1; j<k; j++){
        union(party.get(j-1), party.get(j));
      }
      parties[i] = party;
    }

    int result = 0;

    for(List<Integer> party : parties){
      boolean hasTruth = false;
      for(int p : party){
        if(find(parent[p]) == 0){
          hasTruth = true;
          break;
        }
      }
      if(!hasTruth) result++;
    }
    return result;
  }

  static int find(int x){
    if(parent[x] == x) return x;
    return parent[x] = find(parent[x]);
  }

  static void union(int x, int y){
    int px= find(x);
    int py= find(y);

    if(px < py) parent[py] = px;
    else parent[px] = py;
  }
}
