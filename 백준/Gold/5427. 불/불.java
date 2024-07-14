import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            char[][] board = new char[h][w];

            for (int j = 0; j < h; j++) {
                board[j] = br.readLine().toCharArray();
            }
            bw.write(bfs(board, w, h) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static String bfs(char[][] board, int w, int h) {
        Queue<Pos> fireQ = new LinkedList<>();
        Queue<Pos> personQ = new LinkedList<>();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        //이 좌표는 불이쓰고 상근이가 읽는다
        int[][] distF = new int[h][w];
        int[][] distP = new int[h][w];

        for (int i = 0; i < h; i++) {
            Arrays.fill(distF[i], -1);
            Arrays.fill(distP[i], -1);
        }

        int nx, ny, nd;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == '*') {
                    fireQ.offer(new Pos(i, j, 0));
                    distF[i][j] = 0;
                } else if (board[i][j] == '@') {
                    personQ.offer(new Pos(i, j, 0));
                    distP[i][j] = 0;
                }
            }
        }

        while (!fireQ.isEmpty()) {
            Pos fire = fireQ.poll();
            for (int i = 0; i < 4; i++) {
                nx = fire.x + dx[i];
                ny = fire.y + dy[i];
                nd = fire.d + 1;

                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if (distF[nx][ny] >= 0 || board[nx][ny] == '#') continue;

                distF[nx][ny] = nd;
                fireQ.offer(new Pos(nx, ny, nd));
            }
        }

        while (!personQ.isEmpty()) {
            Pos person = personQ.poll();
            for (int i = 0; i < 4; i++) {
                nx = person.x + dx[i];
                ny = person.y + dy[i];
                nd = person.d + 1;
                if (nx < 0 || ny < 0 || nx >= h || ny >= w) return nd + "";
                //방문확인 || 벽인지확인(불체크는ㅇㅏ래에서 해서 안해도된당)
                if (distP[nx][ny] >= 0 || board[nx][ny] == '#') continue;
                //불이 전파된 좌표인지 확인
                if (distF[nx][ny] != -1 && distF[nx][ny] <= nd) continue;

                //방문처리
                distP[nx][ny] = nd;
                personQ.offer(new Pos(nx, ny, nd));
            }
        }
        return "IMPOSSIBLE";
    }
}

class Pos {
    int x;
    int y;
    int d;

    public Pos(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}