import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[][] arr = new int[M][N];

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;

		for(int a=0; a<M; a++) {
			for(int b=a+1; b<M; b++){
				boolean isEqual = true;
				for(int i=0; i<N; i++){
					for(int j=i+1; j<N; j++){
						if(arr[a][i]==arr[a][j] && arr[b][i]!=arr[b][j]){
							isEqual = false;
							break;
						}
						if(arr[a][i]>arr[a][j] && arr[b][i]<=arr[b][j]){
							isEqual = false;
							break;
						}
						if(arr[a][i]<arr[a][j] && arr[b][i]>=arr[b][j]){
							isEqual = false;
							break;
						}
					}
				}
				if(isEqual){
					cnt++;
				}
			}
		}

		System.out.print(cnt);
	}
}