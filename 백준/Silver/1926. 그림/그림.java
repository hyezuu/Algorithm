import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer con = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(con.nextToken());
        int m = Integer.parseInt(con.nextToken());

        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        System.out.println(T.solution(n, m, board));

    }

    public String solution(int n, int m, int[][] board) {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int max = 0;
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 || visited[i][j]) continue;
                num++;
                q.offer(new Pair(i, j)); // 시작점만 넣나
                visited[i][j] = true;
                int area = 0;
                while (!q.isEmpty()) {
                    area++;
                    Pair tmp = q.poll();

                    for (int k = 0; k < 4; k++) {
                        int nx = tmp.x + dx[k];
                        int ny = tmp.y + dy[k];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (visited[nx][ny] || board[nx][ny] == 0) continue;
                        visited[nx][ny] = true;
                        q.offer(new Pair(nx, ny));
                    }
                }
                max = Math.max(max, area);

            }
        }

        return num+ "\n" + max;
    }

    public class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}