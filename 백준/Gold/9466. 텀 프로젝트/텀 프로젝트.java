import java.io.*;
import java.util.*;

class Main {
    static int[] students;
    static int[] state;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            students = new int[n];
            state = new int[n];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                students[j] = Integer.parseInt(st.nextToken()) - 1;
            }

            for (int j = 0; j < n; j++) {
                if (state[j] == 0) {
                    dfs(j);
                }
            }

            bw.write(count + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void dfs(int node) {
        state[node] = 1; // 방문 중

        int next = students[node];
        if (state[next] == 0) {
            dfs(next);
        } else if (state[next] == 1) {
            // 사이클 발견
            int current = next;
            while (current != node) {
                current = students[current];
            }
            // 사이클에 포함되지 않은 노드 카운트
            current = next;
            while (current != node) {
                state[current] = 2; // 사이클에 포함
                current = students[current];
            }
            state[node] = 2;
        }

        if (state[node] == 1) {
            count++; // 사이클에 포함되지 않은 노드
            state[node] = 2; // 처리 완료
        }
    }
}