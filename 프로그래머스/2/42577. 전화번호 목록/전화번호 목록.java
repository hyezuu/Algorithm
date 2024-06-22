import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 전화번호 목록을 해시맵에 저장
        Map<String, Boolean> map = new HashMap<>();
        for (String number : phone_book) {
            map.put(number, true);
        }

        // 각 전화번호에 대해 접두사 확인
        for (String number : phone_book) {
            for (int i = 1; i < number.length(); i++) {
                if (map.containsKey(number.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }
}
