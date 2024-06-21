import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        System.out.print(main.solution(a));
        br.close();
    }

    public int solution(int a) {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[a + 1];
        q.offer(1);
        visited[1] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if(cur==a) break;
            int[] tmp = {cur + 1, cur * 2, cur * 3};
            for (int i : tmp) {
                if (i <= a && visited[i] == 0) {
                    visited[i] = visited[cur] + 1;
                    q.offer(i);
                }
            }
        }
        return visited[a];
    }
}