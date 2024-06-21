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
        int[] arr = new int[a + 1];

        for(int i=2; i<=a; i++){
            arr[i] = arr[i-1] + 1;
            if(i%2==0) arr[i] = Math.min(arr[i], arr[i/2]+1);
            if(i%3==0) arr[i] = Math.min(arr[i], arr[i/3]+1);
        }
        return arr[a];

//        Queue<Integer> q = new LinkedList<>();
//        int[] visited = new int[a + 1];
//        q.offer(1);
//        visited[1] = 0;
//        while (!q.isEmpty()) {
//            int cur = q.poll();
//            int[] tmp = {cur + 1, cur * 2, cur * 3};
//            for (int i : tmp) {
//                if (i <= a && visited[i] == 0) {
//                    visited[i] = visited[cur] + 1;
//                    if(i==a) return visited[i];
//                    q.offer(i);
//                }
//            }
//        }
//        return visited[a];
    }
}