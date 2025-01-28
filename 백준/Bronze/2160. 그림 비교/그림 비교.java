import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		char[][] arr = new char[5*N][7];
		for(int i=0; i<5*N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		int max = -1;
		int ans1 = -1;
		int ans2 = -1;

		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				int cnt = 0;
				for(int y=0; y<5; y++){
					for(int x=0; x<7; x++){
						int tmp1 = i*5+y;
						int tmp2 = j*5+y;
						if(arr[tmp1][x] == arr[tmp2][x]) {
							cnt++;
						}
					}
				}
				if(cnt > max){
					max = cnt;
					ans1 = i+1;
					ans2 = j+1;
				}
			}
		}
		System.out.print(ans1 + " " + ans2);
	}
}