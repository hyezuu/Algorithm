class Solution {
    public String solution(String phone_number) {
        int len = phone_number.length()-4;
        StringBuilder sb = new StringBuilder(("*").repeat(len));
        for(int i=0; i<4; i++){
            sb.append(phone_number.charAt(len+i));
        }
        return sb.toString();
    }
}