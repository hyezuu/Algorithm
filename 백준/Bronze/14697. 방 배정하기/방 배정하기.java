import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int n = Integer.parseInt(st.nextToken());

		int answer = 0;

		for(int i=0; i<=n/a; i++){
			for(int j=0; j<=n/b; j++){
				for(int k=0; k<=n/c; k++){
					if(a*i+b*j+c*k==n){
						answer = 1;
						break;
					}
				}
			}
		}

		System.out.print(answer);
	}
}