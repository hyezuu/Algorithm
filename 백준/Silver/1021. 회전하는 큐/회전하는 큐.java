import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer con = new StringTokenizer(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(con.nextToken());
        int m = Integer.parseInt(con.nextToken());
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        System.out.print(solution(n, arr));

        br.close();
    }

    private static int solution(int n, int[] arr) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }
        int cnt = 0;

        for (int a : arr) {

            int idx = 0;

            for (int k : deque) {

                if(a == k){
                    int min = Math.min(deque.size() - idx , idx);
                    cnt += min;
                    if (min == idx) {
                        while (min > 0) {
                            deque.addLast(deque.pollFirst());
                            min--;
                        }
                    } else {
                        while (min > 0) {
                            deque.addFirst(deque.pollLast());
                            min--;
                        }
                    }
                    deque.pollFirst();
                    break;
                }
                idx++;
            }
        }

        return cnt;
    }
}
