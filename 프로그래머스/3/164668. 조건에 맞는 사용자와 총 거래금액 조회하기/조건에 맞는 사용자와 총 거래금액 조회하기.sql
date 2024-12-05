-- 코드를 입력하세요
SELECT u.user_id USER_ID , u.nickname NICKNAME, sum(b.price) as TOTAL_SALES
FROM used_goods_board as b 
INNER JOIN used_goods_user as u on b.writer_id = u.user_id
WHERE b.status like 'DONE'
GROUP BY USER_ID
HAVING TOTAL_SALES >= '700000'
ORDER BY TOTAL_SALES 
