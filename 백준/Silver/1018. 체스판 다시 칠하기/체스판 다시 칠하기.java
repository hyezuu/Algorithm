import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[][] arr = new char[n][m];

		for(int i=0; i<n; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		int min = Integer.MAX_VALUE;

		//시작이 W인경우
		//시작이 B인경우

		for(int i=0; i<n-7; i++) {
			for(int j=0; j<m-7; j++) {
				int w = 0;
				int b = 0;
				for(int x=0; x<8; x++){
					for(int y=0; y<8; y++){
						if((x%2==0 && y%2== 0) || (x%2!=0 && y%2!=0)){
							if(arr[i+x][j+y] == 'W'){
								w++;
							}
							else b++;
						}
						else if(arr[i+x][j+y] == 'W'){
							b++;
						}
						else w++;
					}
				}
				min = Math.min(min, Math.min(w,b));
			}
		}

		System.out.print(min);
	}
}