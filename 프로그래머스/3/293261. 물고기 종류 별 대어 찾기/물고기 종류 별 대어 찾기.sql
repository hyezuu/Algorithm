-- 코드를 작성해주세요
WITH MAX_FISH_LENGTH as (
    SELECT MAX(LENGTH) as LENGTH, FISH_TYPE
    FROM FISH_INFO
    GROUP BY FISH_TYPE
)
SELECT fi.ID, fni.FISH_NAME, mfl.LENGTH
FROM MAX_FISH_LENGTH as mfl
JOIN FISH_NAME_INFO as fni ON mfl.FISH_TYPE = fni.FISH_TYPE
JOIN FISH_INFO as fi WHERE fi.FISH_TYPE = mfl.FISH_TYPE AND fi.LENGTH = mfl.LENGTH
ORDER BY ID