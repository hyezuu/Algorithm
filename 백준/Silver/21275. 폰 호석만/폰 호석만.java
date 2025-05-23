import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

  public static int[] nums = new int[36];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    String nums1 = st.nextToken();
    String nums2 = st.nextToken();

    solve(nums1, nums2);
  }

  public static void solve(String nums1, String nums2) {
    int max1 = 0, max2 = 0;

    int[] arr1 = new int[nums1.length()];
    int[] arr2 = new int[nums2.length()];

    int idx = nums1.length() - 1;

    int tmp = 0;

    for (char num1 : nums1.toCharArray()) {
      if (Character.isDigit(num1)) {
        tmp = num1 - '0';
      } else {
        tmp = num1 - 'a' + 10;
      }

      arr1[idx--] = tmp;
      max1 = Math.max(max1, tmp);
    }

    idx = nums2.length() - 1;

    for (char num2 : nums2.toCharArray()) {
      if (Character.isDigit(num2)) {
        tmp = num2 - '0';
      } else {
        tmp = num2 - 'a' + 10;
      }

      arr2[idx--] = tmp;
      max2 = Math.max(max2, tmp);
    }

    max1 = max1 + 1;
    max2 = max2 + 1;

    Map<Long, int[]> map = new HashMap<>();

    for (int j = max1; j <= 35; j++) {
      long longNum1 = 0L;
      int pow = 0;
      for (int k : arr1) {
        longNum1 += (long) (Math.pow(j, pow++) * k);
      }
      map.put(longNum1, new int[]{j, 0});
    }

    for (long key : map.keySet()) {
      for (int j = max2; j <= 35; j++) {
        int rt = 0;
        long tmp2 = key;
        int cnt = 0;
        while (tmp2 > 0) {
          if (tmp2 % j != arr2[rt++]) {
            break;
          }
          tmp2 /= j;
          cnt++;
          if(rt == arr2.length) break;
        }
        if (cnt == nums2.length()) {
          int[] arr = map.get(key);
          arr[1] = j;
          map.put(key, arr);
        }
      }
    }

    long[] answer = new long[3];

    for (long key : map.keySet()) {
      int[] arr = map.get(key);
      if (arr[0] != 0 && arr[1] != 0) {
        if (answer[0] != 0) {
          System.out.println("Multiple");
          return;
        }
        answer[0] = key;
        answer[1] = arr[0];
        answer[2] = arr[1];
      }
    }
    if (answer[0] == 0) {
      System.out.println("Impossible");
      return;
    }

    System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
  }
}
