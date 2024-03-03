import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        while (true){
            String s = br.readLine();
            if(s.equals("0"))break;
            StringBuilder sb = new StringBuilder(s);
            if(s.contentEquals(sb.reverse()))answer.append("yes").append("\n");
            else answer.append("no").append("\n");
        }
        System.out.println(answer);
    }
}
