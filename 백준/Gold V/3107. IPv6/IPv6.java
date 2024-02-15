import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public String solution(String str) {
        StringBuilder sb = new StringBuilder();
        str = str.replaceAll("::",":zero:");

        String[] arr = str.split(":");
        for(String s : arr){
            if(s.equals("zero")){
                sb.append("0000:".repeat(9-arr.length));
            }
            else if(s.length()<4){
                sb.append("0".repeat(4-s.length())).append(s).append(":");
            }
            else sb.append(s).append(":");
        }
        return sb.substring(0,sb.length()-1);
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine().trim();
        bw.write(T.solution(str));
        bw.flush();
    }
}
