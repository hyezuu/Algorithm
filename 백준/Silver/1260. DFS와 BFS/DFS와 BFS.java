import java.io.*;
import java.util.*;

class Main {

    static boolean[][] graph;
    static int n;
    static int m;
    static int v;
    static List<Integer> dfsList = new ArrayList<>();
    static List<Integer> bfsList = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new boolean[n+1][n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1][n2] = true;
            graph[n2][n1] = true;
        }

        visited = new boolean[n+1];
        dfs(v);
        bfs(v);


        for(int i : dfsList){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i : bfsList){
            System.out.print(i+" ");
        }
    }

    public static void dfs(int v) {
        dfsList.add(v);
        visited[v] = true;
        for(int i=1; i<=n; i++){
            if(graph[v][i] && !visited[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.offer(v);
        visited[v] = true;

        while(!q.isEmpty()){
            int poll = q.poll();
            bfsList.add(poll);
            for(int i=1; i<=n; i++){
                if(graph[poll][i] && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
