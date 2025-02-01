import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());

		long answer = -1;

		for(int i=0; i<100000; i++){
			long point = (long)i*x + p1;

			if((point - p2)%y==0 && (point - p2)/y >= 0){
				answer = point;
				break;
			}
		}

		System.out.print(answer);
	}
}