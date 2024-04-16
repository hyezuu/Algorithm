class Solution {
  public String solution(String s) {
        String[] arr = s.toLowerCase().split("");
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for(String str : arr) {
            sb.append(flag ? str.toUpperCase() : str);
            flag = str.equals(" ") ? true : false;
        }

        return sb.toString();
  }
}
