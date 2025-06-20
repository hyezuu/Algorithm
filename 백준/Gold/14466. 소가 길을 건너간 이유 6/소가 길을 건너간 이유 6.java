import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  static int N, K, R;
  static int[][] cows;
  static Set<Road>[][] roads;
  static int[] parent;
  static int[] dy = {0, 1, 0, -1};
  static int[] dx = {1, 0, -1, 0};


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    roads = new Set[N][N];

    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++){
        roads[i][j] = new HashSet<>();
      }
    }

    for(int i=0; i<R; i++){
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken())-1;
      int c = Integer.parseInt(st.nextToken())-1;
      int r2 = Integer.parseInt(st.nextToken())-1;
      int c2 = Integer.parseInt(st.nextToken())-1;

      roads[r][c].add(new Road(r2, c2));
      roads[r2][c2].add(new Road(r, c));
    }

    cows = new int[K][2];

    for(int i=0; i<K; i++){
      st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken())-1;
      int x = Integer.parseInt(st.nextToken())-1;

      cows[i] = new int[]{y, x};
    }

    System.out.println(solve());
  }

  static int solve(){
    parent = new int[N*N];
    for(int i=0; i<N*N; i++){
      parent[i] = i;
    }
    
    for(int y=0; y<N; y++){
      for(int x=0; x<N; x++){
        for(int dir = 0; dir<4; dir++){
          int ny = y+dy[dir];
          int nx = x+dx[dir];
          
          if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
          if(roads[y][x].contains(new Road(ny, nx))) continue;
          
          union(getIndex(y, x), getIndex(ny, nx));
        }
      }
    }
    
    int distPairs = 0;
    
    for(int i=0; i<K; i++){
      for(int j=i+1; j<K; j++){
        int pos1 = getIndex(cows[i][0], cows[i][1]);
        int pos2 = getIndex(cows[j][0], cows[j][1]);
        
        if(find(pos1) != find(pos2)){
          distPairs++;
        }
      }
    }
    return distPairs;
  }
  static void union(int x, int y){
    int rootX = find(x);
    int rootY = find(y);
    parent[rootY] = rootX;
  }

  static int find(int x){
    if(parent[x] != x){
      parent[x] = find(parent[x]);
    }
    return parent[x];
  }
  
  static int getIndex(int y, int x){
    return y*N+x;
  }

  static class Road{
    int y;
    int x;

    Road(int y, int x){
      this.y = y;
      this.x = x;
    }

    @Override
    public boolean equals(Object o) {
      if (o == null || Road.class != o.getClass()) {
        return false;
      }
      Road road = (Road) o;
      return y == road.y && x == road.x;
    }

    @Override
    public int hashCode() {
      return Objects.hash(y, x);
    }
  }
}
