import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

class Main {
    public static void  main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] weights = new Integer[n];
        for(int i=0; i<n; i++){
            weights[i] = Integer.parseInt(br.readLine());
        }

        System.out.print(solution(weights));
        br.close();
    }
    public static int solution(Integer[] weights){
        Arrays.sort(weights, Collections.reverseOrder());

        int max = 0;
        for(int i=1; i<=weights.length; i++){
            if(weights[i-1]*i>max) max = weights[i-1]*i;
        }

        return max;
    }
}