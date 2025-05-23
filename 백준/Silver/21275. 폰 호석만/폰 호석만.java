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

    long[] answer = new long[3];

    for (int j = max1; j <= 36; j++) {
      long longNum1 = 0L;
      int pow = 0;
      for (int k : arr1) {
        longNum1 += (long) (Math.pow(j, pow++) * (long) k);
      }
      for (int l = max2; l <= 36; l++) {
        if (l == j) {
          continue;
        }
        int rt = 0;
        long tmp2 = longNum1;

        while (tmp2 > 0) {
          if (tmp2 % l != arr2[rt++]) {
            break;
          }
          tmp2 /= l;

          if(rt == arr2.length) {
            break;
          }
        }
        if (rt == arr2.length && tmp2 == 0) {
          if (map.containsKey(longNum1)) {
            System.out.println("Multiple");
            return;
          }
          map.put(longNum1, new int[]{j, l});
          answer = new long[]{longNum1, j, l};
        }
      }
    }

    if (map.isEmpty()) {
      System.out.println("Impossible");
      return;
    }
    if (map.size() > 1) {
      System.out.println("Multiple");
      return;
    }
    System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
  }
}
