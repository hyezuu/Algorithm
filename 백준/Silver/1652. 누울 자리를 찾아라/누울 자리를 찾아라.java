import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		char[][] room = new char[n][n];

		int[] answer = new int[2];

		for(int i = 0; i < n; i++) {
			room[i] = br.readLine().toCharArray();

			StringTokenizer st = new StringTokenizer(String.valueOf(room[i]), "X");
			while (st.hasMoreTokens()) {
				if(st.nextToken().length() >= 2){
					answer[0]++;
				}
			}
		}

		for(int j=0; j < n; j++) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<n; i++) {
				sb.append(room[i][j]);
			}

			StringTokenizer st = new StringTokenizer(String.valueOf(sb), "X");
			while (st.hasMoreTokens()) {
				if(st.nextToken().length() >= 2){
					answer[1]++;
				}
			}
		}

		System.out.print(answer[0] + " " + answer[1]);
	}
}