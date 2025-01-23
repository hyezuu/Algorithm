import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0){
			int tmp = Integer.parseInt(br.readLine());
			int answer = 0;

			outer : for(int i = 1; i < tmp-1; i++){
				if(!isTriangleNumber(i)) continue;
				for(int j = 1; j < tmp-1; j++){
					if(!isTriangleNumber(j)) continue;
					for(int k = 1; k < tmp-1; k++){
						if(!isTriangleNumber(k)) continue;
						if(i+j+k == tmp) {
							answer = 1;
							break outer;
						}
					}
				}
			}
			sb.append(answer).append("\n");
		}

		System.out.print(sb);

	}

	static boolean isTriangleNumber(int n){
		int sum = 0;
		for(int i=1; i<=(n/2)+1; i++){
			sum+=i;
			if(sum==n) return true;
		}
		return false;
	}
}