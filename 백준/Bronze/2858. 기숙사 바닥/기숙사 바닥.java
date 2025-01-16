import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int sum = R + B;

        int L = 1, W = 1;

        for (int i = 3; i<sum/2; i++){
            if (sum%i == 0){
                L = Math.max(i, sum/i);
                W = Math.min(i, sum/i);

                if((L-2) * (W-2) == B){
                    break;
                }
            }
        }

        System.out.print(L + " " + W);
    }
}