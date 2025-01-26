import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[5];

		for(int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		
		int min = Integer.MAX_VALUE;

		for(int i=0; i<5; i++){
			for(int j=i+1; j<5; j++){
				if(i!=j){
					int LCM = getLCM(arr[i], arr[j]);
					for(int k=j+1; k<5; k++){
						min = Math.min(getLCM(LCM, arr[k]),min);
					}
				}
			}
		}
		System.out.print(min);
	}

	static int getLCM(int a, int b){
		int LCM = a * b;
		while(b!=0){
			int r = a % b;
			a = b;
			b = r;
		}
		return LCM / a;
	}
}