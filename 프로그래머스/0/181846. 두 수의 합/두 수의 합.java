class Solution {
    public String solution(String a, String b) {
        StringBuilder sb = new StringBuilder();
        
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        
        int lenA = arrA.length;
        int lenB = arrB.length;
        
        int carry = 0;
        
        for(int i = 1; i <= Math.max(lenA, lenB); i++) {
            int sum = carry;
            if(lenA - i >= 0) {
                sum += arrA[lenA - i] - '0';
            }
            if(lenB - i >= 0) {
                sum += arrB[lenB - i] - '0';
            }
            carry = sum / 10;
            sb.insert(0, sum % 10);
        }
        // 마지막 자리 올림이 남아있는 경우
        if(carry > 0) {
            sb.insert(0, carry);
        }
        
        return sb.toString();
    }
}
