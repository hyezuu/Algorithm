import java.io.*;
import java.util.*;

class Main {
    static ArrayList<Integer>[] network;
    static boolean[] visited;
    static int N;
    static int other;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int me = Integer.parseInt(st.nextToken());
        other = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());

        network = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            network[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int parents = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            network[parents].add(child);
            network[child].add(parents);
        }
        visited = new boolean[N+1];
        visited[me] = true;
        System.out.print(dfs(me, 0));
    }

    public static int dfs(int d, int distance){
        if(d==other){
            return distance;
        }
        for(int next : network[d]){
            if(!visited[next]){
                visited[next] = true;
                int result = dfs(next, distance+1);
                if(result != -1){
                    return result;
                }
                visited[next] = false;
            }
        }
        return -1;
    }

}
