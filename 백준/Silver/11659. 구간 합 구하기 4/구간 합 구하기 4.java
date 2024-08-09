import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] interval = new int[2];
        int[] board = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            board[i] = Integer.parseInt(st.nextToken())+board[i-1];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                interval[j] = Integer.parseInt(st.nextToken());
            }
            bw.write(prefixSum(interval, board) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    //interval = {x1, y1, x2, y2}
    static int prefixSum(int[] interval, int[] board) {
        return board[interval[1]]-board[interval[0]-1];
    }
}