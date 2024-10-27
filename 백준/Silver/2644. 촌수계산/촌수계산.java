import java.io.*;
import java.util.*;

class Main {
    static int [][] graph;
    static int N;
    static int other;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int me = Integer.parseInt(st.nextToken());
        other = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());

        graph = new int[N+1][N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int parents = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            graph[parents][child] = graph[child][parents] = 1;
        }
        dist = new int[N+1];
        bfs(me);
        System.out.print(dist[other] == 0 ? -1 : dist[other]);
    }

    public static void bfs (int d){
        Queue<Integer> q = new LinkedList<>();
        q.offer(d);

        while(!q.isEmpty()){
            int tmp = q.poll();
            if(tmp == other) break;
            for (int i=1; i<=N; i++) {
                if(graph[tmp][i] == 1 && dist[i]==0) {
                    q.offer(i);
                    dist[i] = dist[tmp] + 1;
                }
            }
        }
    }
}
