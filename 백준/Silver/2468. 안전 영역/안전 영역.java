import java.io.*;
import java.util.*;

class Main {

    static int[][] board;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        int maxHeight = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, board[i][j]);
            }
        }
        int maxCount = 0;
        for(int i=0; i<=maxHeight; i++){
            maxCount = Math.max(maxCount, bfs(i));
        }

        System.out.print(maxCount);
    }

    public static int bfs(int h) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] check = new boolean[n][n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > h && !check[i][j]) {
                    q.offer(new int[]{i, j});
                    check[i][j] = true;
                    cnt++;
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int y = cur[0];
                        int x = cur[1];

                        int[] ny = {0, -1, 0, 1};
                        int[] nx = {1, 0, -1, 0};

                        for (int k = 0; k < 4; k++) {
                            int dy = y + ny[k];
                            int dx = x + nx[k];
                            if (dy < 0 || dx < 0 || dx >= n || dy >= n) continue;
                            if (board[dy][dx] > h && !check[dy][dx]) {
                                q.offer(new int[]{dy, dx});
                                check[dy][dx] = true;
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
