import java.io.*;
import java.util.*;

class Main {

    static int cnt, m, n;
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] board = new int[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            for (int y = ly; y < ry; y++) {
                for (int x = lx; x < rx; x++) {
                    board[y][x] = 1;
                }
            }
        }

        list = new ArrayList<>();

        bfs(board);

        System.out.println(cnt);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    public static void bfs(int[][] board) {
        int size = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    cnt++;
                    while (!q.isEmpty()) {
                        int[] nx = {0, 0, 0, -1, 1};
                        int[] ny = {0, -1, 1, 0, 0};
                        int[] tmp = q.poll();
                        for (int k = 0; k < 5; k++) {
                            int dx = tmp[1] + nx[k];
                            int dy = tmp[0] + ny[k];

                            if ((dx >= 0 && dx < n) && (dy >= 0 && dy < m) && board[dy][dx] == 0) {
                                q.offer(new int[]{dy, dx});
                                board[dy][dx] = 1;
                                size++;
                            }
                        }
                    }
                    list.add(size);
                    size = 0;
                }
            }
            Collections.sort(list);
        }
    }
}
