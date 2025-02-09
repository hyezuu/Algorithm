import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(br.readLine());
		int[] S = new int[L+1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 1; i <= L ; i++){
			S[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(S);

		int n = Integer.parseInt(br.readLine());

		int cnt = 0;

		for(int i=0; i<L; i++){
			if(n > S[i] && n < S[i+1]) {
				for(int j = S[i]+1 ; j <= Math.min(n, S[1+i]-1) ; j++){
					for(int k = Math.max(j+1, n) ; k < S[i+1] ; k++){
						cnt ++;
					}
				}
				break;
			}
		}
		System.out.print(cnt);
	}
}