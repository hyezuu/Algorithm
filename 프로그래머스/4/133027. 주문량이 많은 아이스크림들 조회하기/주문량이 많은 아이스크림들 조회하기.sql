-- 코드를 입력하세요
SELECT fh.FLAVOR
FROM FIRST_HALF fh
INNER JOIN JULY j ON fh.flavor = j.flavor
group by flavor
ORDER BY (sum(fh.total_order) + sum(j.total_order)) desc
LIMIT 3