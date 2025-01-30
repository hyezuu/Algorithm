import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int cnt = 0;
			for(int j=N; j<=M; j++) {
				cnt += countZero(j);
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	static int countZero(int n){
		if(n==0) return 1;
		int cnt = 0;
		while(n>0){
			if(n%10==0) cnt++;
			n=n/10;
		}
		return cnt;
	}


}