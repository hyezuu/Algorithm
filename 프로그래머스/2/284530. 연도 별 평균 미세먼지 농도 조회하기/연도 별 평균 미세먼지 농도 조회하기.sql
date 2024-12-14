-- 코드를 작성해주세요
SELECT YEAR(YM) as YEAR, round(avg(pm_val1), 2) as PM10, round(avg(pm_val2), 2) as 'PM2.5'
FROM AIR_POLLUTION
WHERE LOCATION2 = '수원'
GROUP BY YEAR
ORDER BY YEAR