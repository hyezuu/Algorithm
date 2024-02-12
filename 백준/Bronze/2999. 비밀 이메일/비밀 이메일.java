import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public String solution(String str) {
        int r = 0;
        int c = 0;
        StringBuilder sb = new StringBuilder();
        int n= str.length();
        for(int i=1; i<=n; i++){
            if(n%i==0&&i<=n/i){
               r = i;
               c = n/r;
            }
        }
        char[][] answer = new char[r][c];
        for(int i=0; i<c; i++){
            for(int j=0; j<r; j++){
                answer[j][i] = str.charAt(j);
            }
            str = str.substring(r);
        }
        for(int j=0; j<r; j++){
            for(int i=0; i<c; i++){
                sb.append(answer[j][i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        bw.write(T.solution(str));
        bw.flush();
    }
}
