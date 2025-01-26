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

		if (n % (a + b + c) == 0 || n % (a + b) % c == 0 || n % (a + c) % b == 0
			|| n % (b + c) % a == 0 || n % a % b % c == 0 || n % b % c % a == 0 || n % c % b % a == 0) {
			System.out.print(1);
		} else {
			System.out.print(0);
		}
	}
}