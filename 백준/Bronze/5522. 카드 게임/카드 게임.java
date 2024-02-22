import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long answer = 0;
        for(int i=0; i<5; i++){
            answer+=Long.parseLong(br.readLine());
        }
        System.out.print(answer);
    }
}
