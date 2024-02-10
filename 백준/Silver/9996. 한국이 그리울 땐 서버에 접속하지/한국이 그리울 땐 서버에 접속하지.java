import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public String solution(int n , String pattern, String[] arr) {
        String[] pt = pattern.split("[*]");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            if(arr[i].startsWith(pt[0])&&arr[i].substring(pt[0].length()).endsWith(pt[1])){
                sb.append("DA").append("\n");
            }
            else sb.append("NE").append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        String pattern = br.readLine();
        for(int i=0; i<n; i++){
            arr[i] = br.readLine();
        }
        bw.write(T.solution(n, pattern, arr));
        bw.flush();
    }
}
