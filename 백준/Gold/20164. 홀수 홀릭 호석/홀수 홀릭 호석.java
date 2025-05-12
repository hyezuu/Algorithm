import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String tmp = br.readLine();

		recursion(tmp, 0);
		System.out.println(min+" "+max);
	}

	public static void recursion(String tmp, int cnt){
		// 각 자릿수의 홀수여부판별은 공통적으로 수행되므로 최초에 한번만 수행해도됨.. 공통로직 제거할것
		if(tmp.length() == 1){
			if(Integer.parseInt(tmp)%2==1) cnt++;

			min = Math.min(min, cnt);
			max = Math.max(max, cnt);
		}
		else if(tmp.length()==2){
			int num = Integer.parseInt(tmp);
			int next = (num%10 + num/10);
			if(num%10%2==1) cnt++;
			if(num/10%2==1) cnt++;
			recursion(next+"", cnt);
		}
		else {
			int num = Integer.parseInt(tmp);
			while (num>0){
				if(num%10%2==1) cnt++;
				num/=10;
			}

			for(int i=0; i<tmp.length()-2; i++){
				for(int j=i+1; j<tmp.length()-1; j++){
					int start = Integer.parseInt(tmp.substring(0, i+1));
					int mid = Integer.parseInt(tmp.substring(i+1, j+1));
					int end = Integer.parseInt(tmp.substring(j+1));

					recursion(start+mid+end+"", cnt);
				}
			}
		}
	}
}


