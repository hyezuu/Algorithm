import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int max = 0;
		for(int i=1; i<=k; i++){
			max = Math.max(max, reverse(n*i));
		}
		System.out.print(max);
	}

	private static int reverse(int n){
		StringBuilder sb = new StringBuilder();
		while(n>0){
			sb.append(n%10);
			n=n/10;
		}
		return Integer.parseInt(sb.toString());
	}

}