import java.io.*;
import java.util.*;

class Main {

    static char[][] board;
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        list = new ArrayList<>();

        bfs();

        Collections.sort(list);

        System.out.println(list.size());
        for(int num : list) {
            System.out.println(num);
        }
    }

    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '1') {
                    q.offer(new int[]{i, j});
                    board[i][j] = '0';
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

                            if (dy < 0 || dx < 0 || dx >= board.length || dy >= board.length
                                || board[dy][dx] != '1') continue;

                            q.offer(new int[]{dy, dx});
                            board[dy][dx] = '0';
                            cnt++;
                        }
                    }
                    list.add(cnt);
                    cnt=0;
                }
            }
        }
    }
}
