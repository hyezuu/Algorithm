import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 전화번호 목록을 해시셋에 저장
        Set<String> set = new HashSet<>();
        for (String number : phone_book) {
            set.add(number);
        }

        // 각 전화번호에 대해 접두사 확인
        for (String number : phone_book) {
            for (int i = 1; i < number.length(); i++) {
                if (set.contains(number.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }
}
