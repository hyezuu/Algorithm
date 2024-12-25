-- 코드를 작성해주세요
SELECT ROUND(AVG(case when length is null then '10' else length end), 2) as AVERAGE_LENGTH
FROM FISH_INFO