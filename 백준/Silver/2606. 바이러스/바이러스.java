import java.io.*;
import java.util.*;

class Main {
    static ArrayList<Integer>[] network;
    static boolean[] visited;
    static int N;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        network = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            network[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            network[a].add(b);
            network[b].add(a);
        }
        visited = new boolean[N+1];
        count = 0;
        visited[1] = true;
        dfs(1);
        System.out.print(count);
    }

    public static void dfs(int d){
        for(int i : network[d]){
            if(!visited[i]){
                count++;
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
