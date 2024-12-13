-- 코드를 작성해주세요
SELECT COUNT(fi.ID) as FISH_COUNT, fni.fish_name as FISH_NAME
FROM FISH_INFO as fi
INNER JOIN FISH_NAME_INFO as fni ON fi.fish_type = fni.fish_type
GROUP BY FISH_NAME
ORDER BY FISH_COUNT DESC