import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int len = 9;
		int[] arr = new int[len];
		int sum = 0;

		for (int i = 0; i < len; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}

		Arrays.sort(arr);

		int lt = 0, rt = arr.length - 1;
		while (lt < rt) {
			int temp = arr[lt] + arr[rt];
            if (temp == sum - 100) {
                break;
            }
			if (temp > sum - 100) {
				rt--;
			} else if (temp < sum - 100) {
				lt++;
			}
		}

		for (int i = 0; i < len; i++) {
			if (i != lt && i != rt) {
				System.out.println(arr[i]);
			}
		}


	}
}