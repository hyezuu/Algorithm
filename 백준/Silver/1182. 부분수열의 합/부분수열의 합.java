import java.io.*;
import java.util.*;

class Main {
    static int[] arr;
    static int n;
    static int s;
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution(0, 0);
        if(s == 0) cnt--;
        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
    public static void solution(int idx , int sum) {
        if(idx == n){
            if(sum == s){
                cnt ++;
            }
            return;
        }

        solution(idx+1, sum+arr[idx]);
        solution(idx+1, sum);
    }
}
