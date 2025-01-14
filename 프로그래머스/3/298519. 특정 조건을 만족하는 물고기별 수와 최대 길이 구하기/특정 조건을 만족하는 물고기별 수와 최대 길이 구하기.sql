-- 코드를 작성해주세요
SELECT 
    COUNT(ID) as FISH_COUNT,
    MAX(LENGTH) as MAX_LENGTH,
    FISH_TYPE
FROM FISH_INFO
GROUP BY FISH_TYPE
HAVING avg(ifnull(length, 10)) >= 33
ORDER BY FISH_TYPE