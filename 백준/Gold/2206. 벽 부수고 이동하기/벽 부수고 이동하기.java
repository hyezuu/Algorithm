import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];

        for(int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        bw.write(String.valueOf(bfs(board, N, M)));

        br.close();
        bw.flush();
        bw.close();
    }

    private static int bfs(char[][] board, int N, int M) {
        int[][][] visited = new int[N][M][2];
        Queue<Pos> queue = new LinkedList<>();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        queue.offer(new Pos(0, 0, 0));
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            Pos pos = queue.poll();
            
            if(pos.x == N - 1 && pos.y == M - 1) {
                return visited[pos.x][pos.y][pos.broken];
            }

            for(int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(board[nx][ny] == '0') {
                    if(visited[nx][ny][pos.broken] == 0) {
                        queue.offer(new Pos(nx, ny, pos.broken));
                        visited[nx][ny][pos.broken] = visited[pos.x][pos.y][pos.broken] + 1;
                    }
                }
                else if(pos.broken == 0) {
                    if(visited[nx][ny][1] == 0) {
                        queue.offer(new Pos(nx, ny, 1));
                        visited[nx][ny][1] = visited[pos.x][pos.y][0] + 1;
                    }
                }
            }
        }
        return -1;
    }
}

class Pos {
    int x;
    int y;
    int broken;

    public Pos(int x, int y, int broken) {
        this.x = x;
        this.y = y;
        this.broken = broken;
    }
}