import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];

		for(int i = 0; i < arr.length; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		int sum = 0;

		for(int i = 0; i < arr.length; i++){
			int newNum = sum + arr[i];

			if(getClosestNum(newNum, sum) == sum){
				break;
			}
			sum = newNum;
		}

		System.out.print(sum);
	}

	static int getClosestNum(int num1, int num2){
		if(Math.abs(num1-100) < Math.abs(num2-100)){
			return num1;
		}
		else if(Math.abs(num1-100) > Math.abs(num2-100)){
			return num2;
		}
		return Math.max(num1, num2);
	}
}