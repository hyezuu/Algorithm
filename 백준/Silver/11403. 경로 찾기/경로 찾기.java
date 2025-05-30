import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static List<Integer>[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());


    arr = new List[N];

    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      arr[i] = new ArrayList<>();
      for(int j = 0; j < N; j++){
        if(st.nextToken().equals("1")){
          arr[i].add(j);
        }
      }
    }

    solve();
  }

  static void solve(){
    int[][] answer = new int[N][N];

    for(int start = 0; start < N; start++){
      boolean[] visited = new boolean[N];
      Queue<Integer> q = new LinkedList<>();

      q.offer(start);
      visited[start] = true;

      while(!q.isEmpty()){
        int now = q.poll();
        for(int next : arr[now]){
          answer[start][next] = 1;
          if(!visited[next]){
            visited[next] = true;
            q.offer(next);
          }
        }
      }
    }

    for(int[] row : answer){
      for(int i : row){
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
}