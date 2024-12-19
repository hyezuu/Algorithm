-- 코드를 입력하세요
SELECT ugu.USER_ID, ugu.NICKNAME,
concat(city,' ', ugu.STREET_ADDRESS1,' ', ugu.STREET_ADDRESS2) as '전체주소', 
concat(substring(ugu.tlno, 1, 3), '-',substring(ugu.tlno, 4, 4), '-',substring(ugu.tlno, 8, 4)) as '전화번호'
FROM used_goods_board as ugb
INNER JOIN used_goods_user as ugu ON ugb.writer_id = ugu.user_id
GROUP BY ugu.user_id
HAVING count(user_id) >= 3
ORDER BY USER_ID desc
