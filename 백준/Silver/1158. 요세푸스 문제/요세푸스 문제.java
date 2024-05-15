import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, k;
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        System.out.println(main.solution(n,k));
    }

    public String solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        Queue<Integer> q = new LinkedList<>();
        int cnt = 1;

        for(int i=1; i<=n; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()){
            if(cnt==k) {
                sb.append(q.poll()).append(", ");
                cnt = 1;
            }
            else {
                q.offer(q.poll());
                cnt++;
            }
        }
        return sb.substring(0, sb.length()-2)+">";
    }
}