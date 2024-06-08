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
        Set<Integer> set = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{n, 0});
        set.add(n);
        int answer = 0;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int cur = tmp[0];
            int dist = tmp[1];
            if(cur==k){
                answer = dist;
                break;
            }
            int[] next = {cur+1, cur-1, cur*2};
            for(int a : next){
                if(a>=0 && a<=100000 && set.add(a)){
                    q.offer(new int[]{a, dist+1});
                }
            }
        }
        return answer;
    }
}