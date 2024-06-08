import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        System.out.print(main.solution(n, k));
        br.close();
    }

    public int solution(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        int[] distance = new int[100002];
        Arrays.fill(distance, -1);
        distance[n] = 0;
        q.offer(n);
        while (!q.isEmpty()) {
            int cur = q.poll();
            int[] next = {cur+1, cur-1, cur*2};
            for(int a : next){
                if(a>=0 && a<=100000 && distance[a]==-1){
                    distance[a] = distance[cur] + 1;
                    q.offer(a);
                }
            }
        }
        return distance[k];
    }
}